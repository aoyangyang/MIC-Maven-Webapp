/**
 * chenPeng
 * com.mic.service.atendnc
 * TeacherAtendncDo.java
 * 创建人:chenpeng
 * 时间：2018年11月20日-下午7:16:55 
 * 2018陈鹏-版权所有
 */
package com.mic.service.atendnc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.atendnc.Attendance;
import com.mic.bean.atendnc.Leave;
import com.mic.bean.course.CourseNote;
import com.mic.bean.departments.Information;
import com.mic.bean.departments.PancakeDate;
import com.mic.bean.student.StudentArrive;
import com.mic.core.CpDate;
import com.mic.core.NoToClass;
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
		//状态
		String staus = "";
		//学生列表
		List<StudentArrive> absenceList = new ArrayList<StudentArrive>();
		StudentArrive stuA;
		
		for (Information information : ifomtionList) {
			staus = information.getStatus();
			if (staus.equals("缺勤")) {
				stuA = teacherAtendncDao.getStuArrive(information.getStudent_id());
				absenceList.add(stuA);
			}
		}
		return absenceList;
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
		
		//状态
		String staus = "";
		//学生列表
		List<StudentArrive> leaveList = new ArrayList<StudentArrive>();
		StudentArrive stuA;
		
		for (Information information : ifomtionList) {
			staus = information.getStatus();
			if (staus.equals("请假")) {
				stuA = teacherAtendncDao.getStuArrive(information.getStudent_id());
				leaveList.add(stuA);
			}
		}
		return leaveList;
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
	 * 去到某堂课的上课时间信息
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
	
	/**
	 * 
	 * 插入考勤并得到id
	 * 方法名：addAtendnc
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-上午2:41:52 
	 * 手机:17673111810
	 * @param atd
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer addAtendnc(Attendance atd){
		teacherAtendncDao.addAtendnc(atd);
		return atd.getId();
	}
	
	/**
	 * 输入时间2018-11-26/1得到时钟时间
	 * 方法名：getClockTimeDo
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-上午4:39:13 
	 * 手机:17673111810
	 * @param time
	 * @return long
	 * @exception 
	 * @since  1.0.0
	 */
	public long getClockTimeDo(String time){
		NoToClass noToClass = new NoToClass();
		CpDate cpDate = new CpDate();
		
		Integer no = noToClass.getNo(time);
		String hour = noToClass.noToTime(no);
		String date = noToClass.getTime(time);
		String stime = date+" "+hour;
		long lTime = cpDate.getClockTime("yyyy-MM-dd HH:mm:ss", stime);
		return lTime;
	}

	/**
	 * 判断请假是否成功
	 * 方法名：isLeave
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-下午4:27:42 
	 * 手机:17673111810
	 * @param leaveList
	 * @param bTime
	 * @param eTime
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean isLeave(List<Leave> leaveList,
								long bTime, long eTime){
		CpDate cpDate = new CpDate();
		for (Leave leave : leaveList) {
			long lBTime = cpDate.getClockTime("yyyy-MM-dd HH:mm:ss", leave.getBegin_time());
			long lETime = cpDate.getClockTime("yyyy-MM-dd HH:mm:ss", leave.getEnd_time());
			
			if (lBTime<bTime&&lETime>eTime) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * 写入考情信息
	 * 方法名：addInFoMation
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-下午3:18:08 
	 * 手机:17673111810
	 * @param stuIdList
	 * @param atdId
	 * @param bTime
	 * @param eTime void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addInFoMation(List<Integer> stuIdList, Integer atdId, long bTime, long eTime) {
		// TODO Auto-generated method stub
		boolean temp;
		Information inf;

		for (Integer stu : stuIdList) {
			temp = false;
			//得到该学生的请假信息
			List<Leave> leaveList = teacherAtendncDao.getStuLeave(stu);
			//判断是否请假
			if (leaveList.size()!=0) {
				temp = isLeave(leaveList,bTime,eTime);
			}
			
			//将数据写入数据库
			inf = new Information();
			inf.setAttendance_id(atdId);
			inf.setStatus(temp? "请假":"缺勤");
			inf.setStudent_id(stu);
			
			teacherAtendncDao.addInformation(inf);
			
		}
	}

	/**
	 * 是否可以签到
	 * 方法名：getCan
	 * 创建人：chenPeng
	 * 时间：2019年2月17日-下午9:21:03 
	 * 手机:17673111810
	 * @param noteId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getCan(Integer noteId) {
		// TODO Auto-generated method stub
		return teacherAtendncDao.getCan(noteId);
	}


	/**
	 * 查询点到的id
	 * 方法名：getAMsgId
	 * 创建人：chenPeng
	 * 时间：2019年2月17日-下午9:48:18 
	 * 手机:17673111810
	 * @param couNoteId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getAMsgId(Integer couNoteId) {
		// TODO Auto-generated method stub
		return teacherAtendncDao.getAMsgId(couNoteId);
	}


	/**
	 * 判断两种状态
	 * 方法名：JudgeMode
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午5:39:30 
	 * 手机:17673111810
	 * @param andView void
	 * @exception 
	 * @since  1.0.0
	 */
	public void JudgeMode(ModelAndView andView,Integer atendncId, Integer noteId){
		//查询是那种点到
		Integer mode = teacherAtendncDao.getMode(atendncId);
		andView.addObject("teaTemp", "1");
		andView.addObject("noteId", noteId);
		
		if (mode == 1) {
			andView.setViewName("teacher/atendenc");
		}else{
			//取密码
			Integer timeKey = teacherAtendncDao.getTimeKey(atendncId);
			andView.addObject("timeKeys", timeKey);
			andView.setViewName("teacher/atendenc2");
		}
		
		
	}
	


	/**
	 * 停止点到
	 * 方法名：stopAtendnc
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午9:07:02 
	 * 手机:17673111810
	 * @param noteId void
	 * @exception 
	 * @since  1.0.0
	*/
	public void stopAtendnc(Integer noteId) {
		// TODO Auto-generated method stub
		teacherAtendncDao.stopAtendnc(noteId);
	}


	/**
	 * 将密码写入数据库
	 * 方法名：setPword
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午11:54:03 
	 * 手机:17673111810
	 * @param timeKey void
	 * @param noteId 
	 * @exception 
	 * @since  1.0.0
	*/
	public void setPword(Integer timeKey, Integer noteId) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("timeKey", timeKey);
		map.put("noteId", noteId);
		teacherAtendncDao.setPword(map);
	}


	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：setCanAndMode
	 * 创建人：chenPeng
	 * 时间：2019年2月19日-上午12:44:43 
	 * 手机:17673111810
	 * @param can
	 * @param mode void
	 * @param noteId 
	 * @exception 
	 * @since  1.0.0
	*/
	public void setCanAndMode(Integer can, Integer mode, Integer noteId) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("can", can);
		map.put("mode", mode);
		map.put("noteId", noteId);
		teacherAtendncDao.setCanAndMode(map);
	}

}
