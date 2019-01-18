package com.fh.lw.pojo.student;

import javax.persistence.Id;
import javax.persistence.Table;
import com.fh.lw.pojo.BasePojo;
/**
 * 退款记录
 * @author lanzheng
 *
 */
@Table(name="tb_refund")
public class Refund extends BasePojo{
   @Id
   private Long refundId;
   private Integer payWay;//支付方式1-支付宝，2-微信
   private String number;//账号
   private Long userId;//退款人id
   private Integer money;//退款金额、
   private String phone;//退款人电话
   private String name;//姓名
   private String updateTime;//更新时间
   private Integer isCheck;//处理:0-待处理，1-已处理,2-已退款
   private Long orderId;//订单id
   
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public Long getRefundId() {
	return refundId;
}
public void setRefundId(Long refundId) {
	this.refundId = refundId;
}
public Integer getPayWay() {
	return payWay;
}
public void setPayWay(Integer payWay) {
	this.payWay = payWay;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public Integer getMoney() {
	return money;
}
public void setMoney(Integer money) {
	this.money = money;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
}
public Integer getIsCheck() {
	return isCheck;
}
public void setIsCheck(Integer isCheck) {
	this.isCheck = isCheck;
}
   
   
}
