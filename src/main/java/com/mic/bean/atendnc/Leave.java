/**
 * chenPeng
 * com.mic.bean.atendnc
 * Leave.java
 * 创建人:chenpeng
 * 时间：2018年11月25日-下午3:12:44 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.atendnc;

/**
 * 
 * Leave
 * 创建人:chenPeng
 * 时间：2018年11月25日-下午3:12:44 
 * @version 1.0.0
 * 
 */
public class Leave {
	private Integer id;
	private Integer student_id;
	private String reason;
	private String s_phone;
	private String begin_time;
	private String end_time;
	private Integer state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

}
