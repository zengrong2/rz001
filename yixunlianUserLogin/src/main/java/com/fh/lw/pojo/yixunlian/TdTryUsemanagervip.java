package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdTryUsemanagervip {
    private String tryUsevipId;

    private Integer tryUsevipDays;

    private Date tryUsevipStartday;

    private String utypeId;

    private Date created;

    private Date updated;

    public String getTryUsevipId() {
        return tryUsevipId;
    }

    public void setTryUsevipId(String tryUsevipId) {
        this.tryUsevipId = tryUsevipId == null ? null : tryUsevipId.trim();
    }

    public Integer getTryUsevipDays() {
        return tryUsevipDays;
    }

    public void setTryUsevipDays(Integer tryUsevipDays) {
        this.tryUsevipDays = tryUsevipDays;
    }

    public Date getTryUsevipStartday() {
        return tryUsevipStartday;
    }

    public void setTryUsevipStartday(Date tryUsevipStartday) {
        this.tryUsevipStartday = tryUsevipStartday;
    }

    public String getUtypeId() {
        return utypeId;
    }

    public void setUtypeId(String utypeId) {
        this.utypeId = utypeId == null ? null : utypeId.trim();
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