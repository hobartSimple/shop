package com.interview.hobart.shop.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.ProductDao;
import com.interview.hobart.shop.entity.ProductInfo;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<ProductInfo> implements ProductDao {
	
	// 查询商品信息，级联类别
	@Override
	public List<ProductInfo> queryJoinCategory(String name, int page, int size) {
		return hibernateTemplate.execute(new HibernateCallback<List<ProductInfo>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<ProductInfo> doInHibernate(Session session) throws HibernateException {
				String hql = "from ProductInfo p left join fetch p.category where p.name like :name";
				Query query = session.createQuery(hql);
				query.setString("name", "%" + name + "%");
				query.setFirstResult((page-1) * size); //从第几个开始显示  
				query.setMaxResults(size); //显示几个 
				return query.list();
			}
		});
	}

	// 根据关键字查询总记录数
	@Override
	public Long getCount(String name) {
		return hibernateTemplate.execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				String hql = "select count(p) from ProductInfo p where p.name like :name"; 
				Query query = session.createQuery(hql);
				query.setString("name", "%" + name + "%"); 
				return (Long) query.uniqueResult(); //返回一条记录:总记录数
			}
		});
	}

	// 根据ids删除多条记录
	@Override
	public void deleteByIds(String ids) {
		hibernateTemplate.execute(new HibernateCallback<ProductInfo>() {
			@Override
			public ProductInfo doInHibernate(Session session) throws HibernateException {
				String hql = "delete from ProductInfo c where c.id in (:ids)";
				Query query = session.createQuery(hql);
				query.setString("ids", ids);
				query.executeUpdate();
				return null;
			}
		});
	}

	// 根据热点类别id查询推荐商品（仅仅查询前4个）
	@Override
	public List<ProductInfo> querByCategoryId(int cid) {
		return hibernateTemplate.execute(new HibernateCallback<List<ProductInfo>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<ProductInfo> doInHibernate(Session session) throws HibernateException {
				String hql = "from ProductInfo p left join fetch p.category where p.commend=true and p.open=true and p.category.id=:cid order by p.date desc";
				Query query = session.createQuery(hql);
				query.setInteger("cid", cid);
				query.setFirstResult(0); //从第几个开始显示  
				query.setMaxResults(4); //显示几个 
				return query.list();
			}
		});
	}
}
