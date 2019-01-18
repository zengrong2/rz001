package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.MemberTypeMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.lw.service.BaseService;

@Service
public class MemberTypeService extends BaseService<TdUtype>{
	 @Autowired
	 private MemberTypeMapper mapper;
}
