package com.interview.hobart.shop.service;

import java.util.Map;

import com.interview.hobart.shop.model.BackData;
import com.interview.hobart.shop.model.SendData;

public interface PayService {

	// 把加密后的信息存储到requestMap中
    public abstract Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);

    //把返回的数据进行加密得到密文，并与传回来的密文比较，（我们后面再来实现）
    public boolean checkBackData(BackData backData);

}
