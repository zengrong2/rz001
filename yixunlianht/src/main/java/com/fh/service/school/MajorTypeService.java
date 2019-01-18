package com.fh.service.school;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.school.MajorType;
import com.fh.util.PageData;

@Service
public class MajorTypeService implements MajorTypeManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<MajorType> listSubMajorTypeBypId(Long pid) throws Exception {
		// TODO Auto-generated method stub
		return (List<MajorType>)dao.findForList("MajorTypeMapper.listSubMajorTypeBypId", pid);
	}

	@Override
	public PageData getMajorTypeById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("MajorTypeMapper.getMajorTypeById", pd);
	}

	@Override
	public void saveMajorType(MajorType serve) throws Exception {
		// TODO Auto-generated method stub
		dao.save("MajorTypeMapper.insertMajorType", serve);
	}

	@Override
	public PageData findMaxId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("MajorTypeMapper.findMaxId", pd);
	}

	@Override
	public void deleteMajorTypeById(Long type_id) throws Exception {
		// TODO Auto-generated method stub
		dao.save("MajorTypeMapper.deleteMajorTypeById", type_id);
	}

	@Override
	public void edit(MajorType serve) throws Exception {
		// TODO Auto-generated method stub
		dao.update("MajorTypeMapper.updateMajorType",serve);
	}

	@Override
	public PageData editicon(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MajorType> listAllMajorType(Long SERVE_ID) throws Exception {
		// TODO Auto-generated method stub
		List<MajorType> serList = this.listSubMajorTypeBypId(SERVE_ID);
		for(MajorType ser : serList){
			ser.setURL("major/type/toEdit.do?type_id="+ser.getType_id());
			ser.setSubType(this.listAllMajorType(ser.getType_id()));;
			ser.setTarget("treeFrame");
		}
		return serList;
	}

	@Override
	public List<MajorType> listAllMajorTypeQx(Long SERVE_ID) throws Exception {
		// TODO Auto-generated method stub
		List<MajorType> serList = this.listSubMajorTypeBypId(SERVE_ID);
		for(MajorType serve : serList){
			serve.setSubType(this.listAllMajorTypeQx(serve.getType_id()));
			serve.setTarget("treeFrame");
		}
		return serList;
	}

}
