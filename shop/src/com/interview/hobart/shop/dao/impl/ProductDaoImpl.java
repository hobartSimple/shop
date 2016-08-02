package com.interview.hobart.shop.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.ProductDao;
import com.interview.hobart.shop.entity.ProductInfo;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<ProductInfo> implements ProductDao {
	@Resource HibernateTemplate hibernateTemplate;

	@Override
	public List<ProductInfo> queryJoinCategory(String name, int page, int size) {
		return hibernateTemplate.execute(new HibernateCallback<List<ProductInfo>>() {
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
}
