package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdAdvertisementimage;
@Service
public class AdvertisementSqlService implements AdvertisementSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdAdvertisementimage> getAllTdAdvertisement(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdAdvertisementimage>)dao.findForList("TdAdvertisementimageMapper.getAllTdAdvertisementlistPage", page);
	}
}
