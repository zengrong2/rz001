package com.fh.lw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.fh.lw.pojo.school.MajorType;


@Service
public class FMajorTypeService extends BaseService<MajorType>{


public List<MajorType> getMajorTypeByPid(Long pid) {
    MajorType mt=new MajorType();
    mt.setPid(pid);
	
	return super.queryListByWhere(mt);
}
}
