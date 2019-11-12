/**
 * chenPeng
 * com.mic.service.admin
 * AdminLoginDo.java
 * 创建人:chenpeng
 * 时间：2018年12月29日-上午1:59:08 
 * 2018陈鹏-版权所有
 */
package com.mic.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.Admin;
import com.mic.bean.Leader;
import com.mic.bean.Teacher;
import com.mic.bean.school.School;
import com.mic.bean.student.Student;
import com.mic.dao.admin.AdminLoginDao;

/**
 * 
 * AdminLoginDo
 * 创建人:chenPeng
 * 时间：2018年12月29日-上午1:59:08 
 * @version 1.0.0
 * 
 */
@Service
public class AdminLoginDo {
	@Autowired
	private AdminLoginDao adminLoginDao;

	/**
	 * 登陸
	 * 方法名：adminLogin
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午2:16:02 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	*/
	public Admin adminLogin(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		return adminLoginDao.adminLogin(admin);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLeaderList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:08:38 
	 * 手机:17673111810
	 * @param i
	 * @return List<Leader>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Leader> getLeaderList(Integer page) {
		// TODO Auto-generated method stub
		page = (page-1)*10;
		return adminLoginDao.getLeaderList(page);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getStuList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:08:47 
	 * 手机:17673111810
	 * @param i
	 * @return List<Student>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Student> getStuList(Integer page) {
		// TODO Auto-generated method stub
		page = (page-1)*10;
		return adminLoginDao.getStuList(page);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getTeaList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:08:52 
	 * 手机:17673111810
	 * @param i
	 * @return List<Teacher>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Teacher> getTeaList(Integer page) {
		// TODO Auto-generated method stub
		page = (page-1)*10;
		return adminLoginDao.getTeaList(page);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getSchList
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:16:21 
	 * 手机:17673111810
	 * @param i
	 * @return List<School>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<School> getSchList(Integer page) {
		// TODO Auto-generated method stub
		page = (page-1)*10; 
		return adminLoginDao.getSchList(page);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLeaderPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:24:24 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getLeaderPage() {
		// TODO Auto-generated method stub
		return adminLoginDao.getLeaderPage();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getStuPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:24:28 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getStuPage() {
		// TODO Auto-generated method stub
		return adminLoginDao.getStuPage();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getTeaPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:24:32 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getTeaPage() {
		// TODO Auto-generated method stub
		return adminLoginDao.getTeaPage();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getSchPage
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午3:24:35 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getSchPage() {
		// TODO Auto-generated method stub
		return adminLoginDao.getSchPage();
	}
	
}
