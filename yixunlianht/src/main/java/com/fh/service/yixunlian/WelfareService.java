package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.WelfareMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdMembershipwelfare;
import com.fh.lw.service.BaseService;

@Service
public class WelfareService extends BaseService<TdMembershipwelfare>{
	@Autowired
	  private WelfareMapper mapper;
}
