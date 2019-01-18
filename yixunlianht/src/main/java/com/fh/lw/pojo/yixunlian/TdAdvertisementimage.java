package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_advertisementimage")
public class TdAdvertisementimage extends BasePojo{
	@Id
    private String id;

	
	private Integer isOnlineStatus;
    public Integer getIsOnlineStatus() {
		return isOnlineStatus;
	}

	public void setIsOnlineStatus(Integer isOnlineStatus) {
		this.isOnlineStatus = isOnlineStatus;
	}

	public String getId() {
		return id;
	}

	private String remark;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String imgName;

    private String imgUrl;

    private Date created;

    private Date updated;

    private String advertisementDetailsurl;

   

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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

    public String getAdvertisementDetailsurl() {
        return advertisementDetailsurl;
    }

    public void setAdvertisementDetailsurl(String advertisementDetailsurl) {
        this.advertisementDetailsurl = advertisementDetailsurl == null ? null : advertisementDetailsurl.trim();
    }
}