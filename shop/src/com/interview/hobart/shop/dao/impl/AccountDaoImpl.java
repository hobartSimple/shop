package com.interview.hobart.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.AccountDao;
import com.interview.hobart.shop.entity.AccountInfo;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<AccountInfo> implements AccountDao {
	
}