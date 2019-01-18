package com.fh.controller.yixunlian;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;

import com.fh.lw.pojo.yixunlian.TdActivityFillInItem;
import com.fh.lw.pojo.yixunlian.TdActivitysign;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.yixunlian.ActivityFillInItemService;
import com.fh.service.yixunlian.ActivityProjectAndEnrollService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySignService;
import com.fh.service.yixunlian.ActivityUenrollAndActivityService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

@Controller
@RequestMapping("activityUenrollAndActivity/")
public class ActivityUenrollAndActivityController extends BaseController{
	@Autowired
	private ActivityUenrollAndActivityService service;
	@Autowired
	private ClientUserService clientUserService;
	
	@Autowired
	private ActivityFillInItemService activityFillInItemService;
	@Autowired
	private ActivitySignService activitySignService;
	/*
	 * 活动报名详情
	 * ActivityEnrollInfoDetail
	 */

	/*
	 * 活动报名详情
	 * ActivityEnrollInfoDetail
	 */
	@RequestMapping(value="ActivityEnrollInfoDetail")
	public ModelAndView ActivityEnrollInfoDetail(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");				
				TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();
				tdUenrollandactivity.setActivityId(activity_id);
				List<TdUenrollandactivity> tdUenrollandactivityList = service.queryListByWhere(tdUenrollandactivity);			
				for (TdUenrollandactivity tdUenrollandactivity2 : tdUenrollandactivityList) {
				    TdUser tdUser = clientUserService.queryById(tdUenrollandactivity2.getUserId());
				    tdUenrollandactivity2.setTdUser(tdUser);
				    //报名填写项
				    //所在区域
				    TdActivitysign tdActivitysign = activitySignService.getActivitySign(activity_id,tdUenrollandactivity2.getUserId(),1);
				    //邀约人
				    TdActivitysign tdActivitysign2 = activitySignService.getActivitySign(activity_id,tdUenrollandactivity2.getUserId(),2);
				    if(tdActivitysign!=null) {
					    tdUenrollandactivity2.setMustWriteFillArea(tdActivitysign.getFillInItemVal());
				    }
                    if(tdActivitysign2!=null) {				    	
                    	tdUenrollandactivity2.setMustWriteFillInvitingUser(tdActivitysign2.getFillInItemVal());
				    }
                    //报名填写项 增项
                    List<TdActivitysign> addListTdActivitysign = activitySignService.getAddActivitySign(activity_id,tdUenrollandactivity2.getUserId());
                    tdUenrollandactivity2.setAddListTdActivitysign(addListTdActivitysign);
                    tdUenrollandactivity2.setSignTime(sdcFormatTimeToStringTime(tdUenrollandactivity2.getCreated()+""));
				}
				
				mv.addObject("tdUenrollandactivityList",tdUenrollandactivityList);			
				mv.setViewName("system/activity/activityEnrollList_detail");
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);	
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	//导出报名表excelUenrollAndActivity
	
