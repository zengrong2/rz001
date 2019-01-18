package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;

//活动收费项目
@Table(name="td_activity_charge_item")
public class TdActivityChargeItem extends BasePojo {
	@Id
	private String activityChargeItemId;
	private String activityChargeItemName;
	private BigDecimal activityChargeItemMoney;
	private String activityId;
	private String userId;
	private String remark;
	public String getActivityChargeItemId() {
		return activityChargeItemId;
	}
	public void setActivityChargeItemId(String activityChargeItemId) {
		this.activityChargeItemId = activityChargeItemId;
	}
	public String getActivityChargeItemName() {
		return activityChargeItemName;
	}
	public void setActivityChargeItemName(String activityChargeItemName) {
		this.activityChargeItemName = activityChargeItemName;
	}
	
	public BigDecimal getActivityChargeItemMoney() {
		return activityChargeItemMoney;
	}
	public void setActivityChargeItemMoney(BigDecimal activityChargeItemMoney) {
		this.activityChargeItemMoney = activityChargeItemMoney;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
