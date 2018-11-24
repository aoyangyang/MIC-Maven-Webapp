/**
 * chenPeng
 * com.mic.service
 * StudentAddDo.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-下午10:16:04 
 * 2018陈鹏-版权所有
 */
package com.mic.service.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.EvAndDepartments;
import com.mic.bean.school.School;
import com.mic.bean.student.Student;
import com.mic.core.CpJudge;
import com.mic.core.FileUp;
import com.mic.core.NoteIsNull;
import com.mic.dao.register.StudentAddDao;

/**
 * 
 * StudentAddDo
 * 创建人:chenPeng
 * 时间：2018年8月5日-下午10:16:04 
 * @version 1.0.0
 * 
 */
@Service
public class StudentAddDo {
	@Autowired
	private StudentAddDao studentAddDao;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 得到全部是学校
	 * 方法名：getAllSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午10:29:58 
	 * 手机:17673111810
	 * @return List<School>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<School> getAllSchool(){
		return studentAddDao.getSchool();
	}
	
	/**
	 * 得到班级 
	 * 方法名：getClasss
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午11:27:56 
	 * 手机:17673111810
	 * @param departments
	 * @param enrolment
	 * @return List<Classs>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getClasss(Integer departments,Integer enrolment){
		EvAndDepartments evAndDepartments = new EvAndDepartments();
		evAndDepartments.setDepartments_id(departments);
		evAndDepartments.setEnrolment(enrolment);
		return studentAddDao.getClasss(evAndDepartments);
	}
	
	/**
	 * 学生注册
	 * 方法名：studentAdd
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午6:00:39 
	 * 手机:17673111810
	 * @param file
	 * @param student
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	public ModelAndView studentAdd(MultipartFile file, Student student){
		ModelAndView andView = new ModelAndView();
		
		
		NoteIsNull noteIsNull = new NoteIsNull();
		CpJudge cpJudge = new CpJudge();
		//判断空
		if(!noteIsNull.noteIsNull(student.getAddress())||
					!noteIsNull.noteIsNull(student.getEmail())||
					!noteIsNull.noteIsNull(student.getPassword())||
					!noteIsNull.noteIsNull(student.getPhone())||
					!noteIsNull.noteIsNull(student.getUsername())||
					!noteIsNull.noteIsNull(student.getSex())||
					!noteIsNull.noteIsNull(student.getClass_id()) ){
			re.getSession().setAttribute("errorMessage", "填写信息中有空值");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//判断规范
		if(!cpJudge.isEmail(student.getEmail())||
				!cpJudge.isPhone(student.getPhone())){
			re.getSession().setAttribute("errorMessage", "信息填写未按规范");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//头像上传
		String picSrc = 
				re.getSession().getServletContext().getRealPath("/img/head");
		FileUp fileUp = new FileUp();
		String fileName = fileUp.fileUp(file, picSrc);
		if(!noteIsNull.noteIsNull(fileName)){
			re.getSession().setAttribute("errorMessage", "图片上传失败");
			return new ModelAndView("redirect:/500.jsp");
		}
		student.setPic(fileName);
		
		
		//写入数据库
		studentAddDao.studentAdd(student);
		
		andView.setViewName("Login");
		return andView;
	}
}
