package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.ForClause;
import com.alibaba.fastjson.JSONObject;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivityprojectandacsign;
import com.fh.lw.pojo.yixunlian.TdActivitysign;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdTransactionItem;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.utils.EasyUIResult;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySignService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.ActivityUenrollAndActivityService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.TdAddressService;
import com.fh.service.yixunlian.TransactionItemService;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("activity/")
public class ActivityController  extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private ActivityService service;
	//这是注入的是写sql语句的service
	@Autowired
	private ActivitySqlManager sqlService;
	@Autowired
	private UserManager um;
	 @Resource(name="fhlogService")
	 private FHlogManager FHLOG;
	 @Autowired
	 private ClientUserService clientUserservice;
	 //活动收费项目
	 @Autowired
	private ActivityProjectService activityProjectservice;
	 //活动：报名列表：成交项目金额设置
	 @Autowired
     private TransactionItemService transactionItemService;
	 //活动类型
	 @Autowired
	 private ActivityTypeService activityTypeService;
	 //报名
	 @Autowired
		private ActivitySignService activitySignService;
	 //地址表
	@Autowired
	private TdAddressService tdAddressService;
	
	 @Autowired
		private ActivityUenrollAndActivityService activityUenrollAndActivityService;
	//logBefore(logger, Jurisdiction.getUsername() + "确认學生就读");记录日志文档
	//分页显示活动列表
	@RequestMapping(value="goListactivity")
	public ModelAndView goListactivity(Page page)throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String keywords = pd.getString("keywords");
		//活动名称
		if(null!=keywords&&!"".equals(keywords)) {
			pd.put("keywords", keywords);
		
			page.setPd(pd);			
		}
		//主办方名称检索
		String userName = pd.getString("userName");
		if(userName!=null) {			
			TdUser tdUser = new TdUser();
			tdUser.setuName(userName);
			TdUser tdUser2 = clientUserservice.queryOne(tdUser);
			//根据关键词搜索，查看该用户是否为空
			if(tdUser2!=null) {				
				pd.put("userId", tdUser2.getUserId());	
				page.setPd(pd);	
			}
		}
		String start=pd.getString("start");
		if(start!=null && !"".equals(start)) {
		start=start+" 00:00:00";
		}
		pd.put("start", start);
		
		String end=pd.getString("end");
		if(end !=null && !"".equals(end)) {
		end=end+" 23:59:59";
		}
		pd.put("end", end);
		
		page.setPd(pd);
		if("3f9660f63a6b4d4cbf51a2bc455ca497".equals(user.getString("ROLE_ID"))) {			
			String citycode = user.getString("citycode");
			pd.put("citycode", citycode);
			page.setPd(pd);
		}
			List<PageData> listActivity = this.sqlService.getAllTdActivity(page);
			if(!listActivity.isEmpty()) {
		 float sumSoloActivityDealMoney = 0;
			for (PageData pageData : listActivity) {
			TdUser tduser = clientUserservice.queryById(pageData.getString("user_id"));
				if(tduser!=null) {					
					pageData.put("userName", tduser.getuNickname());
				}
	       //统计单独一个的活动成交金额
			
			sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
			 pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
			}
			}
		    mv.setViewName("system/activity/activity_list");
		
		    mv.addObject("listActivity",listActivity);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * goAddActivity跳转到添加活动页面
	 */
	@RequestMapping(value="/goAddActivity")
	public ModelAndView goAddActivity(Page page)throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/activity/activity_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 执行添加活动
	 */
	@RequestMapping(value="/saveActivityInfo")
	public ModelAndView saveActivityInfo() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
