package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_sysuser_and_feedbackadvice")
public class TdSysuserAndFeedbackadvice extends BasePojo{
	@Id
    private String sysuserAndfeedbackadviceId;

    private String sysuserId;

    @Override
	public String toString() {
		return "TdSysuserAndFeedbackadvice [sysuserAndfeedbackadviceId=" + sysuserAndfeedbackadviceId + ", sysuserId="
				+ sysuserId + ", userId=" + userId + ", feedbackadviceId=" + feedbackadviceId + ", replyContext="
				+ replyContext + "]";
	}

	private String userId;

    private String feedbackadviceId;
    private String replyContext;

    public String getReplyContext() {
		return replyContext;
	}

	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}

	public String getSysuserAndfeedbackadviceId() {
        return sysuserAndfeedbackadviceId;
    }

    public void setSysuserAndfeedbackadviceId(String sysuserAndfeedbackadviceId) {
        this.sysuserAndfeedbackadviceId = sysuserAndfeedbackadviceId == null ? null : sysuserAndfeedbackadviceId.trim();
    }

    public String getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(String sysuserId) {
        this.sysuserId = sysuserId == null ? null : sysuserId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFeedbackadviceId() {
        return feedbackadviceId;
    }

    public void setFeedbackadviceId(String feedbackadviceId) {
        this.feedbackadviceId = feedbackadviceId == null ? null : feedbackadviceId.trim();
    }
}