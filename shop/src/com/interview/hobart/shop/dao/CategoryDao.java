package com.interview.hobart.shop.dao;

import java.util.List;

import com.interview.hobart.shop.entity.CategoryInfo;

public interface CategoryDao extends BaseDao<CategoryInfo> {

	// 查询类别信息，级联管理员// 使用类别的名称查询
	public List<CategoryInfo> queryJoinAccount(String type, int page, int size);
	
	// 根据关键字查询总记录数
	public Long getCount(String type);

	// 根据ids删除多条记录
	public void deleteByIds(String ids);

	// 根据boelen值查询热点或非热点类别
	public List<CategoryInfo> queryByHot(boolean hot);
}
