package com.interview.hobart.shop.dao;

import java.math.BigDecimal;

import com.interview.hobart.shop.entity.ForderInfo;

public interface ForderDao extends BaseDao<ForderInfo>{

	//计算购物总价格  
	public BigDecimal cluTotal(ForderInfo forder);

}
