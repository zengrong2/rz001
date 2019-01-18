package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdResourceStrategy {
    private String resourceStrategyId;

    private String userId;

    private String resourceStrategyQrcodeurl;

    private Date created;

    private Date updated;

    private String resourceStrategyContext;

    public String getResourceStrategyId() {
        return resourceStrategyId;
    }

    public void setResourceStrategyId(String resourceStrategyId) {
        this.resourceStrategyId = resourceStrategyId == null ? null : resourceStrategyId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getResourceStrategyQrcodeurl() {
        return resourceStrategyQrcodeurl;
    }

    public void setResourceStrategyQrcodeurl(String resourceStrategyQrcodeurl) {
        this.resourceStrategyQrcodeurl = resourceStrategyQrcodeurl == null ? null : resourceStrategyQrcodeurl.trim();
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

    public String getResourceStrategyContext() {
        return resourceStrategyContext;
    }

    public void setResourceStrategyContext(String resourceStrategyContext) {
        this.resourceStrategyContext = resourceStrategyContext == null ? null : resourceStrategyContext.trim();
    }
}