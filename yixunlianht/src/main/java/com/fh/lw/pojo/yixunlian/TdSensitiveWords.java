package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_sensitive_words")
public class TdSensitiveWords extends BasePojo{
	@Id
    private String sensitiveWordsId;

    private Date created;

    private Date updated;

    private String sensitiveWordsContext;
    private String remark;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSensitiveWordsId() {
        return sensitiveWordsId;
    }

    public void setSensitiveWordsId(String sensitiveWordsId) {
        this.sensitiveWordsId = sensitiveWordsId == null ? null : sensitiveWordsId.trim();
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

    public String getSensitiveWordsContext() {
        return sensitiveWordsContext;
    }

    public void setSensitiveWordsContext(String sensitiveWordsContext) {
        this.sensitiveWordsContext = sensitiveWordsContext == null ? null : sensitiveWordsContext.trim();
    }
}