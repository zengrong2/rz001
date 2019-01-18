package com.fh.controller.yixunlian;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ClientUserSqlManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("membershipStatements/")
public class MembershipStatementsController extends BaseController{
	//通用mapper
	@Autowired
	private ClientUserService clientUserService;
	//这是注入的是写sql语句的service
	@Autowired
	private ClientUserSqlManager sqlService;
	@Autowired
	private UserManager um;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
	 @RequestMapping(value="goListmembershipStatements")
		public ModelAndView goListmembershipStatements(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String keywords = pd.getString("keywords");
			String yearNumber = pd.getString("yearNumber");
			//统计年用户变量
			int  allCustomerCountByYear = 0;
			//统计年未激活用户
			int  allNotActiveCustomerCountByYear = 0;
			//当日新增钻石客户经理 
			int  alldiamondCustomerCountByDay = 0;
			//当日新增VIP体验客户经理 
			int  allVipCustomerCountByDay = 0;
			//当日新增用户
			int  allCustomerCountByDay = 0;
			//xin
			//当日新增VIP体验客户经理
			int  allVipExperienceCustomerCountByDay = 0;
			//当日新增VIP试用客户经理
			int  allVipTryCustomerCountByDay = 0;
			//当日新增普通客户经理
			int  allCustomerManagerCountByDay = 0;
			//当日新增普通用户
			int  allOrdinaryUserCountByDay = 0;
			//当日新增未激活用户
			int  allNotActivityUserCountByDay = 0;
			//年
			if(null!=yearNumber&&!"".equals(yearNumber)) {
				//1界面设置传来的查询年份
				/*System.out.println("yearNumber"+yearNumber);*/
			
				Integer tempYear = Integer.parseInt(yearNumber);
				String endYear = (tempYear+1)+"";
				//当前年
				String startYears = yearNumber+"-01-01 00:00:00";
				String endYears = endYear+"-01-01 00:00:00";
				//当前年的当前月的当前天
				Calendar cal = Calendar.getInstance();  									
				String month =  cal.get(Calendar.MONTH)+"";
				Integer reallyMonth = Integer.parseInt(month);
				SimpleDateFormat s=new SimpleDateFormat(yearNumber +"-"+(reallyMonth+1)+"-dd 00:00:00");
				cal.add(Calendar.DAY_OF_YEAR, +0); 
				String curDate = s.format(cal.getTime());//获取当前天
				cal.add(Calendar.DAY_OF_YEAR, +1);  
				String nextDate = s.format(cal.getTime());  //获取当前天的后一天
				//统计当日新增Vip体验客户经理
				 allVipExperienceCustomerCountByDay = clientUserService.getAllVipExperienceCustomerCountByDay(curDate,nextDate);
				//当日新增VIP试用客户经理
				 allVipTryCustomerCountByDay = clientUserService.getAllVipTryCustomerCountByDay(curDate,nextDate);
				//当日新增普通客户经理
				 allCustomerManagerCountByDay = clientUserService.getAllCustomerManagerCountByDay(curDate,nextDate);
				//当日新增普通用户
				 allOrdinaryUserCountByDay =clientUserService.getAllOrdinaryUserCountByDay(curDate,nextDate);
				//当日新增未激活用户
				 allNotActivityUserCountByDay =clientUserService.getAllNotActivityUserCountByDay(curDate,nextDate);
				//当日新增钻石客户经理
				 alldiamondCustomerCountByDay = clientUserService.getAlldiamondCustomerCountByDay(curDate,nextDate);
				//当日新增vip客户经理
				 allVipCustomerCountByDay =  clientUserService.getAllVipCustomerCountByDay(curDate,nextDate);
				//当日新增用户总数量
				 allCustomerCountByDay = clientUserService.getClientUserService(curDate,nextDate);
			
				pd.put("startYear", startYears);
				pd.put("endYear",endYears);
				page.setPd(pd);		
				//统计年总用户
				  allCustomerCountByYear = clientUserService.getAllCustomerCountByYear(startYears,endYears);
                //统计年未激活用户
				  allNotActiveCustomerCountByYear = clientUserService.getAllNotActiveCustomerCountByYear(startYears,endYears);

			    }else {	
			    //2默认为当前年份
			    Calendar now = Calendar.getInstance();  				
				String year =  now.get(Calendar.YEAR)+"";
				pd.put("yearNumber",now.get(Calendar.YEAR));
			/*	System.out.println("now"+year);
				System.out.println("now2"+now.get(Calendar.YEAR));*/
				if(year!=null) {
					Integer tempYear = Integer.parseInt(year);
					String endYear = (tempYear+1)+"";
				//当前年
					String startYears =  year+"-01-01 00:00:00";
					String endYears = endYear+"-01-01 00:00:00";
				//当前年的当前月的当前天
					Calendar cal = Calendar.getInstance();  									
					String month =  cal.get(Calendar.MONTH)+"";
					Integer reallyMonth = Integer.parseInt(month);
					SimpleDateFormat s=new SimpleDateFormat(year +"-"+(reallyMonth+1)+"-dd 00:00:00");
					cal.add(Calendar.DAY_OF_YEAR, +0); 
					String curDate = s.format(cal.getTime());//获取当前天
					cal.add(Calendar.DAY_OF_YEAR, +1);  
					String nextDate = s.format(cal.getTime());  //获取当前天的后一天
					//统计当日新增Vip体验客户经理
					 allVipExperienceCustomerCountByDay = clientUserService.getAllVipExperienceCustomerCountByDay(curDate,nextDate);
					//当日新增VIP试用客户经理
					 allVipTryCustomerCountByDay = clientUserService.getAllVipTryCustomerCountByDay(curDate,nextDate);
					//当日新增普通客户经理
					 allCustomerManagerCountByDay = clientUserService.getAllCustomerManagerCountByDay(curDate,nextDate);
					//当日新增普通用户
					 allOrdinaryUserCountByDay =clientUserService.getAllOrdinaryUserCountByDay(curDate,nextDate);
					//当日新增未激活用户
					 allNotActivityUserCountByDay =clientUserService.getAllNotActivityUserCountByDay(curDate,nextDate);
					//当日新增钻石客户经理
					 alldiamondCustomerCountByDay = clientUserService.getAlldiamondCustomerCountByDay(curDate,nextDate);
					//当日新增vip客户经理
					 allVipCustomerCountByDay =  clientUserService.getAllVipCustomerCountByDay(curDate,nextDate);
					//当日新增用户总数量
					 allCustomerCountByDay = clientUserService.getClientUserService(curDate,nextDate);
					/*System.out.println(curDate+"  "+ nextDate);
					System.out.println("a"+alldiamondCustomerCountByDay+"b"+allVipCustomerCountByDay+"c"+allCustomerCountByDay);*/
					pd.put("startYear",startYears);
					pd.put("endYear",endYears);
					page.setPd(pd);
					//统计年总用户
				  allCustomerCountByYear = clientUserService.getAllCustomerCountByYear(startYears,endYears);
				    //统计年为激活用户
				  allNotActiveCustomerCountByYear = clientUserService.getAllNotActiveCustomerCountByYear(startYears,endYears);

				}
			}
		//年钻石客户经理
			int diamondCustomerManagerCountByYear = 0;
			//每个月钻石客户经理
			pd.put("diamondCustomerManagerId", "6");
			page.setPd(pd);
			List<PageData>  diamondCustomerManagerStatistics =sqlService.getDiamondCustomerManagerStatistics(page);
			float diamondCustomerManagers[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			for (PageData pageData : diamondCustomerManagerStatistics) {
				Integer months = Integer.parseInt(pageData.getString("months"));
				
				diamondCustomerManagerCountByYear+=Integer.parseInt(pageData.getLong("count")+"");
				for(int i=0;i<diamondCustomerManagers.length;i++) {
					diamondCustomerManagers[months-1]=Float.parseFloat(pageData.getLong("count")+"") ;
				}
			}
			
			//年VIP客户经理
			int vipCustomerManagerCountByYear = 0;
			//每个月VIP客户经理
			pd.put("vipCustomerManagerId", "3");
			page.setPd(pd);
			List<PageData>  vipCustomerManagerStatistics =sqlService.getVipCustomerManagerStatistics(page);
			float vipCustomerManagers[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			for (PageData pageData : vipCustomerManagerStatistics) {
				Integer months = Integer.parseInt(pageData.getString("months"));
				vipCustomerManagerCountByYear+=Integer.parseInt(pageData.getLong("count")+"");
				for(int i=0;i<vipCustomerManagers.length;i++) {
					vipCustomerManagers[months-1]=Float.parseFloat(pageData.getLong("count")+"") ;
				}
			}
			
			//年VIP试用客户经理
			int vipTryCustomerManagerCountByYear = 0;
			//每个月VIP试用客户经理
			pd.put("vipTryCustomerManagerId", "5");
			page.setPd(pd);
			List<PageData>  vipTryCustomerManagerStatistics =sqlService.getVipTryCustomerManagerStatistics(page);
			float vipTryCustomerManagers[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			for (PageData pageData : vipTryCustomerManagerStatistics) {
				Integer months = Integer.parseInt(pageData.getString("months"));
				vipTryCustomerManagerCountByYear+=Integer.parseInt(pageData.getLong("count")+"");
				for(int i=0;i<vipTryCustomerManagers.length;i++) {
					vipTryCustomerManagers[months-1]=Float.parseFloat(pageData.getLong("count")+"") ;
				}
			}
		
			//年VIP体验客户经理
			float vipExperienceCustomerManagerCountByYear = 0;
			//每个月VIP体验客户经理
			pd.put("vipExperienceCustomerManagerId", "4");
			page.setPd(pd);
			List<PageData>  vipExperienceCustomerManagerStatistics =sqlService.getVipExperienceCustomerManagerStatistics(page);
			float vipExperienceCustomerManagers[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			for (PageData pageData : vipExperienceCustomerManagerStatistics) {
				Integer months = Integer.parseInt(pageData.getString("months"));
				vipExperienceCustomerManagerCountByYear+=Float.parseFloat(pageData.getLong("count")+"");
				for(int i=0;i<vipExperienceCustomerManagers.length;i++) {
					vipExperienceCustomerManagers[months-1]=Float.parseFloat(pageData.getLong("count")+"") ;
				}
			}
			//年普通客户经理
			float CustomerManagerCountByYear = 0;
			//每个月普通客户经理
			pd.put("CustomerManagerId", "2");
			page.setPd(pd);
			List<PageData>  CustomerManagerStatistics =sqlService.getCustomerManagerStatistics(page);
			float CustomerManagers[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			for (PageData pageData : CustomerManagerStatistics) {
				Integer months = Integer.parseInt(pageData.getString("months"));
				CustomerManagerCountByYear+=Float.parseFloat(pageData.getLong("count")+"");
				for(int i=0;i<CustomerManagers.length;i++) {
					CustomerManagers[months-1]=Float.parseFloat(pageData.getLong("count")+"") ;
				}
			}
			//年普通客户
			float customerCountByYear = 0;
			//每个月普通客户
			pd.put("CustomerId", "1");
			page.setPd(pd);
			List<PageData>  customerStatistics =sqlService.getCustomerStatistics(page);
			float customers[] = {0,0,0,0,0,0,0,0,0,0,0,0};
			for (PageData pageData : customerStatistics) {
				Integer months = Integer.parseInt(pageData.getString("months"));
				customerCountByYear+=Float.parseFloat(pageData.getLong("count")+"");
				for(int i=0;i<customers.length;i++) {
					customers[months-1]=Float.parseFloat(pageData.getLong("count")+"") ;
				}
			}
			
				mv.setViewName("system/tdUser/membershipStatements");
			 
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
				//每年
				
				mv.addObject("allCustomerCountByYear", allCustomerCountByYear);
				mv.addObject("allNotActiveCustomerCountByYear", allNotActiveCustomerCountByYear);
				mv.addObject("diamondCustomerManagerCountByYear", diamondCustomerManagerCountByYear);
				mv.addObject("vipCustomerManagerCountByYear", vipCustomerManagerCountByYear);
				mv.addObject("vipTryCustomerManagerCountByYear", vipTryCustomerManagerCountByYear);
				mv.addObject("vipExperienceCustomerManagerCountByYear", vipExperienceCustomerManagerCountByYear);
				mv.addObject("CustomerManagerCountByYear", CustomerManagerCountByYear);
				mv.addObject("customerCountByYear", customerCountByYear);
				//每月
				mv.addObject("diamondCustomerManagers", diamondCustomerManagers);
				mv.addObject("vipCustomerManagers", vipCustomerManagers);
				mv.addObject("vipTryCustomerManagers", vipTryCustomerManagers);
				mv.addObject("vipExperienceCustomerManagers", vipExperienceCustomerManagers);
				mv.addObject("CustomerManagers", CustomerManagers);
				mv.addObject("customers", customers);
				//当前年当前月当前日
				mv.addObject("alldiamondCustomerCountByDay", alldiamondCustomerCountByDay);
				mv.addObject("allVipCustomerCountByDay", allVipCustomerCountByDay);
				mv.addObject("allCustomerCountByDay", allCustomerCountByDay);				
				mv.addObject("allVipExperienceCustomerCountByDay", allVipExperienceCustomerCountByDay);
				mv.addObject("allVipTryCustomerCountByDay", allVipTryCustomerCountByDay);
				mv.addObject("allCustomerManagerCountByDay", allCustomerManagerCountByDay);
				mv.addObject("allOrdinaryUserCountByDay", allOrdinaryUserCountByDay);
				mv.addObject("allNotActivityUserCountByDay", allNotActivityUserCountByDay);
				
			return mv;
		}
	
}
