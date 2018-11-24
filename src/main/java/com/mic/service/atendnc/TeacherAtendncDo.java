/**
 * chenPeng
 * com.mic.service.atendnc
 * TeacherAtendncDo.java
 * 创建人:chenpeng
 * 时间：2018年11月20日-下午7:16:55 
 * 2018陈鹏-版权所有
 */
package com.mic.service.atendnc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.course.CourseNote;
import com.mic.bean.departments.Information;
import com.mic.bean.departments.PancakeDate;
import com.mic.bean.student.StudentArrive;
import com.mic.dao.atendnc.TeacherAtendncDao;


/**
 * 老师点到
 * TeacherAtendncDo
 * 创建人:chenPeng
 * 时间：2018年11月20日-下午7:16:55 
 * @version 1.0.0
 * 
 */
@Service
public class TeacherAtendncDo {
	@Autowired
	private TeacherAtendncDao teacherAtendncDao;
	
	
	
	
	/**
	 * 
	 * 更具noteid 得到 考勤表的id
	 * 方法名：getAtendncId
	 * 创建人：chenPeng
	 * 时间：2018年11月20日-下午7:18:10 
	 * 手机:17673111810
	 * @return integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer getAtendncId(Integer noteId){
		return teacherAtendncDao.getAtendncID(noteId);
	}

	
	/**
	 * 得到全部的考情信息
	 * 方法名：getAMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月20日-下午10:52:06 
	 * 手机:17673111810
	 * @param atendncId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Information> getAMsg(Integer atendncId) {
		// TODO Auto-generated method stub
		return teacherAtendncDao.getAMsg(atendncId);
	}
	
	
	/**
	 * 
	 * 通过给的信息 得到饼图
	 * 方法名：getPancakeDate
	 * 创建人：chenPeng
	 * 时间：2018年11月21日-下午12:45:32 
	 * 手机:17673111810
	 * @param ifomtionList
	 * @return PancakeDate
	 * @exception 
	 * @since  1.0.0
	 */
	public PancakeDate getPancakeDate(
					List<Information> ifomtionList){
		
		PancakeDate date = new PancakeDate();
		//状态
		String staus = "";
		
		//缺勤
		Integer absence = 0;
		//请假
		Integer leave = 0;
		//正常
		Integer attendance = 0;
		
		
		for (Information information : ifomtionList) {
			staus = information.getStatus();
			if (staus.equals("到课")) {
				attendance++;
			}else if (staus.equals("请假")) {
				leave++;
			}else if (staus.equals("缺勤")) {
				absence++;
			}
		}
		
		//放入饼图
		date.setAbsence(absence);
		date.setLeave(leave);
		date.setAttendance(attendance);
		
		return date;
	}
	
	/**
	 * 
	 * 通过信息得到缺勤的信息
	 * 方法名：getAbsenceList
	 * 创建人：chenPeng
	 * 时间：2018年11月21日-下午12:45:55 
	 * 手机:17673111810
	 * @param ifomtionList
	 * @return List<StudentArrive>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<StudentArrive> getAbsenceList(
					List<Information> ifomtionList){
		
		return null;
	}
	
	/**
	 * 
	 * 通过信息得到请假信息
	 * 方法名：getLeaveList
	 * 创建人：chenPeng
	 * 时间：2018年11月21日-下午12:46:23 
	 * 手机:17673111810
	 * @param ifomtionList
	 * @return List<StudentArrive>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<StudentArrive> getLeaveList(
					List<Information> ifomtionList){
		
		return null;
	}



	/**
	 * 通过课堂id 得到全部的学生id
	 * 方法名：getStuIdList
	 * 创建人：chenPeng
	 * 时间：2018年11月23日-下午1:51:03 
	 * 手机:17673111810
	 * @param noteId
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getStuIdList(Integer noteId) {
		// TODO Auto-generated method stub
		
		return teacherAtendncDao.getStuIdList(noteId);
	}


	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getTimeMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月23日-下午2:06:07 
	 * 手机:17673111810
	 * @param noteId
	 * @return CourseNote
	 * @exception 
	 * @since  1.0.0
	*/
	public CourseNote getTimeMsg(Integer noteId) {
		// TODO Auto-generated method stub
		return teacherAtendncDao.getTimeMsg(noteId);
	}
}
