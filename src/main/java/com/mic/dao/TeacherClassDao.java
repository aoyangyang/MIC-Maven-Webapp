/**
 * chenPeng
 * com.mic.dao
 * TeachaerClassDao.java
 * 创建人:chenpeng
 * 时间：2018年11月17日-下午8:37:35 
 * 2018陈鹏-版权所有
 */
package com.mic.dao;

import java.util.List;

import com.mic.bean.Course;
import com.mic.bean.CourseNote;
import com.mic.bean.IdAndNo;

/**
 * 老师查看课程信息
 * TeachaerClassDao
 * 创建人:chenPeng
 * 时间：2018年11月17日-下午8:37:35 
 * @version 1.0.0
 * 
 */
public interface TeacherClassDao {
	/**
	 * 查询出该老师的全部课程
	 * 方法名：fondClassList
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午8:49:26 
	 * 手机:17673111810
	 * @param idAndNo
	 * @return List<Course>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Course> fondClassList(IdAndNo idAndNo);
	
	
	/**
	 * 查询出数据的量
	 * 方法名：getLength
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午9:14:06 
	 * 手机:17673111810
	 * @param teaId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer getLength(Integer teaId);


	/**
	 * 拿到课程信息
	 * 方法名：getCourMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-上午11:17:38 
	 * 手机:17673111810
	 * @param idAndNo
	 * @return Course
	 * @exception 
	 * @since  1.0.0
	*/
	public Course getCourMsg(IdAndNo idAndNo);
	
	/**
	 * 
	 * 判断是不是这个老师的课程
	 * 方法名：testTeacher
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-下午3:22:34 
	 * 手机:17673111810
	 * @param idAndNo
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer testTeacher(IdAndNo idAndNo);
	
	/**
	 * 
	 * 得到指定页码的课程信息
	 * 方法名：getClsList
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-下午3:34:51 
	 * 手机:17673111810
	 * @param idAndNo
	 * @return List<CourseNote>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<CourseNote> getClsList(IdAndNo idAndNo);
}
