package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdUserExperienceVip {
    private String experienceVipId;

    private String userId;

    private String utypeId;

    private Date experienceVipStarttime;

    private Date created;

    private Date updated;

    public String getExperienceVipId() {
        return experienceVipId;
    }

    public void setExperienceVipId(String experienceVipId) {
        this.experienceVipId = experienceVipId == null ? null : experienceVipId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUtypeId() {
        return utypeId;
    }

    public void setUtypeId(String utypeId) {
        this.utypeId = utypeId == null ? null : utypeId.trim();
    }

    public Date getExperienceVipStarttime() {
        return experienceVipStarttime;
    }

    public void setExperienceVipStarttime(Date experienceVipStarttime) {
        this.experienceVipStarttime = experienceVipStarttime;
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