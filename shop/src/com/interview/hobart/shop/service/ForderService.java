package com.interview.hobart.shop.service;

import java.math.BigDecimal;

import com.interview.hobart.shop.entity.ForderInfo;

public interface ForderService{
	
	//计算购物总价格  
    public BigDecimal cluTotal(ForderInfo forder);

	public void save(ForderInfo model);
    
}
