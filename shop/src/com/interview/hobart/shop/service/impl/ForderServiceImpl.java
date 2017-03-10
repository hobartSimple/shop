package com.interview.hobart.shop.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.interview.hobart.shop.dao.ForderDao;
import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl implements ForderService {

	@Resource ForderDao forderDao;
	
	//计算购物总价格 
	@Override
	public BigDecimal cluTotal(ForderInfo forder) {
		return forderDao.cluTotal(forder);
	}

	@Override
	public void save(ForderInfo model) {
		forderDao.save(model);
	}

}
