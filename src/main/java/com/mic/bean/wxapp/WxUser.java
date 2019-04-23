/**
 * chenPeng
 * com.mic.dao.wxapp
 * WxUser.java
 * 创建人:chenpeng
 * 时间：2019年4月22日-下午9:51:00 
 * 2019陈鹏-版权所有
 */
package com.mic.bean.wxapp;

/**
 * 
 * WxUser
 * 创建人:chenPeng
 * 时间：2019年4月22日-下午9:51:00 
 * @version 1.0.0
 * 
 */
public class WxUser {
	private Integer id;
	private String pic;
	
	
	/**
	 * 创建一个新的实例 WxUser.
	 * @param id
	 * @param pic
	 */
	public WxUser(Integer id, String pic) {
		super();
		this.id = id;
		this.pic = pic;
	}
	
	/**
	 * 创建一个新的实例 WxUser.
	 */
	public WxUser() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
