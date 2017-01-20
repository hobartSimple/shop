package com.interview.hobart.shop.dao;

import com.interview.hobart.shop.entity.UserInfo;

public interface UserDao extends BaseDao<UserInfo> {

	public UserInfo login(UserInfo user);

}
