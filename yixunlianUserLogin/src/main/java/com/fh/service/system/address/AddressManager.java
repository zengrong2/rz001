package com.fh.service.system.address;

import java.util.List;
import com.fh.lw.pojo.Address;
import com.fh.util.PageData;

public interface AddressManager {
	public List<Address> listSubAddressBypId(String pid)throws Exception;
	public PageData getAddressById(PageData pd) throws Exception;
	public void saveAddress(Address address) throws Exception;
	public PageData findMaxId(PageData pd) throws Exception;
	public void deleteAddressById(String id) throws Exception;
	public void edit(Address address) throws Exception;
	
	/**
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<Address> listAllAddress(String id) throws Exception;
	
	/**
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<Address> listAllAddressQx(String id) throws Exception;

}
