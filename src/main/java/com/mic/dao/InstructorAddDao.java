package com.mic.dao;

import java.util.List;

import com.mic.bean.AdClass;
import com.mic.bean.AddClass;
import com.mic.bean.FindDepartments;
import com.mic.bean.FindSchool;

public interface InstructorAddDao {
	/**
	 * 索引出全部学校
	 * 方法名：findAllSchool
	 * 创建人：Shanice
	 * 时间：2018年10月18日-下午2:06:49 
	 * 手机:15873158820
	 * @return List<AddSchool>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<FindSchool> findAllSchool();
	
	/**
	 *
	 * 索引出全部的学院、学部
	 * 方法名：findDepartments
	 * 创建人：Shanice
	 * 时间：2018年10月18日-下午5:28:49 
	 * 手机:15873158820
	 * @return List<FindDepartments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<FindDepartments> findDepartments(Integer id); 
	
	/**
	 * 
	 * 添加班级
	 * 方法名：addClasss
	 * 创建人：Shanice
	 * 时间：2018年10月19日-下午10:26:01 
	 * 手机:15873158820
	 * @param addClass void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addClasss(AddClass addClass);
	
	/**
	 * 
	 * 检索名字
	 * 方法名：addClassDo
	 * 创建人：Shanice
	 * 时间：2018年10月19日-下午10:52:16 
	 * 手机:15873158820
	 * @param classname void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addClassDo(String classname);
	
	/**
	 *
	 * 传入classId，leaderId
	 * 方法名：adClasss
	 * 创建人：Shanice
	 * 时间：2018年10月26日-上午8:58:40 
	 * 手机:15873158820
	 * @param adClass void
	 * @exception 
	 * @since  1.0.0
	 */
	public void adClasss(AdClass adClass);
}
