package com.fh.controller.yixunlian;

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
import com.fh.lw.pojo.yixunlian.TdJournalism;
import com.fh.lw.pojo.yixunlian.TdSystembulletin;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.SystembulletinService;
import com.fh.service.yixunlian.SystembulletinSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

/*
 * 系统基本信息
 */
@Controller
@RequestMapping("systembulletin/")
public class SystembulletinController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private SystembulletinService service;
	//这是注入的是写sql语句的service
	@Autowired
	private SystembulletinSqlManager sqlService;
	@Autowired
	private UserManager um;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
	@RequestMapping(value="listSystembulletin")
	public ModelAndView listSystembulletin(Page page)throws Exception {
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
		
			List<TdSystembulletin> listSystembulletin = this.sqlService.getAllTdSystembulletin(page);
			mv.setViewName("system/systemManager/systembulletin_list");
		    mv.addObject("listSystembulletin",listSystembulletin);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 浏览系统信息表(活动功能介绍和了解我们，1收益攻略，2用户协议)信息
	 * showSystembulletinDetailById
	 */
	@RequestMapping(value="showSystembulletinDetailById")
	public ModelAndView showSystembulletinDetailById(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String systembulletin_id = pd.getString("systembulletin_id");
				TdSystembulletin tdSystembulletin = service.queryById(systembulletin_id);
			    mv.addObject("tdSystembulletin",tdSystembulletin);
				mv.setViewName("system/systemManager/systembulletinInfo_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	/*
	 * 跳转到系统信息富文本编辑页面
	 * goEditSystembulletin
	 */
	@RequestMapping(value="/goEditSystembulletin")
	public ModelAndView goEditSystembulletin() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String systembulletin_id = pd.getString("systembulletin_id");
		TdSystembulletin tdSystembulletin = service.queryById(systembulletin_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		
		mv.setViewName("system/systemManager/systembulletin_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("tdSystembulletin", tdSystembulletin);
		return mv;
	}
	/*
	 * 保存富文本内容
	 * sendSystembulletin
	 */
	@RequestMapping(value="/sendSystembulletin")
	@ResponseBody
	public Object sendSystembulletin() throws MessagingException{
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> map = new HashMap<String,Object>();
		String msg = "";		//发送状态
		List<PageData> pdList = new ArrayList<PageData>();
		String CONTENT = pd.getString("CONTENT");				//内容
		String TYPE = pd.getString("TYPE");						//类型
		String systembulletinId = pd.getString("systembulletinId");	
		String systemStatus = pd.getString("systemStatus");
		String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
//TYPE 为1为文本格式，为2为html格式
    if("1".equals(TYPE)){
    	TdSystembulletin tdSystembulletin = new TdSystembulletin();
    	tdSystembulletin.setSystembulletinId(systembulletinId);
    	tdSystembulletin.setSystembulletinUrl(CONTENT);
    /*	Integer systemStatuss = Integer.parseInt(systemStatus);
    	tdSystembulletin.setSystemStatus(systemStatuss);*/
    	int returnSaveResult =	service.updateSelective(tdSystembulletin);
    	 if(returnSaveResult==1) {
         	msg = "ok";
         }else {
         	msg = "error";
         }   	
    }else if("2".equals(TYPE)) {
    	TdSystembulletin tdSystembulletin = new TdSystembulletin();
    	tdSystembulletin.setSystembulletinId(systembulletinId);
    	tdSystembulletin.setSystembulletinUrl(CONTENT);
    	/*Integer systemStatuss = Integer.parseInt(systemStatus);
    	tdSystembulletin.setSystemStatus(systemStatuss);*/
    	int returnSaveResult =	service.updateSelective(tdSystembulletin);
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
