package com.fh.lw.pojo.finance;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;


@Table(name="tb_lbt")
public class LunBo extends BasePojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer lbt_id;
	private String lbt_url;
	public Integer getLbt_id() {
		return lbt_id;
	}
	public void setLbt_id(Integer lbt_id) {
		this.lbt_id = lbt_id;
	}
	public String getLbtUrl() {
		return lbt_url;
	}
	public void setLbtUrl(String lbtUrl) {
		this.lbt_url = lbtUrl;
	}
	

}
