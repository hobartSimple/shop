package com.interview.hobart.shop.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.UserDao;
import com.interview.hobart.shop.entity.UserInfo;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements UserDao {

	@Override
	public UserInfo login(UserInfo user) {
		return hibernateTemplate.execute(new HibernateCallback<UserInfo>() {
			@Override
			public UserInfo doInHibernate(Session session) throws HibernateException {
				String hql = "from UserInfo u where u.login=:login and u.pass=:pass"; 
				Query query = session.createQuery(hql);
				query.setString("login", user.getLogin());  
	            query.setString("pass", user.getPass());
				return (UserInfo) query.uniqueResult();
			}
		});
	}

}
