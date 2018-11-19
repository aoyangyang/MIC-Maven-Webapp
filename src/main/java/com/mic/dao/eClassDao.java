/**
 * lei
 * com.mic.dao
 * eClassDao.java
 * 创建人:lei
 * 时间：2018年9月28日-下午19:45:04 
 * 2018雷-版权所有
 */

package com.mic.dao;

import com.mic.bean.eClassBean;
/**
 * 
 * eClassDao
 * 创建人:lei
 * 时间：2018年9月28日-下午19:45:04
 * @version 1.0.0
 * 
 */

public interface eClassDao {
	/**
	 *
	 * 添加每节课的信息
	 * 方法名：addCourseNote
	 * 创建人：lei
	 * 时间：2018年9月28日-下午19:45:04
	 * 手机:15873169121
	 * @param eclassbean
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	public void addCourseNote(eClassBean eclassbean);
	
	
	
	/**
	 * 修改已经建立的课程
	 * 方法名：upCourseNote
	 * 创建人：chenPeng
	 * 时间：2018年11月19日-下午1:29:09 
	 * 手机:17673111810
	 * @param eclassbean void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upCourseNote(eClassBean eclassbean);
}
