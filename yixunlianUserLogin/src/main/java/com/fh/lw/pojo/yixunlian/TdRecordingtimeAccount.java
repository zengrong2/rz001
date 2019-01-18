package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;

public class TdRecordingtimeAccount {
    private String recordingtimeId;

    private Date recordingtimeStart;

    private Date recordingtimeEnd;

    private BigDecimal accountAmount;

    private String userId;

    private Date created;

    private Date updated;

    public String getRecordingtimeId() {
        return recordingtimeId;
    }

    public void setRecordingtimeId(String recordingtimeId) {
        this.recordingtimeId = recordingtimeId == null ? null : recordingtimeId.trim();
    }

    public Date getRecordingtimeStart() {
        return recordingtimeStart;
    }

    public void setRecordingtimeStart(Date recordingtimeStart) {
        this.recordingtimeStart = recordingtimeStart;
    }

    public Date getRecordingtimeEnd() {
        return recordingtimeEnd;
    }

    public void setRecordingtimeEnd(Date recordingtimeEnd) {
        this.recordingtimeEnd = recordingtimeEnd;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
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
}