package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_activity_fill_in_item")
public class TdActivityFillInItem extends BasePojo{

	private String fillInItemId;
	private String activityId;
	private String fillInItemName;
	private Date created;
	private String type;
	private Date updated;
	private String remark;
	public String getFillInItemId() {
		return fillInItemId;
	}
	public void setFillInItemId(String fillInItemId) {
		this.fillInItemId = fillInItemId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getFillInItemName() {
		return fillInItemName;
	}
	public void setFillInItemName(String fillInItemName) {
		this.fillInItemName = fillInItemName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
}
