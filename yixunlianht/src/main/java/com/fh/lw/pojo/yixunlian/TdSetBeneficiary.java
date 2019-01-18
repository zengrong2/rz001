package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_set_beneficiary")
public class TdSetBeneficiary extends BasePojo{
	@Id
	private String beneficiaryId;	
	private String beneficiaryUserId;
	private String remark;
	@Transient
	private TdUser tdUserBeneficiary;
	@Transient
	private TdUser tdUserMember;
	
	public TdUser getTdUserBeneficiary() {
		return tdUserBeneficiary;
	}
	public void setTdUserBeneficiary(TdUser tdUserBeneficiary) {
		this.tdUserBeneficiary = tdUserBeneficiary;
	}
	public TdUser getTdUserMember() {
		return tdUserMember;
	}
	public void setTdUserMember(TdUser tdUserMember) {
		this.tdUserMember = tdUserMember;
	}
	private String memberUserId;
	public String getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(String beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getBeneficiaryUserId() {
		return beneficiaryUserId;
	}
	public void setBeneficiaryUserId(String beneficiaryUserId) {
		this.beneficiaryUserId = beneficiaryUserId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMemberUserId() {
		return memberUserId;
	}
	public void setMemberUserId(String memberUserId) {
		this.memberUserId = memberUserId;
	}
	public Integer getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}
	private Integer isCancel ;
}
