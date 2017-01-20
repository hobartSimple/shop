package com.interview.hobart.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.interview.hobart.shop.dao.SorderDao;
import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.entity.SorderInfo;

@Repository("sorderDao")
public class SorderDaoImpl extends BaseDaoImpl<SorderInfo> implements SorderDao {

	 @Override  
	public ForderInfo addSorder(ForderInfo forder, ProductInfo product) {
		boolean isHave = false; // 用来标记有没有重复购物项
		// 拿到当前的购物项
		SorderInfo sorder = productToSorder(product);
		// 判断当前购物项是否重复，如果重复，则添加数量即可
		for (SorderInfo old : forder.getSorders()) {
			if (old.getProduct().getId().equals(sorder.getProduct().getId())) {
				// 购物项有重复，添加数量即可
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//当前购物项在购物车中不存在，新添加即可  
        if(!isHave) {  
            //我们在这里插入一句：  
            //在向购物中添加购物项之前，先建立购物项与购物车的关联，但是此时forder.id为null，  
            //但是在入库的时候是先入库购物车，再入库购物项，那时候就有主键了  
            sorder.setForder(forder);  
            forder.getSorders().add(sorder);  
        }  
		return forder;
	}
	  
    @Override  
    public SorderInfo productToSorder(ProductInfo product) {  
    	SorderInfo sorder = new SorderInfo();  
        sorder.setName(product.getName());  
        sorder.setNumber(1);  
        sorder.setPrice(product.getPrice());  
        sorder.setProduct(product);  
        return sorder;  
    }  

}
