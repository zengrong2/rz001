package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_background_transfer_recordout")
public class TdBackgroundTransferRecordout  extends BasePojo{
	@Id
   private String backgroundTransferRecordId;
   private float backgroundTransferMoney;
   private String userId;
   private String activityId;
   private String remark;
   
private Integer transferType;
   private String transferSingleNumber;
   private String transfTime;
   private String paymentMethod;
   public String getBackgroundTransferRecordId() {
	return backgroundTransferRecordId;
}
public void setBackgroundTransferRecordId(String backgroundTransferRecordId) {
	this.backgroundTransferRecordId = backgroundTransferRecordId;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getActivityId() {
	return activityId;
}
public void setActivityId(String activityId) {
	this.activityId = activityId;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Integer getTransferType() {
	return transferType;
}
public void setTransferType(Integer transferType) {
	this.transferType = transferType;
}
public String getTransferSingleNumber() {
	return transferSingleNumber;
}
public void setTransferSingleNumber(String transferSingleNumber) {
	this.transferSingleNumber = transferSingleNumber;
}

public float getBackgroundTransferMoney() {
	return backgroundTransferMoney;
}
public void setBackgroundTransferMoney(float backgroundTransferMoney) {
	this.backgroundTransferMoney = backgroundTransferMoney;
}
public String getTransfTime() {
	return transfTime;
}
public void setTransfTime(String transfTime) {
	this.transfTime = transfTime;
}
public String getPaymentMethod() {
	return paymentMethod;
}
public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}
public Integer getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(Integer paymentStatus) {
	this.paymentStatus = paymentStatus;
}
private Integer paymentStatus;
   
}