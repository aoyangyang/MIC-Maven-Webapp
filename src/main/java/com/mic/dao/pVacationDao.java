/**
 * lei
 * com.mic.dao
 * pVacationDao.java
 * 创建人:lei
 * 时间：2018年9月29日-下午17:11:04 
 * 2018雷-版权所有
 */
package com.mic.dao;

import com.mic.bean.pVacationBean;
/**
 * 
 * pVacationDao
 * 创建人:lei
 * 时间：2018年9月29日-下午17:11:04 
 * @version 1.0.0
 * 
 */

public interface pVacationDao {
	/**
	 *
	 * 添加每节课的信息
	 * 方法名：addpVacation
	 * 创建人：lei
	 * 时间：2018年9月29日-下午17:11:04 
	 * 手机:15873169121
	 * @param eclassbean
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	public void addPVacation(pVacationBean pvacationbean);
}
