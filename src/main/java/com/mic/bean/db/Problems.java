/**
 * chenPeng
 * com.mic.bean.db
 * Problem.java
 * 创建人:chenpeng
 * 时间：2019年2月11日-下午8:44:00 
 * 2019陈鹏-版权所有
 */
package com.mic.bean.db;

/**
 * 
 * Problem
 * 创建人:chenPeng
 * 时间：2019年2月11日-下午8:44:00 
 * @version 1.0.0
 * 
 */
public class Problems {
	private Integer id;
	private Integer course_note_id;
	private String problem;
	private String answer;
	private String imgsrc;
	private Integer anonymity;
	private Integer dispark;
	public Integer getDispark() {
		return dispark;
	}


	public void setDispark(Integer dispark) {
		this.dispark = dispark;
	}
	public Problems(){};
	
	
	
	/**
	 * 创建一个新的实例 Problems.
	 * @param id
	 * @param course_note_id
	 * @param problem
	 * @param answer
	 * @param imgsrc
	 * @param anonymity
	 * @param dispark
	 */
	public Problems(Integer id, Integer course_note_id, String problem, String answer, String imgsrc, Integer anonymity,
			Integer dispark) {
		super();
		this.id = id;
		this.course_note_id = course_note_id;
		this.problem = problem;
		this.answer = answer;
		this.imgsrc = imgsrc;
		this.anonymity = anonymity;
		this.dispark = dispark;
	}


	/**
	 * 创建一个新的实例 Problem.
	 * @param course_note_id
	 * @param problem
	 * @param answer
	 * @param imgsrc
	 * @param anonymity
	 */
	public Problems(Integer course_note_id, String problem, String answer, String imgsrc, Integer anonymity) {
		this.course_note_id = course_note_id;
		this.problem = problem;
		this.answer = answer;
		this.imgsrc = imgsrc;
		this.anonymity = anonymity;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourse_note_id() {
		return course_note_id;
	}
	public void setCourse_note_id(Integer course_note_id) {
		this.course_note_id = course_note_id;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public Integer getAnonymity() {
		return anonymity;
	}
	public void setAnonymity(Integer anonymity) {
		this.anonymity = anonymity;
	}
	

}
