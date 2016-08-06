package com.interview.hobart.shop.service;

import java.util.List;

import com.interview.hobart.shop.entity.ProductInfo;

public interface ProductService {
	//查询商品信息，级联类别  
    public List<ProductInfo> queryJoinCategory(String type, int page, int size); //使用商品的名称查询  
    //根据关键字查询总记录数  
    public Long getCount(String type);
    
	public void save(ProductInfo model);
}
