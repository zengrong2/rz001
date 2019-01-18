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

    private String activityId;

    private Integer dealStatus;
    
    private String changeHeadUrl;
  
    private String uNickname;
    private String uSex;
    private String uPhone;
    private String organizerId;
    private String activitycategoryId;
    private String isOperation;
    private String eventSharerMemberid;
    private String eventSharerId;
    
    private String transactionNum;
  
    public String getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(String transactionNum) {
		this.transactionNum = transactionNum;
	}

	//报名填写项目-增项
    @Transient
    private List<TdActivitysign> addListTdActivitysign;
    
    //报名填写区域
    @Transient
    private String mustWriteFillArea;
    //报名填写邀约人
    @Transient
    private String mustWriteFillInvitingUser;
    private Integer usersignStatus;

    private Integer paymentStatus;

    private BigDecimal paymentNum;
   
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

	
	public String getuNickname() {
		return uNickname;
	}

	public List<TdActivitysign> getAddListTdActivitysign() {
		return addListTdActivitysign;
	}

	public void setAddListTdActivitysign(List<TdActivitysign> addListTdActivitysign) {
		this.addListTdActivitysign = addListTdActivitysign;
	}

	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}

	public String getUandactivityenrollId() {
        return uandactivityenrollId;
    }

    public void setUandactivityenrollId(String uandactivityenrollId) {
        this.uandactivityenrollId = uandactivityenrollId == null ? null : uandactivityenrollId.trim();
    }

    public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
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

	public String getActivitycategoryId() {
		return activitycategoryId;
	}

	public void setActivitycategoryId(String activitycategoryId) {
		this.activitycategoryId = activitycategoryId;
	}

	public String getIsOperation() {
		return isOperation;
	}

	public void setIsOperation(String isOperation) {
		this.isOperation = isOperation;
	}

	public String getEventSharerMemberid() {
		return eventSharerMemberid;
	}

	public void setEventSharerMemberid(String eventSharerMemberid) {
		this.eventSharerMemberid = eventSharerMemberid;
	}

	public String getEventSharerId() {
		return eventSharerId;
	}

	public void setEventSharerId(String eventSharerId) {
		this.eventSharerId = eventSharerId;
	}

	public String getMustWriteFillArea() {
		return mustWriteFillArea;
	}

	public String getChangeHeadUrl() {
		return changeHeadUrl;
	}

	public void setChangeHeadUrl(String changeHeadUrl) {
		this.changeHeadUrl = changeHeadUrl;
	}

	public void setMustWriteFillArea(String mustWriteFillArea) {
		this.mustWriteFillArea = mustWriteFillArea;
	}

	public String getMustWriteFillInvitingUser() {
		return mustWriteFillInvitingUser;
	}

	public void setMustWriteFillInvitingUser(String mustWriteFillInvitingUser) {
		this.mustWriteFillInvitingUser = mustWriteFillInvitingUser;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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