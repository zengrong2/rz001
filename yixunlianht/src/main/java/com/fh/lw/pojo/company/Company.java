package com.fh.lw.pojo.company;

import java.util.List;

import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

import com.fh.lw.pojo.BasePojo;
import com.fh.lw.pojo.user.Teacher;

/**
 * 公司
 * @author 凌鑫
 *
 */
@Table(name="td_company")
public class Company extends BasePojo{
	private static final long serialVersionUID = 1L;

@Id
private int companyId;
private String companyName;//公司名字
private String companyJuli;//距离当前位置
private String companyAdress;//用人单位地址

private String companyWelfare;//用人单位福利
private String companyTime;//发布日期

private String companyScale;//公司规模
private String companyNature;//公司性质
private String companyPhone;//公司电话
private int labour_id;//培训就业id

private Integer is_recruit;//表示招聘状态
private String province;//省
private String city;//市
private String area;//区
private String labour_name;//公司类型
private String remark;//备注
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
@Transient
private List<Company> subType;//递归显示使用
public List<Company> getSubType() {
	return subType;
}
public void setSubType(List<Company> subType) {
	this.subType = subType;
}
public String getLabour_name() {
	return labour_name;
}
public void setLabour_name(String labour_name) {
	this.labour_name = labour_name;
}
public Integer getIs_recruit() {
	return is_recruit;
}
public void setIs_recruit(Integer is_recruit) {
	this.is_recruit = is_recruit;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getLng() {
	return lng;
}
public void setLng(String lng) {
	this.lng = lng;
}
public String getLat() {
	return lat;
}
public void setLat(String lat) {
	this.lat = lat;
}
private String lng;//经度
private String lat;//纬度

public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}

public String getCompanyName() {
	return companyName;
}
public int getLabour_id() {
	return labour_id;
}
public void setLabour_id(int labour_id) {
	this.labour_id = labour_id;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getCompanyJuli() {
	return companyJuli;
}
public void setCompanyJuli(String companyJuli) {
	this.companyJuli = companyJuli;
}
public String getCompanyAdress() {
	return companyAdress;
}
public void setCompanyAdress(String companyAdress) {
	this.companyAdress = companyAdress;
}

public String getCompanyWelfare() {
	return companyWelfare;
}
public void setCompanyWelfare(String companyWelfare) {
	this.companyWelfare = companyWelfare;
}
public String getCompanyTime() {
	return companyTime;
}
public void setCompanyTime(String companyTime) {
	this.companyTime = companyTime;
}

public String getCompanyScale() {
	return companyScale;
}
public void setCompanyScale(String companyScale) {
	this.companyScale = companyScale;
}
public String getCompanyNature() {
	return companyNature;
}
public void setCompanyNature(String companyNature) {
	this.companyNature = companyNature;
}
public String getCompanyPhone() {
	return companyPhone;
}
public void setCompanyPhone(String companyPhone) {
	this.companyPhone = companyPhone;
}


}
