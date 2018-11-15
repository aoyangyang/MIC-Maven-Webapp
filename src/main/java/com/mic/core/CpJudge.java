/**
 * chenPeng
 * com.mic.core
 * InformationJudgment.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午4:14:56 
 * 2018陈鹏-版权所有
 */
package com.mic.core;

import java.util.regex.Pattern;

/**
 * 信息判断
 * InformationJudgment
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午4:14:56 
 * @version 1.0.0
 * 
 */
public class CpJudge {
	/**
	 * 判断邮箱
	 * 方法名：isEmail
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午4:52:17 
	 * 手机:17673111810
	 * @param str
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean isEmail(String str){
		String email = ".*@.*\\.com";
		return Pattern.matches(email, str);
	}
	
	/**
	 * 判断为电话号码
	 * 方法名：isPhone
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午4:59:34 
	 * 手机:17673111810
	 * @param str
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean isPhone(String str){
		String phone = "[0-9]{11}";
		return Pattern.matches(phone, str);
	}
	
	/**
	 * 密码验证低强密码
	 * 方法名：passwordOkMini
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午5:12:11 
	 * 手机:17673111810
	 * @param str1
	 * @param str2
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean passwordOkMini(String str1,String str2){
		String password = "^.*(?=.{6,})(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*? ]).*$";
		if(!str1.equals(str2)){
			return false;
		}
		return Pattern.matches(password, str2);
	}
	public boolean passwordOkMini(String str){
		String password = "^.*(?=.{6,})(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*? ]).*$";
		return Pattern.matches(password, str);
	}
	/**
	 * 密码验证高强度
	 * 方法名：passwordOkBig
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午5:12:40 
	 * 手机:17673111810
	 * @param str1
	 * @param str2
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean passwordOkBig(String str1,String str2){
		String password = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$";
		if(!str1.equals(str2)){
			return false;
		}
		return Pattern.matches(password, str2);
	}
	public boolean passwordOkBig(String str){
		String password = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$";
		return Pattern.matches(password, str);
	}
	
	
}
