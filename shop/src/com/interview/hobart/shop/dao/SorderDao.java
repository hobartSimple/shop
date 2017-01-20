package com.interview.hobart.shop.dao;

import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.entity.SorderInfo;

public interface SorderDao {

	//添加购物项，返回新的购物车  
    public ForderInfo addSorder(ForderInfo forder, ProductInfo product);  
    //把商品数据转化为购物项  
    public SorderInfo productToSorder(ProductInfo product); 

}
