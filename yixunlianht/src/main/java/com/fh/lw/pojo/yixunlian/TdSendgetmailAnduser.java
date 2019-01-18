package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdSendgetmailAnduser {
    private String userandmailId;

    private String mailId;

    private String userId;

    private Integer isReadstatus;

    private Date created;

    private Date updated;

    private String senduserId;

    public String getUserandmailId() {
        return userandmailId;
    }

    public void setUserandmailId(String userandmailId) {
        this.userandmailId = userandmailId == null ? null : userandmailId.trim();
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId == null ? null : mailId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getIsReadstatus() {
        return isReadstatus;
    }

    public void setIsReadstatus(Integer isReadstatus) {
        this.isReadstatus = isReadstatus;
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

    public String getSenduserId() {
        return senduserId;
    }

    public void setSenduserId(String senduserId) {
        this.senduserId = senduserId == null ? null : senduserId.trim();
    }
}