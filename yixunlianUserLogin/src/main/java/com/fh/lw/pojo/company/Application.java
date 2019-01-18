package com.fh.lw.pojo.company;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 申请人
 * @author 凌鑫
 *
 */
@Table(name="td_application")
public class Application extends BasePojo{
	@Id
	private Integer applicationId;
	private String applicationName;//申请人
	private String applicationPhone;//申请人电话
	private String applicationAge;//年龄
	private String applicationSex;//性别
	private String applicationAddress;//申请人地址
	private String applicationEdcation;//教育经历
	private String applicationWork;//工作经历
	private Integer p_id;//职位id
	private Integer user_id;//注册用户id
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	private Integer company_id;//公司id
	
	private Long userId;//学生id
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicationPhone() {
		return applicationPhone;
	}
	public void setApplicationPhone(String applicationPhone) {
		this.applicationPhone = applicationPhone;
	}
	public String getApplicationAge() {
		return applicationAge;
	}
	public void setApplicationAge(String applicationAge) {
		this.applicationAge = applicationAge;
	}
	public String getApplicationSex() {
		return applicationSex;
	}
	public void setApplicationSex(String applicationSex) {
		this.applicationSex = applicationSex;
	}
	public String getApplicationAddress() {
		return applicationAddress;
	}
	public void setApplicationAddress(String applicationAddress) {
		this.applicationAddress = applicationAddress;
	}
	public String getApplicationEdcation() {
		return applicationEdcation;
	}
	public void setApplicationEdcation(String applicationEdcation) {
		this.applicationEdcation = applicationEdcation;
	}
	public String getApplicationWork() {
		return applicationWork;
	}
	public void setApplicationWork(String applicationWork) {
		this.applicationWork = applicationWork;
	}

}
