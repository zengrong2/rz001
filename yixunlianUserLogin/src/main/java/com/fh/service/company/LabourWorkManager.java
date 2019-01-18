package com.fh.service.company;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.util.PageData;

public interface LabourWorkManager {

	List<Labour> ListLabourWordType(Page page) throws Exception;


	void deleteLabourTypeBylid(PageData pd) throws Exception;



	PageData getLabourTypeById(PageData pd) throws Exception;



	void editLabourType(PageData pd) throws Exception;



	void saveLabourTypeInfo(PageData pd) throws Exception;



	List<Labour> showListLabourWorkType() throws Exception;


	Labour findLabourTypeById(int getwId) throws Exception;


	void deleteAllLabourWorkType(String[] arrayLabourWorkType_IDS) throws Exception;



	
	

}
