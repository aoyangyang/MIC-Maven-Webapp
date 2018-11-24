package com.mic.service.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.classs.AdClass;
import com.mic.bean.classs.AddClass;
import com.mic.bean.departments.FindDepartments;
import com.mic.bean.departments.Leader;
import com.mic.bean.school.FindSchool;
import com.mic.dao.register.InstructorAddDao;

/**
 * 
 * 
 * InstructorAddDo
 * 创建人:Shanice
 * 时间：2018年10月18日-下午5:57:38 
 * @version 1.0.0
 *
 */
@Service
public class InstructorAddDo {
	@Autowired
	private InstructorAddDao instructorAddDao;
	
	/**
	 * 
	 * 管理员注册
	 * 方法名：insAdd
	 * 创建人：chenPeng
	 * 时间：2018年11月16日-下午10:58:33 
	 * 手机:17673111810
	 * @param leader void
	 * @exception 
	 * @since  1.0.0
	 */
	public void insAdd(Leader leader){
		instructorAddDao.insAddLeader(leader);
		instructorAddDao.insAddAdClass(leader.getId());
	}
	
	
	/**
	 * 初始化添加页面的全部学校
	 * 方法名：initInstructorAdd
	 * 创建人：Shanice
	 * 时间：2018年10月18日-下午2:09:51 
	 * 手机:15873158820
	 * @return List<FindSchool>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<FindSchool> initInstructorAdd(){
		return instructorAddDao.findAllSchool();
	}
	
	
	/**
	 *
	 * 初始化添加页面的全部学院、学部
	 * 方法名：findDepartments
	 * 创建人：Shanice
	 * 时间：2018年10月18日-下午5:34:24 
	 * 手机:15873158820
	 * @param id
	 * @return List<FindDepartments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<FindDepartments> findDepartments(Integer id){
		return instructorAddDao.findDepartments(id);
	}

	/**
	 * 
	 * 在班级表中添加一个班级
w	 * 方法名：instructorAddClass
	 * 创建人：Shanice
	 * 时间：2018年10月18日-下午11:05:32 
	 * 手机:15873158820
	 * @param addCLass
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer instructorAddClass(AddClass addCLass) {
		// TODO Auto-generated method stub
		instructorAddDao.addClasss(addCLass);
		return addCLass.getId();
	}
	
	
	/**
	 *
	 * 将班级信息和辅导员信息对应上
	 * 方法名：adClass
	 * 创建人：Shanice
	 * 时间：2018年10月26日-上午9:02:54 
	 * 手机:15873158820
	 * @param classId
	 * @param adClassId void
	 * @exception 
	 * @since  1.0.0
	 */
	public void adClass(Integer classId, Integer adClassId){
		AdClass adClass = new AdClass();
		adClass.setLeaderId(adClassId);
		adClass.setClassId(classId);
		instructorAddDao.adClasss(adClass);
	}

}
