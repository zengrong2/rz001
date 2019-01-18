package com.fh.lw.pojo.yixunlian;

import java.util.Date;

public class TdUtypeAndvipmemberCurriculum {
    private String utypeAndvipmemberCurriculumId;

    private String vipMemberCurriculumId;

    private String utypeId;

    private Date created;

    private Date updated;

    public String getUtypeAndvipmemberCurriculumId() {
        return utypeAndvipmemberCurriculumId;
    }

    public void setUtypeAndvipmemberCurriculumId(String utypeAndvipmemberCurriculumId) {
        this.utypeAndvipmemberCurriculumId = utypeAndvipmemberCurriculumId == null ? null : utypeAndvipmemberCurriculumId.trim();
    }

    public String getVipMemberCurriculumId() {
        return vipMemberCurriculumId;
    }

    public void setVipMemberCurriculumId(String vipMemberCurriculumId) {
        this.vipMemberCurriculumId = vipMemberCurriculumId == null ? null : vipMemberCurriculumId.trim();
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