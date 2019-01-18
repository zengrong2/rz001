package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdBackgroundPublishingJournalism {
    private String backgroundJournalismTypeid;

    private String journalismType;

    private Date created;

    private Date updated;

    public String getBackgroundJournalismTypeid() {
        return backgroundJournalismTypeid;
    }

    public void setBackgroundJournalismTypeid(String backgroundJournalismTypeid) {
        this.backgroundJournalismTypeid = backgroundJournalismTypeid == null ? null : backgroundJournalismTypeid.trim();
    }

    public String getJournalismType() {
        return journalismType;
    }

    public void setJournalismType(String journalismType) {
        this.journalismType = journalismType == null ? null : journalismType.trim();
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