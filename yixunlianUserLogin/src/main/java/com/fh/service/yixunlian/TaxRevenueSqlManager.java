package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdTaxrevenue;

public interface TaxRevenueSqlManager {

	List<TdTaxrevenue> getAllTdTaxrevenue(Page page) throws Exception;

}
