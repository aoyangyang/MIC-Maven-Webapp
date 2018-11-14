/**
 * lei
 * com.mic.bean
 * pVacationBean.java
 * 创建人:lei
 * 时间：2018年9月29日-下午16:45:04
 * 2018lei-版权所有
 */
package com.mic.bean;

/**
 * 
 * pVacationBean
 * 创建人:lei
 * 时间：2018年9月29日-下午16:45:04
 * @version 1.0.0
 * 
 */
public class pVacationBean {
       private Integer student_id;
       private Integer state;
       private String reason;
       private String s_phone;
       private String begin_time;
       private String end_time;
       
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
}
