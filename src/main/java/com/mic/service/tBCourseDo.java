/**
 * lei
 * com.mic.service
 * tBCourseDo.java
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04 
 * 2018雷-版权所有
 */

package com.mic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.tBCourseBean;
import com.mic.dao.tBCourseDao;

/**
 * 
 * tBCourseDo
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04 
 * @version 1.0.0
 * 
 */

@Service
public class tBCourseDo {
	@Autowired
	private tBCourseDao tbcoursedao;
	
	/**
	 *
	 * 建立课程
	 * 方法名：tBCourse
	 * 创建人：lei
	 * 时间：2018年9月26日-下午21:39:04
	 * 手机:15873169121
	 * @param 
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	public Integer tBCourse(String teacherName,String className,Integer classNum,String classTime,String classAddress)
	{
        tBCourseBean tbcoursebean = new tBCourseBean();
        tbcoursebean.setTeacherName(teacherName);
        tbcoursebean.setC_name(className);
        tbcoursebean.setO_time(classTime);
        tbcoursebean.setSize(classNum);
        tbcoursebean.setAddress(classAddress);
        tbcoursedao.addCourse(tbcoursebean);
        return tbcoursebean.getId();
	}
	

}
