/**
 * chenPeng
 * com.mic.bean
 * Classs.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-下午10:17:29 
 * 2018陈鹏-版权所有
 */
package com.mic.bean;

/**
 * 班级
 * Classs
 * 创建人:chenPeng
 * 时间：2018年8月5日-下午10:17:29 
 * @version 1.0.0
 * 
 */
public class Classs {
	private Integer id;
	private String classname;
	private Integer departments_id;
	private Integer major_id;
	private Integer enrolment;
	private Integer class_size;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getDepartments_id() {
		return departments_id;
	}
	public void setDepartments_id(Integer departments_id) {
		this.departments_id = departments_id;
	}
	public Integer getMajor_id() {
		return major_id;
	}
	public void setMajor_id(Integer major_id) {
		this.major_id = major_id;
	}
	public Integer getEnrolment() {
		return enrolment;
	}
	public void setEnrolment(Integer enrolment) {
		this.enrolment = enrolment;
	}
	public Integer getClass_size() {
		return class_size;
	}
	public void setClass_size(Integer class_size) {
		this.class_size = class_size;
	}
}
