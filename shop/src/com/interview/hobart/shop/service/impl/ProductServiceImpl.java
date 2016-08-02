package com.interview.hobart.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.interview.hobart.shop.dao.ProductDao;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.service.ProductService;

@Service("productService") 
public class ProductServiceImpl implements ProductService {
	@Resource ProductDao productDao;

	@Override
	public List<ProductInfo> queryJoinCategory(String type, int page, int size) {
		return productDao.queryJoinCategory(type, page, size);
	}

	@Override
	public Long getCount(String type) {
		return productDao.getCount(type);
	}
	
}
