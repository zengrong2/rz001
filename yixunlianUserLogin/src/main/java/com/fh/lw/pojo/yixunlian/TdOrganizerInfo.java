package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="td_organizer_info")
public class TdOrganizerInfo extends BasePojo{
	@Id
	private String organizerInfoId;
	private String headUrl;
	private String name;

	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrganizerInfoId() {
		return organizerInfoId;
	}
	public void setOrganizerInfoId(String organizerInfoId) {
		this.organizerInfoId = organizerInfoId;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	public String getRemark() {
		return remark;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String phone;
	private String userId;
	private String detailInfo;
	private String remark;
}
