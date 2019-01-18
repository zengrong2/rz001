package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_memberupdateextract")
public class TdMemberUpdateExtract extends BasePojo{
	@Id
    private String memberupdateextractId;
	private Integer memberUpdateExtractType;
	private Integer typeId;
	public String getMemberupdateextractId() {
		return memberupdateextractId;
	}
	public void setMemberupdateextractId(String memberupdateextractId) {
		this.memberupdateextractId = memberupdateextractId;
	}
	public Integer getMemberUpdateExtractType() {
		return memberUpdateExtractType;
	}
	public void setMemberUpdateExtractType(Integer memberUpdateExtractType) {
		this.memberUpdateExtractType = memberUpdateExtractType;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Double getMemberUpdateMoney() {
		return memberUpdateMoney;
	}
	public void setMemberUpdateMoney(Double memberUpdateMoney) {
		this.memberUpdateMoney = memberUpdateMoney;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private Double  memberUpdateMoney;
	private String remark;
}
