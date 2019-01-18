package com.fh.lw.pojo.user;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;


/**
 * 问题
 * @author a55660000
 *
 */
@Table(name="tb_common_problem")
public class CommonProblem extends BasePojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer problemId;
	private String content;//问题内容
	private String answer;//问题回答
	public Integer getProblemId() {
		return problemId;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
