package com.fh.controller.yixunlian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdEverjoin;
import com.fh.lw.pojo.yixunlian.TdOverJoinActivityTemp;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.EverjoinActivityService;
import com.fh.util.PageData;

@Controller
@RequestMapping("everjoinActivity/")
public class EverjoinActivityController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private EverjoinActivityService service;
			//这是注入的是写sql语句的service
		/*	@Autowired
			private EverjoinActivitySqlManager sqlService;*/
			@Autowired
			private UserManager um;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   //活动
			@Autowired
			private ActivityService activityService;
		   //活动类别
		   @Autowired
			private ActivityTypeService activityTypeService;
		   @Autowired
			private ActivityProjectService activityProjectService;
		   /*
		    * 通过用户id查看曾经参与的活动
		    * listUserOverJoinDetail
		    */
			@RequestMapping(value="listUserOverJoinDetail")
			public ModelAndView listUserOverJoinDetail(){
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
						try{
						pd = this.getPageData();			
						String user_id = pd.getString("user_id");
						
						TdEverjoin tdEverjoin = new TdEverjoin();
						tdEverjoin.setUserId(user_id);
						//用户参加过的集合
						List<TdEverjoin> tdEverjoinList = service.queryListByWhere(tdEverjoin);
						Map<String,String> mapCategoryId = new HashMap<>();
					    List<TdActivity> listTdActivity = new ArrayList<>();
					    TdActivity tdActivity = new TdActivity();
					 
					    for (TdEverjoin tdEverjoin2 : tdEverjoinList) {
					    	//通过活动id查找用户参加的活动
					    	tdActivity.setActivityId(tdEverjoin2.getActivityId());				
							TdActivity tdActivity2 = activityService.queryOne(tdActivity);
							listTdActivity.add(tdActivity2);
							//活动类别id去重，然后存放map里面
							mapCategoryId.put(tdEverjoin2.getActivitycategoryId(), tdEverjoin2.getActivitycategoryId());
					    	
						
							
						}
						Set<Entry<String,String>> set = mapCategoryId.entrySet();
						//参加活动类别，参加次数，临时存放对象的集合
						List<TdOverJoinActivityTemp> tdOverJoinActivityTempList =new ArrayList<>();
						for (Entry<String, String> entry : set) { 
							TdOverJoinActivityTemp tdOverJoinActivityTemp = new TdOverJoinActivityTemp();
							tdEverjoin.setActivitycategoryId(entry.getKey());
							//通过用户id和活动类型id查询参加该类型多少次
							int overCount = service.queryTotalCount(tdEverjoin);
							//通过活动类别id查到活动类别名字
							TdActivitycategory tdActivitycategory = activityTypeService.queryById(entry.getKey());
							//把参加活动类别，参加次数，放到临时存放对象里面
							tdOverJoinActivityTemp.setJoinCount(overCount);
							tdOverJoinActivityTemp.setActivityCategoryName(tdActivitycategory.getActivitycategoryName());
							tdOverJoinActivityTempList.add(tdOverJoinActivityTemp);
						}
							
							mv.addObject("listTdActivity",listTdActivity);
							mv.addObject("tdOverJoinActivityTempList",tdOverJoinActivityTempList);
							mv.setViewName("system/tdUser/EverjoinActivity_detail");
							
						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
			
}
