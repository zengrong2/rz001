package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_everjoin")
public class TdEverjoin extends BasePojo{
	@Id
    private String everjoinId;

    private String userId;

    private String activityId;

    private Date created;

    private Date updated;
    private String activitycategoryId;
    

    

	public String getActivitycategoryId() {
		return activitycategoryId;
	}

	public void setActivitycategoryId(String activitycategoryId) {
		this.activitycategoryId = activitycategoryId;
	}

	public String getEverjoinId() {
        return everjoinId;
    }

    public void setEverjoinId(String everjoinId) {
        this.everjoinId = everjoinId == null ? null : everjoinId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
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