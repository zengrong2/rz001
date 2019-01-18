package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_engagendustry")
public class TdEngagendustry extends BasePojo{
	@Id
    private String egidId;

    private String egidName;

    private Date created;

    private Date updated;
    
    private String remark;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEgidId() {
        return egidId;
    }

    public void setEgidId(String egidId) {
        this.egidId = egidId == null ? null : egidId.trim();
    }

    public String getEgidName() {
        return egidName;
    }

    public void setEgidName(String egidName) {
        this.egidName = egidName == null ? null : egidName.trim();
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