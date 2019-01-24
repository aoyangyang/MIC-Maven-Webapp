/**
 * lei
 * com.mic.Web
 * Select1Web.java
 * 创建人:lei
 * 时间：2018年9月30日-下午13:19:04
 * 2018lei-版权所有
 */
package com.mic.web.lei;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.lei.Select1Bean;
import com.mic.service.lei.Select1Do;

/**
 * 学生选课
 * Select1Web
 * 创建人:lei
 * 时间：2018年9月30日-下午13:19:04
 * @version 1.0.0
 * 
 */
@Controller
public class Select1Web {
	@Autowired
	private Select1Do select1do;
	@Autowired
	private HttpServletRequest re;
	
	@RequestMapping("/student/selectClass")
	public ModelAndView select1(){
		ModelAndView mo = new ModelAndView();
		
		Integer studentId = (Integer)re.getSession().getAttribute("studentId");
		String studentName = (String)re.getSession().getAttribute("studentName");
		
		mo.addObject("studentId", studentId);
		mo.addObject("studentName", studentName);
		mo.setViewName("/student/select1");
		return mo;
	}
	
	@RequestMapping(value="/student/selectClassDo", method = RequestMethod.POST)
	public ModelAndView eClassDo(HttpServletRequest re){
    	ModelAndView modelandview = new ModelAndView();
    	
    	Select1Bean select1bean = new Select1Bean();
    	
    	select1bean =  select1do.Select1(re.getParameter("sname"), 
    						Integer.parseInt(re.getParameter("c_id")));
    	
    	modelandview.addObject("Cname", select1bean.getCname());
    	modelandview.addObject("Tname", select1bean.getTname());
    	
    	re.getSession().setAttribute("C_id", select1bean.getCid());	
    	re.getSession().setAttribute("S_id", select1bean.getS_id());	
    	
    	modelandview.setViewName("/student/select2");
		return modelandview;
	}
	
     
}
