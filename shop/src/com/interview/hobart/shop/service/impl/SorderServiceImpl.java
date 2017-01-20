package com.interview.hobart.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.interview.hobart.shop.dao.SorderDao;
import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.entity.SorderInfo;
import com.interview.hobart.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl implements SorderService {

	@Resource SorderDao sorderDao;
	
	@Override
	public ForderInfo addSorder(ForderInfo forder, ProductInfo product) {
		return sorderDao.addSorder(forder, product);
	}

	@Override
	public SorderInfo productToSorder(ProductInfo product) {
		return sorderDao.productToSorder(product);
	}

}
