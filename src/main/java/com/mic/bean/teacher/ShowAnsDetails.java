/**
 * chenPeng
 * com.mic.bean.teacher
 * ShowAnsDetails.java
 * 创建人:chenpeng
 * 时间：2019年2月15日-下午11:22:35 
 * 2019陈鹏-版权所有
 */
package com.mic.bean.teacher;

/**
 * 
 * ShowAnsDetails
 * 创建人:chenPeng
 * 时间：2019年2月15日-下午11:22:35 
 * @version 1.0.0
 * 
 */
public class ShowAnsDetails {
	private Integer id;
	private String username;
	private String answer;
	private Integer correct;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
}
