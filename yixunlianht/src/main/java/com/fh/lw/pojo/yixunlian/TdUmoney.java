package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;

public class TdUmoney {
    private String umoneyId;

    private BigDecimal alreadyPresented;

    private BigDecimal canPresented;

    private BigDecimal toRaised;

    private BigDecimal payTaxes;

    private String userId;

    private BigDecimal putMoney;

    private Date putTime;

    private Date created;

    private Date updated;

    private BigDecimal actualarrivalAmount;

    private String taxrevenueId;

    public String getUmoneyId() {
        return umoneyId;
    }

    public void setUmoneyId(String umoneyId) {
        this.umoneyId = umoneyId == null ? null : umoneyId.trim();
    }

    public BigDecimal getAlreadyPresented() {
        return alreadyPresented;
    }

    public void setAlreadyPresented(BigDecimal alreadyPresented) {
        this.alreadyPresented = alreadyPresented;
    }

    public BigDecimal getCanPresented() {
        return canPresented;
    }

    public void setCanPresented(BigDecimal canPresented) {
        this.canPresented = canPresented;
    }

    public BigDecimal getToRaised() {
        return toRaised;
    }

    public void setToRaised(BigDecimal toRaised) {
        this.toRaised = toRaised;
    }

    public BigDecimal getPayTaxes() {
        return payTaxes;
    }

    public void setPayTaxes(BigDecimal payTaxes) {
        this.payTaxes = payTaxes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public BigDecimal getPutMoney() {
        return putMoney;
    }

    public void setPutMoney(BigDecimal putMoney) {
        this.putMoney = putMoney;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
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

    public BigDecimal getActualarrivalAmount() {
        return actualarrivalAmount;
    }

    public void setActualarrivalAmount(BigDecimal actualarrivalAmount) {
        this.actualarrivalAmount = actualarrivalAmount;
    }

    public String getTaxrevenueId() {
        return taxrevenueId;
    }

    public void setTaxrevenueId(String taxrevenueId) {
        this.taxrevenueId = taxrevenueId == null ? null : taxrevenueId.trim();
    }
}