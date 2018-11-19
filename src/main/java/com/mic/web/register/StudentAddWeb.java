/**
 * chenPeng
 * com.mic.web
 * StudentAddWeb.java
 * 创建人:chenpeng
 * 时间：2018年8月5日-下午10:15:56 
 * 2018陈鹏-版权所有
 */
package com.mic.web.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Classs;
import com.mic.bean.Student;
import com.mic.core.NoteIsNull;
import com.mic.service.register.StudentAddDo;

import net.sf.json.JSONArray;

/**
 * 
 * 学生注册页面
 * StudentAddWeb
 * 创建人:chenPeng
 * 时间：2018年8月5日-下午10:15:56 
 * @version 1.0.0
 * 
 */
@Controller
public class StudentAddWeb {
	@Autowired
	private StudentAddDo studentAddDo;
	@Autowired
	private HttpServletRequest re;
	/**
	 * 得到全部的学校
	 * 方法名：initStudentAddWeb
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午10:32:19 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/studentAdd")
	public ModelAndView initStudentAddWeb(){
		ModelAndView andView = new ModelAndView();
		andView.addObject("schoolList", studentAddDo.getAllSchool());
		andView.setViewName("add/studentAdd");
		return andView;
	}
	
	/**
	 * ajax得到全部的班级
	 * 方法名：logined
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午11:23:10 
	 * 手机:17673111810
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,
			value="/getClass",
				produces = "application/String; charset=utf-8")
	public String getClasss(HttpServletRequest request){
		Integer departments = 
			Integer.parseInt(request.getParameter("departments"));
		Integer enrolment = 
			Integer.parseInt(request.getParameter("enrolment"));
			
		List<Classs> classList = 
				studentAddDo.getClasss(departments, enrolment);
		
		JSONArray jsonArray = new JSONArray();
		for (Classs classs : classList) {
			jsonArray.add(classs);
		}
		
		return jsonArray.toString();
	}
	
	/**
	 * 学生注册
	 * 方法名：studentAdd
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午6:00:19 
	 * 手机:17673111810
	 * @param file
	 * @param username
	 * @param phone
	 * @param password1
	 * @param password2
	 * @param address
	 * @param sex
	 * @param enrolment
	 * @param classs
	 * @param email
	 * @return
	 * @throws Exception ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/studentAddDo",method =RequestMethod.POST)
	public ModelAndView studentAdd(
				MultipartFile file,
				String username,
				String phone,
				String password1,
				String password2,
				String address,
				String sex,
				String enrolment,
				String classs,
				String email
						)throws Exception{
		NoteIsNull noteIsNull = new NoteIsNull();
		
		if(!password1.equals(password2)){
			re.getSession().setAttribute("errorMessage", "两次密码不一致");
			return new ModelAndView("redirect:/500.jsp");
		}
		if(!noteIsNull.noteIsNull(classs)||
				!noteIsNull.noteIsNull(sex)){
			re.getSession().setAttribute("errorMessage", "有值为空");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		Student student = new Student();
		student.setAddress(address);
		student.setClass_id(Integer.parseInt(classs));
		student.setEmail(email);
		student.setPassword(password1);
		student.setSex(Integer.parseInt(sex));
		student.setUsername(username);
		student.setPhone(phone);
		
		return studentAddDo.studentAdd(file,student);
	}
}
