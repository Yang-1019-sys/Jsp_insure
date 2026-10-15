package com.seiryo.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seiryo.dao.CommodityDao;
import com.seiryo.entity.Commodity;
import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.utile.JDBCUTILE;

public class CommodityDaoImpl implements CommodityDao{

	/**
	 * 查询全部商品信息
	 * <p>Title: selectAllCommodity</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.seiryo.dao.CommodityDao#selectAllCommodity()
	 */
	@Override
	public List<Commodity> selectAllCommodity() {
		String sql = "SELECT * FROM commodity";
		ResultSet rest = null;
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			rest = JDBCUTILE.selectDataBaseTable(sql);
			while(rest.next()) {
				Commodity com = new Commodity();
				com.setCommodity_id(rest.getInt("commodity_id"));
				com.setCommodity_name(rest.getString("commodity_name"));
				com.setCommodity_price(rest.getString("commodity_price"));
				com.setCommodity_introduce(rest.getString("commodity_introduce"));
				com.setCommodity_img(rest.getString("commodity_img"));
				com.setCommodity_age_start(rest.getInt("commodity_age_start"));
				com.setCommodity_age_end(rest.getInt("commodity_age_end"));
				com.setCommodity_time_length(rest.getString("commodity_time_length"));
				com.setCommodity_applicable_gender(rest.getInt("commodity_applicable_gender"));
				com.setCommodity_applicable_location(rest.getString("commodity_applicable_location"));
				com.setCommodity_signing_form(rest.getString("commodity_signing_form"));
				com.setCommodity_liability_zjs(rest.getString("commodity_liability_zjs"));
				com.setCommodity_detailed_information1(rest.getString("commodity_detailed_information1"));
				com.setCommodity_detailed_information2(rest.getString("commodity_detailed_information2"));
				com.setCommodity_detailed_information3(rest.getString("commodity_detailed_information3"));
				com.setCommodity_type(rest.getString("commodity_type"));
				
				list.add(com);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUTILE.dbClose(rest, null, null);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 根据类型查询商品信息
	 * <p>Title: selectCommodityByType</p>  
	 * <p>Description: </p>  
	 * @param c1
	 * @return  
	 * @see com.seiryo.dao.CommodityDao#selectCommodityByType(int)
	 */
	@Override
	public List<Commodity> selectCommodityByType(String type) {
		String sql = "SELECT * FROM commodity WHERE commodity_type=?";
		ResultSet rest = null;
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			rest = JDBCUTILE.selectDataBaseTable(sql,type);
			while(rest.next()) {
				Commodity com = new Commodity();
				com.setCommodity_id(rest.getInt("commodity_id"));
				com.setCommodity_name(rest.getString("commodity_name"));
				com.setCommodity_price(rest.getString("commodity_price"));
				com.setCommodity_introduce(rest.getString("commodity_introduce"));
				com.setCommodity_img(rest.getString("commodity_img"));
				com.setCommodity_age_start(rest.getInt("commodity_age_start"));
				com.setCommodity_age_end(rest.getInt("commodity_age_end"));
				com.setCommodity_time_length(rest.getString("commodity_time_length"));
				com.setCommodity_applicable_gender(rest.getInt("commodity_applicable_gender"));
				com.setCommodity_applicable_location(rest.getString("commodity_applicable_location"));
				com.setCommodity_signing_form(rest.getString("commodity_signing_form"));
				com.setCommodity_liability_zjs(rest.getString("commodity_liability_zjs"));
				com.setCommodity_detailed_information1(rest.getString("commodity_detailed_information1"));
				com.setCommodity_detailed_information2(rest.getString("commodity_detailed_information2"));
				com.setCommodity_detailed_information3(rest.getString("commodity_detailed_information3"));
				com.setCommodity_type(rest.getString("commodity_type"));
				
				list.add(com);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUTILE.dbClose(rest, null, null);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 根据Id查询
	 * <p>Title: selectCommdityById</p>  
	 * <p>Description: </p>  
	 * @param commodityId
	 * @return  
	 * @see com.seiryo.dao.CommodityDao#selectCommdityById(int)
	 */
	@Override
	public Commodity selectCommdityById(int commodityId) {
		String sql = "SELECT * FROM commodity WHERE commodity_id=?";
		ResultSet rest = null;
		try {
			rest=JDBCUTILE.selectDataBaseTable(sql, commodityId);
			while(rest.next()) {
				Commodity com = new Commodity();
				com.setCommodity_id(rest.getInt("commodity_id"));
				com.setCommodity_name(rest.getString("commodity_name"));
				com.setCommodity_price(rest.getString("commodity_price"));
				com.setCommodity_introduce(rest.getString("commodity_introduce"));
				com.setCommodity_img(rest.getString("commodity_img"));
				com.setCommodity_age_start(rest.getInt("commodity_age_start"));
				com.setCommodity_age_end(rest.getInt("commodity_age_end"));
				com.setCommodity_time_length(rest.getString("commodity_time_length"));
				com.setCommodity_applicable_gender(rest.getInt("commodity_applicable_gender"));
				com.setCommodity_applicable_location(rest.getString("commodity_applicable_location"));
				com.setCommodity_signing_form(rest.getString("commodity_signing_form"));
				com.setCommodity_liability_zjs(rest.getString("commodity_liability_zjs"));
				com.setCommodity_detailed_information1(rest.getString("commodity_detailed_information1"));
				com.setCommodity_detailed_information2(rest.getString("commodity_detailed_information2"));
				com.setCommodity_detailed_information3(rest.getString("commodity_detailed_information3"));
				com.setCommodity_type(rest.getString("commodity_type"));
				
				return com;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose(rest, null, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	

}
