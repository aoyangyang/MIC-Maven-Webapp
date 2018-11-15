/**
 * chenPeng
 * com.mic.bean
 * Student.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-下午10:16:49 
 * 2018陈鹏-版权所有
 */
package com.mic.bean;

/**
 * 学生
 * Student
 * 创建人:chenPeng
 * 时间：2018年8月5日-下午10:16:49 
 * @version 1.0.0
 * 
 */
public class Student {
	private Integer id;
	private String username;
	private String password;
	private Integer class_id;
	private String email;
	private String pic;
	private Integer point;
	private String address;
	private Integer sex;
	private String phone;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
