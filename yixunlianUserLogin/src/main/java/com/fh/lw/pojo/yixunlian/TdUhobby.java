package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_uhobby")
public class TdUhobby  extends BasePojo{
	@Id
    private String hobbyId;

    private String hobbyName;

    private Date created;

    private Date updated;
    private String remark;
    

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId == null ? null : hobbyId.trim();
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName == null ? null : hobbyName.trim();
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