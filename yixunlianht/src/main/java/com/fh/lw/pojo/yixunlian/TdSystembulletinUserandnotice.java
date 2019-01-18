package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdSystembulletinUserandnotice {
    private String userAndnoticeId;

    private String userId;

    private String noticeId;

    private Date created;

    private Date updated;

    private Integer noticeStatus;

    public String getUserAndnoticeId() {
        return userAndnoticeId;
    }

    public void setUserAndnoticeId(String userAndnoticeId) {
        this.userAndnoticeId = userAndnoticeId == null ? null : userAndnoticeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
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

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}