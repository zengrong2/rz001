package com.fh.lw.pojo.course;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;



@Table(name="tb_chapter")
public class Chapter<T> extends BasePojo{
@Id
private Integer chapterId;
private String chapterName;//章节名字
private Integer curriculumId;


private String curriculum_introduction;
private String curriculum_name;
public String getCurriculum_introduction() {
	return curriculum_introduction;
}
public void setCurriculum_introduction(String curriculum_introduction) {
	this.curriculum_introduction = curriculum_introduction;
}
public String getCurriculum_name() {
	return curriculum_name;
}
public void setCurriculum_name(String curriculum_name) {
	this.curriculum_name = curriculum_name;
}
public Integer getCurriculumId() {
	return curriculumId;
}
public void setCurriculumId(Integer curriculumId) {
	this.curriculumId = curriculumId;
}
transient private T data;

public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}
public Integer getChapterId() {
	return chapterId;
}
public void setChapterId(Integer chapterId) {
	this.chapterId = chapterId;
}
public String getChapterName() {
	return chapterName;
}
public void setChapterName(String chapterName) {
	this.chapterName = chapterName;
}
}
