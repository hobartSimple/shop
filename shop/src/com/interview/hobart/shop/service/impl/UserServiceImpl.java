package com.interview.hobart.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.interview.hobart.shop.dao.UserDao;
import com.interview.hobart.shop.entity.UserInfo;
import com.interview.hobart.shop.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource UserDao userDao;
	@Override
	public UserInfo login(UserInfo user) {
		return userDao.login(user);
	}

}
