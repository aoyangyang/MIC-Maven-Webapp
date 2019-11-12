/**
 * chenPeng
 * com.mic.dao.admin
 * AdminLoginDao.java
 * 创建人:chenpeng
 * 时间：2018年12月29日-上午1:59:40 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.admin;

import java.util.List;

import com.mic.bean.Admin;
import com.mic.bean.Leader;
import com.mic.bean.Teacher;
import com.mic.bean.school.School;
import com.mic.bean.student.Student;

/**
 * 
 * AdminLoginDao
 * 创建人:chenPeng
 * 时间：2018年12月29日-上午1:59:40 
 * @version 1.0.0
 * 
 */
public interface AdminLoginDao {

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：adminLogin
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午2:21:14 
	 * 手机:17673111810
	 * @param admin
	 * @return Admin
	 * @exception 
	 * @since  1.0.0
	*/
	Admin adminLogin(Admin admin);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLeaderList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:12:32 
	 * 手机:17673111810
	 * @param page
	 * @return List<Leader>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Leader> getLeaderList(Integer page);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getStuList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:12:37 
	 * 手机:17673111810
	 * @param page
	 * @return List<Student>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Student> getStuList(Integer page);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getTeaList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:12:41 
	 * 手机:17673111810
	 * @param page
	 * @return List<Teacher>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Teacher> getTeaList(Integer page);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getSchList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:16:41 
	 * 手机:17673111810
	 * @param page
	 * @return List<School>
	 * @exception 
	 * @since  1.0.0
	*/
	List<School> getSchList(Integer page);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLeaderPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:25:09 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getLeaderPage();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getStuPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:25:14 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getStuPage();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getTeaPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:25:18 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getTeaPage();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getSchPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:25:22 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getSchPage();

}
