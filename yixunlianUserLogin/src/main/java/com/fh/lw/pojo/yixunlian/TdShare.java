package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdShare {
    private String shareId;

    private Integer shareidStatus;

    private String sharesendId;

    private String sharegetId;

    private Date created;

    private Date updated;

    private String activityId;

    private String journalismId;

    private Integer sharingRecordsDelete;

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    public Integer getShareidStatus() {
        return shareidStatus;
    }

    public void setShareidStatus(Integer shareidStatus) {
        this.shareidStatus = shareidStatus;
    }

    public String getSharesendId() {
        return sharesendId;
    }

    public void setSharesendId(String sharesendId) {
        this.sharesendId = sharesendId == null ? null : sharesendId.trim();
    }

    public String getSharegetId() {
        return sharegetId;
    }

    public void setSharegetId(String sharegetId) {
        this.sharegetId = sharegetId == null ? null : sharegetId.trim();
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getJournalismId() {
        return journalismId;
    }

    public void setJournalismId(String journalismId) {
        this.journalismId = journalismId == null ? null : journalismId.trim();
    }

    public Integer getSharingRecordsDelete() {
        return sharingRecordsDelete;
    }

    public void setSharingRecordsDelete(Integer sharingRecordsDelete) {
        this.sharingRecordsDelete = sharingRecordsDelete;
    }
}