package com.fh.service.system.user;


import com.fh.lw.pojo.finance.LunBo;
import com.fh.util.PageData;

public interface LuBoManager {
	public PageData listLunBo(PageData pd) throws Exception;
	public void ediL(LunBo lunbo) throws Exception;
}
