package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdBackgroundOperationRecord {
    private String backgroundOperationRecordId;

    private String backgroundOperationRecordName;

    private String userId;

    private Date created;

    private Date updated;

    public String getBackgroundOperationRecordId() {
        return backgroundOperationRecordId;
    }

    public void setBackgroundOperationRecordId(String backgroundOperationRecordId) {
        this.backgroundOperationRecordId = backgroundOperationRecordId == null ? null : backgroundOperationRecordId.trim();
    }

    public String getBackgroundOperationRecordName() {
        return backgroundOperationRecordName;
    }

    public void setBackgroundOperationRecordName(String backgroundOperationRecordName) {
        this.backgroundOperationRecordName = backgroundOperationRecordName == null ? null : backgroundOperationRecordName.trim();
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