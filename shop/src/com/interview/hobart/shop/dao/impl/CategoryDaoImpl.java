package com.interview.hobart.shop.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.CategoryDao;
import com.interview.hobart.shop.entity.CategoryInfo;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<CategoryInfo> implements CategoryDao {

	@Resource
	HibernateTemplate hibernateTemplate;

	@Override
	public List<CategoryInfo> queryJoinAccount(String type, int page, int size) {
		return hibernateTemplate.execute(new HibernateCallback<List<CategoryInfo>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<CategoryInfo> doInHibernate(Session session) throws HibernateException {
				String hql = "from CategoryInfo c left join fetch c.account where c.type like :type";
				Query query = session.createQuery(hql);
				query.setString("type", "%" + type + "%");
				query.setFirstResult((page-1) * size); //从第几个开始显示  
				query.setMaxResults(size); //显示几个  
				return query.list();
			}
		});
	}

	@Override
	public Long getCount(String type) {
		return hibernateTemplate.execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				String hql = "select count(c) from CategoryInfo c where c.type like :type";
				Query query = session.createQuery(hql);
				query.setString("type", "%" + type + "%");
				return (Long) query.uniqueResult(); //返回一条记录:总记录数
			}
		});
	}

	@Override
	public void deleteByIds(String ids) {
		hibernateTemplate.execute(new HibernateCallback<CategoryInfo>() {
			@Override
			public CategoryInfo doInHibernate(Session session) throws HibernateException {
				String hql = "delete from CategoryInfo c where c.id in (:ids)";
				Query query = session.createQuery(hql);
				query.setString("ids", ids);
				query.executeUpdate();
				return null;
			}
		});
	}

	@Override
	public List<CategoryInfo> queryByHot(boolean hot) {
		return hibernateTemplate.execute(new HibernateCallback<List<CategoryInfo>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<CategoryInfo> doInHibernate(Session session) throws HibernateException {
				String hql = "from CategoryInfo c where c.hot=:hot";
				Query query = session.createQuery(hql);
				query.setBoolean("hot", hot); 
				return query.list();
			}
		});
	}
}