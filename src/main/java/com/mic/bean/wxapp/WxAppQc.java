/**
 * chenPeng
 * com.mic.bean
 * WxApp.java
 * 创建人:chenpeng
 * 时间：2019年4月22日-下午8:13:26 
 * 2019陈鹏-版权所有
 */
package com.mic.bean.wxapp;

/**
 * 
 * WxApp
 * 创建人:chenPeng
 * 时间：2019年4月22日-下午8:13:26 
 * @version 1.0.0
 * 
 */
public class WxAppQc {
	private String username;
	private String pword;
	private Integer course_note_id;
	
	
	
	
	/**
	 * 创建一个新的实例 WxAppQc.
	 */
	public WxAppQc() {
		super();
	}


	/**
	 * 创建一个新的实例 WxAppQc.
	 * @param username
	 * @param pword
	 * @param course_note_id
	 */
	public WxAppQc(String username, String pword, Integer course_note_id) {
		this.username = username;
		this.pword = pword;
		this.course_note_id = course_note_id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public Integer getCourse_note_id() {
		return course_note_id;
	}
	public void setCourse_note_id(Integer course_note_id) {
		this.course_note_id = course_note_id;
	}
	
}
