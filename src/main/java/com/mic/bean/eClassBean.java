/**
 * lei
 * com.mic.bean
 * eClassBean.java
 * 创建人:lei
 * 时间：2018年9月28日-下午19:39:04
 * 2018lei-版权所有
 */
package com.mic.bean;


/**
 * 
 * eClassBean
 * 创建人:lei
 * 时间：2018年9月28日-下午19:39:04
 * @version 1.0.0
 * 
 */

public class eClassBean {
	private Integer noteId;
	private Integer id;
	private String name;
    private String Introduction;
    private String begin_time;
    private String end_time;
    private String courseware;
    
    
    public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getCourseware() {
		return courseware;
	}
	public void setCourseware(String courseware) {
		this.courseware = courseware;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
    
}
