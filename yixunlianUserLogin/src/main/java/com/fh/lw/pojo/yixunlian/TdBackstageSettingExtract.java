package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdBackstageSettingExtract {
    private String backstageSettingExtractId;

    private String extractType;

    private Long extractRete;

    private Date created;

    private Date updated;

    public String getBackstageSettingExtractId() {
        return backstageSettingExtractId;
    }

    public void setBackstageSettingExtractId(String backstageSettingExtractId) {
        this.backstageSettingExtractId = backstageSettingExtractId == null ? null : backstageSettingExtractId.trim();
    }

    public String getExtractType() {
        return extractType;
    }

    public void setExtractType(String extractType) {
        this.extractType = extractType == null ? null : extractType.trim();
    }

    public Long getExtractRete() {
        return extractRete;
    }

    public void setExtractRete(Long extractRete) {
        this.extractRete = extractRete;
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