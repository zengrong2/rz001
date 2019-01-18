package com.fh.lw.pojo.yixunlian;

public class TdAffectingcreditvalue {
    private String affectingcreditvalueId;

    private String affectingcreditvalueName;

    private Integer affectingcreditvalueNum;

    private String userId;

    public String getAffectingcreditvalueId() {
        return affectingcreditvalueId;
    }

    public void setAffectingcreditvalueId(String affectingcreditvalueId) {
        this.affectingcreditvalueId = affectingcreditvalueId == null ? null : affectingcreditvalueId.trim();
    }

    public String getAffectingcreditvalueName() {
        return affectingcreditvalueName;
    }

    public void setAffectingcreditvalueName(String affectingcreditvalueName) {
        this.affectingcreditvalueName = affectingcreditvalueName == null ? null : affectingcreditvalueName.trim();
    }

    public Integer getAffectingcreditvalueNum() {
        return affectingcreditvalueNum;
    }

    public void setAffectingcreditvalueNum(Integer affectingcreditvalueNum) {
        this.affectingcreditvalueNum = affectingcreditvalueNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}