package com.fh.controller.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.service.school.CurriculumHourManager;
import com.fh.service.school.SchoolManager;

@Controller
@RequestMapping("train/Curriculum/hour")
public class ChapterHourController {
	String menuUrl = "train/Curriculum/hour/listHour.do"; //菜单地址(权限用)
	@Autowired
	private CurriculumHourManager cservice;
}
