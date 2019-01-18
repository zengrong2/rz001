package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.HobbyAndactivitycategoryService;
import com.fh.service.yixunlian.HobbyService;
import com.fh.service.yixunlian.HobbySqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("hobby/")
public class HobbyController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private HobbyService service;
		//这是注入的是写sql语句的service
		@Autowired
		private HobbySqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		
		
		
		
		//这个注入的是活动类别的通用mapper使用的service
		@Autowired
	    private ActivityTypeService activityTypeService;
		
		@Autowired
	    private HobbyAndactivitycategoryService hobbyAndactivitycategoryService;
		@RequestMapping(value="listHobbyType")
		public ModelAndView listHobbyType(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String keywords = pd.getString("keywords");
			//兴趣爱好
			if(null!=keywords&&!"".equals(keywords)) {
				pd.put("keywords", keywords);
			
				page.setPd(pd);			
			}
		/*	//主办方名称检索
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
			}*/
				List<PageData> listHobby = this.sqlService.getAllTdHobby(page);
				
				mv.setViewName("system/tdUser/userHobby_list");
			    mv.addObject("listHobby",listHobby);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 修改兴趣爱好
		 * goEditHobby
		 */
		@RequestMapping(value="/goEditHobby")
		public ModelAndView goEditHobby() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String hobby_id = pd.getString("hobby_id");
			TdUhobby tdUhobby = service.queryById(hobby_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			TdHobbyAndactivitycategory tdHobbyAndactivitycategory = new TdHobbyAndactivitycategory();
			tdHobbyAndactivitycategory.setHobbyId(hobby_id);
			List<TdHobbyAndactivitycategory> listHobbyAndactivitycategory =  hobbyAndactivitycategoryService.queryListByWhere(tdHobbyAndactivitycategory);  
			for (TdHobbyAndactivitycategory tdHobbyAndactivitycategory2 : listHobbyAndactivitycategory) {
				TdActivitycategory tdActivitycategory =activityTypeService.queryById(tdHobbyAndactivitycategory2.getActivitycategoryId());
				tdHobbyAndactivitycategory2.setActivityCategoryName(tdActivitycategory.getActivitycategoryName());
			}
			List<TdActivitycategory> allTdActivitycategoryList = activityTypeService.queryAll();
			
			mv.setViewName("system/tdUser/userHobby_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdUhobby", tdUhobby);
			mv.addObject("listHobbyAndactivitycategory", listHobbyAndactivitycategory);
			mv.addObject("allTdActivitycategoryList", allTdActivitycategoryList);

			return mv;
		}
		/*
		 * 执行修改
		 * editHobbyById
		 */
		@RequestMapping(value="/editHobbyById")
		public ModelAndView editHobbyById() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();

			String hobby_id = pd.getString("hobby_id");
			String hobby_name = pd.getString("hobby_name");
			String remark = pd.getString("remark");
			String Activitycategory_IDS = pd.getString("Activitycategory_IDS");
		/*	System.out.println("cd"+Activitycategory_IDS);*/
			if(!"".equals(Activitycategory_IDS)&&Activitycategory_IDS!=null) {
		
    		String ArrayActivitycategory_IDS[] = Activitycategory_IDS.split(",");
    		if(ArrayActivitycategory_IDS.length>0) {
    			TdHobbyAndactivitycategory hobbyAndactivitycategorys = new TdHobbyAndactivitycategory();
    			hobbyAndactivitycategorys.setHobbyId(hobby_id);
    			hobbyAndactivitycategoryService.deleteByWhere(hobbyAndactivitycategorys);
    		
			ArrayList<Object> list = new ArrayList<Object>();
			for(int i=0;i<ArrayActivitycategory_IDS.length;i++) {
				
				TdHobbyAndactivitycategory hobbyAndactivitycategory = new TdHobbyAndactivitycategory();
				hobbyAndactivitycategory.setUhobbyAndActivitycategoryId(this.get32UUID());
				hobbyAndactivitycategory.setHobbyId(hobby_id);
				hobbyAndactivitycategory.setActivitycategoryId(ArrayActivitycategory_IDS[i]);
				hobbyAndactivitycategoryService.saveSelective(hobbyAndactivitycategory);
			}
    		}}
			service.updateTdHobby(hobby_id,hobby_name,remark);	//执行修改
			//添加系统日志
			TdUhobby tdUhobby = service.queryById(hobby_id);
			FHLOG.save(Jurisdiction.getUsername(), "修改兴趣爱好"+tdUhobby.getHobbyName()+"的信息");
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
		
		
		/*
		 * 添加兴趣爱好
		 * goAddHobby
		 */
		@RequestMapping(value="/goAddHobby")
		public ModelAndView goAddHobby(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			
			List<TdActivitycategory> TdActivitycategoryList = activityTypeService.queryAll();
			
			mv.setViewName("system/tdUser/userHobby_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			mv.addObject("TdActivitycategoryList", TdActivitycategoryList);
			return mv;
		}
		/*
		 * 执行添加兴趣爱好(关联活动类型表)
		 * saveHobbyInfo
		 */
		@RequestMapping(value="/saveHobbyInfo")
		public void saveHobbyInfo(PrintWriter out) throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		logBefore(logger, Jurisdiction.getUsername()+"新增");
			ModelAndView mv = this.getModelAndView();
			Date date=new Date();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			TdUhobby tdUhobby = new TdUhobby();
			tdUhobby.setHobbyId(this.get32UUID());
			tdUhobby.setHobbyName(pd.getString("hobby_name"));
			
			//Activitycategory_IDS  批量添加活动类型和兴趣爱好的
			String Activitycategory_IDS = pd.getString("Activitycategory_IDS");
    		String ArrayActivitycategory_IDS[] = Activitycategory_IDS.split(",");
			ArrayList<Object> list = new ArrayList<Object>();
			for(int i=0;i<ArrayActivitycategory_IDS.length;i++) {
				
				TdHobbyAndactivitycategory hobbyAndactivitycategory = new TdHobbyAndactivitycategory();
				hobbyAndactivitycategory.setUhobbyAndActivitycategoryId(this.get32UUID());
				hobbyAndactivitycategory.setHobbyId(tdUhobby.getHobbyId());
				hobbyAndactivitycategory.setActivitycategoryId(ArrayActivitycategory_IDS[i]);
				hobbyAndactivitycategoryService.saveSelective(hobbyAndactivitycategory);
			}
			service.save(tdUhobby);
            //添加系统日志
			FHLOG.save(Jurisdiction.getUsername(), "添加兴趣爱好类型"+pd.getString("hobby_name"));
			out.write("success");
			out.close();
		}
		/*
		 * 删除兴趣爱好
		 * delHobbyById
		 */
		@RequestMapping(value = "/delHobbyById")
		public void delHobbyById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String hobby_id = pd.getString("hobby_id");
			TdUhobby tdUhobby = service.queryById(hobby_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除活动类型"+tdUhobby.getHobbyName());
			
		    this.service.deleteUhobbyById(hobby_id);
		
			out.write("success");
			out.close();
		}
}
