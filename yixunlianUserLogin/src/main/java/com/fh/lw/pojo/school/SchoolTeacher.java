package com.fh.lw.pojo.school;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 学校教师
 * @author a55660000
 *
 */
@Table(name="tb_school_teacher")
public class SchoolTeacher extends BasePojo{
	@Id
	private Long teacherId;
	private String name;//教师姓名
	private String headPortrait;//教师头像
	private String profile;//简介
	private Integer type;//是否名师1-是，0-否
	private Long schoolId;//学校id
	private String createTime;//创建时间
	private String updateTime;//更新时间
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
	

}
