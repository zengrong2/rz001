package com.fh.lw.pojo.educationschool;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 学历提升学校
 * @author 凌鑫
 *
 */
@Table(name="td_ed_school")
public class EducationSchool extends  BasePojo{
@Id
private Integer esId;
private String esName;//学历提升学校名字
private String esAddress;//学历提升学校地址
private String esFollow;//学历提升学校关注人数
private String esCollection;//学历提升学校收藏次数
private String esImage;//学历提升学校图片
private String esDetails;//学历提升学校机构详情
public Integer getEsId() {
	return esId;
}
public void setEsId(Integer esId) {
	this.esId = esId;
}
public String getEsName() {
	return esName;
}
public void setEsName(String esName) {
	this.esName = esName;
}
public String getEsAddress() {
	return esAddress;
}
public void setEsAddress(String esAddress) {
	this.esAddress = esAddress;
}
public String getEsFollow() {
	return esFollow;
}
public void setEsFollow(String esFollow) {
	this.esFollow = esFollow;
}
public String getEsCollection() {
	return esCollection;
}
public void setEsCollection(String esCollection) {
	this.esCollection = esCollection;
}
public String getEsImage() {
	return esImage;
}
public void setEsImage(String esImage) {
	this.esImage = esImage;
}
public String getEsDetails() {
	return esDetails;
}
public void setEsDetails(String esDetails) {
	this.esDetails = esDetails;
}

}
