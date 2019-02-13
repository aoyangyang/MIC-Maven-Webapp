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

import com.mic.bean.course.Course;
import com.mic.bean.course.CourseNote;
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
	@Autowired
	private HttpServletRequest re;
	
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
	
	/**
	 * 
	 * 跳转到单门课程的列表上面去
	 * 方法名：getClasss
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-下午2:44:57 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/teacher/class/{no}")
	public ModelAndView getClasss(@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();
		
		//拿到信息列表
		List<CourseNote> coureList = teacherClassDo.getCourList(no,1);
		
		
		//判断老师是否也权限
		if (coureList == null) {
			re.getSession().setAttribute("errorMessage", "您无权限管理该课程或未建立此课程");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//拿到长度
		Integer length = teacherClassDo.getClsLenth(no);
		
		//如果长度为0那么他添加课程
		if (length==0) {
			return new ModelAndView("redirect:/teacher/classMsg/"+no);
		}
		
		andView.addObject("length", (length/10)+1);
		andView.addObject("coureList", coureList);
		andView.setViewName("teacher/teaClass");
		
		return andView;
	}
	
	/**
	 * 老师补签
	 * 方法名：supplementDo
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午1:11:20 
	 * 手机:17673111810
	 * @param attId
	 * @param stuId
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/teacher/supplementDo",method = RequestMethod.POST, 
								produces = "application/String; charset=utf-8")
	@ResponseBody
	public String supplementDo(Integer attId,Integer stuId){
		return teacherClassDo.supplementDo(attId,stuId);
	}
	
	
	
	/**
	 * ajax刷新得到某门课程信息列表
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
						value = "/teacher/classNo", 
							produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getClassListN(HttpServletRequest request) {
		JSONArray jsonArray = new JSONArray();
		Integer number = Integer.parseInt(request.getParameter("number"));
		Integer no = Integer.parseInt(request.getParameter("no"));
		
		
		//拿到信息列表
		List<CourseNote> coureList = teacherClassDo.getCourList(no,number);
		
		for (CourseNote course : coureList) {
			jsonArray.add(course);
		}
		return jsonArray.toString();
	}
	
	
	/**
	 * 
	 * 上课详情信息
	 * 方法名：getClassMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月18日-上午10:52:34 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/teacher/classMsg/{no}")
	public ModelAndView getClassMsg(@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();
		
		//拿到老师的name和id
		Integer teacherId = (Integer) re.getSession().getAttribute("teacherId");
		String teacherName = (String) re.getSession().getAttribute("teacherName");
		
		//拿到课程信息
		Course cou = teacherClassDo.getCourMsg(teacherId,no);
		
		if (cou == null) {
			re.getSession().setAttribute("errorMessage", "您无权限管理该课程或未建立此课程");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		andView.addObject("cou", cou);
		andView.addObject("teacherName", teacherName);
		re.getSession().setAttribute("C_id", cou.getId());
		
		andView.setViewName("teacher/eClass");
		return andView;
	}
	
	/**
	 * 
	 * 修改课程信息
	 * 方法名：upClassMsg
	 * 创建人：chenPeng
	 * 时间：2018年11月19日-下午1:02:36 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/teacher/classUpMsg/{no}/{noteId}")
	public ModelAndView upClassMsg(@PathVariable Integer no,@PathVariable Integer noteId){
		ModelAndView andView = new ModelAndView();
		
		//拿到老师的name和id
		Integer teacherId = (Integer) re.getSession().getAttribute("teacherId");
		String teacherName = (String) re.getSession().getAttribute("teacherName");
		
		//拿到课程信息
		Course cou = teacherClassDo.getCourMsg(teacherId,no);
		
		if (cou == null) {
			re.getSession().setAttribute("errorMessage", "您无权限管理该课程或未建立此课程");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		andView.addObject("cou", cou);
		andView.addObject("teacherName", teacherName);
		re.getSession().setAttribute("C_id", cou.getId());
		re.getSession().setAttribute("noteId", noteId);
		
		andView.setViewName("teacher/upDateEClass");
		
		return andView;
	}
	
	
}
