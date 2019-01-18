package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdSystemHelp;
import com.fh.lw.pojo.yixunlian.TdSystembulletin;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.SystemHelpService;
import com.fh.service.yixunlian.SystemHelpSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("systemHelp/")
public class SystemHelpController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SystemHelpService service;
		//这是注入的是写sql语句的service
		@Autowired
		private SystemHelpSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@RequestMapping(value="goListSystemHelp")
		public ModelAndView goListSystemHelp(Page page)throws Exception {
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
			
				List<TdSystemHelp> listSystemHelp = this.sqlService.getAllTdSystemHelp(page);
				mv.setViewName("system/systemManager/systemHelp_list");
			    mv.addObject("listSystemHelp",listSystemHelp);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 显示系统帮助详情
		 * showSystemHelpDetailById
		 */
		@RequestMapping(value="showSystemHelpDetailById")
		public ModelAndView showSystemHelpDetailById(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String system_help_id = pd.getString("system_help_id");
					TdSystemHelp tdSystemHelp = service.queryById(system_help_id);
				    mv.addObject("tdSystemHelp",tdSystemHelp);
					mv.setViewName("system/systemManager/systemHelpInfo_detail");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		/*
		 * 跳转到修改富文本编辑系统帮助界面
		 * goEditSystemHelp
		 */
		@RequestMapping(value="/goEditSystemHelp")
		public ModelAndView goEditSystemHelp() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String system_help_id = pd.getString("system_help_id");
			TdSystemHelp tdSystemHelp = service.queryById(system_help_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/systemManager/systemHelp_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdSystemHelp", tdSystemHelp);
			return mv;
		}
		/*执行修改富文本系统帮助
		 * sendSystemHelpEdit
		 */
		@RequestMapping(value="/sendSystemHelpEdit")
		@ResponseBody
		public Object sendSystemHelpEdit() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
			String system_help_id = pd.getString("system_help_id");
			String system_help_type = pd.getString("system_help_type");
			String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
	//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdSystemHelp tdSystemHelp = new TdSystemHelp();
	    	tdSystemHelp.setSystemHelpId(system_help_id);
	    	tdSystemHelp.setSystemHelpContext(CONTENT);
	    	tdSystemHelp.setSystemHelpType(system_help_type);
	   
	    	int returnSaveResult =	service.updateSelective(tdSystemHelp);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	TdSystemHelp tdSystemHelp = new TdSystemHelp();
	    	tdSystemHelp.setSystemHelpId(system_help_id);
	    	tdSystemHelp.setSystemHelpContext(CONTENT);
	    	tdSystemHelp.setSystemHelpType(system_help_type);
	   
	    	int returnSaveResult =	service.updateSelective(tdSystemHelp);
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
		 * 通过id删除单个系统帮助
		 * delSystemHelpById
		 */
		@RequestMapping(value = "/delSystemHelpById")
		public void delSystemHelpById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String system_help_id = pd.getString("system_help_id");
			TdSystemHelp tdSystemHelp = service.queryById(system_help_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除系统帮助"+tdSystemHelp.getSystemHelpType());
/*			logBefore(logger, Jurisdiction.getUsername() + "删除活动"+tdActivity.getActivityName());
*/		   
            this.service.deleteByWhere(tdSystemHelp);
			out.write("success");
			out.close();
		}
		/*
		 * 跳转到添加富文本编辑系统帮助界面
		 * goAddSystemHelp
		 */
		@RequestMapping(value="/goAddSystemHelp")
		public ModelAndView goAddSystemHelp() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
		
			
			mv.setViewName("system/systemManager/systemHelp_add");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
		
			return mv;
		}
		/*
		 * 执行保存富文本内容
		 * sendSystemHelpAdd
		 */
		@RequestMapping(value="/sendSystemHelpAdd")
		@ResponseBody
		public Object sendSystemHelpAdd() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
	
			String system_help_type = pd.getString("system_help_type");
			String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
	//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdSystemHelp tdSystemHelp = new TdSystemHelp();
	    	tdSystemHelp.setSystemHelpContext(CONTENT);
	    	tdSystemHelp.setSystemHelpType(system_help_type);
	    	tdSystemHelp.setSystemHelpId(this.get32UUID());
	 
	    	int returnSaveResult =	service.save(tdSystemHelp);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	TdSystemHelp tdSystemHelp = new TdSystemHelp();
	    	tdSystemHelp.setSystemHelpContext(CONTENT);
	    	tdSystemHelp.setSystemHelpType(system_help_type);
	    	tdSystemHelp.setSystemHelpId(this.get32UUID());
	 
	    	int returnSaveResult =	service.save(tdSystemHelp);
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
