package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_complaint")
public class TdComplaint extends BasePojo{
	@Id
    private String complaintId;
	private String userId;
	private String activityId;
	private String complaintContext;
	private Date created;
	private Date updated;
	private String remark;
	private Integer isExamine;
    @Transient
	private String complaintUserName;
    @Transient
	private String complaintUserMemberId;
	@Transient
	private String complaintUserPhone;
	
	public Integer getIsExamine() {
		return isExamine;
	}
	public void setIsExamine(Integer isExamine) {
		this.isExamine = isExamine;
	}
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
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
	public String getComplaintContext() {
		return complaintContext;
	}
	public void setComplaintContext(String complaintContext) {
		this.complaintContext = complaintContext;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getComplaintUserName() {
		return complaintUserName;
	}
	public void setComplaintUserName(String complaintUserName) {
		this.complaintUserName = complaintUserName;
	}
	public String getComplaintUserMemberId() {
		return complaintUserMemberId;
	}
	public void setComplaintUserMemberId(String complaintUserMemberId) {
		this.complaintUserMemberId = complaintUserMemberId;
	}
	public String getComplaintUserPhone() {
		return complaintUserPhone;
	}
	public void setComplaintUserPhone(String complaintUserPhone) {
		this.complaintUserPhone = complaintUserPhone;
	}
	
}