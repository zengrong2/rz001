package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;


@Table(name="td_activity")
public class TdActivity extends BasePojo{
	@Id
    private String activityId;

    private String userId;
    //收费项目
    @Transient
    private List<TdActivityChargeItem> listTdActivityChargeItem;
    //报名填写项
  //报名填写项全部
    @Transient
    private List<TdActivitysign> addListTdActivitysign;

    private String activityName;
    @Transient
    private String address1;
    @Transient
    private String address2;
    @Transient
    private String address3;
    
    
    @Transient
    private String userName;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String activitycategoryId;
	private String activitycategoryName;

    private String activitysignStarttime;

    private String activitysignEndtime;

    private String activitystartTime;

    private String  activityendTime;

    private Integer activityCountpersons;

   /* private Integer activityChargestatus;*/
private Integer activityChargestatus;

    private Integer activityChargemethod;

    private Integer activityType;

    private String provinceCitycode;

    private String cityCitycode;

    private String areaCitycode;
    
    
    private BigDecimal royaltyRatio;
    private String precisionDemandProvinceId;
    private String precisionDemandCityId;
    private String precisionDemandAreaId;
    //详细地址
    private String addressName;
    public BigDecimal getRoyaltyRatio() {
		return royaltyRatio;
	}

	public void setRoyaltyRatio(BigDecimal royaltyRatio) {
		this.royaltyRatio = royaltyRatio;
	}

	public String getPrecisionDemandProvinceId() {
		return precisionDemandProvinceId;
	}

	public List<TdActivitysign> getAddListTdActivitysign() {
		return addListTdActivitysign;
	}

	public void setAddListTdActivitysign(List<TdActivitysign> addListTdActivitysign) {
		this.addListTdActivitysign = addListTdActivitysign;
	}

	public String getActivitycategoryName() {
		return activitycategoryName;
	}

	public List<TdActivityChargeItem> getListTdActivityChargeItem() {
		return listTdActivityChargeItem;
	}

	public void setListTdActivityChargeItem(List<TdActivityChargeItem> listTdActivityChargeItem) {
		this.listTdActivityChargeItem = listTdActivityChargeItem;
	}

