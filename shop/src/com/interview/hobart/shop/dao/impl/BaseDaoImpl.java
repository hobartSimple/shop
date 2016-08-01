package com.interview.hobart.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.BaseDao;

@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<?> clazz;

	@Resource
	HibernateTemplate hibernateTemplate;

	public BaseDaoImpl() {
		// 拿到泛型的参数类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<?>) type.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		hibernateTemplate.save(t);
	}

	@Override
	public void update(T t) {
		hibernateTemplate.update(t);
	}

	@Override
	public void delete(int id) {
		hibernateTemplate.delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) {
		return (T) hibernateTemplate.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		return (List<T>) hibernateTemplate.find(hql, null);
	}

}
