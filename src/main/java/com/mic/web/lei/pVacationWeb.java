/**
 * lei
 * com.mic.Web
 * pVacationWeb.java
 * 创建人:lei
 * 时间：2018年9月29日-下午17:38:04
 * 2018lei-版权所有
 */
package com.mic.web.lei;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.service.lei.pVacationDo;

/**
 * 学生请假页面
 * pVacationWeb
 * 创建人:lei
 * 时间：2018年9月29日-下午17:38:04  
 * @version 1.0.0
 * 
 */
@Controller
public class pVacationWeb {
    @Autowired
    private pVacationDo pVacationdo;
    @Autowired
    private HttpServletRequest re;
    
    @RequestMapping("/student/pVacation")
	public ModelAndView pVacation(){
    	ModelAndView mo = new ModelAndView();
    	
    	Integer studentId = (Integer) re.getSession().getAttribute("studentId");
    	String studentName = (String) re.getSession().getAttribute("studentName");
    	
    	/*得到tel*/
    	String phone = pVacationdo.getPhone(studentId);
    	
    	mo.addObject("phone", phone);
    	mo.addObject("studentId", studentId);
    	mo.addObject("studentName", studentName);
		mo.setViewName("/student/pVacation");
		return mo;
	}
    
    @RequestMapping(value="/student/pVacationDo", method = RequestMethod.POST)
	public ModelAndView eClassDo(HttpServletRequest re){
    	ModelAndView modelandview = new ModelAndView();
    	String Sname = (String) re.getSession().getAttribute("studentName");
    	Integer Sid = (Integer) re.getSession().getAttribute("studentId");
    	String reason = re.getParameter("reson");
    	String Pnum = re.getParameter("Pnum");
    	String Btime = re.getParameter("Btime");
    	String Etime = re.getParameter("Etime");	
    	pVacationdo.pVacationdo(Sid, reason, Pnum, Btime, Etime);
    	
    	modelandview.setViewName("student/stuIndex");
		return modelandview;
	}
}
