package com.seiryo.service.impl;

import java.util.List;

import com.seiryo.dao.CommodityDao;
import com.seiryo.dao.impl.CommodityDaoImpl;
import com.seiryo.entity.Commodity;
import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.service.CommodityService;

public class CommodityServiceImpl implements CommodityService{

	private CommodityDao commodityDao = new CommodityDaoImpl();
	
	
	@Override
	public List<Commodity> selectAllCommodity() {
		return commodityDao.selectAllCommodity();
	}

	@Override
	public List<Commodity> selectCommodityByType(String type) {
		return commodityDao.selectCommodityByType(type);
	}

	@Override
	public Commodity selectCommdityById(int commodityId) {
		// TODO Auto-generated method stub
		return commodityDao.selectCommdityById(commodityId);
	}
	
	
	

}
