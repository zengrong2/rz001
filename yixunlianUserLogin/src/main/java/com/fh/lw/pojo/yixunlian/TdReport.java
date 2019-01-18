package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_report")
public class TdReport extends BasePojo{
	@Id
    private String reportId;
	
	

    private String userId;
    @Transient
    private String reportUserName;
    @Transient
    private String reportUserMemberId;
    @Transient
    private String reportUserPhone;

    public String getReportUserPhone() {
		return reportUserPhone;
	}

	public void setReportUserPhone(String reportUserPhone) {
		this.reportUserPhone = reportUserPhone;
	}

	public String getReportUserName() {
		return reportUserName;
	}

	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}

	public String getReportUserMemberId() {
		return reportUserMemberId;
	}

	public void setReportUserMemberId(String reportUserMemberId) {
		this.reportUserMemberId = reportUserMemberId;
	}

	private String activityId;

    private String reportContext;
    private Integer isExamine;

    public Integer getIsExamine() {
		return isExamine;
	}

	public void setIsExamine(Integer isExamine) {
		this.isExamine = isExamine;
	}

	private Date created;

    private Date updated;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
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

    public String getReportContext() {
        return reportContext;
    }

    public void setReportContext(String reportContext) {
        this.reportContext = reportContext == null ? null : reportContext.trim();
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