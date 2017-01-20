package com.interview.hobart.shop.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.ForderDao;
import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.SorderInfo;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<ForderInfo> implements ForderDao {

	//计算购物总价格 
	@Override
	public BigDecimal cluTotal(ForderInfo forder) {
		double total = 0;  
        for(SorderInfo sorder : forder.getSorders()) {  
        	// BigDecimal 为商用型的 数据类型  数据精度高 ， 它不能直接和 基本类型 或 基本类型的 封装类型 进行运算
            total += sorder.getNumber() * sorder.getPrice().doubleValue();  
        }  
        return BigDecimal.valueOf(total);  
	}

}
