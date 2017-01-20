package com.interview.hobart.shop.service;

import com.interview.hobart.shop.entity.UserInfo;

public interface UserService {
	//用户登陆，成功返回该User  
    public UserInfo login(UserInfo user);  
}
