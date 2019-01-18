package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_activitymusicurl")
public class TdActivitymusicurl extends BasePojo{
	@Id
    private String activitymusicId;

    private String activityMusicurl;
    private String remark;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private String activitymusicName;
    public String getActivitymusicName() {
		return activitymusicName;
	}

	public void setActivitymusicName(String activitymusicName) {
		this.activitymusicName = activitymusicName;
	}

	private Date created;

    private Date updated;

    public String getActivitymusicId() {
        return activitymusicId;
    }

    public void setActivitymusicId(String activitymusicId) {
        this.activitymusicId = activitymusicId == null ? null : activitymusicId.trim();
    }

    public String getActivityMusicurl() {
        return activityMusicurl;
    }

    public void setActivityMusicurl(String activityMusicurl) {
        this.activityMusicurl = activityMusicurl == null ? null : activityMusicurl.trim();
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