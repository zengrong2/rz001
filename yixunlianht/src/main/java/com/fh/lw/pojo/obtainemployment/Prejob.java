package com.fh.lw.pojo.obtainemployment;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 劳动就业
 * @author 凌鑫
 *
 */
@Table(name="td_prejob")
public class Prejob extends BasePojo{
@Id
private Integer wId;
private String wName;//劳动就业名字
private String wImage;//就业图片
private String remark;//备注
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Integer getwId() {
	return wId;
}
public void setwId(Integer wId) {
	this.wId = wId;
}
public String getwName() {
	return wName;
}
public void setwName(String wName) {
	this.wName = wName;
}
public String getwImage() {
	return wImage;
}
public void setwImage(String wImage) {
	this.wImage = wImage;
}
}
