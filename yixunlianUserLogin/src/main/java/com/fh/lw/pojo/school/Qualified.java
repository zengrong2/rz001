package com.fh.lw.pojo.school;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.entity.Page;
import com.fh.lw.pojo.BasePojo;
/**
 * 学校资质
 * @author a55660000
 *
 */
@Table(name="tb_qualified")
public class Qualified extends BasePojo{
  @Id
  private Long qualifiedId;
  private String qualifiedName;//资质名称
  private String imgUrl;//资质图片
  private String schoolName;//学校名称
  private Long schoolId;//学校Id
  private String createTime;
  private String updateTime;
  private Page page;
public Long getQualifiedId() {
	return qualifiedId;
}
public void setQualifiedId(Long qualifiedId) {
	this.qualifiedId = qualifiedId;
}
public String getQualifiedName() {
	return qualifiedName;
}
public void setQualifiedName(String qualifiedName) {
	this.qualifiedName = qualifiedName;
}
public String getImgUrl() {
	return imgUrl;
}
public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public Long getSchoolId() {
	return schoolId;
}
public void setSchoolId(Long schoolId) {
	this.schoolId = schoolId;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
}
public Page getPage() {
	if(page==null)
		page = new Page();
	return page;
}
public void setPage(Page page) {
	this.page = page;
}
}
