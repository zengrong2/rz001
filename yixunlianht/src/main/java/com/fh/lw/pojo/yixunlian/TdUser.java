package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_user")
public class TdUser extends BasePojo{
	@Id
    private String userId;
	
	private String provinceCitycode;
    private String cityCitycode;
    private String areaCitycode;
    private Integer isSpecialActivitytypeUser;
    
    private String registerTime;
    @Transient
    private Integer[] creditrdNumArray;
    
    public String getProvinceCitycode() {
		return provinceCitycode;
	}

	public void setProvinceCitycode(String provinceCitycode) {
		this.provinceCitycode = provinceCitycode;
	}

	public String getCityCitycode() {
		return cityCitycode;
	}

	public void setCityCitycode(String cityCitycode) {
		this.cityCitycode = cityCitycode;
	}

	public String getAreaCitycode() {
		return areaCitycode;
	}

	public void setAreaCitycode(String areaCitycode) {
		this.areaCitycode = areaCitycode;
	}

	private String openId;
    
    private Integer isVip;
    //会员开始结束时间
    private String memberStartTime;
    private String memberEndTime;
    //会员体验时间
    private String experienceTime;
    private String experienceEndTime;
    //等级名称
    private  String utypeName;
   
    public String getMemberStartTime() {
		return memberStartTime;
	}

	public void setMemberStartTime(String memberStartTime) {
		this.memberStartTime = memberStartTime;
	}

	public String getMemberEndTime() {
		return memberEndTime;
	}

	public void setMemberEndTime(String memberEndTime) {
		this.memberEndTime = memberEndTime;
	}

	public String getExperienceTime() {
		return experienceTime;
	}

	public Integer[] getCreditrdNumArray() {
		return creditrdNumArray;
	}

	public void setCreditrdNumArray(Integer[] creditrdNumArray) {
		this.creditrdNumArray = creditrdNumArray;
	}

	public void setExperienceTime(String experienceTime) {
		this.experienceTime = experienceTime;
	}

	public String getExperienceEndTime() {
		return experienceEndTime;
	}

	public void setExperienceEndTime(String experienceEndTime) {
		this.experienceEndTime = experienceEndTime;
	}

	private String professionalTitle;
    private String canProvide;
    private String need;
    private String beliefInLife;
    private String experienceutypeId;
    public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public String getCanProvide() {
		return canProvide;
	}

	public void setCanProvide(String canProvide) {
		this.canProvide = canProvide;
	}

	public String getNeed() {
		return need;
	}

	public void setNeed(String need) {
		this.need = need;
	}

	public Integer getIsSpecialActivitytypeUser() {
		return isSpecialActivitytypeUser;
	}

	public void setIsSpecialActivitytypeUser(Integer isSpecialActivitytypeUser) {
		this.isSpecialActivitytypeUser = isSpecialActivitytypeUser;
	}

	public String getBeliefInLife() {
		return beliefInLife;
	}

	public void setBeliefInLife(String beliefInLife) {
		this.beliefInLife = beliefInLife;
	}

	public String getExperienceutypeId() {
		return experienceutypeId;
	}

	public void setExperienceutypeId(String experienceutypeId) {
		this.experienceutypeId = experienceutypeId;
	}

	public String getResourceAddTime() {
		return resourceAddTime;
	}

	public void setResourceAddTime(String resourceAddTime) {
		this.resourceAddTime = resourceAddTime;
	}
//资源锁定时间
	private String resourceAddTime;
    

    private String uNickname;

    private String headUrl;
    
  

    public String getUtypeName() {
		return utypeName;
	}

	public void setUtypeName(String utypeName) {
		this.utypeName = utypeName;
	}

	private Integer uSex;

    private String ubirthday;

    private String uName;

    private String uCard;

    private String uPhone;

    private Double uBalance;

    private Integer isPay;

   

    private Integer isAuthentication;

  

    private String utypeId;

    private String egidId;
    
    

  /*  private String citycode;*/

    private String memberid;
    public Integer getClosedUserStatus() {
		return closedUserStatus;
	}

	public void setClosedUserStatus(Integer closedUserStatus) {
		this.closedUserStatus = closedUserStatus;
	}

	private Integer closedUserStatus;
    private Integer creditrdNum;

    private String userrefereeUid;

    private String usermanagerUid;
   
    private String userrefereeName;
    //推荐人会员号
    @Transient
    private String userrefereememberid;
    public String getUsermanagermemberid() {
		return usermanagermemberid;
	}

