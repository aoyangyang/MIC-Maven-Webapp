/**
 * lei
 * com.mic.dao
 * Select1Dao.java
 * 创建人:lei
 * 时间：2018年9月28日-下午11:42:04 
 * 2018雷-版权所有
 */

package com.mic.dao.lei;

/**
 * 
 * Select1Dao
 * 创建人:lei
 * 时间：2018年9月28日-下午11:42:04
 * @version 1.0.0
 * 
 */
public interface Select1Dao {
	/**
	 *
	 * 得到学生ID
	 * 方法名：getStudentId
	 * 创建人：lei
	 * 时间：2018年9月28日-下午11:42:04 
	 * 手机:15873169121
	 * @param sname
	 * @return Integer
	 * @exception
	 * @since  1.0.0
	 */
     public Integer getStudentId(String sname);
	
     /**
	 *
	 * 得到课程名
	 * 方法名：getCouresname
	 * 创建人：lei
	 * 时间：2018年9月28日-下午11:46:04 
	 * 手机:15873169121
	 * @param cid
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
	 public String getCouresname(Integer cid);
	 
	 /**
	 *
	 * 得到教师名
	 * 方法名：getTeachername
	 * 创建人：lei
	 * 时间：2018年9月28日-下午11:48:04 
	 * 手机:15873169121
	 * @param cid
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
	 public String getTeachername(Integer cid);
}
