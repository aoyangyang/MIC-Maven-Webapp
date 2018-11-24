/**
 * chenPeng
 * com.mic.dao.atendnc
 * TeacherAtendncDao.java
 * 创建人:chenpeng
 * 时间：2018年11月20日-下午6:27:49 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.atendnc;

import java.util.List;

import com.mic.bean.departments.Information;

/**
 * 
 * TeacherAtendncDao
 * 创建人:chenPeng
 * 时间：2018年11月20日-下午6:27:49 
 * @version 1.0.0
 * 
 */
public interface TeacherAtendncDao{
	/**
	 * 
	 * 查询到考勤信息 得到考勤表id
	 * 方法名：getAtendnc
	 * 创建人：chenPeng
	 * 时间：2018年11月20日-下午6:31:38 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer getAtendncID(Integer noteId);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getAMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月20日-下午10:52:40 
	 * 手机:17673111810
	 * @param atendncId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Information> getAMsg(Integer atendncId);
}
