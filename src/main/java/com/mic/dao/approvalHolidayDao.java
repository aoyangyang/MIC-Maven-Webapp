/**
 * lei
 * com.mic.dao
 * approvalHolidayDao.java
 * 创建人:lei
 * 时间：2018年11月03日-上午11:48:04
 * 2018lei-版权所有
 */
package com.mic.dao;

import java.util.List;

/**
 * 
 * approvalHolidayDao
 * 创建人:lei
 * 时间：2018年11月03日-上午11:48:04
 * @version 1.0.0
 * 
 */

public interface approvalHolidayDao {
	/**
	 *
	 * 得到学生姓名
	 * 方法名：Getstudentname
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:02:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getstudentname(Integer id);
     /**
	 *
	 * 得到学生ID
	 * 方法名：Getstudentname
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:03:04
	 * 手机:15873169121
	 * @param id
	 * @return Integer
	 * @exception
	 * @since  1.0.0
	 */
     public Integer GetstudentId(Integer id);
     /**
	 *
	 * 得到学生班级名
	 * 方法名：Getclassname
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:04:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getclassname(Integer id);
     /**
	 *
	 * 得到学生学院名
	 * 方法名：Getschoolname
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:37:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getschoolname(Integer id);
     /**
	 *
	 * 得到学生手机号码
	 * 方法名：Getphone
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:04:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getphone(Integer id);
     /**
	 *
	 * 得到学生请假开始时间
	 * 方法名：Getbtime
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:05:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getbtime(Integer id);
     /**
	 *
	 * 得到学生请假结束时间
	 * 方法名：Getetime
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:06:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getetime(Integer id);
     /**
	 *
	 * 得到学生请假原因
	 * 方法名：Getreason
	 * 创建人：lei
	 * 时间：2018年11月03日-下午12:07:04
	 * 手机:15873169121
	 * @param id
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
     public String Getreason(Integer id);
     
     /**
	 *
	 * 修改假条状态（同意）
	 * 方法名：modify1
	 * 创建人：lei
	 * 时间：2018年11月5日-下午17:55:04
	 * 手机:15873169121
	 * @param id
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
     public void modify1(Integer id);
     
     /**
	 *
	 * 修改假条状态（不同意）
	 * 方法名：modify2
	 * 创建人：lei
	 * 时间：2018年11月5日-下午17:55:04
	 * 手机:15873169121
	 * @param id
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
     public void modify2(Integer id);
     
     /**
	 *
	 * 得到学生所修课程id
	 * 方法名：GetcoursesId
	 * 创建人：lei
	 * 时间：2018年11月5日-下午19:20:04
	 * 手机:15873169121
	 * @param studentid
	 * @return List<Integer>
	 * @exception
	 * @since  1.0.0
	 */
     public List<Integer> GetcoursesId(Integer studentid);
     
     /**
   	 *
   	 * 得到学生课程的开课时间
   	 * 方法名：Getcbtime
   	 * 创建人：lei
   	 * 时间：2018年11月5日-下午19:36:04
   	 * 手机:15873169121
   	 * @param studentid
   	 * @return List<String>
   	 * @exception
   	 * @since  1.0.0
   	 */
       public List<String> Getcbtime(Integer cid);
       
       /**
     	 *
     	 * 得到学生缺课课程名
     	 * 方法名：Getcoursename
     	 * 创建人：lei
     	 * 时间：2018年11月6日-下午14:19:04
     	 * 手机:15873169121
     	 * @param courseid
     	 * @return String
     	 * @exception
     	 * @since  1.0.0
     	 */
         public String Getcoursename(Integer courseid);
       
}
