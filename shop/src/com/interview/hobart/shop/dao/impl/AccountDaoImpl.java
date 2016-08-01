package com.interview.hobart.shop.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.AccountDao;
import com.interview.hobart.shop.entity.AccountInfo;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<AccountInfo> implements AccountDao {

	@Resource
	HibernateTemplate hibernateTemplate;

}