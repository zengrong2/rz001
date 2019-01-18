package com.fh.lw.pojo.obtainemployment;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 劳动就业
 * @author 凌鑫
 *
 */
@Table(name="td_labour")
public class Labour extends BasePojo{
@Id
private Integer labour_id;
private String remark;//备注
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Integer getLabour_id() {
	return labour_id;
}
public void setLabour_id(Integer labour_id) {
	this.labour_id = labour_id;
}
public String getLabour_name() {
	return labour_name;
}
public void setLabour_name(String labour_name) {
	this.labour_name = labour_name;
}
public String getLabour_image() {
	return labour_image;
}
public void setLabour_image(String labour_image) {
	this.labour_image = labour_image;
}
private String labour_name;//劳动就业名字
private String labour_image;//就业图片

}
