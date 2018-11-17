package com.mic.web.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.AddClass;
import com.mic.bean.FindDepartments;
import com.mic.bean.FindSchool;
import com.mic.bean.Leader;
import com.mic.service.register.InstructorAddDo;

import net.sf.json.JSONArray;

/**
 * 
 * 辅导员跳转添加班级的页面
 * InstructorAddWeb 
 * 创建人:Shanice
 * 时间：2018年10月18日-下午5:55:28 
 * @version 1.0.0
 *
 */
@Controller
public class InstructorAddWeb {
	@Autowired 
	private HttpServletRequest re;
	
	@Autowired
	private InstructorAddDo instructorAddDo;
	
	
	/**
	 * 
	 * 跳转到辅导员注册页面
	 * 方法名：initInsAdd
	 * 创建人：chenPeng
	 * 时间：2018年11月16日-下午10:03:59 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/insAdd")
	public ModelAndView initInsAdd(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("add/insAdd");
		return andView;
	}
	
	@RequestMapping(value="/insAddDo",method=RequestMethod.POST)
	public ModelAndView insAddDo(
				String username,
				String tel,
				String password1,
				String password2,
				String address,
				String email
			){
		/*
		 * 判断两次密码是否相同
		 */
		if(!password1.equals(password2)){
			re.getSession().setAttribute("errorMessage", "两次密码不一致");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		Leader leader= new Leader();
		leader.setAddress(address);
		leader.setEmail(email);
		leader.setPassword(password1);
		leader.setPhone(tel);
		leader.setUsername(username);
		
		instructorAddDo.insAdd(leader);
		
		return new ModelAndView("redirect:/Login");
	}
	
	/**
	 * 
	 * 辅导员跳转添加班级的页面
	 * 初始化学校
	 * 方法名：initInstructorAdd
	 * 创建人：Shanice
	 * 时间：2018年10月9日-上午10:55:18 
	 * 手机:15873158820
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/add/instructorAdd")
	public ModelAndView initInstructorAdd(){
		ModelAndView andView = new ModelAndView();
		List<FindSchool> schoolList = instructorAddDo.initInstructorAdd();
		
		andView.addObject("schoolList", schoolList);
		andView.setViewName("/add/instructorAdd");
		
		return andView;
	}
	
	/**
	 *
	 * ajax动态刷新学部信息
	 * 方法名：logined
	 * 创建人：Shanice
	 * 时间：2018年10月18日-下午5:54:17 
	 * 手机:15873158820
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,
				value="/findDepartments",
					produces = "application/String; charset=utf-8")
	@ResponseBody
	public String logined(HttpServletRequest request){
		Integer schoolNo = Integer.parseInt(request.getParameter("schoolName"));
		
		List<FindDepartments> findDepartmentsList = instructorAddDo.findDepartments(schoolNo);	
		
		JSONArray jsonArray = new JSONArray();
		for (FindDepartments findDepartments : findDepartmentsList){
			jsonArray.add(findDepartments);
		}
		return jsonArray.toString();
	}
	
	
	/**
	 * 
	 * 执行添加学校操作
	 * 方法名：instructorAddClass
	 * 创建人：chenPeng
	 * 时间：2018年11月16日-下午9:31:53 
	 * 手机:17673111810
	 * @param addClass
	 * @param departments
	 * @param AddYear
	 * @param user
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/InstructorAddDo",method=RequestMethod.POST)
	public ModelAndView instructorAddClass(
			String addClass,
			Integer departments,
			Integer AddYear,
			Integer user
			){
		
		AddClass addCLass = new AddClass();
		addCLass.setDepartments_id(departments);
		addCLass.setClassname(addClass);
		addCLass.setEnrolment(AddYear);
		addCLass.setClass_size(user);
		
		Integer classId = instructorAddDo.instructorAddClass(addCLass);
		Integer adClassId = (Integer) re.getSession().getAttribute("adClassId");
		
		
		instructorAddDo.adClass(classId,adClassId);
		
		return new ModelAndView("redirect:/InsIndex");
	}
	
	
	
}
