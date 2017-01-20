package com.interview.hobart.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.interview.hobart.shop.dao.AccountDao;
import com.interview.hobart.shop.entity.AccountInfo;
import com.interview.hobart.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource AccountDao accountDao;

	@Override
	public List<AccountInfo> query() {
		return accountDao.query();
	}
	
}
