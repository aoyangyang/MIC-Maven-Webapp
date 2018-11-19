/**
 * lei
 * com.mic.dao
 * tBCourseDao.java
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04 
 * 2018雷-版权所有
 */

package com.mic.dao;

import com.mic.bean.tBCourseBean;
/**
 * 
 * tBCourseDao
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04 
 * @version 1.0.0
 * 
 */

public interface tBCourseDao {
	
	/**
	 *
	 * 写入课程
	 * 方法名：addCourseName
	 * 创建人：lei
	 * 时间：2018年9月26日-下午21:39:04
	 * 手机:15873169121
	 * @param CourseName
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	public Integer addCourse(tBCourseBean tbcourse);
	
}
