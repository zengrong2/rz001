package com.fh.controller.yixunlian;

import java.util.List;

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
				}
				
				mv.addObject("tdUenrollandactivityList",tdUenrollandactivityList);			
				mv.setViewName("system/activity/activityEnrollList_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	//待发放提成的报名列表SoloActivityWaitPayExtract
	@RequestMapping(value="SoloActivityWaitPayExtract")
	public ModelAndView SoloActivityWaitPayExtract(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");				
				TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();
				tdUenrollandactivity.setActivityId(activity_id);
				tdUenrollandactivity.setPaymentStatus(0);
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
				}
				
				mv.addObject("tdUenrollandactivityList",tdUenrollandactivityList);			
				mv.setViewName("system/activity/activityEnrollList_waitPayExtract");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
}
