package com.fh.lw.pojo.yixunlian;

public class TdBrowseRecords {
    private String browseRecordsId;

    private String journalismId;

    private String activityId;

    private Integer browseRecordsStatus;

    private String userId;

    public String getBrowseRecordsId() {
        return browseRecordsId;
    }

    public void setBrowseRecordsId(String browseRecordsId) {
        this.browseRecordsId = browseRecordsId == null ? null : browseRecordsId.trim();
    }

    public String getJournalismId() {
        return journalismId;
    }

    public void setJournalismId(String journalismId) {
        this.journalismId = journalismId == null ? null : journalismId.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public Integer getBrowseRecordsStatus() {
        return browseRecordsStatus;
    }

    public void setBrowseRecordsStatus(Integer browseRecordsStatus) {
        this.browseRecordsStatus = browseRecordsStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}