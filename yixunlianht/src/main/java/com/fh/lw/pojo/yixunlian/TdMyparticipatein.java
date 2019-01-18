package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdMyparticipatein {
    private String myparticipateinId;

    private String userId;

    private String activityId;

    private Date created;

    private Date updated;

    private Integer myparticipateinStatus;

    public String getMyparticipateinId() {
        return myparticipateinId;
    }

    public void setMyparticipateinId(String myparticipateinId) {
        this.myparticipateinId = myparticipateinId == null ? null : myparticipateinId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Integer getMyparticipateinStatus() {
        return myparticipateinStatus;
    }

    public void setMyparticipateinStatus(Integer myparticipateinStatus) {
        this.myparticipateinStatus = myparticipateinStatus;
    }
}