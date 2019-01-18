package com.fh.lw.pojo.student;

import javax.persistence.Id;
import javax.persistence.Table;
import com.fh.lw.pojo.BasePojo;
/**
 *学生充值记录
 * @author lanzheng
 *
 */
@Table(name="tb_student_recharge")
public class StudentRecharge extends BasePojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long rechargeId;
	private Integer rechargeMoney;//充值金额
	private Integer payWay;//支付方式:1-支付宝，2-微信
	private String studentName;//学生姓名
	private Long  studentId;//学生id
	private  String createTime;//充值时间
	private String rechargeNum;//充值记录单号
	
	public String getRechargeNum() {
		return rechargeNum;
	}
	public void setRechargeNum(String rechargeNum) {
		this.rechargeNum = rechargeNum;
	}
	public Long getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}
	public Integer getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(Integer rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
