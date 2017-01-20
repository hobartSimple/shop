package com.interview.hobart.shop.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.ForderInfo;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.entity.SorderInfo;

@Controller(value = "sorderAction")
@Scope("prototype") 
public class SorderAction extends BaseAction<SorderInfo>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="/sorder_addSorder", results = {@Result(name="showCart", location="user/showCart.jsp")})
	public String addSorder() {

		// 1. 根据product.id获取相应的商品数据
		ProductInfo product = productService.get(model.getProduct().getId());

		// 2. 判断当前session是否有购物车，如果没有则创建
		if (session.get("forder") == null) {
			// 创建新的购物车，存储到session中
			session.put("forder", new ForderInfo(new ArrayList<SorderInfo>()));
		}

		// 3. 把商品信息转化为sorder,并且添加到购物车中（判断购物项是否重复）
		ForderInfo forder = (ForderInfo) session.get("forder");
		forder = sorderService.addSorder(forder, product);

		// 4. 计算购物的总价格
		forder.setTotal(forderService.cluTotal(forder));
		// 5. 把新的购物车存储到session中
		session.put("forder", forder);
		return "showCart";
	}
}
