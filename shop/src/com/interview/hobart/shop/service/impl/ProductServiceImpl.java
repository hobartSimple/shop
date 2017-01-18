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

	//查询商品信息，级联类别  
	@Override
	public List<ProductInfo> queryJoinCategory(String type, int page, int size) {
		return productDao.queryJoinCategory(type, page, size);
	}
	
	//根据关键字查询总记录数  
	@Override
	public Long getCount(String type) {
		return productDao.getCount(type);
	}
	
	//保存
	@Override
	public void save(ProductInfo model) {
		productDao.save(model);
	}

	//根据ids删除多条记录  
	@Override
	public void deleteByIds(String ids) {
		productDao.deleteByIds(ids);
	}

	//根据热点类别id查询推荐商品（仅仅查询前4个）  
	@Override
	public List<ProductInfo> querByCategoryId(int cid) {
		return productDao.querByCategoryId(cid);
	}

	//更新
	@Override
	public void update(ProductInfo model) {
		productDao.update(model);
	}
	
}
