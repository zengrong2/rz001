package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdStudentRemittance {
    private String studentRemittanceId;

    private String userId;

    private Date created;

    private Date updated;

    public String getStudentRemittanceId() {
        return studentRemittanceId;
    }

    public void setStudentRemittanceId(String studentRemittanceId) {
        this.studentRemittanceId = studentRemittanceId == null ? null : studentRemittanceId.trim();
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