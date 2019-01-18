package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdExperienceDays {
    private String experienceDaysId;

    private Integer experienceDays;

    private String userId;

    private Date created;

    private Date updated;

    public String getExperienceDaysId() {
        return experienceDaysId;
    }

    public void setExperienceDaysId(String experienceDaysId) {
        this.experienceDaysId = experienceDaysId == null ? null : experienceDaysId.trim();
    }

    public Integer getExperienceDays() {
        return experienceDays;
    }

    public void setExperienceDays(Integer experienceDays) {
        this.experienceDays = experienceDays;
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