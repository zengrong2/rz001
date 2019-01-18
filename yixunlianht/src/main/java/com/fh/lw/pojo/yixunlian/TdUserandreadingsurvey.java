package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdUserandreadingsurvey {
    private String ureadingsurveyId;

    private String readingsurveyId;

    private String userId;

    private String journalismId;

    private Date created;

    private Date updated;

    public String getUreadingsurveyId() {
        return ureadingsurveyId;
    }

    public void setUreadingsurveyId(String ureadingsurveyId) {
        this.ureadingsurveyId = ureadingsurveyId == null ? null : ureadingsurveyId.trim();
    }

    public String getReadingsurveyId() {
        return readingsurveyId;
    }

    public void setReadingsurveyId(String readingsurveyId) {
        this.readingsurveyId = readingsurveyId == null ? null : readingsurveyId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getJournalismId() {
        return journalismId;
    }

    public void setJournalismId(String journalismId) {
        this.journalismId = journalismId == null ? null : journalismId.trim();
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