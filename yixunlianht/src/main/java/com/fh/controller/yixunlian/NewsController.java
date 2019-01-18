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
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdJournalism;
import com.fh.lw.pojo.yixunlian.TdSystemHelp;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.NewsService;
import com.fh.service.yixunlian.NewsSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.FileUpload;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.PathUtil;
import com.fh.util.Tools;
import com.fh.util.Uploader;
import com.fh.util.mail.SimpleMailSender;



@Controller
@RequestMapping("news/")
public class NewsController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private NewsService service;
	//这是注入的是写sql语句的service
	@Autowired
	private NewsSqlManager sqlService;
	@Autowired
	private UserManager um;
	 @Resource(name="fhlogService")
	private FHlogManager FHLOG;
	 @RequestMapping(value="listnews")
		public ModelAndView listnews(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String keywords = pd.getString("keywords");
			//新闻名称
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
				List<TdJournalism> listNews = this.sqlService.getAllTdJournalism(page);
				mv.setViewName("system/news/news_list");
			    mv.addObject("listNews",listNews);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
	 //
	 @RequestMapping(value="/goAddNews")
		public ModelAndView goAddNews(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/news/news_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
	 //saveNewsInfo
	 @RequestMapping(value="/saveNewsInfo")
		public ModelAndView saveNewsInfo() throws Exception{
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
			/*TdActivity tdActivity = new TdActivity();
			service.save(tdActivity);//??添加参数
*/
			
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
	 /*
	  * 跳转到修改界面
	  */
		@RequestMapping(value="/goEditJournalism")
		public ModelAndView goEditJournalism() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String journalism_id = pd.getString("journalism_id");
			TdJournalism tdJournalism = service.queryById(journalism_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/news/news_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdJournalism", tdJournalism);
			return mv;
		}
		/*
		 * 执行修改
		 * sendNewsEdit
		 */
		@RequestMapping(value="/sendNewsEdit")
		@ResponseBody
		public Object sendNewsEdit() throws MessagingException{
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "";		//发送状态
			List<PageData> pdList = new ArrayList<PageData>();
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
			String journalismId = pd.getString("journalismId");
			String journalismName = pd.getString("journalismName");
			String journalism_show_img = pd.getString("journalism_show_img");
			String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
	        String shareSummary = pd.getString("shareSummary");
	     
			//TYPE 为1为文本格式，为2为html格式
	    if("1".equals(TYPE)){
	    	TdJournalism tdJournalism = new TdJournalism();
	    	tdJournalism.setJournalismId(journalismId);
	       
	    	tdJournalism.setJournalismUrl(editorFixImage(CONTENT));
	    	tdJournalism.setJournalismName(shareSummary);
	    	if(shareSummary!=null||shareSummary!="") { 		
        		tdJournalism.setShareSummary(shareSummary);
        	}
	    	Tools tools = new Tools();
	    /*	if(tools.ueditorStrArray(CONTENT)!=null||tools.ueditorStrArray(CONTENT)!="") {
	    		
	    		tdJournalism.setJournalismShowImg("<img"+tools.ueditorStrArray(CONTENT)+"/>");
	    	}*/
	    	
    		tdJournalism.setJournalismShowImg(journalism_show_img);

	    	int returnSaveResult =	service.updateSelective(tdJournalism);
	    	 if(returnSaveResult==1) {
	         	msg = "ok";
	         }else {
	         	msg = "error";
	         }   	
	    }else if("2".equals(TYPE)) {
	    	
		      
	    	TdJournalism tdJournalism = new TdJournalism();
	    	tdJournalism.setJournalismId(journalismId);
	    	tdJournalism.setJournalismUrl(editorFixImage(CONTENT));
	    	tdJournalism.setJournalismName(journalismName);
	    	if(shareSummary!=null||shareSummary!="") { 		
	    		tdJournalism.setShareSummary(shareSummary);
        	}
	     /*	Tools tools = new Tools();
	      	if(tools.ueditorStrArray(CONTENT)!=null||tools.ueditorStrArray(CONTENT)!="") {
	    		
	    		tdJournalism.setJournalismShowImg("<img"+tools.ueditorStrArray(CONTENT)+"/>");
	    	}*/
	    	tdJournalism.setJournalismShowImg(journalism_show_img);
	    	int returnSaveResult =	service.updateSelective(tdJournalism);
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
		 * 删除新闻
		 * delJournalismById
		 */
		@RequestMapping(value = "/delJournalismById")
		public void delJournalismById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String journalism_id = pd.getString("journalism_id");
			TdJournalism tdJournalism = service.queryById(journalism_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除新闻"+tdJournalism.getJournalismName());
			logBefore(logger, Jurisdiction.getUsername() + "删除新闻"+tdJournalism.getJournalismName());
		    this.service.deleteJournalismById(journalism_id);
		
			out.write("success");
			out.close();
		}
		/*
		 * 批量删除
		 * deleteAllJournalism
		 */
		@RequestMapping(value="/deleteAllJournalism")
		@ResponseBody
		public Object deleteAllJournalism() throws Exception {
			
			FHLOG.save(Jurisdiction.getUsername(), "批量删除新闻");
			TdJournalism tdJournalism = new TdJournalism();
			PageData pd = new PageData();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			String Journalism_IDS = pd.getString("Journalism_IDS");
			service.delAllJournalism(Journalism_IDS);	
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
		
		/*
		 * 新闻发送
		 */
		@RequestMapping(value="/sendNew")
		@ResponseBody
		public Object sendNew() throws MessagingException{
			
			
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> map = new HashMap<String,Object>();
			String msg = "ok";		//发送状态
			int count = 0;			//统计发送成功条数
			int zcount = 0;			//理论条数
/*			String strEMAIL = Tools.readTxtFile(Const.EMAIL);		//读取邮件配置
*/			List<PageData> pdList = new ArrayList<PageData>();
		/*	String toEMAIL = pd.getString("EMAIL");		*/			//对方邮箱
		/*	String TITLE = pd.getString("TITLE");		*/			//标题
			String CONTENT = pd.getString("CONTENT");				//内容
			String TYPE = pd.getString("TYPE");						//类型
			
			String journalism_show_img = pd.getString("journalism_show_img");	
			String journalismName = pd.getString("journalismName");					//是否发送给全体成员 yes or no
			String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
			String shareSummary = pd.getString("shareSummary");	
			
/*		SimpleMailSender.sendEmail(strEM[0], strEM[1], strEM[2], strEM[3], userList.get(i).getString("EMAIL"), TITLE, CONTENT, TYPE);//调用发送邮件函数
*/		
//TYPE 为1为文本格式，为2为html格式 journalism_showImg
        if("1".equals(TYPE)){
        	TdJournalism tdJournalism = new TdJournalism();
        	tdJournalism.setJournalismId(this.get32UUID());
        	tdJournalism.setJournalismUrl(editorFixImage(CONTENT));
        	tdJournalism.setJournalismName(journalismName);
        	if(shareSummary!=null||shareSummary!="") { 		
        		tdJournalism.setShareSummary(shareSummary);
        	}
        	/*Tools tools = new Tools();
	    	if(tools.ueditorStrArray(CONTENT)!=null||tools.ueditorStrArray(CONTENT)!="") {
	    		
	    		tdJournalism.setJournalismShowImg("<img"+tools.ueditorStrArray(CONTENT)+"/>");
	    	}*/
    		tdJournalism.setJournalismShowImg(journalism_show_img);

        	int returnSaveResult =	service.save(tdJournalism);
        	 if(returnSaveResult==1) {
             	msg = "ok";
             }else {
             	msg = "error";
             }
        	
        }else if("2".equals(TYPE)) {
        	/* // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象    
            Multipart mainPart = new MimeMultipart();    
            // 创建一个包含HTML内容的MimeBodyPart    
            BodyPart html = new MimeBodyPart();    
            // 设置HTML内容    
            html.setContent(CONTENT, "text/html; charset=utf-8");    
            mainPart.addBodyPart(html); */
        
        	TdJournalism tdJournalism = new TdJournalism();
        	tdJournalism.setJournalismId(this.get32UUID());
        	tdJournalism.setJournalismUrl(editorFixImage(CONTENT));
        	if(shareSummary!=null||shareSummary!="") { 		
        		tdJournalism.setShareSummary(shareSummary);
        	}
        	tdJournalism.setJournalismName(journalismName);
        	Tools tools = new Tools();
	    /*	if(tools.ueditorStrArray(CONTENT)!=null||tools.ueditorStrArray(CONTENT)!="") {
	    		
	    		tdJournalism.setJournalismShowImg("<img"+tools.ueditorStrArray(CONTENT)+"/>");
	    	}*/
	    	tdJournalism.setJournalismShowImg(journalism_show_img);
             int returnSaveResult = service.save(tdJournalism);
            if(returnSaveResult==1) {
            	msg = "ok";
            }else {
            	msg = "error";
            }
            
        }
  
			pd.put("msg", msg);
			pd.put("count", count);						//成功数
			pd.put("ecount", zcount-count);				//失败数
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
		
		/*
		 * 显示新闻详情
		 * showNewsDetailById
		 */
		@RequestMapping(value="showNewsDetailById")
		public ModelAndView showNewsDetailById(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String journalism_id = pd.getString("journalism_id");
					TdJournalism tdJournalism = service.queryById(journalism_id);
				    mv.addObject("tdJournalism",tdJournalism);
					mv.setViewName("system/news/newsInfo_detail");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		/*
		 * 新闻的上下架
		 * updateNewsState
		 */
		@RequestMapping(value="/updateNewsState")
		public ModelAndView updateNewsState() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String journalism_id = pd.getString("journalism_id");
			TdJournalism tdJournalism = service.queryById(journalism_id);
			String is_onlines = pd.getString("is_online");
			
			Integer is_online = Integer.parseInt(is_onlines);
			if(is_online==1) {	
				FHLOG.save(Jurisdiction.getUsername(), "修改"+tdJournalism.getJournalismName()+"新闻状态:下架新闻");

				logBefore(logger, Jurisdiction.getUsername()+"修改"+tdJournalism.getJournalismName()+"新闻状态:下架新闻");
			}else {
				FHLOG.save(Jurisdiction.getUsername(), "修改"+tdJournalism.getJournalismName()+"新闻状态:上架新闻");

				logBefore(logger, Jurisdiction.getUsername()+"修改"+tdJournalism.getJournalismName()+"新闻状态：上架新闻");

			}
		
			service.updateActivityState(journalism_id,is_online);
			mv.addObject("msg","ok");
			mv.setViewName("save_result");
			return mv;
		}
		/*
		 * showNewImgDetailById
		 * journalism_id
		 */
		@RequestMapping(value="showNewImgDetailById")
		public ModelAndView showNewImgDetailById(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String journalism_id = pd.getString("journalism_id");
					TdJournalism tdJournalism = service.queryById(journalism_id);
				    mv.addObject("tdJournalism",tdJournalism);
					mv.setViewName("system/news/newsImgById_detail");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		//富文本内容，图片路径修改可访问
		public final static String editorFixImage(String editorContext) {
			String contexts[] = editorContext.split("<img src=\"/");
			String finalContext = "";
			finalContext =contexts[0];
		    for (int i = 1; i < contexts.length; i++) {
		    	finalContext+="<img src=\"http://ht.yxl58.com:8080/Users/Administrator/Desktop/back_yxlht/webapps/"+contexts[i];
			}
		    return finalContext;
		}
		/*public static void main(String[] args) {
			String editorContext = "<p><img src=\"/yixunlianht/plugins/ueditor/jsp/upload1/20181206/50821544067410567.jpg\\\" title='莎拉6.jpg'/></p>";
			String contexts[] = editorContext.split("<img src=\"");
			String finalContext = "";
			finalContext =contexts[0];
		    for (int i = 1; i < contexts.length; i++) {
		    	finalContext+="<img src='http://ht.yxl58.com:8080/Users/Administrator/Desktop/back_yxlht/webapps/"+contexts[i];
			}
		    System.out.println(finalContext);
		}*/
}
