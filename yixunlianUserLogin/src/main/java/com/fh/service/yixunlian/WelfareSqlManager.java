package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdMembershipwelfare;

public interface WelfareSqlManager {

	List<TdMembershipwelfare> getAllTdMembershipwelfare(Page page) throws Exception;

}
