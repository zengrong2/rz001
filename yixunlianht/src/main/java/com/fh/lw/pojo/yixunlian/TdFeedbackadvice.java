package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_feedbackadvice")
public class TdFeedbackadvice extends BasePojo{
	@Id
    private String feedbackadviceId;

    private String feedbackadviceImgurl;

    private String userId;

    private String advicePhone;
    private String remark;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private Date created;
    private Integer isAlreadyConsulted;
    

    public Integer getIsAlreadyConsulted() {
		return isAlreadyConsulted;
	}

	public void setIsAlreadyConsulted(Integer isAlreadyConsulted) {
		this.isAlreadyConsulted = isAlreadyConsulted;
	}

	private Date updated;
    private Integer isAdopt;

    public Integer getIsAdopt() {
		return isAdopt;
	}

	public void setIsAdopt(Integer isAdopt) {
		this.isAdopt = isAdopt;
	}

	private String feedbackadviceContext;

    public String getFeedbackadviceId() {
        return feedbackadviceId;
    }

    public void setFeedbackadviceId(String feedbackadviceId) {
        this.feedbackadviceId = feedbackadviceId == null ? null : feedbackadviceId.trim();
    }

    public String getFeedbackadviceImgurl() {
        return feedbackadviceImgurl;
    }

    public void setFeedbackadviceImgurl(String feedbackadviceImgurl) {
        this.feedbackadviceImgurl = feedbackadviceImgurl == null ? null : feedbackadviceImgurl.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAdvicePhone() {
        return advicePhone;
    }

    public void setAdvicePhone(String advicePhone) {
        this.advicePhone = advicePhone == null ? null : advicePhone.trim();
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

    public String getFeedbackadviceContext() {
        return feedbackadviceContext;
    }

    public void setFeedbackadviceContext(String feedbackadviceContext) {
        this.feedbackadviceContext = feedbackadviceContext == null ? null : feedbackadviceContext.trim();
    }
}