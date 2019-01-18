package com.fh.lw.pojo.company;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
import com.fh.lw.pojo.user.Teacher;

/**
 * 职位
 * @author 凌鑫
 *
 */
@Table(name="td_position")
public class Position extends BasePojo{
	private static final long serialVersionUID = 1L;

@Id
private Integer pId;
private Integer companyId;//公司id
private String pName;//职位名称
private String pSalary;//职位工资
private String pAddress;//职位地址
private String pJuli;//职位距离当前位置距离
private String pContent;//职位内容
private String pRequirement;//职位要求
private int  work_collection;//职位收藏
private String company_name;
private String p_type;
private int is_state;
private String remark;//备注
private String work;
public String getWork() {
	return work;
}
public void setWork(String work) {
	this.work = work;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public int getIs_state() {
	return is_state;
}
public void setIs_state(int is_state) {
	this.is_state = is_state;
}
@Transient
private List<Position> subType;//递归显示使用
public List<Position> getSubType() {
	return subType;
}
public void setSubType(List<Position> subType) {
	this.subType = subType;
}
public String getP_type() {
	return p_type;
}
public void setP_type(String p_type) {
	this.p_type = p_type;
}
public String getCompany_name() {
	return company_name;
}
public void setCompany_name(String company_name) {
	this.company_name = company_name;
}
public int getWork_collection() {
	return work_collection;
}
public void setWork_collection(int work_collection) {
	this.work_collection = work_collection;
}
public int getWork_browse() {
	return work_browse;
}
public void setWork_browse(int work_browse) {
	this.work_browse = work_browse;
}
private int work_browse ; //职位浏览量

public Integer getpId() {
	return pId;
}
public void setpId(Integer pId) {
	this.pId = pId;
}
public Integer getCompanyId() {
	return companyId;
}
public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public String getpSalary() {
	return pSalary;
}
public void setpSalary(String pSalary) {
	this.pSalary = pSalary;
}
public String getpAddress() {
	return pAddress;
}
public void setpAddress(String pAddress) {
	this.pAddress = pAddress;
}
public String getpJuli() {
	return pJuli;
}
public void setpJuli(String pJuli) {
	this.pJuli = pJuli;
}
public String getpContent() {
	return pContent;
}
public void setpContent(String pContent) {
	this.pContent = pContent;
}
public String getpRequirement() {
	return pRequirement;
}
public void setpRequirement(String pRequirement) {
	this.pRequirement = pRequirement;
}

}
