package com.fh.controller.school;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Application;
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.company.Position;
import com.fh.lw.pojo.school.School;
import com.fh.lw.pojo.user.Teacher;
import com.fh.lw.utils.MD5;
import com.fh.service.company.CompanyManager;
import com.fh.service.company.WorkManager;
import com.fh.service.student.StudentManager;
import com.fh.service.student.StudentResumeManager;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

@Controller
@RequestMapping("student/")
public class StudentResumeController extends BaseController {
	String menuUrl = "student/goListResume.do"; //菜单地址(权限用)
	@Autowired
   	private UserManager um;
	@Autowired
   	private CompanyManager cm;
	@Autowired
   	private WorkManager wm;
	@Autowired
	private StudentResumeManager srm;
	 @Resource(name="fhlogService")
		private FHlogManager FHLOG;
	@RequestMapping(value="goListResume")
	public ModelAndView goListResume(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//简历查找
				String schoolType = pd.getString("schoolType"); 
				String keywords = pd.getString("keywords"); // 关键词搜索
				if (null != keywords && !"".equals(keywords)) {
					pd.put("keywords", keywords.trim());
					page.setPd(pd);
				}
				if (null != schoolType && !"".equals(schoolType)) {
					pd.put("schoolType", schoolType.trim());

					page.setPd(pd);
				}

		page.setPd(pd);
		
		List<Application> StudentResumeList=this.srm.listStudentResume(page);
		mv.setViewName("system/student/student_resume_list");
		mv.addObject("StudentResumeList",StudentResumeList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());//按钮权限
		
		return mv;

		
	}
	/**删除简历
	 * deleteResumeByid
	 */
	@RequestMapping(value = "/deleteResumeByid")
	public void deleteResumeByid(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
//		pd=this.cm.findSchoolById(pd);
		this.srm.delStudentResumeByCid(pd);
//		pd.put("companyid", 0);
//		this.um.editSchoolId(pd);
		out.write("success");
		out.close();
	}
	/**
	 * 添加页面
	 * goAddResume
	 */
	@RequestMapping(value="/goAddResume")
	public ModelAndView goAddResume()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/student/student_resume_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	/**
	 * 执行保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCompanyInfo")
	public ModelAndView saveCompanyInfo() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		pd.put("ywyid", user.getString("USER_ID"));
		pd.put("ywyphone", user.getString("PHONE"));
		pd.put("pid", 0);
		pd.put("password",MD5.md5(pd.getString("password")));	//密码加密
		pd.put("created", time);
		pd.put("updated", time);
		pd.put("type", 1);
		srm.saveStudentResumeInfo(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	/**
	 * 修改页面
	 * goEditResume
	 */
	@RequestMapping(value="/goEditResume")
	public ModelAndView goEditResume() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		int company_id=Integer.parseInt(pd.getString("company_id"));
		
	    pd= srm.getStudentResumeById(pd);	
		mv.setViewName("system/student/student_resume_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	/**
	 * 执行修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editStudentResumeByid")
	public ModelAndView editStudentResumeByid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			srm.editStudentResume(pd);;	//执行修改
			
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/**
	 * 批量操作
	 * deleteAllResume
	 */
	@RequestMapping(value="/deleteAllResume")
	@ResponseBody
	public Object deleteAllResume() throws Exception {
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"批量删除resume");
		FHLOG.save(Jurisdiction.getUsername(), "批量删除resume");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String Resume_IDS = pd.getString("Resume_IDS");
		if(null != Resume_IDS && !"".equals(Resume_IDS)){
			String ArrayResume_IDS[] = Resume_IDS.split(",");
//			userService.deleteAllU(ArrayPosition_IDS);
//			System.out.println("测试批量1");
			srm.deleteAllResume(ArrayResume_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		System.out.println("测试批量2");
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	/**导出学生简历信息到EXCEL
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/excelStudentResume")
	public ModelAndView excelStudentResume() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		
		pd = this.getPageData();
		try{
				String keywords = pd.getString("keywords");				//关键词检索条件
				if(null != keywords && !"".equals(keywords)){
					pd.put("keywords", keywords.trim());
				}
				String start = pd.getString("start");	//开始时间
				String end = pd.getString("end");		//结束时间
				if(start != null && !"".equals(start)){
					pd.put("start", start+" 00:00:00");
				}
				if(end != null && !"".equals(end)){
					pd.put("end", end+" 00:00:00");
				} 
				Map<String,Object> dataMap = new HashMap<String,Object>();
				List<String> titles = new ArrayList<String>();
				titles.add("编号"); 		//1
				
				titles.add("姓名");  		//2
				titles.add("手机");   //3
				titles.add("年龄");  		//4
				titles.add("性别");			//5
				titles.add("投递公司");			//6
				titles.add("住址");			//7
				titles.add("教育经历");  		//8
				titles.add("工作经验");			//9
				titles.add("投递职位");			//10
				titles.add("用户信息");//11
				dataMap.put("titles", titles);
				List<Application> tList = this.srm.getListStudentResume();
				
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<tList.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", i+1+"");		//1
					vpd.put("var2", tList.get(i).getApplicationName());		//2
					vpd.put("var3", tList.get(i).getApplicationPhone());		//2
					vpd.put("var4", tList.get(i).getApplicationAge());			//3
					vpd.put("var5", tList.get(i).getApplicationSex());	//4
//					pd.put("company_id",tList.get(i).getCompany_id());
					PageData company = this.cm.findCompanyById(tList.get(i).getCompany_id());
//					System.out.println("company1"+company.getString("company_name"));
					if(company!=null) {						
						vpd.put("var6",company.getString("company_name")+"");		//5
					}else {
						vpd.put("var6","");		//5

					}
					
					vpd.put("var7", tList.get(i).getApplicationAddress());		//5
					vpd.put("var8", tList.get(i).getApplicationEdcation());
					vpd.put("var9", tList.get(i).getApplicationWork());
//					pd.put("p_id",tList.get(i).getP_id());
					PageData position = this.wm.findPositionById(tList.get(i).getP_id());
//				    System.out.println("position1"+position.getString("p_name"));
					if(position!=null) {
						vpd.put("var10", position.get("p_name")+"");						
					}else {
						vpd.put("var10","");		//5

					}
					vpd.put("var11", tList.get(i).getUser_id()+"");
					varList.add(vpd);
				}
				dataMap.put("varList", varList);
				ObjectExcelView erv = new ObjectExcelView();					//执行excel操作
				mv = new ModelAndView(erv,dataMap);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
}
