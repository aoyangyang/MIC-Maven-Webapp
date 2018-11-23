/**
 * Shanice
 * com.mic.service;
 * TeacherRegisterDo.java
 * 创建人:Shanice
 * 时间：2018年8月6日-下午8:56:08
 * 2018李向阳-版权所有
 */
package com.mic.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.teacher.TeacherRegister;
import com.mic.dao.register.TeacherRegisterDao;

/**
 * 
 * 
 * TeacherRegisterDo
 * 创建人:Shanice
 * 时间：2018年8月6日-下午8:56:08 
 * @version 1.0.0
 *
 */
@Service
public class TeacherRegisterDo {
	@Autowired
	private TeacherRegisterDao teacherRegisterDao;
	/**
	 * 
	 * 调用写入数据
	 * 方法名：TeacherRegisterDao
	 * 创建人：Shanice
	 * 时间：2018年8月7日-下午10:22:02 
	 * 手机:15873158820
	 * @param register void
	 * @exception 
	 * @since  1.0.0
	 */
	public void TeacherRegisterDao(TeacherRegister register){
		teacherRegisterDao.TeacherRegister(register);
	}
	
}
