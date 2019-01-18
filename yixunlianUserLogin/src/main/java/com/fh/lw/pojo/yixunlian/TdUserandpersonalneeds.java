package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_userandpersonalneeds")
public class TdUserandpersonalneeds extends BasePojo{
	@Id
    private String userandpersonalneedsId;

    private String userId;

    private String personalneedsId;
    
    @Transient
    private TdPersonalneeds tdPersonalneeds;

    public TdPersonalneeds getTdPersonalneeds() {
		return tdPersonalneeds;
	}

	public void setTdPersonalneeds(TdPersonalneeds tdPersonalneeds) {
		this.tdPersonalneeds = tdPersonalneeds;
	}

	private Date created;

    private Date updated;

    public String getUserandpersonalneedsId() {
        return userandpersonalneedsId;
    }

    public void setUserandpersonalneedsId(String userandpersonalneedsId) {
        this.userandpersonalneedsId = userandpersonalneedsId == null ? null : userandpersonalneedsId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPersonalneedsId() {
        return personalneedsId;
    }

    public void setPersonalneedsId(String personalneedsId) {
        this.personalneedsId = personalneedsId == null ? null : personalneedsId.trim();
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