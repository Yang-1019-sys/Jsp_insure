package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.Commodity;
import com.seiryo.entity.Commodity_liability_info;


public interface CommodityDao {
	
	// 查找所有保险信息
	List<Commodity> selectAllCommodity();
	
	// 根据类别查找保险信息
	List<Commodity> selectCommodityByType(String type);
	
	//根据id查找
	Commodity selectCommdityById(int commodityId);

}
