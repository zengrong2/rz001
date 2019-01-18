package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.TdAddressService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("tdAddress/")
public class TdAddressController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private TdAddressService service;
		
		/*@RequestMapping(value="/province")
		public ModelAndView province() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
		
			
			TdAddress tdAddress = new TdAddress();
			tdAddress.setCitylevel(1);
			List<TdAddress> listProvince = service.queryListByWhere(tdAddress);//省份对象集合
			System.out.println("tian");
			mv.addObject("listProvince", listProvince);
			mv.setViewName("save_result");
			return mv;
		}*/
		@RequestMapping(value="/province")
		public String province(HttpServletResponse response,HttpServletRequest request) throws Exception {
			TdAddress tdAddress = new TdAddress();
			tdAddress.setCitylevel(1);
			List<TdAddress> listAddress = service.queryListByWhere(tdAddress);//省份对象集合
			//解析集合用的方法
		
			JSONArray json = new JSONArray();
			 
		         for(TdAddress pLog : listAddress){
		             JSONObject jo = new JSONObject();
		             jo.put("citycode", pLog.getCitycode());
		             jo.put("pidcode", pLog.getPidcode());
		             jo.put("cityname", pLog.getCityname());
		              
		             json.add(jo);
		         }
			
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=null;
			try {
			out=response.getWriter();
			} catch (Exception e) {
			e.printStackTrace();
			}
			//将省份的json字符串响应给jquery的ajax
			out.print(json.toString());
			out.close();
			return null;
			}
		@RequestMapping(value="/city")
			public String city(HttpServletResponse response,HttpServletRequest request) throws Exception {
			String pid=request.getParameter("pid");

			//根据选择的省份去查询对应的城市对象集合
			TdAddress tdAddress = new TdAddress();
			tdAddress.setPidcode(pid);
			List<TdAddress> listAddress = service.queryListByWhere(tdAddress);//省份对象集合
			//解析集合用的方法
			JSONArray json = new JSONArray();
			 for(TdAddress pLog : listAddress){
	             JSONObject jo = new JSONObject();
	             jo.put("citycode", pLog.getCitycode());
	             jo.put("pidcode", pLog.getPidcode());
	             jo.put("cityname", pLog.getCityname());
	              
	             json.add(jo);
	         }
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = null;
			try {
			out = response.getWriter();
			} catch (Exception e) {
			e.printStackTrace();
			}
			//将城市的json字符串响应给jquery的ajax
			out.print(json.toString());
			out.close();
			return null;
			}
		@RequestMapping(value="/district")
			public String district(HttpServletResponse response,HttpServletRequest request) throws Exception {
			String pid=request.getParameter("cid");

			//根据选中的城市拿到对应的区域对象集合
			
			TdAddress tdAddress = new TdAddress();
			tdAddress.setPidcode(pid);
			List<TdAddress> listAddress = service.queryListByWhere(tdAddress);//省份对象集合
			//解析集合用的方法
			JSONArray json = new JSONArray();
			 for(TdAddress pLog : listAddress){
	             JSONObject jo = new JSONObject();
	             jo.put("citycode", pLog.getCitycode());
	             jo.put("pidcode", pLog.getPidcode());
	             jo.put("cityname", pLog.getCityname());
	              
	             json.add(jo);
	         }
		
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = null;
			try {
			out = response.getWriter();
			} catch (Exception e) {
			e.printStackTrace();
			}
			//将区域的json字符串响应给jquery的ajax
			out.print(json.toString());
			out.close();
			return null;
			}
		
		
}
