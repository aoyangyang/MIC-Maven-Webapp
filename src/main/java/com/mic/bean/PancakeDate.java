/**
 * chenPeng
 * com.mic.bean
 * PancakeDate.java
 * 创建人:chenpeng
 * 时间：2018年8月9日-下午10:19:12 
 * 2018陈鹏-版权所有
 */
package com.mic.bean;

/**
 * PancakeDate
 * 创建人:chenPeng
 * 时间：2018年8月9日-下午11:04:32 
 * @version 1.0.0
 * 表名	PanckeName
 * 到课 attendance
 * 请假 leave
 * 缺勤 absence
 */
public class PancakeDate {
	//表名
	private String PanckeName;
	//到课
	private Integer attendance;
	//请假
	private Integer leave;
	//缺勤
	private Integer absence;
	//id
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPanckeName() {
		return PanckeName;
	}
	public void setPanckeName(String panckeName) {
		PanckeName = panckeName;
	}
	public Integer getAttendance() {
		return attendance;
	}
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	public Integer getLeave() {
		return leave;
	}
	public void setLeave(Integer leave) {
		this.leave = leave;
	}
	public Integer getAbsence() {
		return absence;
	}
	public void setAbsence(Integer absence) {
		this.absence = absence;
	}
	
}
