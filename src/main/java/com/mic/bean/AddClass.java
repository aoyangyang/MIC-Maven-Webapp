package com.mic.bean;

/**
 * 
 * 
 * AddClass
 * 创建人:Shanice
 * 时间：2018年10月18日-下午6:11:51 
 * @version 1.0.0
 *
 */
public class AddClass {
	private String classname;
	private Integer id;
	private Integer departments_id;
	private Integer major_id;
	private Integer enrolment;
	private Integer class_size;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
