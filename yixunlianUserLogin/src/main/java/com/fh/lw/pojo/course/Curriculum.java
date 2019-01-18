package com.fh.lw.pojo.course;

import javax.persistence.Table;

@Table(name="td_curriculum")
public class Curriculum {
private Integer curriculumId;//

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
public Integer getCurriculumId() {
	return curriculumId;
}
public void setCurriculumId(Integer curriculumId) {
	this.curriculumId = curriculumId;
}
public String getCurriculumName() {
	return curriculumName;
}
public void setCurriculumName(String curriculumName) {
	this.curriculumName = curriculumName;
}
public String getCurriculumIntroduce() {
	return curriculumIntroduce;
}
public void setCurriculumIntroduce(String curriculumIntroduce) {
	this.curriculumIntroduce = curriculumIntroduce;
}
public String getCurriculumPeople() {
	return curriculumPeople;
}
public void setCurriculumPeople(String curriculumPeople) {
	this.curriculumPeople = curriculumPeople;
}
public String getCurriculumSalary() {
	return curriculumSalary;
}
public void setCurriculumSalary(String curriculumSalary) {
	this.curriculumSalary = curriculumSalary;
}
public Integer getMajorId() {
	return majorId;
}
public void setMajorId(Integer majorId) {
	this.majorId = majorId;
}
private String curriculumName;//课程名字
private String curriculumIntroduce;//课程介绍
private String curriculumPeople;//课程适用人群
private String curriculumSalary;//课程薪资
private Integer majorId;//专业id
}