package com.fh.service.school;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.course.Chapter;
import com.fh.util.PageData;

@Service
public class ChapterService implements ChapterManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Chapter>  findListChapterByCurriculumId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Chapter>)dao.findListChapterByCurriculumId("ChapterMapper.findListChapterByCurriculumId",pd);
	}

	@Override
	public void editChapter(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editChapter("ChapterMapper.editChapterByCid",pd);
	}

	@Override
	public void addChapter(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.addChapter("ChapterMapper.addChapterByCid",pd);
	}

	@Override
	public void deleteChapterBycid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("ChapterMapper.deleteChapterBycid", pd);
	}
}
