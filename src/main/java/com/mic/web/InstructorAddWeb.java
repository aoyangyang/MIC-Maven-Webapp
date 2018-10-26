package com.mic.web;

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
import com.mic.service.InstructorAddDo;

import net.sf.json.JSONArray;

/**
 * 
 * 
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
	
	
	@RequestMapping(value="/InstructorAddDo",method=RequestMethod.POST)
	public ModelAndView instructorAddClass(
			String addClass,
			Integer departments,
			Integer AddYear,
			Integer user
			){
		ModelAndView andView = new ModelAndView();
		
		AddClass addCLass = new AddClass();
		addCLass.setDepartments_id(departments);
		addCLass.setClassname(addClass);
		addCLass.setEnrolment(AddYear);
		addCLass.setClass_size(user);
		
		Integer classId = instructorAddDo.instructorAddClass(addCLass);
		Integer adClassId = (Integer) re.getSession().getAttribute("adClassId");
		
		
		System.out.println("我是classID"+classId+"=========="+"我的辅导员id"+adClassId);
		
		
		
		
		//吧  105和106的两个数据写入数据库    可以参考上面的那个插入   不需要返回值
		instructorAddDo.adClass(classId,adClassId);
		
		
		
		andView.setViewName("辅导员首页");
		return andView;
	}
	
	
	
}
