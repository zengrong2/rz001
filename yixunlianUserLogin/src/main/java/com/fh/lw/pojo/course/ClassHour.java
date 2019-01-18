package com.fh.lw.pojo.course;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;


@Table(name="tb_class_hour")
public class ClassHour extends BasePojo{
	@Id
	private Integer chId;
	private Integer chapterId;//章节id
	private String chName;//课时名字
	public Integer getChId() {
		return chId;
	}
	public void setChId(Integer chId) {
		this.chId = chId;
	}
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	@Override
	public String toString() {
		return "ClassHour [chId=" + chId + ", chapterId=" + chapterId + ", chName=" + chName + "]";
	}
}
