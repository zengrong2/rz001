package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_activity_sponsor_distribute_extract")
public class TdActivitySponsorDistributeExtract extends BasePojo {
	@Id
	private String activitySponsorDistributeExtractId;
	private Integer activitySponsorDistributeExtractType;
	public String getActivitySponsorDistributeExtractId() {
		return activitySponsorDistributeExtractId;
	}
	public void setActivitySponsorDistributeExtractId(String activitySponsorDistributeExtractId) {
		this.activitySponsorDistributeExtractId = activitySponsorDistributeExtractId;
	}
	public Integer getActivitySponsorDistributeExtractType() {
		return activitySponsorDistributeExtractType;
	}
	public void setActivitySponsorDistributeExtractType(Integer activitySponsorDistributeExtractType) {
		this.activitySponsorDistributeExtractType = activitySponsorDistributeExtractType;
	}
	public Double getActivitySponsorDistributeExtractRate() {
		return activitySponsorDistributeExtractRate;
	}
	public void setActivitySponsorDistributeExtractRate(Double activitySponsorDistributeExtractRate) {
		this.activitySponsorDistributeExtractRate = activitySponsorDistributeExtractRate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private Double activitySponsorDistributeExtractRate;
	private String remark;
	
}
