package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;

public class TdVipMemberCurriculum {
    private String vipMemberCurriculumId;

    private String vipMemberCurriculumName;

    private String vipMemberCurriculumIntroduction;

    private BigDecimal vipMemberCurriculumPrice;

    private Date created;

    private Date updated;

    public String getVipMemberCurriculumId() {
        return vipMemberCurriculumId;
    }

    public void setVipMemberCurriculumId(String vipMemberCurriculumId) {
        this.vipMemberCurriculumId = vipMemberCurriculumId == null ? null : vipMemberCurriculumId.trim();
    }

    public String getVipMemberCurriculumName() {
        return vipMemberCurriculumName;
    }

    public void setVipMemberCurriculumName(String vipMemberCurriculumName) {
        this.vipMemberCurriculumName = vipMemberCurriculumName == null ? null : vipMemberCurriculumName.trim();
    }

    public String getVipMemberCurriculumIntroduction() {
        return vipMemberCurriculumIntroduction;
    }

    public void setVipMemberCurriculumIntroduction(String vipMemberCurriculumIntroduction) {
        this.vipMemberCurriculumIntroduction = vipMemberCurriculumIntroduction == null ? null : vipMemberCurriculumIntroduction.trim();
    }

    public BigDecimal getVipMemberCurriculumPrice() {
        return vipMemberCurriculumPrice;
    }

    public void setVipMemberCurriculumPrice(BigDecimal vipMemberCurriculumPrice) {
        this.vipMemberCurriculumPrice = vipMemberCurriculumPrice;
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