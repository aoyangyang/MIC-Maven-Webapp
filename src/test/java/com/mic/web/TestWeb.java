/**
 * chenPeng
 * com.mic.web
 * Test.java
 * 创建人:chenpeng
 * 时间：2018年7月28日-下午2:00:15 
 * 2018陈鹏-版权所有
 *//*
package com.mic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

*//**
 * 
 * Test
 * 创建人:chenPeng
 * 时间：2018年7月28日-下午2:00:15 
 * @version 1.0.0
 * 
 *//*
@Controller
public class TestWeb {
	@RequestMapping("/addSchool")
	public ModelAndView test(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("admin/addSchool");
		System.out.println(1);
		return mo;
	}
	
	@RequestMapping("/LeaderDepAdd")
	public ModelAndView LeaderDepAdd(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("add/LeaderDepAdd");
		System.out.println(1);
		return mo;
	}
	
	@RequestMapping("/LeaderWorkAdd")
	public ModelAndView LeaderWorkAdd(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("add/LeaderWorkAdd");
		System.out.println(1);
		return mo;
	}
	
	@RequestMapping("/studentAdd")
	public ModelAndView studentAdd(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("add/studentAdd");
		System.out.println(1);
		return mo;
	}
	
	@RequestMapping("/teacherRegister")
	public ModelAndView teacherRegister(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("add/teacherRegister");
		System.out.println(1);
		return mo;
	}
	
	
	@RequestMapping("/depLeader")
	public ModelAndView depLeader(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("statistics/depLeader");
		return mo;
	}
	
	@RequestMapping("/depLeaderDetail")
	public ModelAndView depLeaderDetail(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("statistics/depLeaderDetail");
		return mo;
	}
	
	@RequestMapping("/details")
	public ModelAndView details(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("statistics/details");
		return mo;
	}
	
	@RequestMapping("/instructorChoose")
	public ModelAndView instructorChoose(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("statistics/instructorChoose");
		return mo;
	}
	
	@RequestMapping("/workChoose")
	public ModelAndView workChoose(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("statistics/workChoose");
		return mo;
	}
	
	@RequestMapping("/workView")
	public ModelAndView workView(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("statistics/workView");
		return mo;
	}
	

	@RequestMapping("/instructorAdd")
	public ModelAndView instructorAdd(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("add/instructorAdd");
		return mo;
	}
	
	@RequestMapping("/Login")
	public ModelAndView Login(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("Login");
		return mo;
	}
	
	@RequestMapping("/approvalHoliday")
	public ModelAndView approvalHoliday(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/instructor/approvalHoliday");
		return mo;
	}
	
	@RequestMapping("/eClass")
	public ModelAndView eClass(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/teacher/eClass");
		return mo;
	}
	
	@RequestMapping("/pVacation")
	public ModelAndView pVacation(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/student/pVacation");
		return mo;
	}
	
	@RequestMapping("/tBCourse")
	public ModelAndView tBCourse(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/teacher/tBCourse");
		return mo;
	}
	@RequestMapping("/select1")
	public ModelAndView select1(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/student/select1");
		return mo;
	}
	
	@RequestMapping("/select2")
	public ModelAndView select2(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/student/select2");
		return mo;
	}
}
*/