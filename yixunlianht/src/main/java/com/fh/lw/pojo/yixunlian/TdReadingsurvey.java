package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdReadingsurvey {
    private String readingsurveyId;

    private String readingsurveyContext;

    private Integer readingsurveyStatus;

    private Date created;

    private Date updated;

    public String getReadingsurveyId() {
        return readingsurveyId;
    }

    public void setReadingsurveyId(String readingsurveyId) {
        this.readingsurveyId = readingsurveyId == null ? null : readingsurveyId.trim();
    }

    public String getReadingsurveyContext() {
        return readingsurveyContext;
    }

    public void setReadingsurveyContext(String readingsurveyContext) {
        this.readingsurveyContext = readingsurveyContext == null ? null : readingsurveyContext.trim();
    }

    public Integer getReadingsurveyStatus() {
        return readingsurveyStatus;
    }

    public void setReadingsurveyStatus(Integer readingsurveyStatus) {
        this.readingsurveyStatus = readingsurveyStatus;
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