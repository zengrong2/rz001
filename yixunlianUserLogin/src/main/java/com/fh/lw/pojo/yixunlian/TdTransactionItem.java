package com.fh.lw.pojo.yixunlian;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_transaction_item")
public class TdTransactionItem extends BasePojo{
	@Id
	private String transactionItemId;
	private String activityId;
	private String userId;
	private String transactionItemName;
	private BigDecimal transactionItemMoney;
	private Integer status;
	private Date created;
	private Date updated;
	public String getTransactionItemId() {
		return transactionItemId;
	}
	public void setTransactionItemId(String transactionItemId) {
		this.transactionItemId = transactionItemId;
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
	public String getTransactionItemName() {
		return transactionItemName;
	}
	public void setTransactionItemName(String transactionItemName) {
		this.transactionItemName = transactionItemName;
	}
	
	
	public BigDecimal getTransactionItemMoney() {
		return transactionItemMoney;
	}
	public void setTransactionItemMoney(BigDecimal transactionItemMoney) {
		this.transactionItemMoney = transactionItemMoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String remark;
	

}
