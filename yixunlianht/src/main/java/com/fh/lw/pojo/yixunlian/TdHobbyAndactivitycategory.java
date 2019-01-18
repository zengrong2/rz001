package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_uhobbyAndactivitycategory")
public class TdHobbyAndactivitycategory  extends BasePojo{

	@Id
	private String uhobbyAndActivitycategoryId;
	private String hobbyId;
	@Transient
	private String activityCategoryName;
	
	public String getActivityCategoryName() {
		return activityCategoryName;
	}
	public void setActivityCategoryName(String activityCategoryName) {
		this.activityCategoryName = activityCategoryName;
	}
	public String getUhobbyAndActivitycategoryId() {
		return uhobbyAndActivitycategoryId;
	}
	public void setUhobbyAndActivitycategoryId(String uhobbyAndActivitycategoryId) {
		this.uhobbyAndActivitycategoryId = uhobbyAndActivitycategoryId;
	}
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	public String getActivitycategoryId() {
		return activitycategoryId;
	}
	public void setActivitycategoryId(String activitycategoryId) {
		this.activitycategoryId = activitycategoryId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String activitycategoryId;
	private String remark;
	
}
