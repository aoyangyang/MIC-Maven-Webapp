/**
 * chenPeng
 * com.mic.dao
 * LeaderWorkAddDao.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午10:09:43 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.register;

import java.util.List;

import com.mic.bean.departments.AdDepartments;
import com.mic.bean.departments.Departments;
import com.mic.bean.departments.Leader;
import com.mic.bean.school.School;

/**
 * 
 * LeaderWorkAddDao
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午10:09:43 
 * @version 1.0.0
 * 
 */
public interface LeaderWorkAddDao {
	/**
	 * 得到all的学校
	 * 方法名：getSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午10:12:03 
	 * 手机:17673111810
	 * @return List<School>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<School> getSchool();
	
	/**
	 * 得到指定的学部/学院
	 * 方法名：getDepartments
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-上午10:59:49 
	 * 手机:17673111810
	 * @param schoolNo
	 * @return List<Departments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Departments> getDepartments(Integer schoolNo);
	
	/**
	 * 写入leader
	 * 方法名：setLeader
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午6:22:24 
	 * 手机:17673111810
	 * @param leader void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setLeader(Leader leader);
	
	
	/**
	 * 写入Departments
	 * 方法名：setAdDepartments
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午6:35:33 
	 * 手机:17673111810
	 * @param departments void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setAdDepartments(AdDepartments departments);
	
}
