/**
 * chenPeng
 * com.mic.bean.db
 * Reply.java
 * 创建人:chenpeng
 * 时间：2019年2月15日-下午7:01:15 
 * 2019陈鹏-版权所有
 */
package com.mic.bean.db;

/**
 * 
 * Reply
 * 创建人:chenPeng
 * 时间：2019年2月15日-下午7:01:15 
 * @version 1.0.0
 * 
 */
public class Reply {
	private Integer id;
	private Integer problem_id;
	private Integer student_id;
	private String answer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProblem_id() {
		return problem_id;
	}
	public void setProblem_id(Integer problem_id) {
		this.problem_id = problem_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
