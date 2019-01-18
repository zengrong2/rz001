package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_system_help")
public class TdSystemHelp extends BasePojo{
	@Id
    private String systemHelpId;

    private String systemHelpType;

    private String systemHelpContext;

    private Date created;

    private Date updated;

    public String getSystemHelpId() {
        return systemHelpId;
    }

    public void setSystemHelpId(String systemHelpId) {
        this.systemHelpId = systemHelpId == null ? null : systemHelpId.trim();
    }

    public String getSystemHelpType() {
        return systemHelpType;
    }

    public void setSystemHelpType(String systemHelpType) {
        this.systemHelpType = systemHelpType == null ? null : systemHelpType.trim();
    }

    public String getSystemHelpContext() {
        return systemHelpContext;
    }

    public void setSystemHelpContext(String systemHelpContext) {
        this.systemHelpContext = systemHelpContext == null ? null : systemHelpContext.trim();
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
}