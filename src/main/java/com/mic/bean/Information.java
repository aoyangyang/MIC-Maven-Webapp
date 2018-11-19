/**
 * chenPeng
 * com.mic.bean
 * Attendance.java
 * 创建人:chenpeng
 * 时间：2018年8月9日-下午9:06:29 
 * 2018陈鹏-版权所有
 */
package com.mic.bean;

/**
 * 考情信息
 * Attendance
 * 创建人:chenPeng
 * 时间：2018年8月9日-下午9:06:29 
 * @version 1.0.0
 * 
 */
public class Information {
	private Integer attendance_id;
	private Integer student_id;
	private String status;
	public Integer getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(Integer attendance_id) {
		this.attendance_id = attendance_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
