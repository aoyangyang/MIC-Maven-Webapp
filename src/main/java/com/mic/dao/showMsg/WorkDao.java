/**
 * chenPeng
 * com.mic.dao
 * WorkDao.java
 * 创建人:chenpeng
 * 时间：2018年8月16日-下午10:27:30 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.showMsg;

import java.util.List;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.Information;
import com.mic.bean.other.TimeAndId;

/**
 * 学工组
 * WorkDao
 * 创建人:chenPeng
 * 时间：2018年8月16日-下午10:27:30 
 * @version 1.0.0
 * 
 */
public interface WorkDao {
	/**
	 * 得到班级
	 * 方法名：getAllClass
	 * 创建人：chenPeng
	 * 时间：2018年8月18日-下午9:14:50 
	 * 手机:17673111810
	 * @param leaderId
	 * @return List<Classs>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getAllClass(Integer id);
	
	/**
	 * 得到全部的信息
	 * 方法名：getInfmTion
	 * 创建人：chenPeng
	 * 时间：2018年8月18日-下午10:34:07 
	 * 手机:17673111810
	 * @param timeAndId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Information> getInfmTion(TimeAndId timeAndId);
}
