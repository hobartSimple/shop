package com.interview.hobart.shop.dao;

import java.util.List;

import com.interview.hobart.shop.entity.ProductInfo;

public interface ProductDao extends BaseDao<ProductInfo> {
	// 查询商品信息，级联类别
	public List<ProductInfo> queryJoinCategory(String type, int page, int size); // 使用商品的名称查询
	// 根据关键字查询总记录数
	public Long getCount(String type);
	// 保存
	public void save(ProductInfo model);
	// 根据ids删除多条记录
	public void deleteByIds(String ids);
	// 根据热点类别id查询推荐商品（仅仅查询前4个）
	public List<ProductInfo> querByCategoryId(int cid);
}