	@SuppressWarnings({ "unused", "unlikely-arg-type" })
	@RequestMapping(value="/excelUenrollAndActivity")
	public ModelAndView excelUenrollAndActivity() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		
		pd = this.getPageData();
		try{
				String keywords = pd.getString("keywords");				//关键词检索条件
				if(null != keywords && !"".equals(keywords)){
					pd.put("keywords", keywords.trim());
				}
				String start = pd.getString("start");	//开始时间
				String end = pd.getString("end");		//结束时间
				if(start != null && !"".equals(start)){
					pd.put("start", start+" 00:00:00");
				}
				if(end != null && !"".equals(end)){
					pd.put("end", end+" 00:00:00");
				} 
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				titles.add("编号"); 		//1
				
				titles.add("姓名");  		//2
				titles.add("性别");   //3
				titles.add("电话");  		//4
				titles.add("区域");			//5
				titles.add("会员号");			//6
				titles.add("邀约人");			//7
				titles.add("增项");  		//8
				titles.add("签到");			//9
				titles.add("成交");			//10
				titles.add("提成");		//11
				titles.add("备注");	//12
				titles.add("报名时间");		//13

				dataMap.put("titles", titles);
			/*	List<Application> tList = this.srm.getListStudentResume();*/
/*				List<Shen> tList=shenService.getAllListStudentResumeShen();
*/				String activity_id = pd.getString("activity_id");				
				TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();
				tdUenrollandactivity.setActivityId(activity_id);
				List<TdUenrollandactivity> tdUenrollandactivityList = service.queryListByWhere(tdUenrollandactivity);			
				
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<tdUenrollandactivityList.size();i++){
					TdUenrollandactivity tdUenrollandactivity2 = tdUenrollandactivityList.get(i);
					 TdUser tdUser = clientUserService.queryById(tdUenrollandactivity2.getUserId());
					    tdUenrollandactivity2.setTdUser(tdUser);
					    //报名填写项
					    //所在区域
					    TdActivitysign tdActivitysign = activitySignService.getActivitySign(activity_id,tdUenrollandactivity2.getUserId(),1);
					    //邀约人
					    TdActivitysign tdActivitysign2 = activitySignService.getActivitySign(activity_id,tdUenrollandactivity2.getUserId(),2);
					    if(tdActivitysign!=null) {
						    tdUenrollandactivity2.setMustWriteFillArea(tdActivitysign.getFillInItemVal());
					    }
	                    if(tdActivitysign2!=null) {				    	
	                    	tdUenrollandactivity2.setMustWriteFillInvitingUser(tdActivitysign2.getFillInItemVal());
					    }
	                    //报名填写项 增项
	                    List<TdActivitysign> addListTdActivitysign = activitySignService.getAddActivitySign(activity_id,tdUenrollandactivity2.getUserId());
	                    tdUenrollandactivity2.setAddListTdActivitysign(addListTdActivitysign);
	                    PageData vpd = new PageData();
	                    //1
	                    vpd.put("var1", i+1+"");
	                    vpd.put("var2", tdUenrollandactivity2.getuNickname());
	                    if(tdUenrollandactivity2.getuSex()==0) {
	                    	vpd.put("var3", "女");	                    	
	                    }else if(tdUenrollandactivity2.getuSex()==1) {
	                    	vpd.put("var3", "男");	                    	
	                    }else {
	                    	vpd.put("var3", "暂无");	
	                    }
	                    
	                    vpd.put("var4", tdUenrollandactivity2.getuPhone());//电话
	                    if(!"".equals(tdUenrollandactivity2.getMustWriteFillArea())&&tdUenrollandactivity2.getMustWriteFillArea()!=null) {
	                    	vpd.put("var5", tdUenrollandactivity2.getMustWriteFillArea());	//区域
	                   	
	                    }else {
	                    	vpd.put("var5", "暂无");		                    	
	                    }
	                    
	                    vpd.put("var6",tdUenrollandactivity2.getTdUser().getMemberid());	//会员号
	                    if("".equals(tdUenrollandactivity2.getMustWriteFillInvitingUser())||tdUenrollandactivity2.getMustWriteFillInvitingUser()==null) {
	                    	tdUenrollandactivity2.setMustWriteFillInvitingUser("暂无");
	                    }
	                    if("".equals(tdUenrollandactivity2.getEventSharerMemberid())||tdUenrollandactivity2.getEventSharerMemberid()==null) {
	                    	tdUenrollandactivity2.setEventSharerMemberid("暂无");
	                    }
	                    vpd.put("var7", tdUenrollandactivity2.getMustWriteFillInvitingUser()+"/"+tdUenrollandactivity2.getEventSharerMemberid());	//mustWriteFillInvitingUser/eventSharerMemberid
	                    String addSignContext = "";
	                    for (TdActivitysign tdActivitysign3 : addListTdActivitysign) {
	                    	tdActivitysign3.getFillInItemName();
	                    	tdActivitysign3.getFillInItemVal();
	                    	if(!"".equals(tdActivitysign3.getFillInItemName())&&tdActivitysign3.getFillInItemName()!=null) {
	                    		addSignContext+=tdActivitysign3.getFillInItemName()+":"+tdActivitysign3.getFillInItemVal()+",";
	                    		
	                    	}
						}
	                    vpd.put("var8", addSignContext);	//增项
	                    if(tdUenrollandactivity2.getUsersignStatus()==0||"".equals(tdUenrollandactivity2.getUsersignStatus())||tdUenrollandactivity2.getUsersignStatus()==null) {
	                    	vpd.put("var9", "未签到");	   //签到	                    	
	                    }else if(tdUenrollandactivity2.getUsersignStatus()==1) {
	                    	vpd.put("var9", "已签到");
	                    }
	                    //成交
	                    if("".equals(tdUenrollandactivity2.getTransactionNum())||tdUenrollandactivity2.getTransactionNum()==null) {
	                    	BigDecimal s = new BigDecimal(0);
	                    	tdUenrollandactivity2.setTransactionNum(s);
	                    }
	                    if("".equals(tdUenrollandactivity2.getDealStatus())||tdUenrollandactivity2.getDealStatus()==null||tdUenrollandactivity2.getDealStatus()==0 ) {
	                    	vpd.put("var10", "未成交/"+tdUenrollandactivity2.getTransactionNum());
	                    }else if(tdUenrollandactivity2.getDealStatus()==1) {
	                    	vpd.put("var10", "已成交/"+tdUenrollandactivity2.getTransactionNum());
	                    }
	                   //提成
	                    if("".equals(tdUenrollandactivity2.getPaymentNum())||tdUenrollandactivity2.getPaymentNum()==null) {
	                    	BigDecimal s = new BigDecimal(0);
	                    	tdUenrollandactivity2.setPaymentNum(s);
	                    }
	                    if("".equals(tdUenrollandactivity2.getPaymentStatus())||tdUenrollandactivity2.getPaymentStatus()==null||tdUenrollandactivity2.getPaymentStatus()==0) {
	                    	vpd.put("var11", "未发放/"+tdUenrollandactivity2.getPaymentNum());
	                    }else if(tdUenrollandactivity2.getPaymentStatus()==1) {
	                    	vpd.put("var11", "已发放/"+tdUenrollandactivity2.getPaymentNum());
	                    }
	                    //备注
	                    vpd.put("var12", tdUenrollandactivity2.getRemar());
	                    
	                    vpd.put("var13", sdcFormatTimeToStringTime(tdUenrollandactivity2.getCreated()+""));
	                    
	                  
					varList.add(vpd);
				
				}
				dataMap.put("varList", varList);
				ObjectExcelView erv = new ObjectExcelView();					//执行excel操作
				mv = new ModelAndView(erv,dataMap);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	//Sun Dec 30 00:00:00 CST 2018  时间格式转变为2018-12-30 00:00:00时间格式
	public  static String sdcFormatTimeToStringTime(String sdcFormatTime) throws ParseException {
		String dateStr = sdcFormatTime;
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		Date date = (Date) sdf.parse(dateStr);
		String formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return formatStr;
		
	}
}
