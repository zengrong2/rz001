package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_activitycategory")
public class TdActivitycategory extends BasePojo{
	@Id
    private String activitycategoryId;

    private String activitycategoryName;
    
    private Integer isSpecial;
    
    private Integer isOnline;

    public Integer getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Integer isOnline) {
		this.isOnline = isOnline;
	}

	private Date created;
    private String remark;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private Date updated;

    private String readingsurveyId;

    public String getActivitycategoryId() {
        return activitycategoryId;
    }

    public void setActivitycategoryId(String activitycategoryId) {
        this.activitycategoryId = activitycategoryId == null ? null : activitycategoryId.trim();
    }

    public String getActivitycategoryName() {
        return activitycategoryName;
    }

    public void setActivitycategoryName(String activitycategoryName) {
        this.activitycategoryName = activitycategoryName == null ? null : activitycategoryName.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(Integer isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getReadingsurveyId() {
        return readingsurveyId;
    }

    public void setReadingsurveyId(String readingsurveyId) {
        this.readingsurveyId = readingsurveyId == null ? null : readingsurveyId.trim();
    }
}