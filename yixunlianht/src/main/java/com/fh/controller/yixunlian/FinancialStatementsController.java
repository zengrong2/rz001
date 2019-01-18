package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.AidFundSqlManager;
import com.fh.service.yixunlian.BackgroundTransferRecordinputService;
import com.fh.service.yixunlian.BackgroundTransferRecordinputSqlManager;
import com.fh.service.yixunlian.BackgroundTransferRecordoutService;
import com.fh.service.yixunlian.BackgroundTransferRecordoutSqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.PartnerBonusTransferRecordinputService;
import com.fh.service.yixunlian.PartnerBonusTransferRecordinputSqlManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

/*
 * 财务报表
 */
@Controller
@RequestMapping("financialStatements/")
public class FinancialStatementsController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private BackgroundTransferRecordinputService backgroundInputService;
	
	//这是注入的是写sql语句的service
	//后台收入sql
	@Autowired
	private BackgroundTransferRecordinputSqlManager backgroundInputsqlService;
	//后台支出sql
	@Autowired
	private BackgroundTransferRecordoutSqlManager backgroundOutsqlService;
	@Autowired
	private BackgroundTransferRecordoutService backgroundOutService;
	@Autowired
	private PartnerBonusTransferRecordinputService partnerBonusService;
	//合伙人分红sql
	@Autowired
	private PartnerBonusTransferRecordinputSqlManager partnerBonusInputsqlService;
	//助创基金sql
	@Autowired
	private AidFundSqlManager aidFundsqlService;
	@Autowired
	private UserManager um;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
	@Autowired
	private ClientUserService clientUserService;
	 @RequestMapping(value="goListFinancialStatements")
		public ModelAndView goListFinancialStatements(Page page,HttpServletResponse response,HttpServletRequest request)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String yearNumber = pd.getString("yearNumber");
			//年
			if(null!=yearNumber&&!"".equals(yearNumber)) {
				/*System.out.println("yearNumber"+yearNumber);*/
				Integer tempYear = Integer.parseInt(yearNumber);
				String endYear = (tempYear+1)+"";
				pd.put("startYear", yearNumber+"-01-01 00:00:00");
				pd.put("endYear",endYear+"-01-01 00:00:00");
				page.setPd(pd);			
			    }else {			       
			    Calendar now = Calendar.getInstance();  				
				String year =  now.get(Calendar.YEAR)+"";
				pd.put("yearNumber",now.get(Calendar.YEAR));
			/*	System.out.println("now"+year);
				System.out.println("now2"+now.get(Calendar.YEAR));*/
				if(year!=null) {
					Integer tempYear = Integer.parseInt(year);
					String endYear = (tempYear+1)+"";
					pd.put("startYear", year+"-01-01 00:00:00");
					pd.put("endYear",endYear+"-01-01 00:00:00");
					page.setPd(pd);
				}
			}
			
			
		//系统每年进账的金额财务
		float financialBackgroundInputCountByYear = 0;
		//系统每个月进账的金额财务
		List<PageData>	financialBackgroundInput = backgroundInputsqlService.getfinancialBackgroundInputStatistics(page);
		float financialBackgroundInputs[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		for (PageData pageData : financialBackgroundInput) {
			Integer months = Integer.parseInt(pageData.getString("months"));
			financialBackgroundInputCountByYear+=Float.parseFloat(pageData.getBigDecimal("money")+"");
			for(int i=0;i<financialBackgroundInputs.length;i++) {
				financialBackgroundInputs[months-1]=Float.parseFloat(pageData.getBigDecimal("money")+"") ;
			}
		}
		//系统每年支付出去的金额财务
		float financialBackgroundOutCountByYear = 0;
		//系统每个月支付出去的金额财务
		List<PageData>	financialBackgroundOut	 = backgroundOutsqlService.getfinancialBackgroundOutStatistics(page);
		float financialBackgroundOuts[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		for (PageData pageData : financialBackgroundOut) {
			Integer months = Integer.parseInt(pageData.getString("months"));
			financialBackgroundOutCountByYear+=Float.parseFloat(pageData.getBigDecimal("money")+"");
			for(int i=0;i<financialBackgroundOuts.length;i++) {
				financialBackgroundOuts[months-1]=Float.parseFloat(pageData.getBigDecimal("money")+"") ;
			}
		}
		//合伙人分红池每年的财务
		float financialPartnerBonusInputCountByYear = 0;
		//合伙人分红池每个月的财务
		List<PageData>  financialPartnerBonusInput = partnerBonusInputsqlService.getgetfinancialPartnerBonusInputStatistics(page);
		float financialPartnerBonusInputs[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		for (PageData pageData : financialPartnerBonusInput) {
			Integer months = Integer.parseInt(pageData.getString("months"));
			financialPartnerBonusInputCountByYear+=Float.parseFloat(pageData.getBigDecimal("money")+"");
			for(int i=0;i<financialPartnerBonusInputs.length;i++) {
				financialPartnerBonusInputs[months-1]=Float.parseFloat(pageData.getBigDecimal("money")+"") ;
			}
		}
		//助创基金每年财务
		float financialAidFundInputCountByYear = 0;
		//助创基金每个月财务
		List<PageData>  financialAidFundInput =aidFundsqlService.getfinancialAidFundInputStatistics(page);
		float financialAidFundInputs[] = {0,0,0,0,0,0,0,0,0,0,0,0};
		for (PageData pageData : financialAidFundInput) {
			Integer months = Integer.parseInt(pageData.getString("months"));
			financialAidFundInputCountByYear+=Float.parseFloat(pageData.getBigDecimal("money")+"");
			for(int i=0;i<financialAidFundInputs.length;i++) {
				financialAidFundInputs[months-1]=Float.parseFloat(pageData.getBigDecimal("money")+"") ;
			}
		}
		//每年总利润 总收入-总支出
		float totalProfitCountByYear = financialBackgroundInputCountByYear-financialBackgroundOutCountByYear;
        
		
		        mv.setViewName("system/financeManager/financialStatements");			 
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
				//每月
				mv.addObject("financialBackgroundInputs", financialBackgroundInputs);
				mv.addObject("financialBackgroundOuts", financialBackgroundOuts);
				mv.addObject("financialPartnerBonusInputs", financialPartnerBonusInputs);
				mv.addObject("financialAidFundInputs", financialAidFundInputs);
				//每年
				mv.addObject("financialBackgroundInputCountByYear", financialBackgroundInputCountByYear);
				mv.addObject("financialBackgroundOutCountByYear", financialBackgroundOutCountByYear);
				mv.addObject("financialPartnerBonusInputCountByYear", financialPartnerBonusInputCountByYear);
				mv.addObject("financialAidFundInputCountByYear", financialAidFundInputCountByYear);
				//每年总利润
				mv.addObject("totalProfitCountByYear", totalProfitCountByYear);
			return mv;
		}
	 //改变资金来源
	 @RequestMapping(value="/financialSource")
		public String financialSource(HttpServletResponse response,HttpServletRequest request) throws Exception {
		String financialSource=request.getParameter("financialSource");
		/*System.out.println("financialSource"+financialSource);*/
		JSONObject json = new JSONObject();
		//这是选择年总营收金额的资金来源
		if(financialSource.equals("financialSourceType1")) {
			//从界面获取过来的年总营收金额
			String financialBackgroundInputCountByYearValue = request.getParameter("financialBackgroundInputCountByYearValue");
			//前端获取过来的值带有￥，需要截取去除，取整数
			String financialBackgroundInputCountByYearValues[] = financialBackgroundInputCountByYearValue.split("￥");
			//查询出来的升级为钻石客户经理金额，现在设置的固定值需要查询，？？
			Integer promotionDiamondCustomerManager = 300;
			//升级为钻石客户经理金额占年总营收金额比率
			float promotionDiamondCustomerManagerRate =0;
			if(financialBackgroundInputCountByYearValues.length>1) {
			float before=	Float.parseFloat(financialBackgroundInputCountByYearValues[1]);
		     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;
			}else {
				Integer before=	Integer.parseInt(financialBackgroundInputCountByYearValues[0]);
			     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;

			}
		/*	System.out.println("test1");*/
			//升级为钻石客户经理金额
			json.put("promotionDiamondCustomerManagerMoney", "￥"+promotionDiamondCustomerManager);
			//升级为钻石客户经理金额占年总营收金额比率
			json.put("promotionDiamondCustomerManagerRate",promotionDiamondCustomerManagerRate*100 );
			json.put("pd", financialSource);
		}else if(financialSource.equals("financialSourceType2")) {
			//从界面获取过来的年总支出金额
			String financialBackgroundOutCountByYearValue = request.getParameter("financialBackgroundOutCountByYearValue");
			//前端获取过来的值带有￥，需要截取去除，取整数
			String financialBackgroundOutCountByYearValues[] = financialBackgroundOutCountByYearValue.split("￥");
			//查询出来的升级为钻石客户经理金额，现在设置的固定值需要查询，？？
			Integer promotionDiamondCustomerManager = 300;
			//升级为钻石客户经理金额占总支出金额
			float promotionDiamondCustomerManagerRate =0;
			if(financialBackgroundOutCountByYearValues.length>1) {
			float before=	Float.parseFloat(financialBackgroundOutCountByYearValues[1]);
		     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;
			}else {
				Integer before=	Integer.parseInt(financialBackgroundOutCountByYearValues[0]);
			     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;

			}
			/*System.out.println("test2");*/
			//升级为钻石客户经理金额
			json.put("promotionDiamondCustomerManagerMoney", "￥"+promotionDiamondCustomerManager);
			//升级为钻石客户经理金额占年总营收金额比率
			json.put("promotionDiamondCustomerManagerRate",promotionDiamondCustomerManagerRate*100 );
			json.put("pd", financialSource);
		}else if(financialSource.equals("financialSourceType3")) {
			//从界面获取过来的年合伙人分红池金额
			String financialPartnerBonusInputCountByYearValue = request.getParameter("financialPartnerBonusInputCountByYearValue");
			//前端获取过来的值带有￥，需要截取去除，取整数
			String financialPartnerBonusInputCountByYearValues[] = financialPartnerBonusInputCountByYearValue.split("￥");
			//查询出来的升级为钻石客户经理金额，现在设置的固定值需要查询，？？
			Integer promotionDiamondCustomerManager = 300;
			//升级为钻石客户经理金额占年合伙人分红池金额
			float promotionDiamondCustomerManagerRate =0;
			if(financialPartnerBonusInputCountByYearValues.length>1) {
			float before=	Float.parseFloat(financialPartnerBonusInputCountByYearValues[1]);
		     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;
			}else {
				Integer before=	Integer.parseInt(financialPartnerBonusInputCountByYearValues[0]);
			     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;

			}
			/*System.out.println("test3");*/
			//升级为钻石客户经理金额
			json.put("promotionDiamondCustomerManagerMoney", "￥"+promotionDiamondCustomerManager);
			//升级为钻石客户经理金额占年总营收金额比率
			json.put("promotionDiamondCustomerManagerRate",promotionDiamondCustomerManagerRate*100 );
			json.put("pd", financialSource);
		}else if(financialSource.equals("financialSourceType4")) {
			//从界面获取过来的年助创基金
			String financialAidFundInputCountByYearValue = request.getParameter("financialAidFundInputCountByYearValue");
			//前端获取过来的值带有￥，需要截取去除，取整数
			String financialAidFundInputCountByYearValues[] = financialAidFundInputCountByYearValue.split("￥");
			//查询出来的升级为钻石客户经理金额，现在设置的固定值需要查询，？？
			Integer promotionDiamondCustomerManager = 300;
			//升级为钻石客户经理金额占年助创基金
			float promotionDiamondCustomerManagerRate =0;
			if(financialAidFundInputCountByYearValues.length>1) {
			float before=	Float.parseFloat(financialAidFundInputCountByYearValues[1]);
		     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;
			}else {
				Integer before=	Integer.parseInt(financialAidFundInputCountByYearValues[0]);
			     promotionDiamondCustomerManagerRate = promotionDiamondCustomerManager/before;

			}
			/*System.out.println("test4");*/
			//升级为钻石客户经理金额
			json.put("promotionDiamondCustomerManagerMoney", "￥"+promotionDiamondCustomerManager);
			//升级为钻石客户经理金额占年总营收金额比率
			json.put("promotionDiamondCustomerManagerRate",promotionDiamondCustomerManagerRate*100 );
			json.put("pd", financialSource);
		}else {
			System.out.println("test2");
			json.put("promotionDiamondCustomerManagerMoney", "￥500");
			json.put("promotionDiamondCustomerManagerRate", 0.8*100);
			json.put("pd", financialSource);
		}
		
		
	      //解析集合用的方法
	     /* JSONArray json = new JSONArray();    
	      * JSONObject jo = new JSONObject();
	      jo.put("citycode", pLog.getCitycode());
	         jo.put("pidcode", pLog.getPidcode());
	         jo.put("cityname", pLog.getCityname());
	         json.add(jo);*/
		//解析单个对象
	    
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		out.print(json.toString());
		out.close();
		return null;
		}
}
