/**
 * chenPeng
 * com.mic.dao
 * LeaderDepAddDao.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午5:33:19 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.register;

import java.util.List;

import com.mic.bean.departments.Leader;
import com.mic.bean.school.AdSchool;
import com.mic.bean.school.School;

/**
 * 
 * LeaderDepAddDao
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午5:33:19 
 * @version 1.0.0
 * 
 */
public interface LeaderDepAddDao {
	/**
	 * 得到all的学校
	 * 方法名：getSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午5:20:32 
	 * 手机:17673111810 void
	 * @exception 
	 * @since  1.0.0
	 */
	public List<School> getSchool();
	
	/**
	 * 写入leader
	 * 方法名：setLeader
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午7:52:22 
	 * 手机:17673111810
	 * @param leader void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setLeader(Leader leader);
	
	/**
	 * 写入AdSchool
	 * 方法名：setAdSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午8:01:57 
	 * 手机:17673111810
	 * @param adSchool void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setAdSchool(AdSchool adSchool);
}
