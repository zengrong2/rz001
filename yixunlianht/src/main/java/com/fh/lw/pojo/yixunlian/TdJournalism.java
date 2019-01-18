package com.fh.lw.pojo.yixunlian;

import java.util.Date;

import javax.mail.Multipart;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;
@Table(name="td_journalism")
public class TdJournalism extends BasePojo{
	@Id
	private String journalismId;

    private String journalismName;

    private Date journalismDate;

    private String journalismSysoName;

    private Integer journalismBrowsingtimes;

    private Integer journalismSharetimes;
    
    private String journalismShowImg;
    private String remark;
    private String shareSummary;
    
    private Integer is_online;
    

 /*   private Multipart journalismUrl;
  public Multipart getJournalismUrl() {
		return journalismUrl;
	}

	public void setJournalismUrl(Multipart journalismUrl) {
		this.journalismUrl = journalismUrl;
	}*/


	public Integer getIs_online() {
		return is_online;
	}

	public void setIs_online(Integer is_online) {
		this.is_online = is_online;
	}

	public String getJournalismShowImg() {
		return journalismShowImg;
	}

	public String getShareSummary() {
		return shareSummary;
	}

	public void setShareSummary(String shareSummary) {
		this.shareSummary = shareSummary;
	}

	public void setJournalismShowImg(String journalismShowImg) {
		this.journalismShowImg = journalismShowImg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private String  journalismUrl;

    private String readingsurveyId;

    private Date created;

    private Date updated;

    public String getJournalismId() {
        return journalismId;
    }

    public void setJournalismId(String journalismId) {
        this.journalismId = journalismId == null ? null : journalismId.trim();
    }

    public String getJournalismName() {
        return journalismName;
    }

    public void setJournalismName(String journalismName) {
        this.journalismName = journalismName == null ? null : journalismName.trim();
    }

    public Date getJournalismDate() {
        return journalismDate;
    }

    public void setJournalismDate(Date journalismDate) {
        this.journalismDate = journalismDate;
    }

   

    public String getJournalismSysoName() {
		return journalismSysoName;
	}

	public void setJournalismSysoName(String journalismSysoName) {
		this.journalismSysoName = journalismSysoName;
	}

	public Integer getJournalismBrowsingtimes() {
        return journalismBrowsingtimes;
    }

    public void setJournalismBrowsingtimes(Integer journalismBrowsingtimes) {
        this.journalismBrowsingtimes = journalismBrowsingtimes;
    }

    public Integer getJournalismSharetimes() {
        return journalismSharetimes;
    }

    public void setJournalismSharetimes(Integer journalismSharetimes) {
        this.journalismSharetimes = journalismSharetimes;
    }

   public String getJournalismUrl() {
        return journalismUrl;
    }

    public void setJournalismUrl(String journalismUrl) {
        this.journalismUrl = journalismUrl == null ? null : journalismUrl.trim();
    }

    public String getReadingsurveyId() {
        return readingsurveyId;
    }

    public void setReadingsurveyId(String readingsurveyId) {
        this.readingsurveyId = readingsurveyId == null ? null : readingsurveyId.trim();
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