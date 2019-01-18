package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdActivitysignAdditem {
    private String activitysignAdditem;

    private String activitysignAdditemcontext;

    private String activityId;

    private String userId;

    private Date created;

    private Date updated;

    public String getActivitysignAdditem() {
        return activitysignAdditem;
    }

    public void setActivitysignAdditem(String activitysignAdditem) {
        this.activitysignAdditem = activitysignAdditem == null ? null : activitysignAdditem.trim();
    }

    public String getActivitysignAdditemcontext() {
        return activitysignAdditemcontext;
    }

    public void setActivitysignAdditemcontext(String activitysignAdditemcontext) {
        this.activitysignAdditemcontext = activitysignAdditemcontext == null ? null : activitysignAdditemcontext.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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