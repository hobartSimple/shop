package com.interview.hobart.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.interview.hobart.shop.entity.CategoryInfo;
import com.interview.hobart.shop.entity.ProductInfo;
import com.interview.hobart.shop.service.CategoryService;
import com.interview.hobart.shop.service.ProductService;

public class InitDataListener implements ServletContextListener {

	private ProductService productService = null;  
    private CategoryService categoryService = null;  
    private ApplicationContext context = null;  
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {

		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());          
        categoryService = (CategoryService) context.getBean("categoryService");//加载类别信息          
        productService = (ProductService) context.getBean("productService");//加载商品信息  
  
        List<List<ProductInfo>> bigList = new ArrayList<List<ProductInfo>>(); //bigList中存放一个装有Category类的list  
        // 1. 查询出热点类别  
        for(CategoryInfo category : categoryService.queryByHot(true)) {  
            //根据热点类别id获取推荐商品信息  
            List<ProductInfo> lst = productService.querByCategoryId(category.getId());  
            bigList.add(lst); //将装有category的list放到bigList中  
        }  
        // 2. 把查询的bigList交给application内置对象  
        event.getServletContext().setAttribute("bigList", bigList);  

	}

}
