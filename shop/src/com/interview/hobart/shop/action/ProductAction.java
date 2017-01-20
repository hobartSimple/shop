package com.interview.hobart.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.ProductInfo;

@Controller(value = "productAction")
@ParentPackage(value = "json-default")
@Scope("prototype")
public class ProductAction extends BaseAction<ProductInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "/product_queryJoinCategory", results = { @Result(name = "jsonMap", type = "json", params = {
			"root", "pageMap", "excludeProperties", "rows\\[\\d+\\]\\.category\\.account" }) })
	public String queryJoinCategory() throws Exception {
		// 用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		// 根据关键字和分页的参数查询相应的数据
		List<ProductInfo> productList = productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList); // 存储为JSON格式
		// 根据关键字查询总记录数
		Long total = productService.getCount(model.getName());
		pageMap.put("total", total); // 存储为JSON格式
		return "jsonMap";
	}

	@Action(value = "/product_save")
	public void save() throws Exception {
		// fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
		String pic = fileUpload.uploadFile(fileImage);

		model.setPic(pic);
		model.setDate(new Date());
		System.out.println(model + "-=-=-=-=================-=-=-=-=-=");
		// 商品信息入库
		productService.save(model);
	}

	@Action(value = "/product_update")
	public void update() throws Exception {
		// 处理上传的图片，下一篇博客专门分析struts2文件上传
		String pic = fileUpload.uploadFile(fileImage);

		model.setPic(pic);
		model.setDate(new Date()); // 设置一下当前时间，因为前台没有把时间字段传进来，这里自己设置一下即可
		System.out.println(model);
		// 更新商品
		productService.update(model);
	}

	@Action(value = "/product_deleteByIds", results = {
			@Result(name = "stream", type = "stream", params = { "inputName", "inputStream" }) })
	public String deleteByIds() throws Exception {
		System.out.println(ids);
		productService.deleteByIds(ids);
		// 如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

}
