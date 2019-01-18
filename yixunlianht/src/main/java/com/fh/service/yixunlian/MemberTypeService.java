package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.MemberTypeMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class MemberTypeService extends BaseService<TdUtype>{
	 @Autowired
	 private MemberTypeMapper mapper;

	public List<TdUtype> getNotExpUType() {
		// TODO Auto-generated method stub
		TdUtype tdUtype = new TdUtype();
		Example example = new Example(tdUtype.getClass());
		example.createCriteria().andNotEqualTo("utypeId", 4);
		List<TdUtype>  listTdUtype = this.mapper.selectByExample(example);
		return listTdUtype;
	}
}
