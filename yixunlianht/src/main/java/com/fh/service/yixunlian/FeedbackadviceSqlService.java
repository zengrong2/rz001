package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdFeedbackadvice;

@Service
public class FeedbackadviceSqlService implements FeedbackadviceSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdFeedbackadvice> getAllTdlistFeedbackadvice(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdFeedbackadvice>)dao.findForList("TdFeedbackadviceMapper.getAllTdFeedbackadvicelistPage", page);
	}
}
