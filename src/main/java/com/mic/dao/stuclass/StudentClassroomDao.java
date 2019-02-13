/**
 * chenPeng
 * com.mic.dao.stuclass
 * StudentClassroomDao.java
 * 创建人:chenpeng
 * 时间：2019年2月12日-下午3:23:53 
 * 2019陈鹏-版权所有
 */
package com.mic.dao.stuclass;

import java.util.List;
import java.util.Map;

import com.mic.bean.course.CourseNote;
import com.mic.bean.course.StuCourse;
import com.mic.bean.db.Problems;

/**
 * 
 * StudentClassroomDao
 * 创建人:chenPeng
 * 时间：2019年2月12日-下午3:23:53 
 * @version 1.0.0
 * 
 */
public interface StudentClassroomDao {

	/**
	 * 得到学生选的课程
	 * 方法名：getCourse
	 * 创建人：chenPeng
	 * 时间：2019年2月12日-下午9:47:51 
	 * 手机:17673111810
	 * @param studentId
	 * @return List<Course>
	 * @exception 
	 * @since  1.0.0
	*/
	List<StuCourse> getCourse(Integer studentId);

	/**
	 * 点入某个课程查看课堂
	 * 方法名：getCouNoteList
	 * 创建人：chenPeng
	 * 时间：2019年2月12日-下午10:32:25 
	 * 手机:17673111810
	 * @param no
	 * @return List<CourseNote>
	 * @exception 
	 * @since  1.0.0
	*/
	List<CourseNote> getCouNoteList(Integer no);

	/**
	 * 学生得到全部的问题
	 * 方法名：getProblemsList
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午3:12:21 
	 * 手机:17673111810
	 * @param no
	 * @return List<Problems>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Problems> getProblemsList(Integer no);

	/**
	 * 学生回答问题
	 * 方法名：stuAnswer
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午5:14:57 
	 * 手机:17673111810
	 * @param map void
	 * @exception 
	 * @since  1.0.0
	*/
	void stuAnswer(Map<String, String> map);

	/**
	 * 查询学生回答了那些问题
	 * 方法名：getStuAnsProb
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午5:34:52 
	 * 手机:17673111810
	 * @param stuId
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Integer> getStuAnsProb(Integer stuId);

}
