package com.fh.controller.company;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Position;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.utils.MD5;
import com.fh.service.company.LabourWorkManager;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.DateUtil;
import com.fh.util.FileUpload;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.PathUtil;
import com.fh.util.Tools;
import com.fh.util.Watermark;
@RequestMapping("company/")
@Controller
public class LabourWorkTypeController extends BaseController{
	String menuUrl = "company/goListEmploymentType.do"; //菜单地址(权限用)

	@Autowired
	private LabourWorkManager lwm ;
	  @Autowired
	   	private UserManager um;
	  @Resource(name="fhlogService")
		private FHlogManager FHLOG;
	@RequestMapping(value="goListEmploymentType")
	public ModelAndView goListEmploymentType(Page page)throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//劳动就业类型查找
				String labourEmpType = pd.getString("labourEmpType"); 
				String keywords = pd.getString("keywords"); // 关键词搜索
				if (null != keywords && !"".equals(keywords)) {
					pd.put("keywords", keywords.trim());
					page.setPd(pd);
				}
				if (null != labourEmpType && !"".equals(labourEmpType)) {
					pd.put("labourEmpType", labourEmpType.trim());

					page.setPd(pd);
				}
				
			page.setPd(pd);
			List<Labour> listLabourType = this.lwm.ListLabourWordType(page);
			
			mv.setViewName("system/company/LabourType_list");
			mv.addObject("listLabourType",listLabourType);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限

		return mv;
	}
	/*
	 * deleteLabourBylid
	 */
	
	@RequestMapping(value = "/deleteLabourBylid")
	public void deleteLabourBylid(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
//		pd=this.cm.findSchoolById(pd);
		this.lwm.deleteLabourTypeBylid(pd);
//		pd.put("companyid", 0);
//		this.um.editSchoolId(pd);
		out.write("success");
		out.close();
	}
	/**
	 * goEditLabour
	 */
	@RequestMapping(value="/goEditLabour")
	public ModelAndView goEditLabour() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		int company_id=Integer.parseInt(pd.getString("company_id"));
		
	    pd= lwm.getLabourTypeById(pd);	
		mv.setViewName("system/company/LabourType_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * editLabourTypeByCid
	 */
//	@RequestMapping(value="/editLabourTypeByCid")
//	public ModelAndView editLabourTypeByCid() throws Exception{
//		logBefore(logger, Jurisdiction.getUsername()+"修改");
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		
//			Date date=new Date();
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time=format.format(date);
//			pd.put("update_time", time);
//			lwm.editLabourType(pd);;	//执行修改
//			
//		mv.addObject("msg","success");
//		mv.setViewName("save_result");
//		return mv;
//	}
	@RequestMapping(value="/editLabourTypeByCid")
	public ModelAndView editLabourTypeByCid(
			@RequestParam(required=false) MultipartFile file,
			@RequestParam String labour_name,@RequestParam int labour_id,@RequestParam String remark) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();

		logBefore(logger, Jurisdiction.getUsername()+"新增图片");
	
		String  ffile = DateUtil.getDays(), fileName = "";
		PageData pd = new PageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "add")){
			if (null != file && !file.isEmpty()) {
				
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;		//文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
				
			}else{
				System.out.println("上传失败");
			}
			pd.put("labour_id", labour_id);
			pd.put("labour_name", labour_name);								//标题
			pd.put("remark", remark);
			pd.put("labour_image", ffile + "/" + fileName);							//文件名
//			pd.put("labour_image", ffile + "/" + fileName);				//路径
			pd.put("update_time", Tools.date2Str(new Date()));	//创建时间

							//备注
			Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//加水印
			lwm.editLabourType(pd);	//执行修改
		}
		mv.addObject("msg","success");
	    mv.setViewName("save_result");	
		return mv;
	}
	/*
	 * goAddLabourType
	 * 
	 */
	@RequestMapping(value="/goAddLabourType")
	public ModelAndView goAddLabourType()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<Labour> listLabourType = this.lwm.showListLabourWorkType();
		
		mv.setViewName("system/company/LabourType_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		mv.addObject("listLabourType", listLabourType);

		return mv;
	}
	

	/**
	 * 劳动就业（图片）上传
	 * @param file
	 * @param labour_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveLabourTypeInfo")
	public ModelAndView saveLabourTypeInfo(
			@RequestParam(required=false) MultipartFile file,
			@RequestParam String labour_name) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();

		logBefore(logger, Jurisdiction.getUsername()+"新增图片");
	
		String  ffile = DateUtil.getDays(), fileName = "";
		PageData pd = new PageData();
		if(Jurisdiction.buttonJurisdiction(menuUrl, "add")){
			if (null != file && !file.isEmpty()) {
				
				String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;		//文件上传路径
				fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
				/*System.out.println("上传路径"+filePath);*/
				System.out.println();
			/*	System.out.println("上传名字"+fileName);*/
			

			}else{
				System.out.println("上传失败");
			}
			pd.put("labour_id", this.get32UUID());			//主键
			pd.put("labour_name", labour_name);								//标题
			pd.put("labour_image",  ffile + "/"+fileName);							//文件名
//			pd.put("labour_image", ffile + "/" + fileName);				//路径
			pd.put("created", Tools.date2Str(new Date()));	//创建时间
			pd.put("updated", Tools.date2Str(new Date()));	//创建时间						
			Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//加水印
			lwm.saveLabourTypeInfo(pd);
		}
		mv.addObject("msg","success");
	    mv.setViewName("save_result");	
		return mv;
	}
	/**
	 * 显示图片
	 * showLabourPictureDetail
	 */
	@RequestMapping(value="showLabourPictureDetail")
	public ModelAndView showLabourPictureDetail(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					PageData bespoke=lwm.getLabourTypeById(pd);
					mv.setViewName("system/company/company_labour_pictureDetail");
					mv.addObject("pd", bespoke);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	/*
	 * deleteAllLabourType
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAllLabourType")
	@ResponseBody
	public Object deleteAllLabourType() throws Exception {
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"批量删除labourWoekType");
		FHLOG.save(Jurisdiction.getUsername(), "批量删除labourWoekType");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String LabourType_IDS = pd.getString("LabourType_IDS");
		if(null != LabourType_IDS && !"".equals(LabourType_IDS)){
			String ArrayLabourWorkType_IDS[] = LabourType_IDS.split(",");
//			userService.deleteAllU(ArrayPosition_IDS);
			
			lwm.deleteAllLabourWorkType(ArrayLabourWorkType_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
}
