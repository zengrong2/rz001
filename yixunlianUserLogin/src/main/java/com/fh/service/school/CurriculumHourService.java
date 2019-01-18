package com.fh.service.school;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;

@Service
public class CurriculumHourService implements CurriculumHourManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
}
