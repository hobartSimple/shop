package com.interview.hobart.shop.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.ProductInfo;

@Controller
@ParentPackage(value="json-default")
public class ProductAction extends BaseAction<ProductInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "/product_queryJoinCategory", results = { @Result(name = "jsonMap", type = "json", params={"root","pageMap","excludeProperties","rows\\[\\d+\\]\\.category\\.account"}) })
	public String queryJoinCategory() throws Exception {
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		//根据关键字和分页的参数查询相应的数据
		List<ProductInfo> productList = productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList); //存储为JSON格式
		//根据关键字查询总记录数
		Long total = productService.getCount(model.getName());
		pageMap.put("total", total); //存储为JSON格式
		return "jsonMap";
	}
	
	@Action(value="product_save")
	public void save() {
		//fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
		String pic = fileUpload.uploadFile(fileImage);
		
		model.setPic(pic);
		model.setDate(new Date());
		System.out.println(model+"-=-=-=-=================-=-=-=-=-=");
		//商品信息入库
		productService.save(model);
	}
	
}
