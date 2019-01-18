package com.fh.service.system.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.Address;
import com.fh.util.PageData;

@Service("addressService")
public class AddressService implements AddressManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> listSubAddressBypId(String pid) throws Exception {
		// TODO Auto-generated method stub
		return (List<Address>)dao.findForList("AddressMapper.listSubAddressBypId", pid);
	}

	@Override
	public PageData getAddressById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		PageData pd2=(PageData) dao.findForObject("AddressMapper.getAddressById", pd);
		return pd2;
	}

	@Override
	public void saveAddress(Address address) throws Exception {
		// TODO Auto-generated method stub
     
		dao.save("AddressMapper.insertAddress", address);
	}

	@Override
	public PageData findMaxId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("AddressMapper.findMaxId", pd);
	}

	@Override
	public void deleteAddressById(String id) throws Exception {
		dao.save("AddressMapper.deleteAddrerssById", id);
		
	}

	@Override
	public void edit(Address address) throws Exception {
		// TODO Auto-generated method stub
		dao.update("AddressMapper.updateAddress",address);
	}

	

	@Override
	public List<Address> listAllAddress(String id) throws Exception {
		List<Address> serList = this.listSubAddressBypId(id);
		for(Address ser : serList){
			ser.setURL("address/toEdit.do?citycode="+ser.getId());
			ser.setSubType(this.listAllAddress(ser.getId()));;
			ser.setTarget("treeFrame");
		}
		return serList;
	}

	@Override
	public List<Address> listAllAddressQx(String id) throws Exception {
		List<Address> serList = this.listSubAddressBypId(id);
		for(Address serve : serList){
			serve.setSubType(this.listAllAddressQx(serve.getId()));
			serve.setTarget("treeFrame");
		}
		return serList;
	}

}
