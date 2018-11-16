/**
 * lei
 * com.mic.web
 * tBCourseWeb.java
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04 
 * 2018雷-版权所有
 */

package com.mic.web.lei;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.service.tBCourseDo;

/**
 * 
 * tBCourseWeb
 * 创建人:lei
 * 时间：2018年9月26日-下午21:39:04 
 * @version 1.0.0
 * 
 */
@Controller
public class tBCourseWeb {
	@Autowired
	private tBCourseDo tbcoursedo;
	/**
	 * 老师添加学校的页面
	 * 方法名：tBCourseWeb
	 * 创建人：lei
	 * 时间：2018年9月26日-下午21:39:04 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/tBCourse")
	public ModelAndView inittBCourse(){
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("/teacher/tBCourse");
		return modelandview;
	}
	
	@RequestMapping(value="/tBCourseWeb", method = RequestMethod.POST)
	public ModelAndView tBCourseDo(HttpServletRequest re){
		ModelAndView modelandview = new ModelAndView();
		String teacherName = re.getParameter("teacherName");
		String className = re.getParameter("className");
		Integer classNum = Integer.parseInt(re.getParameter("classNum"));
		String classTime = re.getParameter("classTime");
		String classAddress = re.getParameter("classAddress");
		Integer C_id = tbcoursedo.tBCourse(teacherName, className, classNum, classTime, classAddress);
		modelandview.addObject("teacherName", teacherName);
		modelandview.addObject("className", className);
		modelandview.addObject("classNum", classNum);
		modelandview.addObject("classAddress", classAddress);
		re.getSession().setAttribute("C_id", C_id);	
		modelandview.setViewName("teacher/eClass");
		return modelandview;
	}
}
