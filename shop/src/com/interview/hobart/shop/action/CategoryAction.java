package com.interview.hobart.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.interview.hobart.shop.entity.CategoryInfo;

@Controller(value="categoryAction")
@ParentPackage(value = "json-default")
@Scope("prototype") 
public class CategoryAction extends BaseAction<CategoryInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "/category_main_aindex", results = {@Result(name = "aindex", location = "/WEB-INF/main/aindex.jsp") })
	public String aindex() throws Exception {
		return "aindex";
	}
	
	//<!-- 配置黑名单，过滤不需要的选项 ，支持正则表达式
	// \d：一个数字      +:一个或多个     ?:0或1   *：1或多     [ABC]：自定义类型们必须是ABC中的一个  .：任意字符
	//{total:3,rows:[{account:{id:2,login:"user",name:"客服A",pass:"user"},hot:true,id:3,…}]}
	//-->

	@Action(value = "/category_queryJoinAccount", results = {@Result(name = "jsonMap", type = "json", params = { "root", "pageMap", "excludeProperties",
					"rows\\[\\d+\\]\\.account\\.pass,rows\\[\\d+\\]\\.account\\.name" }) })
	public String queryJoinAccount() throws Exception {
		// 用来存储分页的数据
		pageMap = new HashMap<String, Object>();

		// 根据关键字和分页的参数查询相应的数据
		List<CategoryInfo> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList); // 存储为JSON格式
		// 根据关键字查询总记录数
		Long total = categoryService.getCount(model.getType());
		// System.out.println(total+"===========================");
		pageMap.put("total", total); // 存储为JSON格式
		return "jsonMap";
	}

	@Action(value = "/category_save")
	public void save() throws Exception {
		categoryService.save(model);
	}

	@Action(value = "/category_update")
	public void update() throws Exception {
		categoryService.update(model);
	}

	@Action(value = "/category_deleteByIds", results = {@Result(name = "stream", type = "stream", params = { "inputName", "inputStream" }) })
	public String deleteByIds() throws Exception {
		categoryService.deleteByIds(ids);
		// 如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}

	@Action(value = "/category_query", results = { @Result(name = "jsonList", type = "json", params = { "root",
			"jsonList", "excludeProperties", "rows\\[\\d+\\]\\.account" }) })
	public String query() throws Exception {
		jsonList = categoryService.query();
		return "jsonList";
	}
}
