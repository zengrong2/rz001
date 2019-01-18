package com.fh.service.company;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.company.Company;
import com.fh.util.PageData;

public interface CompanyManager {

	List<Company> listCompany(Page page)throws Exception;



	void deleteCompanyByCid(PageData pd) throws Exception;



	PageData getCompanyById(PageData  pd) throws Exception;



	void edit(PageData pd) throws Exception;



	void saveCompanyInfo(PageData pd) throws Exception;



	void editRecruitState(PageData pd) throws Exception;



	void deleteAllCompany(String[] arrayCompany_IDS) throws Exception;



	PageData findCompanyById(int company_id) throws Exception;



	PageData findCompanyByName(String company_name) throws Exception;



	List<Company> getAllCompany() throws Exception;





}
