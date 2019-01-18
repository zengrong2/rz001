package com.fh.lw.pojo.school;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 平台简介
 * @author lanzheng
 *
 */
@Table(name="tb_ptjj")
public class Platform extends BasePojo{
	@Id
	private Integer ptjjId;//平台简介id
    private String title;//标题
    private String imgUrl;//图片路径
    private String htmlUrl;//网页路径    
	public Integer getPtjjId() {
		return ptjjId;
	}
	public void setPtjjId(Integer ptjjId) {
		this.ptjjId = ptjjId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
    
}
