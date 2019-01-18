package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_activityprojectandacsign")
public class TdActivityprojectandacsign extends BasePojo {
	@Id
    private String activityprojectId;

    private String activityprojectName;

    private Long activityprojectMoney;

    private String uandactivityenrollId;

    private String activityId;

    private Date created;

    private Date updated;

    public String getActivityprojectId() {
        return activityprojectId;
    }

    public void setActivityprojectId(String activityprojectId) {
        this.activityprojectId = activityprojectId == null ? null : activityprojectId.trim();
    }

    public String getActivityprojectName() {
        return activityprojectName;
    }

    public void setActivityprojectName(String activityprojectName) {
        this.activityprojectName = activityprojectName == null ? null : activityprojectName.trim();
    }

    public Long getActivityprojectMoney() {
        return activityprojectMoney;
    }

    public void setActivityprojectMoney(Long activityprojectMoney) {
        this.activityprojectMoney = activityprojectMoney;
    }

    public String getUandactivityenrollId() {
        return uandactivityenrollId;
    }

    public void setUandactivityenrollId(String uandactivityenrollId) {
        this.uandactivityenrollId = uandactivityenrollId == null ? null : uandactivityenrollId.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
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
}