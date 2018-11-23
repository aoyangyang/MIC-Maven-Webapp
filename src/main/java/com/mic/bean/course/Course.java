/**
 * chenPeng
 * com.mic.bean
 * Course.java
 * 创建人:chenpeng
 * 时间：2018年11月17日-下午8:38:37 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.course;

/**
 * 课程信息
 * Course
 * 创建人:chenPeng
 * 时间：2018年11月17日-下午8:38:37 
 * @version 1.0.0
 * 
 */
public class Course {
	private Integer id;
	private Integer teacher_id;
	private String course_name;
	private Integer size;
	private String open_time;
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}
