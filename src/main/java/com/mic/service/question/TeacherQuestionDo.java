/**
 * chenPeng
 * com.mic.service.question
 * TeacherQuestionDo.java
 * 创建人:chenpeng
 * 时间：2019年2月9日-下午4:56:03 
 * 2019陈鹏-版权所有
 */
package com.mic.service.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.course.CourseNote;
import com.mic.bean.db.Problems;
import com.mic.dao.question.TeacherQuestionDao;

/**
 * 
 * TeacherQuestionDo
 * 创建人:chenPeng
 * 时间：2019年2月9日-下午4:56:03 
 * @version 1.0.0
 * 
 */
@Service
public class TeacherQuestionDo {
	@Autowired
	private TeacherQuestionDao teacherQuestionDao;
	/**
	 * 查询出课堂信息
	 * 方法名：getCourseNote
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午5:12:20 
	 * 手机:17673111810
	 * @param no
	 * @return CourseNote
	 * @exception 
	 * @since  1.0.0
	*/
	public CourseNote getCourseNote(Integer no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.getCourseNote(no);
	}
	/**
	 * 添加ppt
	 * 方法名：addPPt
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午10:15:45 
	 * 手机:17673111810
	 * @param courseNoteId
	 * @param string void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addPPt(Integer courseNoteId, String string) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("courseNoteId", courseNoteId+"");
		map.put("src", string);
		
		teacherQuestionDao.addPPt(map);
	}
	/**
	 * 得到ppt路径
	 * 方法名：getPptPath
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午9:26:04 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String getPptPath(Integer no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.getPptPath(no);
	}
	/**
	 * 删除ppt
	 * 方法名：deletePpt
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午10:53:45 
	 * 手机:17673111810
	 * @param no
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer deletePpt(String no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.deletePpt(Integer.parseInt(no));
	}
	/**
	 * 添加一个提问
	 * 方法名：addQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午8:43:26 
	 * 手机:17673111810
	 * @param no
	 * @param quText
	 * @param quAns
	 * @param exampleQu
	 * @param newFilePath void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addQu(Integer no, String quText, String quAns, String exampleQu, String newFilePath) {
		// TODO Auto-generated method stub
		int temp = 0;
		if(exampleQu.equals("true")){
			temp = 1;
		}
		teacherQuestionDao.addQu(new Problems(no, quText, quAns, newFilePath, temp));
	}
	/**
	 * 查询出提问
	 * 方法名：getProList
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午9:19:31 
	 * 手机:17673111810
	 * @param no
	 * @return List<Problems>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Problems> getProList(Integer no) {
		// TODO Auto-generated method stub
		return teacherQuestionDao.getProList(no);
	}
	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：doQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午10:23:11 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	*/
	public void doQu(Integer no) {
		// TODO Auto-generated method stub
		teacherQuestionDao.doQu(no);
	}

}
