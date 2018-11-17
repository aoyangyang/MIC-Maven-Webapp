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

import com.mic.bean.Course;
import com.mic.bean.IdAndNo;
import com.mic.dao.TeacherClassDao;

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
	
}