	public void setActivitycategoryName(String activitycategoryName) {
		this.activitycategoryName = activitycategoryName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public void setPrecisionDemandProvinceId(String precisionDemandProvinceId) {
		this.precisionDemandProvinceId = precisionDemandProvinceId;
	}

	public String getPrecisionDemandCityId() {
		return precisionDemandCityId;
	}

	public void setPrecisionDemandCityId(String precisionDemandCityId) {
		this.precisionDemandCityId = precisionDemandCityId;
	}

	public String getPrecisionDemandAreaId() {
		return precisionDemandAreaId;
	}

	public void setPrecisionDemandAreaId(String precisionDemandAreaId) {
		this.precisionDemandAreaId = precisionDemandAreaId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getPrecisionDemandAddressName() {
		return precisionDemandAddressName;
	}

	public void setPrecisionDemandAddressName(String precisionDemandAddressName) {
		this.precisionDemandAddressName = precisionDemandAddressName;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getJoinNum() {
		return joinNum;
	}

	public void setJoinNum(Integer joinNum) {
		this.joinNum = joinNum;
	}

	public Integer getPaymentResult() {
		return paymentResult;
	}

	public void setPaymentResult(Integer paymentResult) {
		this.paymentResult = paymentResult;
	}

	//活动匹配地址名称
    private String precisionDemandAddressName;
    private Integer views;
    private Integer joinNum;
    private Integer paymentResult;
 
    
    private String lng;

    private String lat;

    private String activityCoverimgurl;

    private Integer activityIsextract;

    private String activityDetailsurl;

    private String activitymusicId;

    private Date created;

    private Date updated;

    private Integer onlineStatus;

    private Integer activitySignupstatus;

    private Integer activityStatus;

    private String activityQrcode;

    private String shareAbstract;

    private String undercarriageReason;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivitycategoryId() {
        return activitycategoryId;
    }

    public void setActivitycategoryId(String activitycategoryId) {
        this.activitycategoryId = activitycategoryId == null ? null : activitycategoryId.trim();
    }

   
    public String getActivitysignStarttime() {
		return activitysignStarttime;
	}

	public void setActivitysignStarttime(String activitysignStarttime) {
		this.activitysignStarttime = activitysignStarttime;
	}

	public String getActivitysignEndtime() {
		return activitysignEndtime;
	}

	public void setActivitysignEndtime(String activitysignEndtime) {
		this.activitysignEndtime = activitysignEndtime;
	}

	public String getActivitystartTime() {
		return activitystartTime;
	}

	public void setActivitystartTime(String activitystartTime) {
		this.activitystartTime = activitystartTime;
	}

	public String getActivityendTime() {
		return activityendTime;
	}

	public void setActivityendTime(String activityendTime) {
		this.activityendTime = activityendTime;
	}

	public Integer getActivityCountpersons() {
        return activityCountpersons;
    }

    public void setActivityCountpersons(Integer activityCountpersons) {
        this.activityCountpersons = activityCountpersons;
    }

    public Integer getActivityChargestatus() {
        return activityChargestatus;
    }

    public void setActivityChargestatus(Integer activityChargestatus) {
        this.activityChargestatus = activityChargestatus;
    }

    public Integer getActivityChargemethod() {
        return activityChargemethod;
    }

    public void setActivityChargemethod(Integer activityChargemethod) {
        this.activityChargemethod = activityChargemethod;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getProvinceCitycode() {
        return provinceCitycode;
    }

    public void setProvinceCitycode(String provinceCitycode) {
        this.provinceCitycode = provinceCitycode == null ? null : provinceCitycode.trim();
    }

    public String getCityCitycode() {
        return cityCitycode;
    }

    public void setCityCitycode(String cityCitycode) {
        this.cityCitycode = cityCitycode == null ? null : cityCitycode.trim();
    }

    public String getAreaCitycode() {
        return areaCitycode;
    }

    public void setAreaCitycode(String areaCitycode) {
        this.areaCitycode = areaCitycode == null ? null : areaCitycode.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getActivityCoverimgurl() {
        return activityCoverimgurl;
    }

    public void setActivityCoverimgurl(String activityCoverimgurl) {
        this.activityCoverimgurl = activityCoverimgurl == null ? null : activityCoverimgurl.trim();
    }

    public Integer getActivityIsextract() {
        return activityIsextract;
    }

    public void setActivityIsextract(Integer activityIsextract) {
        this.activityIsextract = activityIsextract;
    }

    public String getActivityDetailsurl() {
        return activityDetailsurl;
    }

    public void setActivityDetailsurl(String activityDetailsurl) {
        this.activityDetailsurl = activityDetailsurl == null ? null : activityDetailsurl.trim();
    }

    public String getActivitymusicId() {
        return activitymusicId;
    }

    public void setActivitymusicId(String activitymusicId) {
        this.activitymusicId = activitymusicId == null ? null : activitymusicId.trim();
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

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getActivitySignupstatus() {
        return activitySignupstatus;
    }

    public void setActivitySignupstatus(Integer activitySignupstatus) {
        this.activitySignupstatus = activitySignupstatus;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityQrcode() {
        return activityQrcode;
    }

    public void setActivityQrcode(String activityQrcode) {
        this.activityQrcode = activityQrcode == null ? null : activityQrcode.trim();
    }

    public String getShareAbstract() {
        return shareAbstract;
    }

    public void setShareAbstract(String shareAbstract) {
        this.shareAbstract = shareAbstract == null ? null : shareAbstract.trim();
    }

    public String getUndercarriageReason() {
        return undercarriageReason;
    }

    public void setUndercarriageReason(String undercarriageReason) {
        this.undercarriageReason = undercarriageReason == null ? null : undercarriageReason.trim();
    }
}