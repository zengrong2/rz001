package com.fh.controller.school;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.school.CommentManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@RequestMapping("comment/")
@Controller
public class CommentController extends BaseController{
	String menuUrl = "comment.do"; //菜单地址(权限用)
	@Autowired
	private CommentManager service;
	@Autowired
	private UserManager um;
	@Autowired
	private SchoolManager sservice;
	@RequestMapping(value="listComment")
	public ModelAndView listComment(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String user_id=user.getString("USER_ID");
		pd.put("user_id", user_id);
		String keywords = pd.getString("keywords"); // 关键词搜索
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
		}
		PageData school=this.sservice.findSchoolByUid(pd);//通过登录人的用户id找到学校
		if(school==null) {
			page.setPd(pd);
		}else {
			if (null != keywords && !"".equals(keywords)) {
				school.put("keywords", keywords.trim());
			}
		page.setPd(school);
		}
		List<PageData> smList=this.service.listAllComment(page);
		mv.setViewName("system/school/comment_list");
		mv.addObject("cList",smList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	@RequestMapping(value = "updateState")
	public void editP(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		pd.put("updated", time); // 更新时间
		this.service.editC(pd);
		out.write("success");
		out.close();
	}
	

}
