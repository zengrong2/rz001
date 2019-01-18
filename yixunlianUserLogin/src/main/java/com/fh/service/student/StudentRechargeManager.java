package com.fh.service.student;

import java.util.List;

import com.fh.lw.pojo.student.StudentRecharge;
import com.fh.util.PageData;

public interface StudentRechargeManager {
	public List<StudentRecharge> studentRechargeBySId(PageData pd)throws Exception;

}
