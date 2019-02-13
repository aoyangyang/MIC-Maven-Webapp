/**
 * chenPeng
 * com.mic.service.stuclass
 * StudentClassroomDo.java
 * 创建人:chenpeng
 * 时间：2019年2月12日-下午3:23:46 
 * 2019陈鹏-版权所有
 */
package com.mic.service.stuclass;

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
	 * (这里用一句话描述这个方法的作用)
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

}
