package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdSendgetmail {
    private String mailId;

    private String mail;

    private String senduserId;

    private String getuserId;

    private Date created;

    private Date updated;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId == null ? null : mailId.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getSenduserId() {
        return senduserId;
    }

    public void setSenduserId(String senduserId) {
        this.senduserId = senduserId == null ? null : senduserId.trim();
    }

    public String getGetuserId() {
        return getuserId;
    }

    public void setGetuserId(String getuserId) {
        this.getuserId = getuserId == null ? null : getuserId.trim();
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