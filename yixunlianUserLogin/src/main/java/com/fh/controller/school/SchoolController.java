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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.controller.lw.util.GetLocation;
import com.fh.entity.Page;
import com.fh.entity.system.User;
import com.fh.lw.pojo.obtainemployment.Prejob;
import com.fh.lw.pojo.school.Qualified;
import com.fh.lw.pojo.school.School;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.pojo.school.SchoolTeacher;
import com.fh.lw.pojo.user.Teacher;
import com.fh.service.school.PreJobManager;
import com.fh.service.school.QualifiedManager;
import com.fh.service.school.SchoolMajorManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.school.SchoolTeacherManager;
import com.fh.service.student.StudentManager;
import com.fh.service.system.menu.MenuManager;
import com.fh.service.system.user.TeacherManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
@Controller
@RequestMapping("school/")
public class SchoolController extends BaseController{
	String menuUrl = "school/listSchool.do"; //菜单地址(权限用)
	  @Autowired
	  private PreJobManager pjm;
	@Autowired
	private SchoolManager service;
	@Autowired
	private UserManager um;
	@Autowired
	private StudentManager sservice;
	@Autowired
	private QualifiedManager qm;
	@Autowired
	private SchoolTeacherManager stm;
	@Autowired
	private SchoolMajorManager smm;
	@Autowired
	private TeacherManager tm;
	@Resource(name="menuService")
	private MenuManager menuService;
	@RequestMapping(value="listSchool")
	public ModelAndView listUsers(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String w_ids = pd.getString("w_id"); 
		if (null != w_ids && !"".equals(w_ids)) {
			Integer w_id=Integer.parseInt(w_ids);
		
			page.setPd(pd);
		}
		String is_checks = pd.getString("is_check"); 
		if (null != is_checks && !"".equals(is_checks)) {
			Integer is_check =Integer.parseInt(is_checks);
			
			page.setPd(pd);
		}
		//学校类型查找
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
		List<School> schoolList=service.listAllSchool(page);
		List<Prejob> listPreJobs = this.pjm.ListPreJobType();
		mv.setViewName("system/school/school_list");
		mv.addObject("sList",schoolList);
		mv.addObject("pd", pd);
		mv.addObject("listPreJobs",listPreJobs);
		mv.addObject("QX",Jurisdiction.getHC());//按钮权限
		
		return mv;

		
	}
	//查看学校详情
	@RequestMapping(value="listSchoolDetail")
	public ModelAndView listSchool(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					PageData bespoke=service.findSchoolById(pd);
					mv.setViewName("system/school/school_detail");
					mv.addObject("pd", bespoke);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	//查看地址
		@RequestMapping(value="listAddress")
		public ModelAndView listAddress(Page page){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
						pd = this.getPageData();			
						page.setPd(pd);
						PageData bespoke=service.findSchoolById(pd);
						mv.setViewName("system/school/school_address");
						mv.addObject("pd", bespoke);
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		
		/**去新增页面
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="goAddS")
		public ModelAndView goAddU()throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("ROLE_ID", "4a525a16517a46a8831406bef482327e");
			List<User> uList=this.um.listUserByRoldId(pd);
			mv.setViewName("system/school/school_add");
			mv.addObject("uList",uList);
			mv.addObject("msg", "saveS");
			mv.addObject("pd", pd);
			return mv;
		}
		
		/**保存
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="saveS")
		public ModelAndView saveS() throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			logBefore(logger, Jurisdiction.getUsername()+"新增");
			ModelAndView mv = this.getModelAndView();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("create_time", time);
			pd.put("update_time", time);
			String lng=pd.getString("lng");
			String lat=pd.getString("lat");
		   String []a=GetLocation.getArea(lng, lat);//通过经纬度获取省市区
		    pd.put("province", a[0]);//设置省
		    pd.put("city", a[1]);//设置市
		    pd.put("school_phone", "028-82687920");
		    pd.put("area", a[2]);//设置区
			this.service.saveS(pd);
			pd.put("sid", 1);
			this.um.editSchoolId(pd);
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
		
	
		@RequestMapping(value = "/deleteS")
		public void deleteU(PrintWriter out) throws Exception {
			logBefore(logger, Jurisdiction.getUsername() + "删除");
			PageData pd = new PageData();
			pd = this.getPageData();
			pd=this.service.findSchoolById(pd);
			this.service.deleteS(pd);
			pd.put("sid", 0);
			this.um.editSchoolId(pd);
			out.write("success");
			out.close();
		}

		/**
		 * 查询管理员信息
		 * @param page
		 * @return
		 */
		@RequestMapping(value="goFindUser")
		public ModelAndView goFindUser(Page page){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
						pd = this.getPageData();			
						page.setPd(pd);
						PageData user=um.findById(pd);
						mv.setViewName("system/school/user_detail");
						mv.addObject("pd", user);
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		/*
		 * 刪除學生
		 */
		@RequestMapping(value = "/deleteStuden")
		public ModelAndView deleteStuden(Page page) throws Exception {
			ModelAndView mv = this.getModelAndView();

			/*if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
				return;
			} // 校验权限
*/			logBefore(logger, Jurisdiction.getUsername() + "删除學生");
			PageData pd = new PageData();
			pd = this.getPageData();
			sservice.deleteU(pd);
			mv.setViewName("system/school/school_student_list");
			return mv;
			
		}
		//只有学校才确认学生就读comfirmStuden
		@RequestMapping(value="comfirmStuden")
		public ModelAndView comfirmStuden() throws Exception{
		
//			if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限

			logBefore(logger, Jurisdiction.getUsername() + "确认學生就读");
			ModelAndView mv = this.getModelAndView();

			PageData pd = new PageData();
			pd = this.getPageData();
				
//			pd.put("USERNAME",Jurisdiction.getUsername());
//			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			
			sservice.comfirmStuden(pd);
			
			mv.setViewName("system/school/school_student_list");
			return mv;
		}
		
		/**
		 * 列出我的学校
		 */
		@RequestMapping(value="goListSchool")
		public ModelAndView goListSchool(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					pd.put("USERNAME",Jurisdiction.getUsername());
					PageData user=this.um.findByUsername(pd);//通过用户名找出用户
					String user_id=user.getString("USER_ID");
					pd.put("user_id", user_id);
					PageData school=this.service.findSchoolByUid(pd);//通过登录人的用户id找到学校
					List<User> uList=this.um.listUserByRoldId(pd);
					mv.addObject("school",school);
					mv.addObject("uList",uList);
					mv.setViewName("system/school/user_school");
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
		/**保存
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="editS")
		public ModelAndView editS() throws Exception{
			ModelAndView mv = this.getModelAndView();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("update_time", time);
			String lng=pd.getString("lng");
			String lat=pd.getString("lat");
		   String []a=GetLocation.getArea(lng, lat);//通过经纬度获取省市区
		    pd.put("province", a[0]);//设置省
		    pd.put("city", a[1]);//设置市
		    pd.put("area", a[2]);//设置区
		    String sdf=pd.getString("enroll_cost");//得到试读报名费
		    Integer bmf=(int) (Double.parseDouble(sdf)*100);
		    pd.put("enroll_cost", bmf+"");
			this.service.editS(pd);
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
		
		/**
		 * 列出我学校的学生
		 */
		@RequestMapping(value="goListStudent")
		public ModelAndView goListStudent(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					pd.put("USERNAME",Jurisdiction.getUsername());
					PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				
					
					String user_id=user.getString("USER_ID");
					String user_roleId = user.getString("ROLE_ID");
					
					pd.put("user_id", user_id);
					String state=pd.getString("state");
					PageData school=this.service.findSchoolByUid(pd);//通过登录人的用户id找到学校
					String keywords = pd.getString("keywords"); // 关键词搜索
					if (null != keywords && !"".equals(keywords)) {
						pd.put("keywords", keywords.trim());
					}
					String tphone=pd.getString("tphone");//招生老师电话
					if (null != tphone && !"".equals(tphone)) {
						pd.put("tphone", tphone.trim());
					}
					String start=pd.getString("start");
					if(start!=null && !"".equals(start)) {
					start=start+" 00:00:00";
					}
					pd.put("start", start);
					String end=pd.getString("end");
					if(end !=null && !"".equals(end)) {
					end=end+" 23:59:59";
					}
					pd.put("end", end);
                    if(school==null) {
    					page.setPd(pd);
                    }else {
                    	school.put("end", end);
                    	school.put("start", start);
                    	school.put("state", state);			
						if (null != keywords && !"".equals(keywords)) {
							school.put("keywords", keywords.trim());
						}
						if (null != tphone && !"".equals(tphone)) {
							pd.put("tphone", tphone.trim());
						}
						page.setPd(school);
                    }
					List<PageData> sList=this.sservice.listStudentBySchoolId(page);
					for(int i=0;i<sList.size();i++){//遍历
						Teacher teacher=this.tm.findTeacherById(sList.get(i).getLong("inviter_id"));
						if(teacher !=null) {
							if(teacher.getType()==1) {
							sList.get(i).put("tyname", teacher.getName());//设置一级招生老师名称
							User u=this.um.getUserById(teacher.getYwyid());//通过一级老师的业务员id找到业务员
							if(u!=null) {
							sList.get(i).put("ywyname",u.getNAME());//设置业务员姓名
							}
							}
							if(teacher.getType()==2) {
								sList.get(i).put("tename", teacher.getName());//设置二级招生老师名称
								Teacher tea=this.tm.findTeacherById(teacher.getPid());
								User u=this.um.getUserById(tea.getYwyid());//通过一级老师的业务员id找到业务员
								sList.get(i).put("tyname", tea.getName());//设置一级招生老师名称
								if(u!=null) {
									sList.get(i).put("ywyname",u.getNAME());//设置业务员姓名
									}
							}
						}
					}
					
					if(start!=null && !"".equals(start)) {
					start=start.replace(" 00:00:00","");
					pd.put("start", start);
					}
					if(end !=null && !"".equals(end)) {
					end=end.replace(" 23:59:59", "");
					pd.put("end", end);
					}
					List<Teacher> tList=this.tm.listAllTeacher();
					mv.addObject("tList",tList);
					mv.addObject("sList",sList);
					mv.addObject("pd", pd);
					mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
					mv.addObject("user_roleId",user_roleId);
					mv.setViewName("system/student/school_student_list");
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
		
		/**
		 * 运营中心查看学校的专业
		 */
		@RequestMapping(value="/goMajor")
		public ModelAndView goStudent() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			List<SchoolMajor> smList=this.smm.schoolMajorBySId(pd);	
			mv.setViewName("system/school/yymajor_list");
			mv.addObject("smList", smList);
			return mv;
		}
		
		/**
		 * 运营中心查看学校的教师
		 */
		@RequestMapping(value="/goTeacher")
		public ModelAndView goTeacher() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			List<SchoolTeacher> smList=this.stm.schoolTeacherBySId(pd);	
			mv.setViewName("system/school/yyteacher_list");
			mv.addObject("qList", smList);
			return mv;
		}
		/**
		 * 运营中心查看学校的教师
		 */
		@RequestMapping(value="/goQualified")
		public ModelAndView goQualified() throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			List<Qualified> qList=this.qm.qualifiedBySId(pd);
			mv.setViewName("system/school/yyqualified_list");
			mv.addObject("qList", qList);
			return mv;
		}
		@RequestMapping(value = "updateState")
		public void editP(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time); // 更新时间
			this.service.editState(pd);
			out.write("success");
			out.close();
		}
		
		/**导出用户信息到EXCEL
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping(value="/excel")
		public ModelAndView exportExcel() throws Exception{
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
					titles.add("序号"); 		//1
					titles.add("姓名");  		//2
					titles.add("电话");			//3
					titles.add("学校名称");			//4
					titles.add("注册时间");			//5
					titles.add("状态");			//6
					titles.add("一级招生老师");			//7
					titles.add("二级招生老师");			//8
					titles.add("业务员");
					dataMap.put("titles", titles);
					List<PageData> sList=this.sservice.listAllStudents(pd);
					List<PageData> varList = new ArrayList<PageData>();
					Integer s=-1;
					for(int i=0;i<sList.size();i++){
						PageData vpd = new PageData();
						
						vpd.put("var1", i+1+"");		//1
						vpd.put("var2", sList.get(i).getString("name"));		//2
						vpd.put("var3", sList.get(i).getString("school_phone"));			//3
						vpd.put("var4", sList.get(i).getString("school_name"));	//4
						vpd.put("var5", sList.get(i).getString("create_time"));		//5
						s=sList.get(i).getInteger("state");
						if(s==0) {
							vpd.put("var6", "待报名");		//6
						}else if(s==1){
							vpd.put("var6", "已报名");		//6
						}else if(s==2) {
							vpd.put("var6", "已退学");		//6
						}
						Teacher teacher=this.tm.findTeacherById(sList.get(i).getLong("inviter_id"));
						if(teacher !=null) {
						   if(teacher.getType()==1) {
						   vpd.put("var7",teacher.getName());//设置一级招生老师名称
						   User u=this.um.getUserById(teacher.getYwyid());//通过一级老师的业务员id找到业务员
						   if(u!=null) {
						   vpd.put("var9", u.getNAME());//设置业务员姓名
						   }
						   }
						   if(teacher.getType()==2) {
							   vpd.put("var8",teacher.getName());//设置二级招生老师名称
							   Teacher tea=this.tm.findTeacherById(teacher.getPid());
							   vpd.put("var7",tea.getName());//设置一级招生老师名称
							   User u=this.um.getUserById(tea.getYwyid());//通过一级老师的业务员id找到业务员
							   if(u!=null) {
								   vpd.put("var9", u.getNAME());//设置业务员姓名
								   }
						   }
						}
						
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
