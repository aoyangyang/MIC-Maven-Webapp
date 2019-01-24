/**
 * chenPeng
 * com.mic.bean
 * Admin.java
 * 创建人:chenpeng
 * 时间：2018年12月29日-上午2:16:47 
 * 2018陈鹏-版权所有
 */
package com.mic.bean;

/**
 * 
 * Admin
 * 创建人:chenPeng
 * 时间：2018年12月29日-上午2:16:47 
 * @version 1.0.0
 * 
 */
public class Admin {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
