/**
 * chenPeng
 * com.mic.dao
 * InstructorDao.java
 * 创建人:chenpeng
 * 时间：2018年8月12日-下午8:48:21 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.showMsg;

import java.util.List;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.Information;
import com.mic.bean.other.TimeAndId;
import com.mic.bean.student.StudentArrive;

/**
 * 辅导员
 * InstructorDao
 * 创建人:chenPeng
 * 时间：2018年8月12日-下午8:48:21 
 * @version 1.0.0
 * 
 */
public interface InstructorDao {
	/**
	 * 得到该辅导员的全部班级
	 * 方法名：getClasss
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午8:56:27 
	 * 手机:17673111810
	 * @param adClassId
	 * @return List<Classs>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getClasss(Integer adClassId);
	
	/**
	 * 得到全部的消息
	 * 方法名：getAllInfMation
	 * 创建人：chenPeng
	 * 时间：2018年8月15日-下午11:23:18 
	 * 手机:17673111810
	 * @param timeAndId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Information> getAllInfMation(TimeAndId timeAndId);
	
	/**
	 * 通过id得到学校名称
	 * 方法名：className
	 * 创建人：chenPeng
	 * 时间：2018年8月16日-下午12:05:28 
	 * 手机:17673111810
	 * @param id
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getClassName(Integer id);
	
	/**
	 * 得到缺勤学生信息
	 * 方法名：getAbsence
	 * 创建人：chenPeng
	 * 时间：2018年8月16日-下午12:22:17 
	 * 手机:17673111810
	 * @param id
	 * @return Student
	 * @exception 
	 * @since  1.0.0
	 */
	public StudentArrive getAbsence(Integer id);
}
