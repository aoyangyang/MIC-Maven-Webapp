/**
 * chenPeng
 * com.mic.web.login
 * LoginClean.java
 * 创建人:chenpeng
 * 时间：2018年11月17日-下午2:56:29 
 * 2018陈鹏-版权所有
 */
package com.mic.core;

import javax.servlet.http.HttpServletRequest;

/**
 * 清除登陆状态
 * LoginClean
 * 创建人:chenPeng
 * 时间：2018年11月17日-下午2:56:29 
 * @version 1.0.0
 * 
 */
public class LoginClean {
	
	/**
	 * 
	 * 清空全部的登陆信息
	 * 方法名：clearAll
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午3:05:30 
	 * 手机:17673111810
	 * @param re void
	 * @exception 
	 * @since  1.0.0
	 */
	public void clearAll(HttpServletRequest re){
		re.getSession().setAttribute("studentId", null);
		re.getSession().setAttribute("studentName", null);
		re.getSession().setAttribute("teacherId", null);
		re.getSession().setAttribute("teacherName", null);
		re.getSession().setAttribute("adClassId", null);
		re.getSession().setAttribute("adClassName", null);
		re.getSession().setAttribute("adDepartmentId", null);
		re.getSession().setAttribute("adDepartmentName", null);
		re.getSession().setAttribute("adSchoolId", null);
		re.getSession().setAttribute("adSchoolName", null);
		
	}
}
