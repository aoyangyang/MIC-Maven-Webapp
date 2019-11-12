/**
 * chenPeng
 * com.mic.service.stuclass
 * StudentClassroomDo.java
 * 创建人:chenpeng
 * 时间：2019年2月12日-下午3:23:46 
 * 2019陈鹏-版权所有
 */
package com.mic.service.stuclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.course.CourseNote;
import com.mic.bean.course.StuCourse;
import com.mic.bean.db.Problems;
import com.mic.dao.stuclass.StudentClassroomDao;

/**
 * 
 * StudentClassroomDo
 * 创建人:chenPeng
 * 时间：2019年2月12日-下午3:23:46 
 * @version 1.0.0
 * 
 */
@Service
public class StudentClassroomDo {
	@Autowired
	private StudentClassroomDao studentClassroomDao;
	
	/**
	 * 得到学生选的课
	 * 方法名：getCourse
	 * 创建人：chenPeng
	 * 时间：2019年2月12日-下午9:41:58 
	 * 手机:17673111810
	 * @param studentId
	 * @return List<Course>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<StuCourse> getCourse(Integer studentId) {
		// TODO Auto-generated method stub
		
		return studentClassroomDao.getCourse(studentId);
	}

	/**
	 * 点入某个课程查看课堂
	 * 方法名：getCouNoteList
	 * 创建人：chenPeng
	 * 时间：2019年2月12日-下午10:32:01 
	 * 手机:17673111810
	 * @param no
	 * @return List<CourseNote>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<CourseNote> getCouNoteList(Integer no) {
		// TODO Auto-generated method stub
		return studentClassroomDao.getCouNoteList(no);
	}

	/**
	 * 学生段得到全部的问题
	 * 方法名：getProblemsList
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午3:11:13 
	 * 手机:17673111810
	 * @param no
	 * @return List<Problems>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Problems> getProblemsList(Integer no) {
		// TODO Auto-generated method stub
		return studentClassroomDao.getProblemsList(no);
	}

	/**
	 * 回答问
	 * 方法名：stuAnswer
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午5:05:13 
	 * 手机:17673111810
	 * @param studentId
	 * @param ans
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	*/
	public void stuAnswer(Integer studentId, String ans, Integer no) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("studentId", studentId+"");
		map.put("ans", ans);
		map.put("no", no+"");
		
		studentClassroomDao.stuAnswer(map);
	}

	/**
	 * 得到一个学生的回答记录
	 * 方法名：getStuAnsProb
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午5:34:24 
	 * 手机:17673111810
	 * @param attribute
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getStuAnsProb(Integer stuId) {
		// TODO Auto-generated method stub
		return studentClassroomDao.getStuAnsProb(stuId);
	}

	/**
	 * 得到正确答案
	 * 方法名：getAns
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午8:25:40 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String getAns(Integer no) {
		// TODO Auto-generated method stub
		return studentClassroomDao.getAns(no);
	}

	/**
	 * 加分
	 * 方法名：addIntegral
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午8:52:59 
	 * 手机:17673111810
	 * @param studentId
	 * @param no
	 * @param integralNub void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addIntegral(Integer studentId, Integer no, Integer integralNub) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("studentId",studentId);
		map.put("no",no);
		map.put("integralNub",integralNub);
		
		studentClassroomDao.addIntegral(map);
	}

	/**
	 * 判断是否可以答题
	 * 方法名：canAnswer
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午9:03:29 
	 * 手机:17673111810
	 * @param no
	 * @return boolean
	 * @throws ParseException 
	 * @exception 
	 * @since  1.0.0
	*/
	public boolean canAnswer(Integer no) throws ParseException {
		// TODO Auto-generated method stub
		//拿到课堂时间
		String endTime = studentClassroomDao.getEndTime(no).split("/")[0];
		//2018-12-29/2
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(endTime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 2);
		
		Long now = new Date().getTime();
		Long end = calendar.getTime().getTime();
		
		if (end>now) {
			return true;
		}
		
		return false;
	}
	

}
