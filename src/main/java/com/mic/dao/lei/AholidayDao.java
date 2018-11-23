/**
 * lei
 * com.mic.dao
 * AholidayDao.java
 * 创建人:lei
 * 时间：2018年11月3日-下午1:14:04 
 * 2018雷-版权所有
 */
package com.mic.dao.lei;

import java.util.List;

/**
 * 
 * AholidayDao
 * 创建人:lei
 * 时间：2018年11月3日-下午1:14:04
 * @version 1.0.0
 * 
 */
public interface AholidayDao {
    
	/**
	 *
	 * 得到该辅导员的所有学生ID
	 * 方法名：GetStudentIds
	 * 创建人：lei
	 * 时间：2018年11月3日-下午2:39:04
	 * 手机:15873169121
	 * @param username
	 * @return List<Integer>
	 * @exception
	 * @since  1.0.0
	 */
	public List<Integer> GetStudentIds(Integer caClassId);
	
	/**
	 *
	 * 得到符合条件的请假条ID
	 * 方法名：GetStudentIds
	 * 创建人：lei
	 * 时间：2018年11月3日-下午2:39:04
	 * 手机:15873169121
	 * @param studentid
	 * @return List<Integer>
	 * @exception
	 * @since  1.0.0
	 */
	public List<Integer> GetleaveId(Integer student_id);
	
	/**
	 *
	 * 得到学生姓名
	 * 方法名：GetStudentName
	 * 创建人：lei
	 * 时间：2018年11月3日-下午2:56:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
	public String GetStudentName(Integer id);
	
	/**
	 *
	 * 得到学生班级名
	 * 方法名：GetStudentclass
	 * 创建人：lei
	 * 时间：2018年11月3日-下午2:58:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
	public String GetStudentclassname(Integer id);
}
