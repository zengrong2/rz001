package com.fh.service.school;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.obtainemployment.Prejob;
import com.fh.util.PageData;

public interface PreJobManager {

	List<Prejob> findListPreJobType(Page page) throws Exception;

	void delPreJobTypeBylid(PageData pd) throws Exception;

	void savePreJobTypeInfo(PageData pd) throws Exception;

	PageData getPreJobTypeTypeById(PageData pd) throws Exception;

	void editPreJobTypeType(PageData pd) throws Exception;

	void deleteAllProJobType(String[] arrayProJobType_IDS) throws Exception;

	List<Prejob> ListPreJobType() throws Exception;

}
