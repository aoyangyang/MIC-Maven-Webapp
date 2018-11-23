/**
 * chenPeng
 * com.mic.bean
 * CourseNote.java
 * 创建人:chenpeng
 * 时间：2018年11月18日-下午2:57:25 
 * 2018陈鹏-版权所有
 */
package com.mic.bean.course;

/**
 * 
 * CourseNote
 * 创建人:chenPeng
 * 时间：2018年11月18日-下午2:57:25 
 * @version 1.0.0
 * 
 */
public class CourseNote {
	private Integer id;
	private Integer course_id;
	private String name;
	private String Introduction;
	private String	begin_time;
	private String end_time;
	private String courseware;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
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
	public String getCourseware() {
		return courseware;
	}
	public void setCourseware(String courseware) {
		this.courseware = courseware;
	}


}
