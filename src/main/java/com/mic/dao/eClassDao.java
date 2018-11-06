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
}
