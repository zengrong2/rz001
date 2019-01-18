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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.FileUpload;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.PathUtil;
@Controller
@RequestMapping("activityMusic/")
public class ActivityMusicController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private ActivityMusicService service;
		//这是注入的是写sql语句的service
		@Autowired
		private ActivityMusicSqlManager sqlService;
		@Autowired
		private UserManager um;
	   @Resource(name="fhlogService")
		private FHlogManager FHLOG;
	   @RequestMapping(value="goListactivityMusic")
		public ModelAndView goListactivityMusic(Page page)throws Exception {
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
			/*//主办方名称检索
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
				List<TdActivitymusicurl> listActivityMusic = this.sqlService.getAllTdlistActivityMusic(page);
				mv.setViewName("system/activity/activityMusic_list");
			    mv.addObject("listActivityMusic",listActivityMusic);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
	   /*
	    * 跳转到修改界面
	    * goEditActivityMusic
	    */
	   @RequestMapping(value="/goEditActivityMusic")
		public ModelAndView goEditActivityMusic() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String activitymusic_id = pd.getString("activitymusic_id");
			TdActivitymusicurl tdActivitymusicurl = service.queryById(activitymusic_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/activity/activityMusic_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdActivitymusicurl", tdActivitymusicurl);
			return mv;
		}
	   /*
	    *执行修改
	    *editActivityMusicById
	    */
	   @RequestMapping(value="/editActivityMusicById")
		public ModelAndView editActivityMusicById(@RequestParam(required=false) MultipartFile file,
				@RequestParam String activitymusic_name,@RequestParam String activitymusic_id,
				@RequestParam String remark) throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			TdActivitymusicurl tdActivitymusicurl = new TdActivitymusicurl();
		
			
			String  ffile = DateUtil.getDays(), fileName = "";
	        if (null != file && !file.isEmpty()) {				
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;		//文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
				
			}else{
				System.out.println("上传失败");
			}
	        
	        tdActivitymusicurl.setRemark(remark);
			tdActivitymusicurl.setActivitymusicId(activitymusic_id);
			tdActivitymusicurl.setActivitymusicName(activitymusic_name);
			tdActivitymusicurl.setActivityMusicurl(ffile + "/" + fileName);
			TdActivitymusicurl before = service.queryById(activitymusic_id);
			int returnResult= service.updateSelective(tdActivitymusicurl);
			if(returnResult==1) {			
				
				FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改活动音乐:->"+"活动音乐名字"
				+before.getActivitymusicName()+" 改为: "+activitymusic_name);
			}
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
	   /*
	    * 删除活动音乐
	    * delActivityMusicById
	    */
	   @RequestMapping(value = "/delActivityMusicById")
		public void delActivityMusicById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String activitymusic_id = pd.getString("activitymusic_id");
			TdActivitymusicurl tdActivitymusicurl = service.queryById(activitymusic_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除活动音乐"+tdActivitymusicurl.getActivitymusicName());
			logBefore(logger, Jurisdiction.getUsername() + "删除活动音乐"+tdActivitymusicurl.getActivitymusicName());
		    this.service.deleteActivityMusicByAid(activitymusic_id);
		
			out.write("success");
			out.close();
		}
	   /*
	    * 跳转到添加界面
	    * goAddActivityMusic
	    */
	   @RequestMapping(value="/goAddActivityMusic")
		public ModelAndView goAddActivityMusic(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/activity/activityMusic_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
	   /*
	    * 执行添加活动音乐
	    * saveActivityMusicInfo
	    */
	   @RequestMapping(value="/saveActivityMusicInfo")
		public ModelAndView saveActivityMusicInfo(
				@RequestParam(required=false) MultipartFile file,
				@RequestParam String activitymusic_name) throws Exception{
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
			String  ffile = DateUtil.getDays(), fileName = "";
	        if (null != file && !file.isEmpty()) {
				
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;		//文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
				
			}else{
				System.out.println("上传失败");
			}
		
			TdActivitymusicurl tdActivitymusicurl = new TdActivitymusicurl();
			tdActivitymusicurl.setActivitymusicId(this.get32UUID());
			tdActivitymusicurl.setActivitymusicName(activitymusic_name);
			tdActivitymusicurl.setActivityMusicurl(ffile + "/" + fileName);
			FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":添加活动音乐->"+tdActivitymusicurl.getActivitymusicName());

			service.save(tdActivitymusicurl);//

			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
	   /*
	    * 批量删除活动音乐
	    * deleteAllActivityMusic
	    */
		@RequestMapping(value="/deleteAllActivityMusic")
		@ResponseBody
		public Object deleteAllActivityMusic() throws Exception {
			
			
			TdActivitymusicurl tdActivitymusicurl = new TdActivitymusicurl();
			PageData pd = new PageData();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			String ActivityMusic_IDS = pd.getString("ActivityMusic_IDS");
		
			//系统日志批量删除记录
			String activityMusicIds[] = ActivityMusic_IDS.split(",");
			StringBuffer sb = new StringBuffer();
			if(activityMusicIds.length>=2) {
			for (String activityMusicId:activityMusicIds) {
			
				TdActivitymusicurl activitymusicurl = service.queryById(activityMusicId);	
				if(activitymusicurl!=null) {
				
			    	sb.append("活动音乐->:"+activitymusicurl.getActivitymusicName()+" ");
			    }
				
			}
			}
			FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":批量删除活动音乐:->"+sb.toString());
			//批量删除
			service.delAllActivityMusic(ActivityMusic_IDS);	
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
}
