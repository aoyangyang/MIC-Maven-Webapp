/**
 * chenPeng
 * com.mic.bean
 * AdDepartments.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-下午6:33:12 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.departments;

/**
 * 学工组
 * AdDepartments
 * 创建人:chenPeng
 * 时间：2018年8月5日-下午6:33:12 
 * @version 1.0.0
 * 
 */
public class AdDepartments {
	private Integer id;
	private Integer leader_id;
	private Integer departments_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLeader_id() {
		return leader_id;
	}
	public void setLeader_id(Integer leader_id) {
		this.leader_id = leader_id;
	}
	public Integer getDepartments_id() {
		return departments_id;
	}
	public void setDepartments_id(Integer departments_id) {
		this.departments_id = departments_id;
	}
}
