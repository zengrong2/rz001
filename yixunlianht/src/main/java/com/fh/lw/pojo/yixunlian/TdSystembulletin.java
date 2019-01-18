package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_systembulletin")
public class TdSystembulletin extends BasePojo{
	@Id
    private String systembulletinId;

    private String systembulletinUrl;

    private Integer systemStatus;
    
    private String shareTitle;
    private String shareSummary;

    private Date created;

    private Date updated;

    public String getSystembulletinId() {
        return systembulletinId;
    }

    public void setSystembulletinId(String systembulletinId) {
        this.systembulletinId = systembulletinId == null ? null : systembulletinId.trim();
    }

    public String getSystembulletinUrl() {
        return systembulletinUrl;
    }

    public void setSystembulletinUrl(String systembulletinUrl) {
        this.systembulletinUrl = systembulletinUrl == null ? null : systembulletinUrl.trim();
    }

    public Integer getSystemStatus() {
        return systemStatus;
    }

    public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareSummary() {
		return shareSummary;
	}

	public void setShareSummary(String shareSummary) {
		this.shareSummary = shareSummary;
	}

	public void setSystemStatus(Integer systemStatus) {
        this.systemStatus = systemStatus;
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