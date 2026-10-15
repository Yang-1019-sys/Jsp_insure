package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.Commodity;

public interface CommodityService {
	
	// 查找所有保险信息
	List<Commodity> selectAllCommodity();
	
	// 根据类别查找保险信息
	List<Commodity> selectCommodityByType(String type);
	
	//根据id查找
	Commodity selectCommdityById(int commodityId);

}
