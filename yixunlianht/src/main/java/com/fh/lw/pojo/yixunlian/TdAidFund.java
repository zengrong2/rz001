package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_aid_fund")
public class TdAidFund extends BasePojo{
	@Id
	private String afId;
	private String backgroundTransferMoney;
	private String userId;
	private String activityId;
	public String getAfId() {
		return afId;
	}
	public void setAfId(String afId) {
		this.afId = afId;
	}
	public String getBackgroundTransferMoney() {
		return backgroundTransferMoney;
	}
	public void setBackgroundTransferMoney(String backgroundTransferMoney) {
		this.backgroundTransferMoney = backgroundTransferMoney;
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
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public String getTransferSingleNumber() {
		return transferSingleNumber;
	}
	public void setTransferSingleNumber(String transferSingleNumber) {
		this.transferSingleNumber = transferSingleNumber;
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String transferType;
	private String transferSingleNumber;
	private String transfTime;
	private String paymentMethod;
	private String paymentStatus;
	private String remark;
	
}
