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
      
	@Override
	public List<CategoryInfo> queryJoinAccount(String type, int page, int size) {
		return categoryDao.queryJoinAccount(type, page, size);
	}  

	@Override
	public Long getCount(String type) {
		return categoryDao.getCount(type); //返回一条记录:总记录数
	}

	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
	}

	@Override
	public List<CategoryInfo> queryByHot(boolean hot) {
		return null;
	}

	@Override
	public void save(CategoryInfo model) {
		categoryDao.save(model);
	}

	@Override
	public void update(CategoryInfo model) {
		categoryDao.update(model);
	}
}
