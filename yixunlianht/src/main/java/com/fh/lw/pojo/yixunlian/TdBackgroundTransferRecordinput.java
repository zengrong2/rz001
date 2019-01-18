package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_background_transfer_recordinput")
public class TdBackgroundTransferRecordinput extends BasePojo{
	@Id
    private String backgroundTransferRecordId;

    private Double backgroundTransferRecordMoney;
    private String userId;
    private String activityId;
    public String getBackgroundTransferRecordId() {
		return backgroundTransferRecordId;
	}
	public void setBackgroundTransferRecordId(String backgroundTransferRecordId) {
		this.backgroundTransferRecordId = backgroundTransferRecordId;
	}
	public Double getBackgroundTransferRecordMoney() {
		return backgroundTransferRecordMoney;
	}
	public void setBackgroundTransferRecordMoney(Double backgroundTransferRecordMoney) {
		this.backgroundTransferRecordMoney = backgroundTransferRecordMoney;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private Integer transferType;
    private String transferSingleNumber;
    private String transfTime;
    private String paymentMethod;
    private Integer paymentStatus;
    private String remark;
    
    

    
}