package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_utype")
public class TdUtype extends BasePojo{
	@Id
    private String utypeId;

    private String userType;

    private String userDay;
    @Transient
    private Integer countTdUser;
    public Integer getCountTdUser() {
		return countTdUser;
	}

	public void setCountTdUser(Integer countTdUser) {
		this.countTdUser = countTdUser;
	}

	private String remark;
    private Integer utypeCharge;

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private Date created;

    private Date updated;

    public String getUtypeId() {
        return utypeId;
    }

    public void setUtypeId(String utypeId) {
        this.utypeId = utypeId == null ? null : utypeId.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserDay() {
        return userDay;
    }

    public void setUserDay(String userDay) {
        this.userDay = userDay == null ? null : userDay.trim();
    }

    public Integer getUtypeCharge() {
        return utypeCharge;
    }

    public void setUtypeCharge(Integer utypeCharge) {
        this.utypeCharge = utypeCharge;
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