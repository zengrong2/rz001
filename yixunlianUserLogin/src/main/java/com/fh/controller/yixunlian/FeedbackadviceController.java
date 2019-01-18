package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdFeedbackadvice;
import com.fh.lw.pojo.yixunlian.TdSysuserAndFeedbackadvice;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.FeedbackadviceService;
import com.fh.service.yixunlian.FeedbackadviceSqlManager;
import com.fh.service.yixunlian.SysuserAndFeedbackadviceService;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.FileUpload;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.PathUtil;

@Controller
@RequestMapping("feedbackadvice/")
public class FeedbackadviceController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private FeedbackadviceService service;
		//这是注入的是写sql语句的service
		@Autowired
		private FeedbackadviceSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@Autowired
		private SysuserAndFeedbackadviceService sysuserAndFeedbackadviceService;
		@RequestMapping(value="goListfeedbackadvice")
		public ModelAndView goListfeedbackadvice(Page page)throws Exception {
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
		
				List<TdFeedbackadvice> listFeedbackadvice = this.sqlService.getAllTdlistFeedbackadvice(page);
				mv.setViewName("system/systemManager/feedbackadvice_list");
			    mv.addObject("listFeedbackadvice",listFeedbackadvice);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
				mv.addObject("USER_ID", user.getString("USER_ID"));
			return mv;
		}
		/*
		 * 执行
		 * 修改
		 * delFeedbackadviceById
		 */
		@RequestMapping(value = "/delFeedbackadviceById")
		public void delFeedbackadviceById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String feedbackadvice_id = pd.getString("feedbackadvice_id");
			TdFeedbackadvice tdFeedbackadvice = service.queryById(feedbackadvice_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除活动反馈建议"+tdFeedbackadvice.getFeedbackadviceContext());
			logBefore(logger, Jurisdiction.getUsername() + "删除活动反馈建议"+tdFeedbackadvice.getFeedbackadviceContext());
		    this.service.deleteFeedbackadviceByAid(feedbackadvice_id);
		
			out.write("success");
			out.close();
		}
		/*
		 * 跳转到管理员采纳反馈建议并回复内容
		 * goAdoptFeedbackadvice
		 */
		@RequestMapping(value="/goSysUserReplyFeedbackadvice")
		public ModelAndView goSysUserReplyFeedbackadvice(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			pd.put("USER_ID", user.get("USER_ID"));
			
			mv.setViewName("system/systemManager/feedbackadvice_add");
			mv.addObject("msg", "saveU");
			
			mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行管理员采纳反馈建议并回复内容
		 * saveSysUserReplyFeedbackadviceInfo
		 */
		 @RequestMapping(value="/saveSysUserReplyFeedbackadviceInfo")
			public ModelAndView saveSysUserReplyFeedbackadviceInfo() throws Exception{
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
				String feedbackadvice_id = pd.getString("feedbackadvice_id");
			
				TdSysuserAndFeedbackadvice tdSysuserAndFeedbackadvice = new TdSysuserAndFeedbackadvice();
				tdSysuserAndFeedbackadvice.setSysuserAndfeedbackadviceId(this.get32UUID());
				tdSysuserAndFeedbackadvice.setFeedbackadviceId(feedbackadvice_id);
				tdSysuserAndFeedbackadvice.setReplyContext(pd.getString("reply_context"));
				tdSysuserAndFeedbackadvice.setSysuserId(pd.getString("sysuser_id"));
				if("" !=pd.getString("user_id")||null !=pd.getString("user_id")) {
					
					tdSysuserAndFeedbackadvice.setUserId(pd.getString("user_id"));
				}
				Integer  returnResult= sysuserAndFeedbackadviceService.save(tdSysuserAndFeedbackadvice);//
				if(returnResult==1) {
                	TdFeedbackadvice tdFeedbackadvice = new TdFeedbackadvice();
                	tdFeedbackadvice.setFeedbackadviceId(feedbackadvice_id);
                	tdFeedbackadvice.setIsAdopt(1);
                	service.updateSelective(tdFeedbackadvice);
                }
				mv.addObject("msg","success");
			    mv.setViewName("save_result");		
				return mv;
			}
		
		/*
		 * 跳转到系统管理员回复信息显示回复反馈建议内容
		 * goShowFeedbackadvice
		 */
		@RequestMapping(value="/goShowSysUserReplyFeedbackadvice")
		public ModelAndView goShowSysUserReplyFeedbackadvice() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String user_id = pd.getString("user_id");
		
			String feedbackadvice_id = pd.getString("feedbackadvice_id");
			
			List<TdSysuserAndFeedbackadvice> tdSysuserAndFeedbackadvice = sysuserAndFeedbackadviceService.getSysuserAndFeedbackadvice(user_id,feedbackadvice_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/systemManager/feedbackadvice_ShowSysUserReplyDetail");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdSysuserAndFeedbackadvice", tdSysuserAndFeedbackadvice);
			return mv;
		}
		
		/*
		 * 修改反馈建议查阅状态
		 * updateFeedbackAdviceState
		 */
		@RequestMapping(value="/updateFeedbackAdviceState")
		public ModelAndView updateFeedbackAdviceState() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			 
			
			String  is_already_consulteds = pd.getString("is_already_consulted");
			Integer is_already_consulted = Integer.parseInt(is_already_consulteds);
			String feedbackadvice_id = pd.getString("feedbackadvice_id");
			
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			
			TdFeedbackadvice tdFeedbackadvice = new TdFeedbackadvice();
			tdFeedbackadvice.setFeedbackadviceId(feedbackadvice_id);
			tdFeedbackadvice.setIsAlreadyConsulted(1);
			
			Integer returnValue =  service.updateSelective(tdFeedbackadvice);
		
			if(returnValue==1) {
				FHLOG.save(Jurisdiction.getUsername(),Jurisdiction.getUsername()+"查阅 并修改反馈建议查阅状态");

			}
			/*tdSysuserAndFeedbackadvice.updateActivityState(activity_id,is_state);
			*/
			mv.setViewName("save_result");
			return mv;
		}
}
