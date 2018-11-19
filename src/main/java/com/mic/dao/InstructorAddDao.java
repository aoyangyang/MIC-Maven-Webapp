package com.mic.dao;

import java.util.List;

import com.mic.bean.AdClass;
import com.mic.bean.AddClass;
import com.mic.bean.FindDepartments;
import com.mic.bean.FindSchool;
import com.mic.bean.Leader;

public interface InstructorAddDao {
	
	/**
	 * 辅导员注册写入leader
	 * 方法名：insAddLeader
	 * 创建人：chenPeng
	 * 时间：2018年11月16日-下午10:39:46 
	 * 手机:17673111810
	 * @param leader
	 * @return void
	 * @exception 
	 * @since  1.0.0
	 */
    public void insAddLeader(Leader leader);
	
    
    
    
    
    /**
     * 辅导员注册预先写入 ad_class表
     * 方法名：insAddAdClass
     * 创建人：chenPeng
     * 时间：2018年11月16日-下午10:40:13 
     * 手机:17673111810
     * @param id
     * @return int
     * @exception 
     * @since  1.0.0
     */
	public int insAddAdClass(Integer id);
	
	
	
	
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
