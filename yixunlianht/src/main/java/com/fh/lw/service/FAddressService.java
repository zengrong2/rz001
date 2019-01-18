package com.fh.lw.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.fh.lw.pojo.Address;
@Service
public class FAddressService extends BaseService<Address>{
	
	private static final double EARTH_RADIUS = 6378137;
	
	
	 private static double rad(double d)  
     {  
        return d * Math.PI / 180.0;  
     } 


	//通过pid查找街圈
	public List<Address> getAddressByPid(String pid){
		Address address=new Address();
	     address.setPid(pid);
	     return super.queryListByWhere(address);
	}
	//通过经纬度获取区
	public Address getAddress(String area) {
		// TODO Auto-generated method stub
		Address address=new Address();
		address.setStreet_name(area);
		address.setPid("510100");
		
		return super.queryOne(address);
	}
	/**
	 * 通过区和经纬度查询街圈
	 * 陈富平
	 * @param pid
	 * @param mapx
	 * @param mapy
	 * @return
	 */
	public Address getaddressBypidAndmap(String pid, double mapx, double mapy) {
		Address a1 = new Address();
		a1.setPid(pid);
		List<Address> one = super.queryListByWhere(a1);
		
		double sa = 100000000.0;
		Address n =new Address();
		for (Address o : one) {
			double x=Double.parseDouble(o.getLng());//纬度
			double y = Double.parseDouble(o.getLat());//经度
			
			double radLat1 = rad(mapx);  
	        double radLat2 = rad(x);  
	        double a = radLat1 - radLat2;  
	        double b = rad(mapy) - rad(y);  
	        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +   
	         Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
	        s = s * EARTH_RADIUS;  
	        s = Math.round(s * 10000) / 10000; 
		
				if(s<sa) {
					sa=s;
					n=o;
				}
				
			
		}
		
		return n;
	}

}
