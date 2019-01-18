package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdCreditrating {
    private String creditrdId;

    private Integer creditRating;

    private Integer creditratingMax;

    private Integer creditratingMix;

    private Date created;

    private Date updated;

    public String getCreditrdId() {
        return creditrdId;
    }

    public void setCreditrdId(String creditrdId) {
        this.creditrdId = creditrdId == null ? null : creditrdId.trim();
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

    public Integer getCreditratingMax() {
        return creditratingMax;
    }

    public void setCreditratingMax(Integer creditratingMax) {
        this.creditratingMax = creditratingMax;
    }

    public Integer getCreditratingMix() {
        return creditratingMix;
    }

    public void setCreditratingMix(Integer creditratingMix) {
        this.creditratingMix = creditratingMix;
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