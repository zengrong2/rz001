package com.fh.service.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Company;
import com.fh.util.PageData;

@Service
public class CompanyService implements CompanyManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listCompany (Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Company>)dao.listCompany("CompanyMapper.companylistPage",page);
	}

	@Override
	public void deleteCompanyByCid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.deleteCompanyByCid("CompanyMapper.deleteCompanyById", pd);

	}

	@Override
	public PageData getCompanyById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.getCompanyByCid("CompanyMapper.findCompanyByCid",pd);
	}

	@Override
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.editCompanyByCid("CompanyMapper.editCompanyById", pd);

	}

	@Override
	public void saveCompanyInfo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.saveCompanyInfo("CompanyMapper.saveCompanyInfo", pd);

	}

	@Override
	public void editRecruitState(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editRecruitState("CompanyMapper.editRecruitState",pd);
	}

	@Override
	public void deleteAllCompany(String[] arrayCompany_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("CompanyMapper.deleteAllCompany", arrayCompany_IDS);
	}

	@Override
	public PageData findCompanyById(int company_id) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findCompanyById("CompanyMapper.findCompanyById",company_id);
	}

	@Override
	public PageData findCompanyByName(String company_name) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findCompanyByName("CompanyMapper.findCompanyByName", company_name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllCompany() throws Exception {
		// TODO Auto-generated method stub
		return (List<Company>)dao.getAllCompany("CompanyMapper.getAllCompany");
	}


	
}
