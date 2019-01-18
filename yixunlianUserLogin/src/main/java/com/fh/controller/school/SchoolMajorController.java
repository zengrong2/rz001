package com.fh.controller.school;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.MajorType;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.service.FMajorTypeService;
import com.fh.service.school.SchoolMajorManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("school/major/")
public class SchoolMajorController extends BaseController{
	String menuUrl = "school/major.do"; //菜单地址(权限用)
	@Autowired
	private SchoolMajorManager service;
	@Autowired
	private UserManager um;
	@Autowired
	private SchoolManager sservice;
	@Autowired
	 private FMajorTypeService fservice;
	@RequestMapping(value="listSchoolMajor")
	public ModelAndView listSchoolMajor(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords"); // 关键词搜索
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String user_id=user.getString("USER_ID");
		pd.put("user_id", user_id);
		PageData school=this.sservice.findSchoolByUid(pd);//通过登录人的用户id找到学校
		
      if(school!=null) {
    	  
    	  if (null != keywords && !"".equals(keywords)) {
    		  school.put("keywords", keywords.trim());
    	  }
    	  page.setPd(school);
    	  List<SchoolMajor> smList=this.service.listAllSchoolMajor(page);
    	  mv.addObject("smList",smList);
      }
		
		mv.setViewName("system/school/school_major_list");
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**
	 * 去新增页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goAddSm")
	public ModelAndView goAddU()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		List<MajorType> mtList=this.fservice.getMajorTypeByPid(0l);
		mv.setViewName("system/school/school_major_add");
		mv.addObject("mtList",mtList);
		mv.addObject("msg", "saveSm");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
     * 查询专业学科分类
     */
    @RequestMapping(value = "getMajorTypeByPid", method = RequestMethod.GET)
   	public ResponseEntity<List<MajorType>> getMajorTypeByPid(
   			@RequestParam(value = "pid", defaultValue = "0") Long pid) {
   		try {
   			List<MajorType> list = this.fservice.getMajorTypeByPid(pid);
   			return ResponseEntity.ok(list);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
   	}
    /**
     * 根据类别Id查询详情
     */
    @RequestMapping(value="getMajorTypeById",method=RequestMethod.GET)
    public ResponseEntity<MajorType>getMajorTypeById(@RequestParam(value="typeId")Long typeId){
  	   try {
  			MajorType list = this.fservice.queryById(typeId);
  			return ResponseEntity.ok(list);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    
    
	/**保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="saveSm")
	public ModelAndView saveS( ) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		pd.put("create_time", time);
		pd.put("update_time", time);
		String ss=pd.getString("money");
		Double smoney=Double.parseDouble(ss)*100;
		pd.put("money",smoney );
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String user_id=user.getString("USER_ID");
		pd.put("user_id", user_id);
		PageData school=this.sservice.findSchoolByUid(pd);//通过登录人的用户id找到学校
		pd.put("school_name", school.get("name"));//设置学校名称
		pd.put("school_id", school.get("school_id"));
		pd.put("is_check", 0);
		this.sservice.editState(pd);//更新审核状态
		this.service.saveSm(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	
	@RequestMapping(value = "/deleteSm")
	public void deleteU(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
		pd=this.service.findSchoolMajorById(pd);
		this.service.deleteSm(pd);
		
		out.write("success");
		out.close();
	}
	
	/**
	 * 去修改页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goEditSm")
	public ModelAndView goEditU()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd=this.service.findSchoolMajorById(pd);
		List<MajorType> mtList=this.fservice.getMajorTypeByPid(0l);
		mv.setViewName("system/school/school_major_edit");
		mv.addObject("mtList",mtList);
		mv.addObject("msg", "editSm");
		mv.addObject("pd", pd);
		
		return mv;
	}
	
	@RequestMapping(value="editSm")
	public ModelAndView editSm( ) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		pd.put("update_time", time);
		String ss=pd.getString("money");
		Double smoney=Double.parseDouble(ss)*100;
		pd.put("money",smoney );
		this.service.editSm(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	
	
}
