/**
 * chenPeng
 * com.mic.dao
 * DepLeadertestDao.java
 * 创建人:chenpeng
 * 时间：2018年8月8日-下午2:34:30 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.showMsg;

import java.util.List;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.Departments;
import com.mic.bean.departments.Information;
import com.mic.bean.other.TimeAndId;

/**
 * 院领导
 * DepLeadertestDao
 * 创建人:chenPeng
 * 时间：2018年8月8日-下午2:34:30 
 * @version 1.0.0
 * 
 */
public interface DepLeadertestDao {
	/**
	 * 通过id得到全部的学校
	 * 方法名：getAllDepart
	 * 创建人：chenPeng
	 * 时间：2018年8月9日-下午9:20:50 
	 * 手机:17673111810
	 * @return List<Departments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Departments> getAllDepart(Integer leader_id);
	
	/**
	 * 传入时间与id得到考情信息
	 * 方法名：getAllInfMation
	 * 创建人：chenPeng
	 * 时间：2018年8月9日-下午9:45:21 
	 * 手机:17673111810
	 * @param timeAndId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Information> getAllInfMation(TimeAndId timeAndId);
	
	/**
	 * 根据班级来得到信息
	 * 方法名：getAllClass
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午1:41:04 
	 * 手机:17673111810
	 * @param no
	 * @return List<Departments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getAllClass(Integer no);
	
	/**
	 * 更具时间和id得到考勤信息
	 * 方法名：getClassInfMation
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午1:45:24 
	 * 手机:17673111810
	 * @param timeAndId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Information> getClassInfMation(TimeAndId timeAndId);
}
 