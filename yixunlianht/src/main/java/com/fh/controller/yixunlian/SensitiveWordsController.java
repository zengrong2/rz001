package com.fh.controller.yixunlian;

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
import com.fh.lw.pojo.yixunlian.TdSensitiveWords;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.SensitiveWordsService;
import com.fh.service.yixunlian.SensitiveWordsSqlManager;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.FileUpload;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.PathUtil;

@Controller
@RequestMapping("sensitiveWords/")
public class SensitiveWordsController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SensitiveWordsService service;
		//这是注入的是写sql语句的service
		@Autowired
		private SensitiveWordsSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@RequestMapping(value="goListSensitiveWords")
		public ModelAndView goListSensitiveWords(Page page)throws Exception {
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
			
				List<TdSensitiveWords> SensitiveWords = this.sqlService.getAllTdSensitiveWords(page);
				mv.setViewName("system/systemManager/sensitiveWords_list");
			    mv.addObject("SensitiveWords",SensitiveWords);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 跳转到修改敏感词界面
		 * goEditSensitiveWords
		 */
		 @RequestMapping(value="/goEditSensitiveWords")
			public ModelAndView goEditSensitiveWords() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String sensitive_words_id = pd.getString("sensitive_words_id");
				TdSensitiveWords tdSensitiveWords = service.queryById(sensitive_words_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/systemManager/sensitiveWords_edit");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdSensitiveWords", tdSensitiveWords);
				return mv;
			}
		 /*
		  * 执行修改操作
		  * editSensitiveWords
		  */
		 @RequestMapping(value="/editSensitiveWords")
			public ModelAndView editSensitiveWords() throws Exception{
				logBefore(logger, Jurisdiction.getUsername()+"修改");
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				TdSensitiveWords tdSensitiveWords = new TdSensitiveWords();
				tdSensitiveWords.setSensitiveWordsId(pd.getString("sensitiveWordsId"));
				tdSensitiveWords.setSensitiveWordsContext(pd.getString("sensitiveWordsContext"));
				tdSensitiveWords.setRemark(pd.getString("remark"));
				
				service.updateSelective(tdSensitiveWords);
				mv.addObject("msg","success");
				mv.setViewName("save_result");
				return mv;
			}
		 /*
		  * 跳转到添加敏感词界面
		  * goAddSensitiveWords
		  */
		 @RequestMapping(value="/goAddSensitiveWords")
			public ModelAndView goAddSensitiveWords() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
			
				mv.setViewName("system/systemManager/sensitiveWords_add");
				mv.addObject("msg", "saveU");
				mv.addObject("pd", pd);
				
				return mv;
			}
		 /*
		  * 执行保存敏感词库
		  * addSensitiveWords
		  */
		 @RequestMapping(value="/addSensitiveWords")
			public ModelAndView addSensitiveWords() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				
				String sensitiveWordsContext  =pd.getString("sensitiveWordsContext");
				TdSensitiveWords tdSensitiveWords = new TdSensitiveWords();
				tdSensitiveWords.setSensitiveWordsId(this.get32UUID());
				tdSensitiveWords.setSensitiveWordsContext(sensitiveWordsContext);
			    service.save(tdSensitiveWords);
			    
			
				mv.addObject("msg","success");
			    mv.setViewName("save_result");	
				
				return mv;
			}
}
