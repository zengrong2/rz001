package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.AddressMapper;
import com.fh.lw.mapper.TdAddressMapper;
import com.fh.lw.mapper.WelfareMapper;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdMembershipwelfare;
import com.fh.lw.service.BaseService;

@Service
public class TdAddressService extends BaseService<TdAddress>{
	@Autowired
	  private TdAddressMapper mapper;
}
