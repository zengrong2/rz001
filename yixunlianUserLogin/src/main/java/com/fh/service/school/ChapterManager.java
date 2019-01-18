package com.fh.service.school;

import java.util.List;

import com.fh.lw.pojo.course.Chapter;
import com.fh.util.PageData;

public interface ChapterManager {

	List<Chapter>  findListChapterByCurriculumId(PageData pd) throws Exception;

	void editChapter(PageData pd) throws Exception;

	void addChapter(PageData pd) throws Exception;

	void deleteChapterBycid(PageData pd) throws Exception;

}
