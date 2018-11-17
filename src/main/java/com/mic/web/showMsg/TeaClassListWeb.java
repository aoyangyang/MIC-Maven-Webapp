/**
 * chenPeng
 * com.mic.web.showMsg
 * TeaClassList.java
 * 创建人:chenpeng
 * 时间：2018年11月17日-下午8:13:55 
 * 2018陈鹏-版权所有
 */
package com.mic.web.showMsg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Course;
import com.mic.bean.Departments;
import com.mic.service.showMsg.TeacherClassDo;

import net.sf.json.JSONArray;

/**
 * 老师的课程列表
 * TeaClassList
 * 创建人:chenPeng
 * 时间：2018年11月17日-下午8:13:55 
 * @version 1.0.0
 * 
 */
@Controller
public class TeaClassListWeb {
	@Autowired
	private TeacherClassDo teacherClassDo;
	
	/**
	 * 
	 * 老师全部的课程列表
	 * 方法名：initTeaClassList
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午8:52:27 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/teacher/classList")
	public ModelAndView initTeaClassList(){
		ModelAndView andView = new ModelAndView();
		Integer no = teacherClassDo.getLength();
		List<Course> classList = teacherClassDo.getClassList(1);
		
		andView.addObject("no", (no/10)+1);
		andView.addObject("classList", classList);
		andView.setViewName("teacher/teaClassList");
		return andView;
	}
	
	
	/**
	 * ajax刷新得到课程信息
	 * 方法名：getClassList
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午9:48:39 
	 * 手机:17673111810
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method = RequestMethod.POST, 
						value = "/getClassList", 
							produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getClassList(HttpServletRequest request) {
		JSONArray jsonArray = new JSONArray();
		Integer number = Integer.parseInt(request.getParameter("number"));
		
		List<Course> classList = teacherClassDo.getClassList(number);
		
		for (Course course : classList) {
			jsonArray.add(course);
		}
	
		return jsonArray.toString();
	}
	
}