*/		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		TdActivity tdActivity = new TdActivity();
		service.save(tdActivity);//??添加参数

		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	/*
	 * 跳转到修改界面
	 * goEditActivity
	 */
	@RequestMapping(value="/goEditActivity")
	public ModelAndView goEditActivity() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");
		TdActivity tdActivity = service.queryById(activity_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		
		mv.setViewName("system/activity/pubActivityOrganizerInfo_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("tdActivity", tdActivity);
		return mv;
	}
	/*
	 * 执行修改
	 * 
	 */
	@RequestMapping(value="/editActivityByAid")
	public ModelAndView editActivityByAid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		TdActivity tdActivity = new TdActivity();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		pd.put("update_time", time);
		service.update(tdActivity);	//执行修改,？？传参数	
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	//上下架活动
	//updateActivityState
	@RequestMapping(value="/updateActivityState")
	public ModelAndView updateActivityState() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");
		TdActivity tdActivity = service.queryById(activity_id);
		String is_states = pd.getString("online_status");		
		Integer is_state = Integer.parseInt(is_states);
		
		if(is_state==1) {	
			FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改->"+tdActivity.getActivityName()+"活动状态:上架活动");
			logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态:上架活动");
		}else {
			FHLOG.save(Jurisdiction.getUsername(),Jurisdiction.getUsername()+ ":修改->"+tdActivity.getActivityName()+"活动状态:下架活动");
			logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态：下架活动");

		}
	
		service.updateActivityState(activity_id,is_state);
		mv.addObject("msg","ok");
		mv.setViewName("save_result");
		return mv;
	}
	
	@RequestMapping(value="showActivityDetailById")
	public ModelAndView showActivityDetailById(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");
				TdActivity tdActivity = service.queryById(activity_id);
				//省市区
				if(!"".equals(tdActivity.getPrecisionDemandProvinceId())&&tdActivity.getPrecisionDemandProvinceId()!=null) {
					TdAddress tdAddressProvince =	tdAddressService.queryById(tdActivity.getPrecisionDemandProvinceId());
					 if(tdAddressProvince!=null) {
						   tdActivity.setAddress1(tdAddressProvince.getCityname());
						  		   
					   }else {
						   if("000000".equals(tdActivity.getPrecisionDemandProvinceId())){							 
						   tdActivity.setAddress1("全国");
						   }
					   }
				}
				//市
				if(!"".equals(tdActivity.getPrecisionDemandCityId())&&tdActivity.getPrecisionDemandCityId()!=null) {
					TdAddress tdAddressCity = tdAddressService.queryById(tdActivity.getPrecisionDemandCityId());
					if(tdAddressCity!=null) {
						   tdActivity.setAddress2(tdAddressCity.getCityname());
					   }else {
						   if("000000".equals(tdActivity.getPrecisionDemandCityId())){						 
							   tdActivity.setAddress2("全省");
						   }
					   }
				}
				//区县
				if(!"".equals(tdActivity.getPrecisionDemandAreaId())&&tdActivity.getPrecisionDemandAreaId()!=null) {
					TdAddress tdAddressArea = tdAddressService.queryById(tdActivity.getPrecisionDemandAreaId());
					if(tdAddressArea!=null) {
						  			   
						   tdActivity.setAddress3(tdAddressArea.getCityname());
					}else {
						   if("000000".equals(tdActivity.getPrecisionDemandAreaId())){
							   tdActivity.setAddress3("全市");
						   }
					   }
				}
				
				  //收费项目
				TdActivityChargeItem  tdActivityChargeItem = new TdActivityChargeItem();
				tdActivityChargeItem.setActivityId(tdActivity.getActivityId());
				List<TdActivityChargeItem>	listTdActivityChargeItemByAid = activityProjectservice.queryListByWhere(tdActivityChargeItem);
				tdActivity.setListTdActivityChargeItem(listTdActivityChargeItemByAid);
				  //报名填写项全部
                List<TdActivitysign> addListTdActivitysign = activitySignService.getAddActivitySignAll(activity_id,tdActivity.getUserId());
                tdActivity.setAddListTdActivitysign(addListTdActivitysign);
				mv.addObject("tdActivity",tdActivity);
				mv.setViewName("system/activity/activityInfo_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	//delActivityByAid
	/*
	 * 单独删除一个活动
	 */
	@RequestMapping(value = "/delActivityByAid")
	public void delActivityByAid(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");
		TdActivity tdActivity = service.queryById(activity_id);
		FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":删除活动:->"+tdActivity.getActivityName());
		logBefore(logger, Jurisdiction.getUsername() + ":删除活动:->"+tdActivity.getActivityName());
	    this.service.deleteActivityByAid(activity_id);
	
		out.write("success");
		out.close();
	}
	
	
	//deleteAllActivity批量删除
	@RequestMapping(value="/deleteAllActivity")
	@ResponseBody
	public Object deleteAllActivity() throws Exception {
		
		
		TdActivity tdActivity = new TdActivity();
		PageData pd = new PageData();
		List<PageData> pdList = new ArrayList<PageData>();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		String activity_IDS = pd.getString("Activity_IDS");
		String activity_ids[] = activity_IDS.split(",");
	
		//系统日志批量删除的活动名称
		StringBuffer sb = new StringBuffer();
		for (String activityId : activity_ids) {
			tdActivity.setActivityId(activityId);
			TdActivity tdActivityById = service.queryOne(tdActivity);
			sb.append("活动->:"+tdActivityById.getActivityName()+" ");
		}
		FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":批量删除活动:->"+sb.toString());

		service.delAllActivity(activity_IDS);	
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	//活动下架理由展示SoloActivityUnderReasonList
		@RequestMapping(value="SoloActivityUnderReasonList")
		public ModelAndView SoloActivityUnderReasonList(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String activity_id = pd.getString("activity_id");
					TdActivity  tdActivity = service.queryById(activity_id);
					
					List<TdActivity> listTdActivity = new ArrayList<>();
					listTdActivity.add(tdActivity);
					mv.addObject("listTdActivity",listTdActivity);
					mv.setViewName("system/activity/activity_undercarriageReason");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		
		//上架已经下架的活动updateActivityState
		@RequestMapping(value="/updateActivityStateUnder")
		public ModelAndView updateActivityStateUnder() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
		
			String activityId = pd.getString("activityId");
			TdActivity tdActivity = service.queryById(activityId);
			String onlineStatus = pd.getString("onlineStatus");
			Integer onlineStatuss = Integer.parseInt(onlineStatus);				
			/*if(isExamines==0) {	
				FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":审核举报->"+tdActivity.getActivityName()+":"+);
				logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态:上架活动");
			}*/
		
			service.updateActivityStateUnder(activityId,onlineStatuss);
			mv.addObject("msg","ok");
			mv.setViewName("save_result");
			return mv;
		}
	
	/*
	 * 项目收费成交情况
	 * ActivityProjectDealDetail
	 */
	@RequestMapping(value="ActivityProjectDealDetail")
	public ModelAndView ActivityProjectDealDetail(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");
				
				TdActivityChargeItem tdActivityChargeItem = new TdActivityChargeItem();
			
				tdActivityChargeItem.setActivityId(activity_id);
					List<TdActivityChargeItem> activityprojectandacsigns = activityProjectservice.queryListByWhere(tdActivityChargeItem);
					mv.addObject("activityprojectandacsigns",activityprojectandacsigns);
					mv.setViewName("system/activity/activityProject_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	//上传主办方活动成交情况uploadOADealData
	@RequestMapping(value="uploadOADealData")
	public ModelAndView uploadOADealData(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
			pd = this.getPageData();			
			String activityId = pd.getString("activityId");	
			String userId = pd.getString("userId");	
			String uandactivityenrollId = pd.getString("uandactivityenrollId");
			mv.addObject("pd",pd);
			mv.setViewName("system/activity/uploadOADealData");					
			} catch(Exception e){
					logger.error(e.toString(), e);
			}
				return mv;
			}
	//执行上传数据
	
	@RequestMapping(value="/setUploadOADealData")
	public String setUploadOADealData(HttpServletResponse response,HttpServletRequest request) throws Exception {
	String activityId=request.getParameter("activityId");
	String userId=request.getParameter("userId");
	String dealStatu1=request.getParameter("dealStatu1");
	String dealStatu2=request.getParameter("dealStatu2");
	String uandactivityenrollId=request.getParameter("uandactivityenrollId");
	
    String dealProjectmInfoSaveArray = request.getParameter("dealProjectmInfoSaveArray");
  
    //未设置成交项目
    if(!"".equals(dealStatu1)&&dealStatu1!=null) {
    	int dealStatuA = Integer.parseInt(dealStatu1);
    	activityUenrollAndActivityService.setUploadOADealDataIsNotDeal(uandactivityenrollId);
    }
    //已经设置成交项目
    if(!"".equals(dealStatu2)&&dealStatu2!=null) {
    	int dealStatuB = Integer.parseInt(dealStatu2);
    	float totalMoney = 0;
    //成交项目内容
    if(!"".equals(dealProjectmInfoSaveArray)&&dealProjectmInfoSaveArray!=null) {
    	String dealProjectArrays[] = dealProjectmInfoSaveArray.split(",");
    	if(dealProjectArrays.length>0) {
    		for (int i = 0; i < dealProjectArrays.length; i++) {
				String dealProject[] = dealProjectArrays[i].split(":");
				if(dealProject.length>1) {
				if(!"".equals(dealProject[1])&&dealProject[1]!=null&&!"undefined".equals(dealProject[1])) {
					BigDecimal money = new BigDecimal(dealProject[1]);
					float soloMoney = Float.parseFloat(dealProject[1]);
					TdTransactionItem tdTransactionItem = new TdTransactionItem();
					tdTransactionItem.setTransactionItemId(this.get32UUID());
					tdTransactionItem.setTransactionItemName(dealProject[0]);
					tdTransactionItem.setTransactionItemMoney(money);
					tdTransactionItem.setActivityId(activityId);
					tdTransactionItem.setUserId(userId);
					tdTransactionItem.setStatus(0);
					transactionItemService.saveSelective(tdTransactionItem);
					totalMoney+=soloMoney;
					
				}
					
				}
			}
    	}
    }
   
	activityUenrollAndActivityService.setUploadOADealDataIsDeal(uandactivityenrollId,totalMoney);

    }
	
	//解析集合用的方法
/*	JSONArray json = new JSONArray();*/
	
       /*  JSONObject jo = new JSONObject();
         jo.put("citycode", pLog.getCitycode());
         jo.put("pidcode", pLog.getPidcode());
         jo.put("cityname", pLog.getCityname());*/
	JSONObject json = new JSONObject();
	/*json.put("uNickname", TdUser.getuNickname());*/
      /*   json.add(jo);*/
    

	
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
	  public final static String dateToString(Date time) {
			
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	        
          String times = sdf.format(time);
        
		  return times;
	  }
	public static void main(String[] args) {
		String a = "100";
		BigDecimal money = new BigDecimal(a);
		System.out.println("m"+money);
	}
}
