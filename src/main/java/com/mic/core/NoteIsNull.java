/**
 * chenPeng
 * com.mic.core
 * NoteIsNull.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-上午12:59:25 
 * 2018陈鹏-版权所有
 */
package com.mic.core;

/**
 * 
 * NoteIsNull
 * 创建人:chenPeng
 * 时间：2018年8月4日-上午12:59:25 
 * @version 1.0.0
 * 
 */
public class NoteIsNull {
	/**
	 * 判断空
	 * 方法名：noteIsNull
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-上午1:15:54 
	 * 手机:17673111810
	 * @param obj
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean noteIsNull(Object obj) {
		if (obj==null || obj.equals("")) {
			return false;
		}
		return true;
	}
}
