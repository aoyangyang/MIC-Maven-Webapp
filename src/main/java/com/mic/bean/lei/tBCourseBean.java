/**
 * lei
 * com.mic.bean
 * tBCourseBean.java
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04
 * 2018lei-版权所有
 */
package com.mic.bean.lei;


/**
 * 
 * tBCourseBean
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04
 * @version 1.0.0
 * 
 */
public class tBCourseBean {
	private Integer id;
	private Integer teacherId;
	private String teacherName;
	private Integer size;
	private String c_name;
	private String o_time;
	private String address;
	
	
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
   
}
