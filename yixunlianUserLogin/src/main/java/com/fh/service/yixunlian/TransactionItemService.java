package com.fh.service.yixunlian;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.TransactionItemMapper;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdTransactionItem;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class TransactionItemService extends BaseService<TdTransactionItem>{
	 @Autowired
	  private TransactionItemMapper mapper;

	
}
