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
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdSystemHelp;
import com.fh.lw.pojo.yixunlian.TdSystembulletinNotice;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.SystemNoticeService;
import com.fh.service.yixunlian.SystemNoticeSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("systemNotice/")
public class SystemNoticeController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SystemNoticeService service;
		//这是注入的是写sql语句的service
		@Autowired
		private SystemNoticeSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@RequestMapping(value="listsystemNotice")
		public ModelAndView listsystemNotice(Page page)throws Exception {
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
			
				List<TdSystembulletinNotice> listSystemNotice = this.sqlService.getAllTdSystembulletinNotice(page);
				mv.setViewName("system/systemManager/systemNotice_list");
			    mv.addObject("listSystemNotice",listSystemNotice);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 跳转到添加富文本系统公告界面
		 * goAddSystemNotice
		 */
		@RequestMapping(value="/goAddSystemNotice")
		public ModelAndView goAddSystemNotice() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
		
			
			mv.setViewName("system/systemManager/systemNotice_add");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
		
			return mv;
		}
		/*执行保存系统公告富文本
		 * sendSystemNoticeAdd
		 */
		@RequestMapping(value="/sendSystemNoticeAdd")
		@ResponseBody
		public Object sendSystemNoticeAdd() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
	
			
			String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
	//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdSystembulletinNotice tdSystembulletinNotice = new TdSystembulletinNotice();
	    	tdSystembulletinNotice.setNoticeContext(pubActivityEditorImage(NewsController.editorFixImage(CONTENT)));
	    	tdSystembulletinNotice.setNoticeId(this.get32UUID());
	    	tdSystembulletinNotice.setNoticeStatus(1);
	    	int returnSaveResult =	service.save(tdSystembulletinNotice);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	TdSystembulletinNotice tdSystembulletinNotice = new TdSystembulletinNotice();
	    	tdSystembulletinNotice.setNoticeContext(pubActivityEditorImage(NewsController.editorFixImage(CONTENT)));
	    	tdSystembulletinNotice.setNoticeId(this.get32UUID());
	    	tdSystembulletinNotice.setNoticeStatus(1);
	    	int returnSaveResult =	service.save(tdSystembulletinNotice);
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
		 * 跳转到修改系统公告富文本界面
		 * goEditSystemNotice
		 */
		@RequestMapping(value="/goEditSystemNotice")
		public ModelAndView goEditSystemNotice() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String notice_id = pd.getString("notice_id");
			TdSystembulletinNotice tdSystembulletinNotice = service.queryById(notice_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/systemManager/systemNotice_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdSystembulletinNotice", tdSystembulletinNotice);
			return mv;
		}
		/*
		 * 执行修改
		 * sendSystemNoticeEdit
		 */
		@RequestMapping(value="/sendSystemNoticeEdit")
		@ResponseBody
		public Object sendSystemNoticeEdit() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
			String noticeId = pd.getString("noticeId");
		
			String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
	//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdSystembulletinNotice tdSystembulletinNotice = new TdSystembulletinNotice();
	    	tdSystembulletinNotice.setNoticeId(noticeId);
	    	tdSystembulletinNotice.setNoticeContext(pubActivityEditorImage(NewsController.editorFixImage(CONTENT)));
	    
	    	int returnSaveResult =	service.updateSelective(tdSystembulletinNotice);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	TdSystembulletinNotice tdSystembulletinNotice = new TdSystembulletinNotice();
	    	tdSystembulletinNotice.setNoticeId(noticeId);
	    	tdSystembulletinNotice.setNoticeContext(pubActivityEditorImage(NewsController.editorFixImage(CONTENT)));
	    
	    	int returnSaveResult =	service.updateSelective(tdSystembulletinNotice);
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
		 * 删除单个系统公告，不是物理删除，只是逻辑删除
		 * delSystemNoticeById
		 */
		@RequestMapping(value = "/delSystemNoticeById")
		public void delSystemNoticeById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String notice_id = pd.getString("notice_id");
			TdSystembulletinNotice tdSystembulletinNotice = service.queryById(notice_id);
			FHLOG.save(Jurisdiction.getUsername(), "系统公告");
/*			logBefore(logger, Jurisdiction.getUsername() + "删除活动"+tdActivity.getActivityName());
*/		    tdSystembulletinNotice.setNoticeId(notice_id);
            tdSystembulletinNotice.setNoticeStatus(0);
            this.service.updateSelective(tdSystembulletinNotice);
			
			out.write("success");
			out.close();
		}
		/*
		 * 显示系统公告详情
		 * showSystemNoticeDetailById
		 */
		@RequestMapping(value="showSystemNoticeDetailById")
		public ModelAndView showSystemHelpDetailById(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String notice_id = pd.getString("notice_id");
					TdSystembulletinNotice tdSystembulletinNotice = service.queryById(notice_id);
				    mv.addObject("tdSystembulletinNotice",tdSystembulletinNotice);
					mv.setViewName("system/systemManager/systemNoticeInfo_detail");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		/*
		 * 批量逻辑删除系统公告，不是物理删除
		 * deleteAllSystemNotice
		 */
		@RequestMapping(value="/deleteAllSystemNotice")
		@ResponseBody
		public Object deleteAllSystemNotice() throws Exception {
			
			FHLOG.save(Jurisdiction.getUsername(), "批量删除系统公告");
			TdSystembulletinNotice tdSystembulletinNotice = new TdSystembulletinNotice();
			PageData pd = new PageData();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			String SystemNotice_IDS = pd.getString("SystemNotice_IDS");
			service.delAllSystemNotice(SystemNotice_IDS);	
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
		public final static String pubActivityEditorImage(String editorContext) {
			String contexts[] = editorContext.split("<img src=\"");
		  	String finalContext = "";
		  	finalContext =contexts[0];
		  	String finalEditContext = "";
		  	if(contexts.length>1) {
		  		
		  		for (int i = 1; i < contexts.length; i++) {			    	 
		  			String imgContext[] =   contexts[i].split("\"");
		  			
		  			String imgContextfinal = imgContext[0];
		  			
		  			String srcContext[] =   contexts[i].split(">");
		  			String finalContextLast = "";
		  			for (int j = 1; j < srcContext.length; j++) {
		  				finalContextLast+=	">" +srcContext[j];
					}
		  			
		  			finalContext+="<img src=\""+imgContextfinal+"\""+"style=\"font-size: 0.28rem; max-width: 100%;\""+finalContextLast+">";
		  		}
		  		/*finalEditContext = finalContext.substring(0,finalContext.length()-1);*/
		  	}
		  return finalContext;
	  }
}
