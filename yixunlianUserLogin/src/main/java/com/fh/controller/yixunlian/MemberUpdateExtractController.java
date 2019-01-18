package com.fh.controller.yixunlian;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitySponsorDistributeExtract;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdMemberUpdateExtract;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.MemberUpdateExtractService;
import com.fh.service.yixunlian.MemberUpdateExtractSqlManager;
//  会员升级角色提成  
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("mUpExtract/")
public class MemberUpdateExtractController  extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private MemberUpdateExtractService service;
	//这是注入的是写sql语句的service
	@Autowired
	private MemberUpdateExtractSqlManager sqlService;
	@Autowired
	private UserManager um;
	 @Resource(name="fhlogService")
	 private FHlogManager FHLOG;
	 @Autowired
	 private ClientUserService clientUserservice;
	 @Autowired
		private ActivityProjectService activityProjectservice;
	
	        @RequestMapping(value="goListMUpExtract")
			public ModelAndView goListMUpExtract(Page page)throws Exception {
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				pd.put("USERNAME",Jurisdiction.getUsername());
				PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				String keywords = pd.getString("keywords");
				
			
					List<TdMemberUpdateExtract> listMemberUpdateExtract = this.sqlService.getAllTdlistMemberUpdateExtract(page);
					mv.setViewName("system/systemManager/memberUpdateExtract_list");
				    mv.addObject("listMemberUpdateExtract",listMemberUpdateExtract);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
	        /*
	         *跳转到会员升级提成修改界面
	         *goEditMUpExtract 
	         */
	        @RequestMapping(value="/goEditMUpExtract")
			public ModelAndView goEditMUpExtract() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String memberupdateextract_id = pd.getString("memberupdateextract_id");
				TdMemberUpdateExtract tdMemberUpdateExtract = service.queryById(memberupdateextract_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/systemManager/memberUpdateExtract_edit");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdMemberUpdateExtract", tdMemberUpdateExtract);
				return mv;
			}
		    /*
		     * 执行修改
		     * editMUpExtractById
		     */
		    @RequestMapping(value="/editMUpExtractById")
			public ModelAndView editMUpExtractById() throws Exception{
				logBefore(logger, Jurisdiction.getUsername()+"修改");
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				TdMemberUpdateExtract tdMemberUpdateExtract = new TdMemberUpdateExtract();
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				
				
				tdMemberUpdateExtract.setMemberupdateextractId(pd.getString("memberupdateextractId"));
				String memberUpdateMoney = pd.getString("memberUpdateMoney");
				Double memberUpdateMoneys = Double.parseDouble(memberUpdateMoney);
				
				/*tdMemberUpdateExtract.setMemberUpdateExtractType(memberUpdateExtractType);
				tdMemberUpdateExtract.setMemberUpdateRole(memberUpdateRole);*/
				tdMemberUpdateExtract.setMemberUpdateMoney(memberUpdateMoneys);
				tdMemberUpdateExtract.setRemark(pd.getString("remark"));
				service.updateSelective(tdMemberUpdateExtract);		
				mv.addObject("msg","success");
				mv.setViewName("save_result");
				return mv;
			}
}
