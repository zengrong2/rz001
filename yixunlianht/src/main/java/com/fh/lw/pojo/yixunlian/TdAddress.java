package com.fh.lw.pojo.yixunlian;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

@Table(name="tb_address")
public class TdAddress  extends BasePojo{
	 @Id
     private String citycode;
	 private String cityname;
	 private String pidcode;
	 private String simplename;
	 private Integer citylevel;
	 private String areacode;
	 private String postcode;
	 private String py;
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getPidcode() {
		return pidcode;
	}
	public void setPidcode(String pidcode) {
		this.pidcode = pidcode;
	}
	public String getSimplename() {
		return simplename;
	}
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	public Integer getCitylevel() {
		return citylevel;
	}
	public void setCitylevel(Integer citylevel) {
		this.citylevel = citylevel;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPy() {
		return py;
	}
	public void setPy(String py) {
		this.py = py;
	}
	
	
}
