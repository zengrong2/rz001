package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.TaxRevenueMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdTaxrevenue;
import com.fh.lw.service.BaseService;

@Service
public class TaxRevenueService extends BaseService<TdTaxrevenue>{
	 @Autowired
	 private TaxRevenueMapper mapper;
}
