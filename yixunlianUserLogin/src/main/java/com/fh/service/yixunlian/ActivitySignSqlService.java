package com.fh.service.yixunlian;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;

@Service
public class ActivitySignSqlService  implements ActivitySignSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
}
