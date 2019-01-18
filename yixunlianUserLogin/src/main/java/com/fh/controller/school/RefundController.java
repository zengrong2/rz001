package com.fh.controller.school;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.student.Refund;
import com.fh.service.school.SchoolOrderManager;
import com.fh.service.student.RefundManager;
import com.fh.service.student.StudentManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@RequestMapping("refund/")
@Controller
public class RefundController extends BaseController{
	@Autowired
	private RefundManager service;
	@Autowired
	private SchoolOrderManager som;
	@Autowired
	private StudentManager sm;
	@RequestMapping(value="listRefund")
	public ModelAndView listRefund(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<PageData> rList=this.service.listAllRefund(page);
		mv.setViewName("system/student/refund_list");
		mv.addObject("rList",rList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	@RequestMapping(value = "updateState")
	public void editP(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		Integer i=Integer.parseInt(pd.getString("is_check"));
		PageData refund=this.service.findRefundById(pd);//找出退款记录
		pd.put("order_id", refund.getLong("order_id"));
		PageData so=this.som.findSchoolOrderById(pd);
		if(i==1) {//退款已处理
			//通过退款记录中的订单id找到订单
			
			pd.put("state", so.getInteger("zqstate"));
			pd.put("updated", time); // 更新时间
			this.som.editC(pd);//更新订单
		}else {
			//已退款
			pd.put("state", 4);//将订单状态设置为已退学
			this.som.editC(pd);
			pd.put("user_id", refund.getLong("user_id"));
			pd.put("state", 2);//将学生状态设置为已退学
			this.sm.editS(pd);//更新学生状态
		}
		pd.put("update_time", time); // 更新时间
		this.service.editC(pd);
		out.write("success");
		out.close();
	}

}
