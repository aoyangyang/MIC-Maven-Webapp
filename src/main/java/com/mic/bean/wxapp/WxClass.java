/**
 * chenPeng
 * com.mic.dao.wxapp
 * WxClass.java
 * 创建人:chenpeng
 * 时间：2019年4月22日-下午9:51:08 
 * 2019陈鹏-版权所有
 */
package com.mic.bean.wxapp;

/**
 * 
 * WxClass
 * 创建人:chenPeng
 * 时间：2019年4月22日-下午9:51:08 
 * @version 1.0.0
 * 
 */
public class WxClass {
	private String classroom;
	private Integer id;
	private Integer state;
	private Integer can;
	
	public Integer getCan() {
		return can;
	}
	public void setCan(Integer can) {
		this.can = can;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	
	/**
	 * 创建一个新的实例 WxClass.
	 */
	public WxClass() {
		super();
	}
	/**
	 * 创建一个新的实例 WxClass.
	 * @param classroom
	 * @param id
	 * @param state
	 */
	public WxClass(String classroom, Integer id, Integer state,Integer can) {
		super();
		this.classroom = classroom;
		this.id = id;
		this.state = state;
		this.can = can;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	

	
}
