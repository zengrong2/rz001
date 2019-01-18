package com.fh.controller.system.user;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.system.User;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.pojo.student.Student;
import com.fh.lw.pojo.user.Teacher;
import com.fh.lw.utils.MD5;
import com.fh.service.school.SchoolMajorManager;
import com.fh.service.student.StudentManager;
import com.fh.service.system.user.TeacherManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

@RequestMapping("teacher/")
@Controller
public class TeacherController extends BaseController{
	String menuUrl = "teacher/list.do"; //菜单地址(权限用)
   @Autowired
   private TeacherManager service;
   @Autowired
   private StudentManager sservice;
   @Autowired
	private UserManager um;
   @Autowired
   private SchoolMajorManager ssmService;
   //显示列表
   @RequestMapping(value="list")
   public ModelAndView list() {
   	ModelAndView mv=this.getModelAndView();
   	PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords"); // 关键词搜索
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
		}
		try {
			String SERVE_ID = (null == pd.get("tid") || "".equals(pd.get("tid").toString()))?"0":pd.get("tid").toString();
			Long tid=Long.parseLong(SERVE_ID);
			pd.put("pid", tid);
			String yphone=pd.getString("ywyphone");
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			if("3f9660f63a6b4d4cbf51a2bc455ca497".equals(user.get("ROLE_ID"))) {
				//如果他是业务员
				pd.put("ywyid", user.getString("USER_ID"));
			}
			List<Teacher> serList = service.listSubTeacherBypId(pd);
			
			//*********
			
			//一级老师
			if(tid==0) {
				for (Teacher teacher : serList) {
					teacher.setIntegral(0);
					int firstTeaExtractMoney = 0;
					pd.put("tids", teacher.getTid());
					List<PageData> firstTeaGetStu = sservice.findFirstTeaGetStu(pd);
						
						if(firstTeaGetStu.isEmpty()) {
							//一级老师自己和二级老师都没招聘到学生的情况
							teacher.setIntegral(firstTeaExtractMoney);
						}else {
						
								for(int j=0;j<firstTeaGetStu.size();j++){	
//									System.out.println("测试学生"+firstTeaGetStu.get(j).toString());
//									System.out.println("学校id"+firstTeaGetStu.get(j).getLong("school_id")+"专业"+
//											firstTeaGetStu.get(j).getString("mojar"));
									//是否确认就读
									if(firstTeaGetStu.get(j).getInteger("state")==3) {
									//每个学生报名总费用
									if(firstTeaGetStu.get(j).getLong("school_id")!=0&&firstTeaGetStu.get(j).getLong("school_id")!=null
									&&firstTeaGetStu.get(j).getString("mojar")!=null&&firstTeaGetStu.get(j).getString("mojar")!="") {
									 pd.put("school_ids", firstTeaGetStu.get(j).getLong("school_id"));
								     pd.put("mojars", firstTeaGetStu.get(j).getString("mojar"));
								     SchoolMajor   soloStuAllMoneyToFirst = ssmService.getMoneyBySid(pd);
								    if(soloStuAllMoneyToFirst!=null) {
								    	 
//								    	 System.out.println("测试123"+firstTeaExtractMoney);
								    	 firstTeaExtractMoney +=soloStuAllMoneyToFirst.getMoney();
								    	 
								    }else {
								    	 firstTeaExtractMoney+=0;
								    }
									}else {
										firstTeaExtractMoney+=0;
									}
									}else {
										firstTeaExtractMoney+=0;
									}
								}
//								System.out.println("测试缴费"+firstTeaExtractMoney);
							teacher.setIntegral((firstTeaExtractMoney/100)*teacher.getCommission());
						    pd.put("integrals",teacher.getIntegral());
							pd.put("teaId", teacher.getTid());
						    this.service.addIntegralTeacherByTid(pd);
						}
					

				}
			}else {
				
				for (Teacher teacher : serList) {
					
					int firstTeaExtractMoney = 0;
					pd.put("tids", teacher.getTid());
					List<PageData> firstTeaGetStu = sservice.findFirstTeaGetStu(pd);
						
						if(firstTeaGetStu.isEmpty()) {
							//一级老师自己和二级老师都没招聘到学生的情况
							teacher.setIntegral(firstTeaExtractMoney);
						}else {
						
								for(int j=0;j<firstTeaGetStu.size();j++){	
//									
									//是否确认就读
									if(firstTeaGetStu.get(j).getInteger("state")==3) {
									//每个学生报名总费用
									if(firstTeaGetStu.get(j).getLong("school_id")!=0&&firstTeaGetStu.get(j).getLong("school_id")!=null
									&&firstTeaGetStu.get(j).getString("mojar")!=null&&firstTeaGetStu.get(j).getString("mojar")!="") {
									 pd.put("school_ids", firstTeaGetStu.get(j).getLong("school_id"));
								     pd.put("mojars", firstTeaGetStu.get(j).getString("mojar"));
								     SchoolMajor   soloStuAllMoneyToFirst = ssmService.getMoneyBySid(pd);
								    if(soloStuAllMoneyToFirst!=null) {
								    	
								    	 firstTeaExtractMoney +=soloStuAllMoneyToFirst.getMoney();
								    }else {
								    	 firstTeaExtractMoney+=0;
								    }
									}else {
										firstTeaExtractMoney+=0;
									}
									}else {
										firstTeaExtractMoney+=0;
									}
								}
							teacher.setIntegral((firstTeaExtractMoney/100)*teacher.getCommission());
//							System.out.println("缴费2"+teacher.getIntegral());
							pd.put("integrals",teacher.getIntegral());
							pd.put("teaId", teacher.getTid());
							this.service.addIntegralTeacherByTid(pd);
						}
					
			}
			}
			
			mv.addObject("pd", service.getTeacherById(pd));
			mv.addObject("tid", tid);
			mv.addObject("MSG", null == pd.get("MSG")?"list":pd.get("MSG").toString()); //MSG=change 则为编辑或删除后跳转过来的
			mv.addObject("tList",serList);
			mv.addObject("yphone",yphone);
			mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
			mv.setViewName("system/user/teacher_list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//传入父菜单所有信息
   	return mv;
   }
 
   /**去新增用户页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAddT")
	public ModelAndView goAddU()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/user/teacher_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**保存用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveT")
	public ModelAndView saveU() throws Exception{
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
		pd.put("create_time", time);
		pd.put("update_time", time);
		pd.put("type", 1);
		service.saveT(pd); 					//执行保存
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	
	@RequestMapping(value="/goEditT")
	public ModelAndView goEditU() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = service.getTeacherById(pd);	
		mv.setViewName("system/user/commission_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	
	@RequestMapping(value="/editT")
	public ModelAndView editU() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Long tids=Long.parseLong(pd.getString("tid"));//得到招生老师id
		String phone=pd.getString("phone");//得到电话
		Teacher t=this.service.findTeacherByPhone(phone);//通过电话找到老师
		if(t==null || t.getTid()==tids) {
			//如果招生老师为空，或者跟当前招生老师一样
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			service.edit(pd);;	//执行修改
			List<PageData> sList=this.sservice.listStudentByInviter(pd);//通过招生老师Id找出学生
			if(sList!=null) {
			for (PageData pageData : sList) {
				pageData.put("tid", tids);
				pageData.put("phone", phone);
				this.sservice.editTid(pageData);
			}
			}
		}else {//否则就是转户
			List<Teacher> tlist=this.service.listTeacherBypId(tids);//通过当前id找出下面的二级招生老师
			PageData p=new PageData();
			p.put("pid", t.getTid());//
			if(tlist!=null) {
			for (Teacher teacher : tlist) {
				p.put("tid", teacher.getTid());
				
				this.service.editPid(p);//更新
			}
			}
			List<PageData> sList=this.sservice.listStudentByInviter(pd);//通过招生老师Id找出学生
			if(sList!=null) {
			for (PageData pageData : sList) {
				pageData.put("tid", t.getTid());
				pageData.put("phone", t.getPhone());
				this.sservice.editTid(pageData);
			}
			}
			this.service.deleteT(tids);//删除原来的
		}
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	@RequestMapping(value="/goStudent")
	public ModelAndView goStudent() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> sList=this.sservice.listStudentByInviter(pd);

		mv.setViewName("system/student/student_list");
		mv.addObject("sList", sList);
		return mv;
	}
	
	/**
	 * 结算积分
	 * 2018/8/4
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/toIntegralMoney")
	public ModelAndView toIntegralMoney() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String SERVE_ID = (null == pd.get("tid") || "".equals(pd.get("tid").toString()))?"0":pd.get("tid").toString();
		Long tid=Long.parseLong(SERVE_ID);
		pd.put("pid", tid);
		List<PageData> sList=this.sservice.listStudentByInviter(pd);
		
		//一级老师钱
		Teacher soloTeacher = this.service.findTeacherById(tid);
		//通过一级老师查看二级老师
		List<PageData> secondTeacher = this.service.listTeacherBypId(pd);
	    mv.setViewName("system/student/student_IntegralMoneyForTeacher");
        if(secondTeacher.isEmpty()) {
        	mv.addObject("TeacherCommissMoney", soloTeacher.getIntegral());
		}else {
			int secondCommissMoney = 0;
			List<PageData> secondList2 = null;
			for (int i=0; i<secondTeacher.size() ;i++) {
			Teacher soloTeacher2 = this.service.findTeacherById2(secondTeacher.get(i).getLong("tid"));
			System.out.println("laoshi"+soloTeacher2.getName());
			
			
			if(soloTeacher2!=null) {
				secondCommissMoney+=soloTeacher2.getIntegral();
				pd.put("pid", soloTeacher2.getTid());
				
				secondList2=this.sservice.listStudentByInviter(pd);
			}else {
				secondCommissMoney+=0;
			}
			}
			int totalMoney = soloTeacher.getIntegral()+secondCommissMoney;
			mv.addObject("TeacherCommissMoney",totalMoney );
			mv.addObject("sList2", secondList2);
		}
        mv.addObject("type","toIntegralMoney");
		mv.addObject("sList", sList);
		
		return mv;
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
				titles.add("用户id");  		//2
				titles.add("姓名");  		//3
				titles.add("电话");			//4
				titles.add("提成");			//5
				titles.add("等级");			//6
				titles.add("上级id");  		//7
				titles.add("居住地址");			//8
				titles.add("更新时间");			//9
				dataMap.put("titles", titles);
				List<Teacher> tList=this.service.listAllTeacher();
				List<PageData> varList = new ArrayList<PageData>();
				for(int i=0;i<tList.size();i++){
					PageData vpd = new PageData();
					vpd.put("var1", i+1+"");		//1
					vpd.put("var2", tList.get(i).getTid()+"");		//2
					vpd.put("var3", tList.get(i).getName());		//2
					vpd.put("var4", tList.get(i).getPhone());			//3
					vpd.put("var5", tList.get(i).getCommission()+"%");	//4
					vpd.put("var6", tList.get(i).getType()+"");		//5
					vpd.put("var7", tList.get(i).getPid()+"");		//5
					vpd.put("var8", tList.get(i).getAddress());
					vpd.put("var9", tList.get(i).getUpdateTime());
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
	
	/**删除招生老师
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteT")
	public void deleteU(PrintWriter out) throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> sList=this.sservice.listStudentByInviter(pd);//通过招生老师Id找出学生
		Long eTid=Long.parseLong(pd.getString("tid"));
		Teacher t=this.service.findTeacherById(eTid);//通过Id找到老师
		if(t!=null) {
		for (PageData pageData : sList) {
			pageData.put("tid", t.getPid());//将招生老师上级Id设置为学生的邀请人
			this.sservice.editTid(pageData);
		}
		}
		this.service.deleteT(eTid);//删除原来的
		
	}
}
