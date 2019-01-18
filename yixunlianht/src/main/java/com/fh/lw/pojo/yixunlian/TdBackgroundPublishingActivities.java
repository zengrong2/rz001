package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdBackgroundPublishingActivities {
    private String backgroundActivitiesTypeid;

    private String publishingType;

    private Date created;

    private Date updated;

    public String getBackgroundActivitiesTypeid() {
        return backgroundActivitiesTypeid;
    }

    public void setBackgroundActivitiesTypeid(String backgroundActivitiesTypeid) {
        this.backgroundActivitiesTypeid = backgroundActivitiesTypeid == null ? null : backgroundActivitiesTypeid.trim();
    }

    public String getPublishingType() {
        return publishingType;
    }

    public void setPublishingType(String publishingType) {
        this.publishingType = publishingType == null ? null : publishingType.trim();
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