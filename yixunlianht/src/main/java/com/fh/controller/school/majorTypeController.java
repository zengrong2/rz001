package com.fh.controller.school;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.school.MajorType;
import com.fh.service.school.MajorTypeManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

import net.sf.json.JSONArray;

@RequestMapping("major/type/")
@Controller

public class majorTypeController extends BaseController{
   @Autowired
   private MajorTypeManager service;
   
   //显示列表
   @RequestMapping(value="list")
   public ModelAndView list() {
   	ModelAndView mv=this.getModelAndView();
   	PageData pd = new PageData();
		pd = this.getPageData();
		try {
			String SERVE_ID = (null == pd.get("type_id") || "".equals(pd.get("type_id").toString()))?"0":pd.get("type_id").toString();
			Long typeId=Long.parseLong(SERVE_ID);
			List<MajorType> serList =service.listSubMajorTypeBypId(typeId);
			mv.addObject("pd", service.getMajorTypeById(pd));
			mv.addObject("type_id", typeId);
			mv.addObject("MSG", null == pd.get("MSG")?"list":pd.get("MSG").toString()); //MSG=change 则为编辑或删除后跳转过来的
			mv.addObject("serList",serList);
			mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
			mv.setViewName("system/school/major_type_list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//传入父菜单所有信息
   	return mv;
   }
   /**
	 * 请求新增页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			String SERVE_ID = (null == pd.get("type_id") || "".equals(pd.get("type_id").toString()))?"0":pd.get("type_id").toString();//接收传过来的上级菜单ID,如果上级为顶级就取值“0”
			pd.put("type_id",SERVE_ID);
			
			mv.addObject("pds", service.getMajorTypeById(pd));	//传入父菜单所有信息
			mv.addObject("type_id", SERVE_ID);					//传入菜单ID，作为子菜单的父菜单ID用
			mv.addObject("MSG", "add");							//执行状态 add 为添加
			mv.setViewName("system/school/major_type_add");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}	
	/**
	 * 保存菜单信息
	 * @param menu
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add")
	public ModelAndView add(MajorType serve)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			
			serve.setType_name(pd.getString("type_name"));
			serve.setImg_url(pd.getString("img_url"));
			Date date=new Date();
			 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String time=format.format(date);
			serve.setUpdate_time(time);
			serve.setType(serve.getType()+1);
			service.saveMajorType(serve); //保存菜单
		} catch(Exception e){
			mv.addObject("msg","failed");
		}
		mv.setViewName("redirect:/major/type/list.do?type_id="+serve.getPid()); //保存成功跳转到列表页面
		return mv;
	}
	
	/**
	 * 删除菜单
	 * @param MENU_ID
	 * @param out
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(@RequestParam Long type_id)throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "";
		try{
			if(service.listSubMajorTypeBypId(type_id).size() > 0){//判断是否有子菜单，是：不允许删除
				errInfo = "false";
			}else{
				service.deleteMajorTypeById(type_id);;
				errInfo = "success";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 请求编辑菜单页面
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/toEdit")
	public ModelAndView toEdit(Long type_id)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd.put("type_id",type_id);				//接收过来的要修改的ID
			pd = service.getMajorTypeById(pd);	//读取此ID的菜单数据
			mv.addObject("pd", pd);				//放入视图容器
			pd.put("type_id",pd.get("pid").toString());			//用作读取父菜单信息
			mv.addObject("pds",service.getMajorTypeById(pd));			//传入父菜单所有信息
			mv.addObject("type_id", pd.get("pid").toString());	//传入父菜单ID，作为子菜单的父菜单ID用
			mv.addObject("MSG", "edit");
			pd.put("type_id",type_id);			//复原本菜单ID
			mv.setViewName("system/school/major_type_edit");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 保存编辑
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(MajorType serve)throws Exception{
		ModelAndView mv = this.getModelAndView();
		try{
			Date date=new Date();
			 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String time=format.format(date);
			serve.setUpdate_time(time);
			
			service.edit(serve);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		mv.setViewName("redirect:/major/type/list.do?type_id="+serve.getPid()); //保存成功跳转到列表页面
		return mv;
	}
	
	 //显示分类列表
    @RequestMapping(value="/listAllMajorType")
    public ModelAndView listAllMenu(Model model,Long type_id) {
    	ModelAndView mv=this.getModelAndView();
    	JSONArray arr;
		try {
			arr = JSONArray.fromObject(service.listAllMajorType(0l));
			String json=arr.toString();
    		json = json.replaceAll("type_id", "type_id").replaceAll("pid", "pId").replaceAll("type_name", "name").replaceAll("subType", "nodes").replaceAll("URL", "url");
    		//System.out.println(json);
    		model.addAttribute("zTreeNode", json);
    		mv.addObject("type_id",type_id);
    		mv.setViewName("system/school/major_type_ztree");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	return mv;
    }
      
    
}
