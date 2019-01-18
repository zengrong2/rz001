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
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.finance.LunBo;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdAdvertisementimage;
import com.fh.lw.pojo.yixunlian.TdSystemHelp;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.AdvertisementService;
import com.fh.service.yixunlian.AdvertisementSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;

@Controller
@RequestMapping("advertisement/")
public class AdvertisementController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private AdvertisementService service;
		//这是注入的是写sql语句的service
		@Autowired
		private AdvertisementSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@RequestMapping(value="listAdvertisement")
		public ModelAndView listAdvertisement(Page page)throws Exception {
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
				List<TdAdvertisementimage> listAdvertisement = this.sqlService.getAllTdAdvertisement(page);
				mv.setViewName("system/systemManager/advertisement_list");
			    mv.addObject("listAdvertisement",listAdvertisement);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行删除广告
		 * delAdvertisementByAid
		 */
		@RequestMapping(value = "/delAdvertisementByAid")
		public void delAdvertisementByAid(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			
			TdAdvertisementimage tdAdvertisementimage = service.queryById(id);
			FHLOG.save(Jurisdiction.getUsername(), "删除首页广告"+tdAdvertisementimage.getImgName());
			logBefore(logger, Jurisdiction.getUsername() + "删除首页广告"+tdAdvertisementimage.getImgName());
			TdAdvertisementimage tdAdvertisementimages = new TdAdvertisementimage();
			tdAdvertisementimages.setId(id);
			/*tdAdvertisementimages.setIsOnlineStatus(0);*/
			this.service.deleteByWhere(tdAdvertisementimages);
			out.write("success");
			out.close();
		}
		/*
		 * 跳转到添加广告界面
		 * goAddAdvertisement
		 */
		@RequestMapping(value="/goAddAdvertisement")
		public ModelAndView goAddAdvertisement(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/systemManager/advertisement_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行添加保存广告
		 * saveAdvertisementInfo
		 */
		@RequestMapping(value="/saveAdvertisementInfo")
		public ModelAndView saveAdvertisementInfo() throws Exception{
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
			TdAdvertisementimage tdAdvertisementimage = new TdAdvertisementimage();
			tdAdvertisementimage.setId(this.get32UUID());
			tdAdvertisementimage.setImgName(pd.getString("img_name"));
			service.save(tdAdvertisementimage);//

			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
		/*
		 * 跳转到上传图片界面
		 * goUploadAdvertisementImg
		 */
		@RequestMapping(value="/goUploadAdvertisementImg")
		public ModelAndView goUploadAdvertisementImg(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/systemManager/advertisement_addImage");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 上传广告图片
		 */
		@RequestMapping(value="toEdit")
		public ModelAndView toEdit()throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			try{
				pd = this.getPageData();
				
				TdAdvertisementimage tdAdvertisementimage  =service.queryById(pd.getString("id"));
			/*	pd =tdAdvertisementimage.getImgUrl(); 
				pd = lbm.listLunBo(pd);//查出轮播图
*/				mv.addObject("pd", tdAdvertisementimage);				//放入视图容器
				mv.setViewName("system/systemManager/advertisement_addImage");
			} catch(Exception e){
				logger.error(e.toString(), e);
			}
			return mv;
		}
		
		/**
		 * 保存编辑
		 * @param 
		 * @return
		 */
		@RequestMapping(value="edit")
		public ModelAndView edit()throws Exception{
			ModelAndView mv = this.getModelAndView();
			try{
				PageData pd = new PageData();
				pd = this.getPageData();
				TdAdvertisementimage tdAdvertisementimage=new TdAdvertisementimage();
			/*	lunbo.setLbt_id(Integer.parseInt(pd.getString("lbt_id")));*/
				tdAdvertisementimage.setId(pd.getString("id"));
				tdAdvertisementimage.setImgUrl(pd.getString("img_url"));
				
				service.updateSelective(tdAdvertisementimage);
			} catch(Exception e){
				logger.error(e.toString(), e);
			}
			mv.setViewName("redirect:/advertisement/toEdit.do"); //保存成功跳转到列表页面
			return mv;
		}
		/*
		 * 显示广告内容详情
		 * goShowAdDetail
		 */
		@RequestMapping(value="/goShowAdDetail")
		public ModelAndView goShowAdDetail() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			TdAdvertisementimage tdAdvertisementimage = service.queryById(id);
		
				
				
		    mv.addObject("tdAdvertisementimage", tdAdvertisementimage);
		
			mv.setViewName("system/systemManager/advertisement_adContextDetail");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
		
			return mv;
		}
		/*
		 * 显示广告图片
		 * goShowAdImg
		 */
		@RequestMapping(value="/goShowAdImg")
		public ModelAndView goShowAdImg() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			TdAdvertisementimage tdAdvertisementimage = service.queryById(id);
		
				
				
		    mv.addObject("tdAdvertisementimage", tdAdvertisementimage);
		
			mv.setViewName("system/systemManager/advertisement_ImageDetail");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
		
			return mv;
		}
		/*
		 * 执行保存添加广告富文本
		 * sendadvertisementAdd
		 */
		@RequestMapping(value="/sendadvertisementAdd")
		@ResponseBody
		public Object sendadvertisementAdd() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
			
			String img_url = pd.getString("img_url");
			String img_name = pd.getString("img_name");
			String fmsg = pd.getString("fmsg");	
			Tools tools = new Tools();
			System.out.println("aaa  "+img_url);
	//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdAdvertisementimage tdAdvertisementimage = new TdAdvertisementimage();
	    	tdAdvertisementimage.setImgName(img_name);
	    	tdAdvertisementimage.setId(this.get32UUID());
	    	tdAdvertisementimage.setIsOnlineStatus(1);
	    	tdAdvertisementimage.setAdvertisementDetailsurl(CONTENT);
	    	tdAdvertisementimage.setImgUrl(img_url);
	    	
	    	int returnSaveResult =	service.save(tdAdvertisementimage);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	TdAdvertisementimage tdAdvertisementimage = new TdAdvertisementimage();
	    	tdAdvertisementimage.setImgName(img_name);
	    	tdAdvertisementimage.setId(this.get32UUID());
	    	tdAdvertisementimage.setAdvertisementDetailsurl(CONTENT);
	    	tdAdvertisementimage.setImgUrl(img_url);
	    	tdAdvertisementimage.setIsOnlineStatus(1);
	    	int returnSaveResult =	service.save(tdAdvertisementimage);
	        if(returnSaveResult==1) {
	        	msg = "ok";
	        }else {
	        	msg = "error";
	        }    
	        }
			pd.put("msg", msg);
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
		/*
		 * 
		 * 首页轮播显示状态
		 * updateAdvertisementState
		 */
		
		@RequestMapping(value = "/updateAdvertisementState")
		public void updateAdvertisementState(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			String is_online_statuss = pd.getString("is_online_status");
			Integer is_online_status = Integer.parseInt(is_online_statuss);
			TdAdvertisementimage tdAdvertisementimage = service.queryById(id);
		
			TdAdvertisementimage tdAdvertisementimages = new TdAdvertisementimage();
			tdAdvertisementimages.setId(id);
			if(is_online_status==0) {
				tdAdvertisementimages.setIsOnlineStatus(1);
				FHLOG.save(Jurisdiction.getUsername(), "上架首页广告"+tdAdvertisementimage.getImgName());
				logBefore(logger, Jurisdiction.getUsername() + "下架首页广告"+tdAdvertisementimage.getImgName());
			}else if(is_online_status==1) {
				tdAdvertisementimages.setIsOnlineStatus(0);
				FHLOG.save(Jurisdiction.getUsername(), "上架首页广告"+tdAdvertisementimage.getImgName());
				logBefore(logger, Jurisdiction.getUsername() + "下架首页广告"+tdAdvertisementimage.getImgName());
			}
	
			this.service.updateSelective(tdAdvertisementimages);
			out.write("success");
			out.close();
		}
		/*
		 * goEditAdvertisement
		 * 跳转到广告修改界面
		 */
		
		@RequestMapping(value="/goEditAdvertisement")
		public ModelAndView goEditAdvertisement() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			TdAdvertisementimage tdAdvertisementimage = service.queryById(id);
			/*pd = wm.findPositionByPidd(pd);	*/
		
			mv.setViewName("system/systemManager/advertisement_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdAdvertisementimage", tdAdvertisementimage);
			return mv;
		}
		/*
		 * 执行修改
		 * sendadvertisementEdit
		 */
		@RequestMapping(value="/sendadvertisementEdit")
		@ResponseBody
		public Object sendadvertisementEdit() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
			String id = pd.getString("id");
			String imgUrl = pd.getString("imgurl");
			String img_name = pd.getString("img_name");
			String fmsg = pd.getString("fmsg");	
			Tools tools = new Tools();
			System.out.println("bbb  "+imgUrl);
	//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdAdvertisementimage tdAdvertisementimage = new TdAdvertisementimage();
	    	tdAdvertisementimage.setImgName(img_name);
	    	tdAdvertisementimage.setId(id);
	    	tdAdvertisementimage.setIsOnlineStatus(1);
	    	tdAdvertisementimage.setAdvertisementDetailsurl(CONTENT);
	    	tdAdvertisementimage.setImgUrl(imgUrl);
	    	int returnSaveResult =	service.updateSelective(tdAdvertisementimage);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	TdAdvertisementimage tdAdvertisementimage = new TdAdvertisementimage();
	    	tdAdvertisementimage.setImgName(img_name);
	    	tdAdvertisementimage.setId(id);
	    	tdAdvertisementimage.setAdvertisementDetailsurl(CONTENT);
	    	tdAdvertisementimage.setImgUrl(imgUrl);
	    	tdAdvertisementimage.setIsOnlineStatus(1);
	    	int returnSaveResult =	service.updateSelective(tdAdvertisementimage);
	        if(returnSaveResult==1) {
	        	msg = "ok";
	        }else {
	        	msg = "error";
	        }    
	        }
			pd.put("msg", msg);
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
		
}
