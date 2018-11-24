/**
 * chenPeng
 * com.mic.bean.atendnc
 * Attendance.java
 * 创建人:chenpeng
 * 时间：2018年11月23日-下午5:26:28 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.atendnc;

/**
 * 考勤表
 * Attendance
 * 创建人:chenPeng
 * 时间：2018年11月23日-下午5:26:28 
 * @version 1.0.0
 * 
 */
public class Attendance {
	private Integer id;
	private Integer course_note_id;
	private String time;
	private String classroom;
	private Integer state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourse_note_id() {
		return course_note_id;
	}
	public void setCourse_note_id(Integer course_note_id) {
		this.course_note_id = course_note_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	
}
