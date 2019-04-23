/**
 * chenPeng
 * com.mic.dao.wxapp
 * WxLoginDao.java
 * 创建人:chenpeng
 * 时间：2019年4月21日-下午2:31:21 
 * 2019陈鹏-版权所有
 */
package com.mic.dao.wxapp;

import java.util.Map;

import com.mic.bean.student.Student;
import com.mic.bean.wxapp.WxAppQc;
import com.mic.bean.wxapp.WxClass;
import com.mic.bean.wxapp.WxUser;

/**
 * 微信登录
 * WxLoginDao
 * 创建人:chenPeng
 * 时间：2019年4月21日-下午2:31:21 
 * @version 1.0.0
 * 
 */
public interface WxLoginDao {
	/**
	 * 用户登录
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2019年4月22日-下午4:27:36 
	 * 手机:17673111810
	 * @param user
	 * @return Student
	 * @exception 
	 * @since  1.0.0
	 */
	Student login(Map<String, String> user);

	/**
	 * 得到二维码的秘钥
	 * 方法名：getQCpwd
	 * 创建人：chenPeng
	 * 时间：2019年4月22日-下午4:27:10 
	 * 手机:17673111810
	 * @param courseId
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	String getQCpwd(int courseId);

	/**
	 * 二维码签到
	 * 方法名：upInfoStatrt
	 * 创建人：chenPeng
	 * 时间：2019年4月22日-下午8:17:09 
	 * 手机:17673111810
	 * @param wxAppQc
	 * @return int
	 * @exception 
	 * @since  1.0.0
	*/
	int upInfoStatrt(WxAppQc wxAppQc);

	/**
	 * 得到签到的用户信息
	 * 方法名：getWxUser
	 * 创建人：chenPeng
	 * 时间：2019年4月22日-下午9:55:58 
	 * 手机:17673111810
	 * @param username
	 * @return WxUser
	 * @exception 
	 * @since  1.0.0
	*/
	WxUser getWxUser(String username);

	/**
	 * 获取教室信息
	 * 方法名：getWxClass
	 * 创建人：chenPeng
	 * 时间：2019年4月22日-下午10:07:55 
	 * 手机:17673111810
	 * @param parseInt
	 * @return WxClass
	 * @exception 
	 * @since  1.0.0
	*/
	WxClass getWxClass(int parseInt);
}
