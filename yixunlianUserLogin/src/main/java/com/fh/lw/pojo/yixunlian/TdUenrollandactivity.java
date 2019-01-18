package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_uenrollandactivity")
public class TdUenrollandactivity extends BasePojo{
	@Id
    private String uandactivityenrollId;

    private String userId;
    private String uNickname;
    private Integer uSex;
    private String uPhone;
    private String organizerId;
    private String activityId;
    private BigDecimal transactionNum;
    private Integer dealStatus;
    private String eventSharerId;
    private Integer usersignStatus;
    private String changeHeadUrl;
    private String eventSharerMemberid;
   //报名时间
    @Transient
    private String signTime;
    private Integer paymentStatus;

    private BigDecimal paymentNum;
  //报名填写项目-增项
    @Transient
    private List<TdActivitysign> addListTdActivitysign;
    
    //报名填写区域
    @Transient
    private String mustWriteFillArea;
    //报名填写邀约人
    @Transient
    private String mustWriteFillInvitingUser;
    @Transient
    private TdUser tdUser;

    public TdUser getTdUser() {
		return tdUser;
	}

	public void setTdUser(TdUser tdUser) {
		this.tdUser = tdUser;
	}

	private Date created;

    private Date updated;

    private String remar;

    public String getUandactivityenrollId() {
        return uandactivityenrollId;
    }

    public void setUandactivityenrollId(String uandactivityenrollId) {
        this.uandactivityenrollId = uandactivityenrollId == null ? null : uandactivityenrollId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public List<TdActivitysign> getAddListTdActivitysign() {
		return addListTdActivitysign;
	}

	public void setAddListTdActivitysign(List<TdActivitysign> addListTdActivitysign) {
		this.addListTdActivitysign = addListTdActivitysign;
	}

	public String getMustWriteFillArea() {
		return mustWriteFillArea;
	}

	public void setMustWriteFillArea(String mustWriteFillArea) {
		this.mustWriteFillArea = mustWriteFillArea;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getMustWriteFillInvitingUser() {
		return mustWriteFillInvitingUser;
	}

	public void setMustWriteFillInvitingUser(String mustWriteFillInvitingUser) {
		this.mustWriteFillInvitingUser = mustWriteFillInvitingUser;
	}

	public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getUsersignStatus() {
        return usersignStatus;
    }

    public void setUsersignStatus(Integer usersignStatus) {
        this.usersignStatus = usersignStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    

    public BigDecimal getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(BigDecimal paymentNum) {
		this.paymentNum = paymentNum;
	}

	public Date getCreated() {
        return created;
    }

    public String getuNickname() {
		return uNickname;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	public Integer getuSex() {
		return uSex;
	}

	public void setuSex(Integer uSex) {
		this.uSex = uSex;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(String organizerId) {
		this.organizerId = organizerId;
	}

	public BigDecimal getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(BigDecimal transactionNum) {
		this.transactionNum = transactionNum;
	}

	public String getEventSharerId() {
		return eventSharerId;
	}

	public void setEventSharerId(String eventSharerId) {
		this.eventSharerId = eventSharerId;
	}

	public String getChangeHeadUrl() {
		return changeHeadUrl;
	}

	public void setChangeHeadUrl(String changeHeadUrl) {
		this.changeHeadUrl = changeHeadUrl;
	}

	public String getEventSharerMemberid() {
		return eventSharerMemberid;
	}

	public void setEventSharerMemberid(String eventSharerMemberid) {
		this.eventSharerMemberid = eventSharerMemberid;
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

    public String getRemar() {
        return remar;
    }

    public void setRemar(String remar) {
        this.remar = remar == null ? null : remar.trim();
    }
}