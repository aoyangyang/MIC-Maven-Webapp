/**
 * chenPeng
 * com.mic.dao.atendnc
 * TeacherAtendncDao.java
 * 创建人:chenpeng
 * 时间：2018年11月20日-下午6:27:49 
 * 2018陈鹏-版权所有
 */
package com.mic.dao.atendnc;

import java.util.List;
import java.util.Map;

import com.mic.bean.atendnc.Attendance;
import com.mic.bean.atendnc.Leave;
import com.mic.bean.course.CourseNote;
import com.mic.bean.departments.Information;
import com.mic.bean.student.StudentArrive;

/**
 * 
 * TeacherAtendncDao
 * 创建人:chenPeng
 * 时间：2018年11月20日-下午6:27:49 
 * @version 1.0.0
 * 
 */
public interface TeacherAtendncDao{
	/**
	 * 
	 * 查询到考勤信息 得到考勤表id
	 * 方法名：getAtendnc
	 * 创建人：chenPeng
	 * 时间：2018年11月20日-下午6:31:38 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer getAtendncID(Integer noteId);

	
	/**
	 * 得到全部的考情信息
	 * 方法名：getAMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月20日-下午10:52:40 
	 * 手机:17673111810
	 * @param atendncId
	 * @return List<Information>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Information> getAMsg(Integer atendncId);

	
	/**
	 * 通过课堂id 得到全部的学生id
	 * 方法名：getStuIdList
	 * 创建人：chenPeng
	 * 时间：2018年11月23日-下午1:54:54 
	 * 手机:17673111810
	 * @param noteId
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getStuIdList(Integer noteId);


	/**
	 * 得到时间信息
	 * 方法名：getTimeMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月23日-下午2:06:30 
	 * 手机:17673111810
	 * @param noteId
	 * @return CourseNote
	 * @exception 
	 * @since  1.0.0
	*/
	public CourseNote getTimeMsg(Integer noteId);
	
	/**
	 * 
	 * 建立考情信息
	 * 方法名：addAtendnc
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-上午2:00:30 
	 * 手机:17673111810
	 * @param atd void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addAtendnc(Attendance atd);


	/**
	 * 得到请假信息
	 * 方法名：getStuLeave
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-下午3:17:34 
	 * 手机:17673111810
	 * @param stu
	 * @return List<Leave>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Leave> getStuLeave(Integer stu);


	/**
	 * 将单个学生信息写入数据库
	 * 方法名：addInformation
	 * 创建人：chenPeng
	 * 时间：2018年11月25日-下午4:35:59 
	 * 手机:17673111810
	 * @param inf void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addInformation(Information inf);


	/**
	 * 通过学生id得到学生信息
	 * 方法名：getStuArrive
	 * 创建人：chenPeng
	 * 时间：2018年11月27日-上午10:48:53 
	 * 手机:17673111810
	 * @param student_id
	 * @return StudentArrive
	 * @exception 
	 * @since  1.0.0
	*/
	public StudentArrive getStuArrive(Integer student_id);


	/**
	 * 是否可以签到
	 * 方法名：getCan
	 * 创建人：chenPeng
	 * 时间：2019年2月17日-下午9:22:02 
	 * 手机:17673111810
	 * @param noteId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getCan(Integer noteId);


	/**
	 * 查询点到的id
	 * 方法名：getAMsgId
	 * 创建人：chenPeng
	 * 时间：2019年2月17日-下午9:48:53 
	 * 手机:17673111810
	 * @param couNoteId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getAMsgId(Integer couNoteId);


	/**
	 * 判断两种状态
	 * 方法名：getMode
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午8:34:17 
	 * 手机:17673111810
	 * @param atendncId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getMode(Integer atendncId);


	/**
	 * 停止点到
	 * 方法名：stopAtendnc
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午9:07:54 
	 * 手机:17673111810
	 * @param noteId void
	 * @exception 
	 * @since  1.0.0
	*/
	public void stopAtendnc(Integer noteId);


	/**
	 * 将密码写入数据库
	 * 方法名：setPword
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午11:54:40 
	 * 手机:17673111810
	 * @param map void
	 * @exception 
	 * @since  1.0.0
	*/
	public void setPword(Map<String, Integer> map);


	/**
	 * 得到密码
	 * 方法名：getTimeKey
	 * 创建人：chenPeng
	 * 时间：2019年2月19日-上午12:19:48 
	 * 手机:17673111810
	 * @param atendncId
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getTimeKey(Integer atendncId);


	/**
	 * 写入状态以及模式
	 * 方法名：setCanAndMode
	 * 创建人：chenPeng
	 * 时间：2019年2月19日-上午12:46:30 
	 * 手机:17673111810
	 * @param map void
	 * @exception 
	 * @since  1.0.0
	*/
	public void setCanAndMode(Map<String, Integer> map);
}
