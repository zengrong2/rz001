package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdRefereelockinguser {
    private String userlockingId;

    private String userId;

    private String openId;

    private Date created;

    private Date updated;

    public String getUserlockingId() {
        return userlockingId;
    }

    public void setUserlockingId(String userlockingId) {
        this.userlockingId = userlockingId == null ? null : userlockingId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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