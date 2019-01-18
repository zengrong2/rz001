package com.fh.lw.pojo.school;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 学生选择学校
 * @author a55660000
 *
 */
@Table(name="tb_order")
public class SchoolOrder extends BasePojo{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   @Id
   private Long orderId;
   private String orderNum;//订单号
   private Long schoolId;//学校id
   private String schoolName;//学校名称
   private String subjectType;//学科分类
   private String twoType;//二级分类
   private String majorName;//专业名称
   private String studentPhone;//学生电话
   private String studentName;//学生名称
   private Long studentId;//学生id
   private String remark;//备注
   private Integer state;//状态  0-待学校确认，1-待学生确认，2.待缴费，3-缴费待确认,4-已就读,5.已更换,6-已退学
   private Integer money;//金额:试读费
   private Integer sjmoney;//实交金额：试读费
   private String createTime;
   private String updateTime;
   private Integer wjtution;//未交学费
   private Integer tution;//总学费
   private Integer probationDay;//学校试读天数
   private Integer studay;//学生试读天数
   private Integer payWay;//支付方式:1-支付宝，2-微信,3-余额  
   private Integer zqstate;//订单之前的状态
   
public Integer getZqstate() {
	return zqstate;
}
public void setZqstate(Integer zqstate) {
	this.zqstate = zqstate;
}
public Integer getSjmoney() {
	return sjmoney;
}
public void setSjmoney(Integer sjmoney) {
	this.sjmoney = sjmoney;
}
public Integer getStuday() {
	return studay;
}
public void setStuday(Integer studay) {
	this.studay = studay;
}
public Integer getPayWay() {
	return payWay;
}
public void setPayWay(Integer payWay) {
	this.payWay = payWay;
}

public Integer getProbationDay() {
	return probationDay;
}
public void setProbationDay(Integer probationDay) {
	this.probationDay = probationDay;
}
public Integer getWjtution() {
	return wjtution;
}
public void setWjtution(Integer wjtution) {
	this.wjtution = wjtution;
}
public Integer getTution() {
	return tution;
}
public void setTution(Integer tution) {
	this.tution = tution;
}
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public String getOrderNum() {
	return orderNum;
}
public void setOrderNum(String orderNum) {
	this.orderNum = orderNum;
}
public Long getSchoolId() {
	return schoolId;
}
public void setSchoolId(Long schoolId) {
	this.schoolId = schoolId;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getSubjectType() {
	return subjectType;
}
public void setSubjectType(String subjectType) {
	this.subjectType = subjectType;
}
public String getTwoType() {
	return twoType;
}
public void setTwoType(String twoType) {
	this.twoType = twoType;
}
public String getMajorName() {
	return majorName;
}
public void setMajorName(String majorName) {
	this.majorName = majorName;
}
public String getStudentPhone() {
	return studentPhone;
}
public void setStudentPhone(String studentPhone) {
	this.studentPhone = studentPhone;
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
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
public Integer getMoney() {
	return money;
}
public void setMoney(Integer money) {
	this.money = money;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
}
   
}
