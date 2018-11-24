/**
 * chenPeng
 * com.mic.bean
 * DepLeaderDetail.java
 * 创建人:chenpeng
 * 时间：2018年8月12日-下午5:31:49 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.departments;

/**
 * 领导详情页面
 * DepLeaderDetail
 * 创建人:chenPeng
 * 时间：2018年8月12日-下午5:31:49 
 * @version 1.0.0
 * absence 缺勤
 * leave 请假
 */
public class DepLeaderDetail {
	private String className;
	//缺勤
	private Integer absence;
	//请假
	private Integer leave;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getAbsence() {
		return absence;
	}
	public void setAbsence(Integer absence) {
		this.absence = absence;
	}
	public Integer getLeave() {
		return leave;
	}
	public void setLeave(Integer leave) {
		this.leave = leave;
	}
}
