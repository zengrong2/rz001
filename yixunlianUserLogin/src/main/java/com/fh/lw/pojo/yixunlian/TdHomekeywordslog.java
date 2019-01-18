package com.fh.lw.pojo.yixunlian;

public class TdHomekeywordslog {
    private String homekeywordsId;

    private String homekeywordsName;

    private String homekeywordsImgurl;

    private Integer homekeywordsOrder;

    public String getHomekeywordsId() {
        return homekeywordsId;
    }

    public void setHomekeywordsId(String homekeywordsId) {
        this.homekeywordsId = homekeywordsId == null ? null : homekeywordsId.trim();
    }

    public String getHomekeywordsName() {
        return homekeywordsName;
    }

    public void setHomekeywordsName(String homekeywordsName) {
        this.homekeywordsName = homekeywordsName == null ? null : homekeywordsName.trim();
    }

    public String getHomekeywordsImgurl() {
        return homekeywordsImgurl;
    }

    public void setHomekeywordsImgurl(String homekeywordsImgurl) {
        this.homekeywordsImgurl = homekeywordsImgurl == null ? null : homekeywordsImgurl.trim();
    }

    public Integer getHomekeywordsOrder() {
        return homekeywordsOrder;
    }

    public void setHomekeywordsOrder(Integer homekeywordsOrder) {
        this.homekeywordsOrder = homekeywordsOrder;
    }
}