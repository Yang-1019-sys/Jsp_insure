package com.seiryo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.entity.Commodity;
import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.service.CommodityService;
import com.seiryo.service.impl.CommodityServiceImpl;
import com.seiryo.utile.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

@WebServlet("/CommodityServlet")
public class CommodityServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private CommodityService commodityService = new CommodityServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置请求和响应代码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 获取请求中的数据
		String opt = req.getParameter("opt");
		
		if("selectAllCommodityList".equals(opt)) {
			selectAllCommodityList(req,resp);
		}else if("selectCommodityByType".equals(opt)) {
			selectCommodityByType(req,resp);
		}else if("commodityQueryById".equals(opt)) {
			CommodityQueryById(req,resp);
		}
		
		
	}
	
	/**
	 * 
	 * @Title: selectAllCommodityList  
	 * @Description: 返回全部保险信息 
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException    参数  
	 * @return void    返回类型  
	 * @throws
	 */
	private void selectAllCommodityList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 查询全部保险
		List<Commodity> list = commodityService.selectAllCommodity();
		
		// 设置返回类型为json
		resp.setContentType("application/json;charset=UTF-8");
		
		// 将保险列表转换成JSON字符串
		try {
			String json = JSONUtil.toJSONString(list);
			// 返回前端
			resp.getWriter().write(json);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 根据类型返回保险
	 * @Title: selectCommodityByType  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException    参数  
	 * @return void    返回类型  
	 * @throws
	 */
	private void selectCommodityByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 获取类型
		String type = req.getParameter("type");
		// 根据类型查询保险
		List<Commodity> list = commodityService.selectCommodityByType(type);
		// 设置返回类型为json
		resp.setContentType("application/json;charset=UTF-8");
		
		// 将保险列表转换成JSON字符串
		try {
			String json = JSONUtil.toJSONString(list);
			// 返回前端
			resp.getWriter().write(json);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void CommodityQueryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("commodity_id");
		int commodityId = Integer.parseInt(id);
		
		// 查询该商品
		Commodity com = commodityService.selectCommdityById(commodityId);
		
		if(com==null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"未找到");
			return;
		}
		req.setAttribute("commodityInfo", com);
		req.getRequestDispatcher("/page_info.jsp").forward(req, resp);
		
	}
	
}
