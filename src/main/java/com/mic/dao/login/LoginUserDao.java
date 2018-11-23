package com.mic.dao.login;

import com.mic.bean.other.LoginUser;
import com.mic.bean.other.NameAndId;
/**
 * 
 * 
 * LoginUserDao
 * 创建人:Shanice
 * 时间：2018年8月16日-下午5:34:04 
 * @version 1.0.0
 *
 */
public interface LoginUserDao {
	/**
	 * 学生登录
	 * 方法名：studentLogin
	 * 创建人：Shanice
	 * 时间：2018年8月16日-下午5:26:50 
	 * 手机:15873158820
	 * @param loginUser
	 * @return NameAndId
	 * @exception 
	 * @since  1.0.0
	 */
	public NameAndId studentLogin(LoginUser loginUser);

	/**
	 * 
	 * 老师登录
	 * 方法名：teacherLogin
	 * 创建人：Shanice
	 * 时间：2018年8月16日-下午5:28:02 
	 * 手机:15873158820
	 * @param loginUser
	 * @return NameAndId
	 * @exception 
	 * @since  1.0.0
	 */
	public NameAndId teacherLogin(LoginUser loginUser);

	/**
	 * 
	 * 管理者登录
	 * 方法名：departmentLogin
	 * 创建人：Shanice
	 * 时间：2018年8月16日-下午5:29:11 
	 * 手机:15873158820
	 * @param loginUser
	 * @return NameAndId
	 * @exception 
	 * @since  1.0.0
	 */
	public NameAndId leaderLogin(LoginUser loginUser);
	
	/**
	 * 
	 * 辅导员登录
	 * 方法名：adClass
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午7:13:30 
	 * 手机:15873158820
	 * @param integer
	 * @return NameAndId
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer adClassLogin(Integer no);
	
	/**
	 * 
	 * 院领导登录
	 * 方法名：adDepartment
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午7:15:11 
	 * 手机:15873158820
	 * @param integer
	 * @return NameAndId
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer adDepartmentLogin(Integer no);
	
	/**
	 * 
	 * 学工组登录
	 * 方法名：adSchoolLogin
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午7:17:51 
	 * 手机:15873158820
	 * @param integer
	 * @return NameAndId
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer adSchoolLogin(Integer no);
}
