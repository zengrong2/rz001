package com.fh.controller.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivityUenrollAndActivityService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ComplaintService;
import com.fh.service.yixunlian.OrganizerInfoService;
import com.fh.service.yixunlian.OrganizerInfoSqlManager;
import com.fh.service.yixunlian.ReportService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

//主办方信息表
@Controller
@RequestMapping("organizerInfo/")
public class OrganizerInfoController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private OrganizerInfoService service;
			//这是注入的是写sql语句的service
			@Autowired
			private OrganizerInfoSqlManager sqlService;
			@Autowired
			private UserManager um;
			
			@Autowired
			private ActivityService activityService;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   @Autowired
			private ClientUserService clientUserService;
		   @Autowired
			private ReportService reportService;
		   @Autowired
			private ComplaintService complaintService;
		   //报名表
		   @Autowired
			private ActivityUenrollAndActivityService activityUenrollAndActivityService;
		   @SuppressWarnings("unlikely-arg-type")
		@RequestMapping(value="goListOrganizerInfo")
			public ModelAndView goListOrganizerInfo(Page page)throws Exception {
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				pd.put("USERNAME",Jurisdiction.getUsername());
				PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				String keywords = pd.getString("keywords");
				//投诉人名字
				if(null!=keywords&&!"".equals(keywords)) {
					TdUser tdUser = new TdUser();
					tdUser.setMemberid(keywords);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					if(tdUser2!=null) {
						pd.put("keywords", tdUser2.getUserId());
						page.setPd(pd);			
					}
				}
				//付款人名字检索
				String userName = pd.getString("userName");
				if(userName!=null) {			
					TdUser tdUser = new TdUser();
					
					tdUser.setuNickname(userName);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					//根据关键词搜索，查看该用户是否为空
					if(tdUser2!=null) {				
						pd.put("keywords", tdUser2.getUserId());	
						page.setPd(pd);	
					}
				}
					List<PageData> listOrganizerInfo = this.sqlService.getAllTdlistOrganizerInfo(page);
					//1统计所有活动，2然后统计每个活动被举报投诉次数
					int countReport = 0;
					int countComplaint = 0;
					for (PageData pageData : listOrganizerInfo) {
						TdActivity tdActivity = new TdActivity();
						tdActivity.setUserId(pageData.getString("user_id"));
						List<TdActivity> tdActivityList =activityService.queryListByWhere(tdActivity);
						for (TdActivity tdActivity2 : tdActivityList) {
							TdReport tdReport = new TdReport();
							tdReport.setActivityId(tdActivity2.getActivityId());
							countReport+= reportService.queryTotalCount(tdReport);
						    TdComplaint tdComplaint = new TdComplaint();
						    tdComplaint.setActivityId(tdActivity2.getActivityId());
						    countComplaint+=complaintService.queryTotalCount(tdComplaint);
						}
						pageData.put("countComplaint", countComplaint);
						pageData.put("countReport", countReport);
						
						//信用值计算
						TdUser tdUser = clientUserService.queryById(pageData.getString("user_id"));
					    if(tdUser!=null) {					    	
					    	if(!"".equals(tdUser.getCreditrdNum())&&tdUser.getCreditrdNum()!=null) {
					    		pageData.put("creditrdNumArray", changeCreditrdNum(tdUser.getCreditrdNum()));																		
					    	}						    	
					    }
					    //活动发布量
					    int organizerPubCountActivity = activityService.getOrganizerPubCountActivity(pageData.getString("user_id"));
					    pageData.put("organizerPubCountActivity", organizerPubCountActivity);
					    //成交总金额
					    float organizerActivityCountDealMoney = activityUenrollAndActivityService.getOrganizerActivityCountDealMoney(pageData.getString("organizer_info_id"));
					    pageData.put("organizerActivityCountDealMoney", organizerActivityCountDealMoney);
					    //分润总金额
					    float organizerActivityCountAlreadyExtractMoney = activityUenrollAndActivityService.getOrganizerActivityCountAlreadyExtractMoney(pageData.getString("organizer_info_id"));
					    pageData.put("organizerActivityCountAlreadyExtractMoney", organizerActivityCountAlreadyExtractMoney);
					}
					
					mv.setViewName("system/tdUser/organizerInfo_list");
				    mv.addObject("listOrganizerInfo",listOrganizerInfo);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
		   /*
		    * 展示用户个人信息
		    * showUserDatailById
		    */
		   @RequestMapping(value="/showUserDatailById")
			public ModelAndView showUserDatailById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String user_id = pd.getString("user_id");
				TdUser tdUser = clientUserService.queryById(user_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/tdUser/organizerInfo_userDetails");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdUser", tdUser);
				return mv;
			}
		   /*
		    * 显示单个主办方信息
		    * user_id
		    * showOrganizerInfoDatailById
		    */
		   @SuppressWarnings("unlikely-arg-type")
		@RequestMapping(value="/showOrganizerInfoDatailById")
			public ModelAndView showOrganizerInfoDatailById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String user_id = pd.getString("user_id");
				TdOrganizerInfo tdOrganizerInfo = new TdOrganizerInfo();
				tdOrganizerInfo.setUserId(user_id);
				TdOrganizerInfo tdUserOrganizerInfo = service.queryOne(tdOrganizerInfo);
				/*pd = wm.findPositionByPidd(pd);	*/
				TdUser tdUser = clientUserService.queryById(user_id);
				//信用值计算
				if(tdUser!=null) {
					if(!"".equals(tdUser.getCreditrdNum())&&tdUser.getCreditrdNum()!=null) {
						tdUser.setCreditrdNumArray(changeCreditrdNum(tdUser.getCreditrdNum()));										
					}
				}
				
				mv.setViewName("system/tdUser/organizerInfo_DetailsInfo");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdUser", tdUser);
				mv.addObject("tdUserOrganizerInfo", tdUserOrganizerInfo);
				return mv;
			}
		
	public static void main(String[] args) {
	/*	int sum = 98;
		int remark1 = sum/50;//1
		int remark2 = sum%50/25;//1
		int remark3 = sum%50%25/10;//23
		int remark4 = sum%50%25%10/5;
		int remark5 = sum%50%25%10%5;
		System.out.println("a"+remark1+"b"+remark2+"c"+remark3+"d"+remark4+"e"+remark5);*/
	System.out.println(
			changeCreditrdNum(100)[0]+" "+
			changeCreditrdNum(100)[1]+" "+
			changeCreditrdNum(100)[2]+" "+
			changeCreditrdNum(100)[3]);
	}
	//信用值计算
	public  final static Integer[] changeCreditrdNum(Integer sum ) {
		/*int a = sum/divider;*/
		/*int remark1 = sum/1250;
		int remark2 = sum%1250/250;
		int remark3 = sum%1250%250/50;
		int remark4 = sum%1250%250%50/10;
		int remark5 = sum%1250%250%50%10;*/
	
		int remark1 = sum/250;
		int remark2 = sum%250/50;
		int remark3 = sum%250%50/10;
		int remark4 = sum%250%50%10;
	    Integer creditrdNums[] = {0,0,0,0};
	    creditrdNums[0] = remark1;
	    creditrdNums[1] = remark2;
	    creditrdNums[2] = remark3;
	    creditrdNums[3] = remark4;
	   /* creditrdNums[4] = remark5; */
		return creditrdNums;
	}

}
