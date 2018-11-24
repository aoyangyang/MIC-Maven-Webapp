/**
 * chenPeng
 * com.mic.bean
 * Departments.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-上午10:56:36 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.departments;

/**
 * 学部/学院
 * Departments
 * 创建人:chenPeng
 * 时间：2018年8月5日-上午10:56:36 
 * @version 1.0.0
 * 
 */
public class Departments {
	private Integer id;
	private Integer school_id;
	private String d_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
}
