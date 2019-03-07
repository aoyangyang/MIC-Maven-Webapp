/**
 * chenPeng
 * com.mic.service.showMsg
 * TeacherClass.java
 * 创建人:chenpeng
 * 时间：2018年11月17日-下午8:36:40 
 * 2018陈鹏-版权所有
 */
package com.mic.service.showMsg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.course.Course;
import com.mic.bean.course.CourseNote;
import com.mic.bean.departments.Information;
import com.mic.bean.other.IdAndNo;
import com.mic.dao.showMsg.TeacherClassDao;

/**
 * 得到该老师的全部信息
 * TeacherClass
 * 创建人:chenPeng
 * 时间：2018年11月17日-下午8:36:40 
 * @version 1.0.0
 * 
 */
@Service
public class TeacherClassDo {
	@Autowired
	private TeacherClassDao teacherClassDao; 
	@Autowired
	private HttpServletRequest re;
	
	public Integer getLength(){
		Integer teaId = (Integer) re.getSession().getAttribute("teacherId");
		return teacherClassDao.getLength(teaId);
	}
	
	
	/**
	 * 得到该老师的全部信息
	 * 方法名：getClassList
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午8:53:21 
	 * 手机:17673111810
	 * @param i 
	 * @return List<Course>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Course> getClassList(Integer no) {
		Integer teaId = (Integer) re.getSession().getAttribute("teacherId");
		no = (no-1)*10;
		
		IdAndNo idAndNo = new IdAndNo();
		idAndNo.setId(teaId);
		idAndNo.setNo(no);
		
		return teacherClassDao.fondClassList(idAndNo);
	}


	/**
	 * 得到课程信息
	 * 方法名：getCourNoId
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-上午11:11:02 
	 * 手机:17673111810
	 * @param teacherId
	 * @param no
	 * @return Course
	 * @exception 
	 * @since  1.0.0
	*/
	public Course getCourMsg(Integer teacherId, Integer no) {
		IdAndNo idAndNo = new  IdAndNo();
		
		idAndNo.setId(teacherId);
		idAndNo.setNo(no);
		
		return teacherClassDao.getCourMsg(idAndNo);
	}


	/**
	 * 拿到一定量的某堂课程信息
	 * 方法名：getCourList
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-下午3:04:41 
	 * 手机:17673111810
	 * @param no  课程编号
	 * @param number  页码
	 * @return List<CourseNote>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<CourseNote> getCourList(Integer no,Integer number) {
		Integer teacherId = (Integer) re.getSession().getAttribute("teacherId");
		
		IdAndNo idAndNo = new IdAndNo();
		IdAndNo idAndNo2 = new IdAndNo();
		idAndNo.setId(teacherId);
		idAndNo.setNo(no);
		
		//先进行对比是否为这个老师
		Integer temp = teacherClassDao.testTeacher(idAndNo);
		if (temp == null) {
			return null;
		}
		
		//传入需要的课程
		idAndNo2.setId(no);
		idAndNo2.setNo((number-1)*10);
		
		return teacherClassDao.getClsList(idAndNo2);
	}


	/**
	 * 得到页码
	 * 方法名：getClsLenth
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-下午10:21:48 
	 * 手机:17673111810
	 * @param no
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getClsLenth(Integer no) {
		return teacherClassDao.getMsgLength(no);
	}


	/**
	 * 补签功能
	 * 方法名：supplementDo
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午1:11:52 
	 * 手机:17673111810
	 * @param attId
	 * @param stuId
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String supplementDo(Integer attId, Integer stuId) {
		// TODO Auto-generated method stub
		Information information  = new Information();
		information.setAttendance_id(attId);
		information.setStudent_id(stuId);
		
		try {
			teacherClassDao.supplementDo(information);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "error";
		}
		return "success";
	}
	
	
}
