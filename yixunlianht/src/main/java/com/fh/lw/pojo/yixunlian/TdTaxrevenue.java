package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_taxrevenue")
public class TdTaxrevenue extends BasePojo{
	@Id
    private String taxrevenueId;

    private Double taxrevenueRate;

    private Date created;

    private Date updated;
    private String remark;
    

    public String getRemark() {
		return remark;
	}

	public Double getTaxrevenueRate() {
		return taxrevenueRate;
	}

	public void setTaxrevenueRate(Double taxrevenueRate) {
		this.taxrevenueRate = taxrevenueRate;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private Integer taxrevenueStatus;

    public String getTaxrevenueId() {
        return taxrevenueId;
    }

    public void setTaxrevenueId(String taxrevenueId) {
        this.taxrevenueId = taxrevenueId == null ? null : taxrevenueId.trim();
    }

   

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getTaxrevenueStatus() {
        return taxrevenueStatus;
    }

    public void setTaxrevenueStatus(Integer taxrevenueStatus) {
        this.taxrevenueStatus = taxrevenueStatus;
    }
}