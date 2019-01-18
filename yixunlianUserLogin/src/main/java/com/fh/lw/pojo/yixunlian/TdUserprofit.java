package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdUserprofit {
    private String profitId;

    private Integer acMoney;

    private String activityId;

    private Date paymentTime;

    private String userId;

    private Date created;

    private Date updated;

    private Date recordingtimeEnd;

    public String getProfitId() {
        return profitId;
    }

    public void setProfitId(String profitId) {
        this.profitId = profitId == null ? null : profitId.trim();
    }

    public Integer getAcMoney() {
        return acMoney;
    }

    public void setAcMoney(Integer acMoney) {
        this.acMoney = acMoney;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Date getRecordingtimeEnd() {
        return recordingtimeEnd;
    }

    public void setRecordingtimeEnd(Date recordingtimeEnd) {
        this.recordingtimeEnd = recordingtimeEnd;
    }
}