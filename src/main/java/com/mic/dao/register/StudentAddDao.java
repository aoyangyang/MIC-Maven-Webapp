/**
 * chenPeng
 * com.mic.dao
 * StudentAddDao.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-下午10:16:15 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.register;

import java.util.List;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.EvAndDepartments;
import com.mic.bean.school.School;
import com.mic.bean.student.Student;

/**
 * 
 * StudentAddDao
 * 创建人:chenPeng
 * 时间：2018年8月5日-下午10:16:15 
 * @version 1.0.0
 * 
 */
public interface StudentAddDao {
	/**
	 * 得到全部的学校
	 * 方法名：getSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午10:26:37 
	 * 手机:17673111810
	 * @return List<School>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<School> getSchool();
	
	/**
	 * 得到班级
	 * 方法名：getClasss
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午11:17:44 
	 * 手机:17673111810
	 * @return List<Classs>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getClasss(EvAndDepartments evAndDepartments);
	
	
	/**
	 * 写入学生
	 * 方法名：studentAdd
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午5:53:38 
	 * 手机:17673111810
	 * @param studen void
	 * @exception 
	 * @since  1.0.0
	 */
	public void studentAdd(Student studen);
}
