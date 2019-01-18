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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Position;
import com.fh.lw.pojo.obtainemployment.Prejob;
import com.fh.lw.utils.MD5;
import com.fh.service.school.PreJobManager;
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
/**
 * 岗前培训
 * @author DELL
 *
 */
@RequestMapping("train/")
@Controller
public class PreJobTypeController extends BaseController{
	String menuUrl = "train/goListTrainingTyle.do"; //菜单地址(权限用)

	  @Autowired
	  private PreJobManager pjm;
	  @Autowired
	   	private UserManager um;
	  @Resource(name="fhlogService")
		private FHlogManager FHLOG;
	  @RequestMapping(value="goListTrainingTyle")
		public ModelAndView goListTrainingTyle(Page page)throws Exception {
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
				List<Prejob> listPreJobs = this.pjm.findListPreJobType(page);
				mv.setViewName("system/school/school_prejobType_list");
				mv.addObject("listPreJobs",listPreJobs);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限

			return mv;
		}
	/**
	 * delPreJobTypeById
	 * 删除
	 */
	  @RequestMapping(value = "/delPreJobTypeById")
		public void delPreJobTypeById(PrintWriter out) throws Exception {
			logBefore(logger, Jurisdiction.getUsername() + "删除");
			PageData pd = new PageData();
			pd = this.getPageData();
//			pd=this.cm.findSchoolById(pd);
			this.pjm.delPreJobTypeBylid(pd);
//			pd.put("companyid", 0);
//			this.um.editSchoolId(pd);
			out.write("success");
			out.close();
		}
	  /**添加页面
	   * goAddPreJobType
	   */
	  @RequestMapping(value="/goAddPreJobType")
		public ModelAndView goAddPreJobType()throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/school/school_prejobType_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
/**
 * 岗前培训类型添加
 * @param file
 * @param w_name
 * @return
 * @throws Exception
 */
	  @RequestMapping(value="/savePreJobTypeTypeInfo")
		public ModelAndView savePreJobTypeTypeInfo(
				@RequestParam(required=false) MultipartFile file,
				@RequestParam String w_name) throws Exception{
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
				pd.put("w_id", this.get32UUID());			//主键
				pd.put("w_name", w_name);								//标题
				pd.put("w_image", ffile + "/"+fileName);					//路径
				
//				pd.put("labour_image", ffile + "/" + fileName);				//路径
				pd.put("created", Tools.date2Str(new Date()));	//创建时间
				pd.put("updated", Tools.date2Str(new Date()));	//创建时间
								//备注
				Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//加水印
				pjm.savePreJobTypeInfo(pd);
			}
			mv.addObject("msg","success");
		    mv.setViewName("save_result");	
			return mv;
		}
	  /**修改页面
	   * goEditPreJobType
	   */
	  @RequestMapping(value="/goEditPreJobType")
		public ModelAndView goEditPreJobType() throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
//			int company_id=Integer.parseInt(pd.getString("company_id"));
			
		    pd= pjm.getPreJobTypeTypeById(pd);	
			mv.setViewName("system/school/school_prejobType_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			return mv;
		}
//	  @RequestMapping(value="/editPreJobTypeByCid")
//		public ModelAndView editPreJobTypeByCid() throws Exception{
//			logBefore(logger, Jurisdiction.getUsername()+"修改");
//			ModelAndView mv = this.getModelAndView();
//			PageData pd = new PageData();
//			pd = this.getPageData();
//			
//				Date date=new Date();
//				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String time=format.format(date);
//				pd.put("update_time", time);
//				pjm.editPreJobTypeType(pd);;	//执行修改
//				
//			mv.addObject("msg","success");
//			mv.setViewName("save_result");
//			return mv;
//		}
	  @RequestMapping(value="/editPreJobTypeByCid")
		public ModelAndView editPreJobTypeByCid(
				@RequestParam(required=false) MultipartFile file,
				@RequestParam String w_name,@RequestParam int w_id,@RequestParam String remark) throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();

			logBefore(logger, Jurisdiction.getUsername()+"修改图片");
		
			String  ffile = DateUtil.getDays(), fileName = "";
			PageData pd = new PageData();
			if(Jurisdiction.buttonJurisdiction(menuUrl, "exit")){
				if (null != file && !file.isEmpty()) {
					
					String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;		//文件上传路径
					fileName = FileUpload.fileUp(file, filePath, this.get32UUID());				//执行上传
				}else{
					System.out.println("上传失败");
				}
				pd.put("w_id", w_id);			//主键
				pd.put("w_name", w_name);								//标题
				pd.put("w_image",  ffile + "/"+fileName);							//文件名
				pd.put("remark", remark);
//				pd.put("labour_image", ffile + "/" + fileName);				//路径
				pd.put("update_time", Tools.date2Str(new Date()));	//创建时间
								//备注
				Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//加水印
				pjm.editPreJobTypeType(pd);
			}
			mv.addObject("msg","success");
		    mv.setViewName("save_result");	
			return mv;
		}
	  
	  /**showPreJobPictureDetail
	   * 显示岗前培训图片信息
	   */
	  @RequestMapping(value="showPreJobPictureDetail")
		public ModelAndView showPreJobPictureDetail(Page page){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
						pd = this.getPageData();			
						page.setPd(pd);
						PageData bespoke=pjm.getPreJobTypeTypeById(pd);
						mv.setViewName("system/school/school_prejob_pictureDetail");
						mv.addObject("pd", bespoke);
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
	  /**
		 * 批量删除
		 * deleteAllProJobType
		 */
		
		@RequestMapping(value="/deleteAllProJobType")
		@ResponseBody
		public Object deleteAllProJobType() throws Exception {
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
			logBefore(logger, Jurisdiction.getUsername()+"批量删除position");
			FHLOG.save(Jurisdiction.getUsername(), "批量删除position");
			PageData pd = new PageData();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String ProJobType_IDS = pd.getString("ProJobType_IDS");
			if(null != ProJobType_IDS && !"".equals(ProJobType_IDS)){
				String ArrayProJobType_IDS[] = ProJobType_IDS.split(",");
//				userService.deleteAllU(ArrayPosition_IDS);
				
				pjm.deleteAllProJobType(ArrayProJobType_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
}
