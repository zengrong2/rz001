package com.fh.service.yixunlian;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;

@Service
public class SysuserAndFeedbackadviceSqlService implements SysuserAndFeedbackadviceSqlManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
}
