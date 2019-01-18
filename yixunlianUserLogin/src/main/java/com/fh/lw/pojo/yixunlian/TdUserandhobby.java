package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_userandhobby")
public class TdUserandhobby extends BasePojo{
	@Id
    private String uandhId;

    private String userId;

    private String hobbyId;
    
    private String hobbyName;
    private String activitycategoryId;
    private Date created;
    private Date updated;
    public String getUandhId() {
		return uandhId;
	}
	public void setUandhId(String uandhId) {
		this.uandhId = uandhId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
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
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String remark;
    
    

    
}