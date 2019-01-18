package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_personalneeds")
public class TdPersonalneeds extends BasePojo{
	@Id
    private String personalneedsId;
	private String userId;

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String personalneedsType;
    private String activitycategoryid;

    public String getActivitycategoryid() {
		return activitycategoryid;
	}

	public void setActivitycategoryid(String activitycategoryid) {
		this.activitycategoryid = activitycategoryid;
	}

	private Date created;

    private Date updated;

    public String getPersonalneedsId() {
        return personalneedsId;
    }

    public void setPersonalneedsId(String personalneedsId) {
        this.personalneedsId = personalneedsId == null ? null : personalneedsId.trim();
    }

    public String getPersonalneedsType() {
        return personalneedsType;
    }

    public void setPersonalneedsType(String personalneedsType) {
        this.personalneedsType = personalneedsType == null ? null : personalneedsType.trim();
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