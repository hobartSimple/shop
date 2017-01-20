package com.interview.hobart.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.interview.hobart.shop.dao.CategoryDao;
import com.interview.hobart.shop.entity.CategoryInfo;
import com.interview.hobart.shop.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource CategoryDao categoryDao;
      
	// 查询类别信息，级联管理员
	@Override
	public List<CategoryInfo> queryJoinAccount(String type, int page, int size) {
		return categoryDao.queryJoinAccount(type, page, size);
	}  

	// 根据关键字查询总记录数
	@Override
	public Long getCount(String type) {
		return categoryDao.getCount(type); //返回一条记录:总记录数
	}

	// 根据ids删除多条记录
	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
	}

	// 根据boelen值查询热点或非热点类别
	@Override
	public List<CategoryInfo> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}

	@Override
	public void update(CategoryInfo model) {
		categoryDao.update(model);
	}

	@Override
	public void save(CategoryInfo model) {
		categoryDao.save(model);
	}

	@Override
	public List<CategoryInfo> query() {
		return categoryDao.query();
	}

}