	public void setUsermanagermemberid(String usermanagermemberid) {
		this.usermanagermemberid = usermanagermemberid;
	}

	@Transient
    private String usermanagermemberid;
    public String getUserrefereememberid() {
		return userrefereememberid;
	}

	public void setUserrefereememberid(String userrefereememberid) {
		this.userrefereememberid = userrefereememberid;
	}

	public String getUserrefereeName() {
		return userrefereeName;
	}
  
	public void setUserrefereeName(String userrefereeName) {
		this.userrefereeName = userrefereeName;
	}

	public String getUsermanagerName() {
		return usermanagerName;
	}

	public void setUsermanagerName(String usermanagerName) {
		this.usermanagerName = usermanagerName;
	}

	
    private String usermanagerName;

    private String introductionIdfront;

    private String introductionIdback;

    private String introductionLicense;

    private Integer userType;

    private Integer pubactivitiesIspay;

    private Integer userIsactivation;

    private Date created;

    private Date updated;

    private Integer memberDays;
//resourceStrategyIsexperience
    private Integer resourceStrategyIsexperience;

  /*  private Date experienceTime;

    private String experienceutypeId;*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getuNickname() {
        return uNickname;
    }

    private String remark;
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

   
    public String getUbirthday() {
		return ubirthday;
	}

	public void setUbirthday(String ubirthday) {
		this.ubirthday = ubirthday;
	}

	public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuCard() {
        return uCard;
    }

    public void setuCard(String uCard) {
        this.uCard = uCard == null ? null : uCard.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public Double getuBalance() {
        return uBalance;
    }

    public void setuBalance(Double uBalance) {
        this.uBalance = uBalance;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

   

    public String getUtypeId() {
        return utypeId;
    }

    public void setUtypeId(String utypeId) {
        this.utypeId = utypeId == null ? null : utypeId.trim();
    }

    public String getEgidId() {
        return egidId;
    }

    public void setEgidId(String egidId) {
        this.egidId = egidId == null ? null : egidId.trim();
    }

   /* public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }*/

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public Integer getCreditrdNum() {
        return creditrdNum;
    }

    public void setCreditrdNum(Integer creditrdNum) {
        this.creditrdNum = creditrdNum;
    }

    public String getUserrefereeUid() {
        return userrefereeUid;
    }

    public void setUserrefereeUid(String userrefereeUid) {
        this.userrefereeUid = userrefereeUid == null ? null : userrefereeUid.trim();
    }

    public String getUsermanagerUid() {
        return usermanagerUid;
    }

    public void setUsermanagerUid(String usermanagerUid) {
        this.usermanagerUid = usermanagerUid == null ? null : usermanagerUid.trim();
    }

    public String getIntroductionIdfront() {
        return introductionIdfront;
    }

    public void setIntroductionIdfront(String introductionIdfront) {
        this.introductionIdfront = introductionIdfront == null ? null : introductionIdfront.trim();
    }

    public String getIntroductionIdback() {
        return introductionIdback;
    }

    public void setIntroductionIdback(String introductionIdback) {
        this.introductionIdback = introductionIdback == null ? null : introductionIdback.trim();
    }

    public String getIntroductionLicense() {
        return introductionLicense;
    }

    public void setIntroductionLicense(String introductionLicense) {
        this.introductionLicense = introductionLicense == null ? null : introductionLicense.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getPubactivitiesIspay() {
        return pubactivitiesIspay;
    }

    public void setPubactivitiesIspay(Integer pubactivitiesIspay) {
        this.pubactivitiesIspay = pubactivitiesIspay;
    }

    public Integer getUserIsactivation() {
        return userIsactivation;
    }

    public void setUserIsactivation(Integer userIsactivation) {
        this.userIsactivation = userIsactivation;
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

    public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getMemberDays() {
        return memberDays;
    }

    public void setMemberDays(Integer memberDays) {
        this.memberDays = memberDays;
    }

    public Integer getResourceStrategyIsexperience() {
        return resourceStrategyIsexperience;
    }

    public void setResourceStrategyIsexperience(Integer resourceStrategyIsexperience) {
        this.resourceStrategyIsexperience = resourceStrategyIsexperience;
    }

    /*public Date getExperienceTime() {
        return experienceTime;
    }

    public void setExperienceTime(Date experienceTime) {
        this.experienceTime = experienceTime;
    }

    public String getExperienceutypeId() {
        return experienceutypeId;
    }

    public void setExperienceutypeId(String experienceutypeId) {
        this.experienceutypeId = experienceutypeId == null ? null : experienceutypeId.trim();
    }*/
}