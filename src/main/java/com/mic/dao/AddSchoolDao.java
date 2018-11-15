/**
 * chenPeng
 * com.mic.dao
 * AddSchoolDao.java
 * 创建人:chenpeng
 * 时间：2018年7月31日-下午6:40:41 
 * 2018陈鹏-版权所有
 */
package com.mic.dao;

import com.mic.bean.AddSchool;

/**
 * 
 * AddSchoolDao
 * 创建人:chenPeng
 * 时间：2018年7月31日-下午6:40:41 
 * @version 1.0.0
 * 
 */
public interface AddSchoolDao {
	/**
	 * 
	 * 写入学校名称并得到该条ID
	 * 方法名：AddSchoolName
	 * 创建人：chenPeng
	 * 时间：2018年7月31日-下午7:03:18 
	 * 手机:17673111810
	 * @param schoolName
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public void AddSchoolName(String schoolName);
	
	/**
	 * 得到学校id
	 * 方法名：getSchoolId
	 * 创建人：chenPeng
	 * 时间：2018年7月31日-下午7:42:07 
	 * 手机:17673111810
	 * @param schoolName
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer getSchoolId(String schoolName);
	
	/**
	 * 
	 * 写入学校的学部
	 * 方法名：AddDepartments
	 * 创建人：chenPeng
	 * 时间：2018年7月31日-下午7:10:24 
	 * 手机:17673111810
	 * @param addschool
	 * @return void
	 * @exception 
	 * @since  1.0.0
	 */
	public void AddDepartments(AddSchool addschool);
	
	
}
