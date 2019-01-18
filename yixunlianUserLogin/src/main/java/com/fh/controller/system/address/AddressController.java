package com.fh.controller.system.address;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.Address;
import com.fh.service.system.address.AddressManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

import net.sf.json.JSONArray;

@RequestMapping("address")
@Controller
public class AddressController extends BaseController{
	
	   String addressUrl="address.do";
	   @Resource(name="addressService")
	   private AddressManager sm;
	 //显示列表
	   @RequestMapping
	   public List<Address> list() {
	   	ModelAndView mv=this.getModelAndView();
	   	PageData pd = new PageData();
	   	List<Address> serList  = new ArrayList<>();
			pd = this.getPageData();
			try {
				String id = (null == pd.get("id") || "".equals(pd.get("id").toString()))?"510100":pd.get("id").toString();
				 serList =sm.listSubAddressBypId(id);
				mv.addObject("pd", sm.getAddressById(pd));
				mv.addObject("id", id);
				mv.addObject("MSG", null == pd.get("MSG")?"list":pd.get("MSG").toString()); //MSG=change 则为编辑或删除后跳转过来的
				mv.addObject("serList",serList);
				mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
				mv.setViewName("system/address/address_list");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	//传入父菜单所有信息
	   	return serList;
	   }
		
		 //显示分类列表
	    @RequestMapping(value="/listAllAddress")
	    public ModelAndView listAllMenu(Model model,String id) {
	    	ModelAndView mv=this.getModelAndView();
	    	JSONArray arr;
			try {
				arr = JSONArray.fromObject(sm.listAllAddress("510100"));
				String json=arr.toString();
	    		json = json.replaceAll("id", "id").replaceAll("pid", "pId").replaceAll("street_name", "name").replaceAll("subType", "nodes").replaceAll("URL", "url");
	    		
	    		model.addAttribute("zTreeNode", json);
	    		mv.addObject("id",id);
	    		mv.setViewName("system/address/address_ztree");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	  				String id = (null == pd.get("id") || "".equals(pd.get("id").toString()))?"510100":pd.get("id").toString();//接收传过来的上级菜单ID,如果上级为顶级就取值“0”
	  				pd.put("id",id);
	  				mv.addObject("pds", sm.getAddressById(pd));	//传入父菜单所有信息
	  				mv.addObject("id", id);					//传入菜单ID，作为子菜单的父菜单ID用
	  				mv.addObject("MSG", "add");							//执行状态 add 为添加
	  				mv.setViewName("system/address/address_add");
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
	  		public ModelAndView add(Address address)throws Exception{
	  			ModelAndView mv = this.getModelAndView();
	  			PageData pd = new PageData();
	  			pd = this.getPageData();
	  			try{
	  				Long i=Long.parseLong("5101000"+sm.findMaxId(pd).get("tid").toString())+1;
	  				address.setId(i+"");
	  				address.setStreet_name(pd.getString("street_name"));
	  				sm.saveAddress(address);
	  			} catch(Exception e){
	  				mv.addObject("msg","failed");
	  			}
	  			mv.setViewName("redirect:/address.do?id="+address.getPid()); //保存成功跳转到列表页面
	  			return mv;
	  		}
	  		/**
	  		 * 删除菜单
	  		 * @param MENU_ID
	  		 * @param out
	  		 */
	  		@RequestMapping(value="/delete")
	  		@ResponseBody
	  		public Object delete(@RequestParam String id)throws Exception{
	  			Map<String,String> map = new HashMap<String,String>();
	  			String errInfo = "";
	  			try{
	  				if(sm.listSubAddressBypId(id).size() > 0){//判断是否有子菜单，是：不允许删除
	  					errInfo = "false";
	  				}else{
	  					sm.deleteAddressById(id);
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
	  		public ModelAndView toEdit(String id)throws Exception{
	  			ModelAndView mv = this.getModelAndView();
	  			PageData pd = new PageData();
	  			try{
	  				pd = this.getPageData();
	  				pd.put("id",id);				//接收过来的要修改的ID
	  				pd = sm.getAddressById(pd);	//读取此ID的菜单数据
	  				mv.addObject("pd", pd);				//放入视图容器
	  				pd.put("id",pd.get("pid").toString());			//用作读取父菜单信息
	  				mv.addObject("pds",sm.getAddressById(pd));			//传入父菜单所有信息
	  				mv.addObject("id", pd.get("pid").toString());	//传入父菜单ID，作为子菜单的父菜单ID用
	  				mv.addObject("MSG", "edit");
	  				pd.put("id",id);			//复原本菜单ID
	  				mv.setViewName("system/address/address_edit");
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
	  		public ModelAndView edit(Address address)throws Exception{
	  			ModelAndView mv = this.getModelAndView();
	  			try{
	  				
	  				sm.edit(address);
	  			} catch(Exception e){
	  				logger.error(e.toString(), e);
	  			}
	  			mv.setViewName("redirect:/address.do?id="+address.getPid()); //保存成功跳转到列表页面
	  			return mv;
	  		}
	  		
	  	
}
