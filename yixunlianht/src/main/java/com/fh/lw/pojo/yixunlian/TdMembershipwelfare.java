package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_membershipwelfare")
public class TdMembershipwelfare extends BasePojo{
	@Id
    private String welfareId;

    private String welfareImgurl;

    private Integer welfareSharecount;

    private String welfareTitle;

    private String welfareContext;

    private Date created;

    private Date updated;

    private Integer welfareCondition;

    public String getWelfareId() {
        return welfareId;
    }

    public void setWelfareId(String welfareId) {
        this.welfareId = welfareId == null ? null : welfareId.trim();
    }

    public String getWelfareImgurl() {
        return welfareImgurl;
    }

    public void setWelfareImgurl(String welfareImgurl) {
        this.welfareImgurl = welfareImgurl == null ? null : welfareImgurl.trim();
    }

    public Integer getWelfareSharecount() {
        return welfareSharecount;
    }

    public void setWelfareSharecount(Integer welfareSharecount) {
        this.welfareSharecount = welfareSharecount;
    }

    public String getWelfareTitle() {
        return welfareTitle;
    }

    public void setWelfareTitle(String welfareTitle) {
        this.welfareTitle = welfareTitle == null ? null : welfareTitle.trim();
    }

    public String getWelfareContext() {
        return welfareContext;
    }

    public void setWelfareContext(String welfareContext) {
        this.welfareContext = welfareContext == null ? null : welfareContext.trim();
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

    public Integer getWelfareCondition() {
        return welfareCondition;
    }

    public void setWelfareCondition(Integer welfareCondition) {
        this.welfareCondition = welfareCondition;
    }
}