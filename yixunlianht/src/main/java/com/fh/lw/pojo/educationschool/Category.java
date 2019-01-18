package com.fh.lw.pojo.educationschool;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 学历提升学校内部
 * @author 凌鑫
 *
 */
@Table(name="td_category")
public class Category extends BasePojo{
@Id
private Integer cId;
private String cName;//学历提升学校内部升学类别
private String cMajor;//学历提升学校内部专业
private String cTuition;//学历提升学校内部学费
private Integer esId;//学历提升学校id
private Integer school_id;
private String remark;//备注
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Integer getSchool_id() {
	return school_id;
}
public void setSchool_id(Integer school_id) {
	this.school_id = school_id;
}
public Integer getEsId() {
	return esId;
}
public void setEsId(Integer esId) {
	this.esId = esId;
}
public Integer getcId() {
	return cId;
}
public void setcId(Integer cId) {
	this.cId = cId;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getcMajor() {
	return cMajor;
}
public void setcMajor(String cMajor) {
	this.cMajor = cMajor;
}
public String getcTuition() {
	return cTuition;
}
public void setcTuition(String cTuition) {
	this.cTuition = cTuition;
}

}
