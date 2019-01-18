package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_partner_bonus_transfer_recordinput")
public class TdPartnerBonusTransferRecordinput extends BasePojo{
	@Id
	private String partnerBonusId;
	private String partnerBonusTransferRecordMoney;
	private String userId;
	public String getPartnerBonusId() {
		return partnerBonusId;
	}
	public void setPartnerBonusId(String partnerBonusId) {
		this.partnerBonusId = partnerBonusId;
	}
	public String getPartnerBonusTransferRecordMoney() {
		return partnerBonusTransferRecordMoney;
	}
	public void setPartnerBonusTransferRecordMoney(String partnerBonusTransferRecordMoney) {
		this.partnerBonusTransferRecordMoney = partnerBonusTransferRecordMoney;
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
	private String activityId;
	private String transferType;
	private String transferSingleNumber;
	private String transfTime;
	private String paymentMethod;
	private String paymentStatus;
	private String remark;
	
}
