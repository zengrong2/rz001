package com.fh.service.school;

import java.util.List;

import com.fh.lw.pojo.school.MajorType;
import com.fh.util.PageData;

public interface MajorTypeManager {
	public List<MajorType> listSubMajorTypeBypId(Long pid)throws Exception;
	public PageData getMajorTypeById(PageData pd) throws Exception;
	public void saveMajorType(MajorType majorType) throws Exception;
	public PageData findMaxId(PageData pd) throws Exception;
	public void deleteMajorTypeById(Long type_id) throws Exception;
	public void edit(MajorType majorType) throws Exception;
    public PageData editicon(PageData pd) throws Exception;
	
	/**
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<MajorType> listAllMajorType(Long type_id) throws Exception;
	
	/**
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<MajorType> listAllMajorTypeQx(Long type_id) throws Exception;
}
