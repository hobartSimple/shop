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
	
	//添加购物项，返回新的购物车
	@Override
	public ForderInfo addSorder(ForderInfo forder, ProductInfo product) {
		return sorderDao.addSorder(forder, product);
	}

	//把商品数据转化为购物项  
	@Override
	public SorderInfo productToSorder(ProductInfo product) {
		return sorderDao.productToSorder(product);
	}

	//根据商品编号更新商品数量
	@Override
	public ForderInfo updateSorder(SorderInfo model, ForderInfo forder) {
		return sorderDao.updateSorder(model,forder);
	}

}
