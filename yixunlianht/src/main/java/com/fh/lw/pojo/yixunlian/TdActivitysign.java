package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_activitysign")
public class TdActivitysign  extends BasePojo{
	@Id
    private String activitySignid;
	private String activityId;
	private String userId;
	private String fillInItemId;
	private String fillInItemName;
	private String fillInItemVal;
	private Date updated;
	private Date created;
	@Transient
	private Integer paymentStatus;
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getUsersignStatus() {
		return usersignStatus;
	}
	public void setUsersignStatus(Integer usersignStatus) {
		this.usersignStatus = usersignStatus;
	}
	@Transient
	private Integer usersignStatus;
	
	public String getActivitySignid() {
		return activitySignid;
	}
	public void setActivitySignid(String activitySignid) {
		this.activitySignid = activitySignid;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFillInItemId() {
		return fillInItemId;
	}
	public void setFillInItemId(String fillInItemId) {
		this.fillInItemId = fillInItemId;
	}
	public String getFillInItemName() {
		return fillInItemName;
	}
	public void setFillInItemName(String fillInItemName) {
		this.fillInItemName = fillInItemName;
	}
	public String getFillInItemVal() {
		return fillInItemVal;
	}
	public void setFillInItemVal(String fillInItemVal) {
		this.fillInItemVal = fillInItemVal;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String remark;
	

  
}