package com.interview.hobart.shop.service;

import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.entity.SorderInfo;

public interface SorderService{
	
	//添加购物项，返回新的购物车  
    public ForderInfo addSorder(ForderInfo forder, ProductInfo product);  
    //把商品数据转化为购物项  
    public SorderInfo productToSorder(ProductInfo product);
	//根据商品编号更新商品数量
	public ForderInfo updateSorder(SorderInfo model, ForderInfo forder); 
    
}
