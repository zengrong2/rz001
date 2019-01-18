package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;

public class TdExtractproject {
    private String extractprojectId;

    private String projectName;

    private BigDecimal projectRate;

    private BigDecimal projectMoney;

    private String activityId;

    private Date created;

    private Date updated;

    public String getExtractprojectId() {
        return extractprojectId;
    }

    public void setExtractprojectId(String extractprojectId) {
        this.extractprojectId = extractprojectId == null ? null : extractprojectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public BigDecimal getProjectRate() {
        return projectRate;
    }

    public void setProjectRate(BigDecimal projectRate) {
        this.projectRate = projectRate;
    }

    public BigDecimal getProjectMoney() {
        return projectMoney;
    }

    public void setProjectMoney(BigDecimal projectMoney) {
        this.projectMoney = projectMoney;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
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