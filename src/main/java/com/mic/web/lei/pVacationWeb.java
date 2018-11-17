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
    
    @RequestMapping("/pVacation")
	public ModelAndView pVacation(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/student/pVacation");
		return mo;
	}
    
    @RequestMapping(value="/pVacation", method = RequestMethod.POST)
	public ModelAndView eClassDo(HttpServletRequest re){
    	ModelAndView modelandview = new ModelAndView();
    	String Sname = re.getParameter("Sname");
    	Integer Sid = Integer.parseInt(re.getParameter("Sid"));
    	String reason = re.getParameter("reson");
    	String Pnum = re.getParameter("Pnum");
    	String Btime = re.getParameter("Btime");
    	String Etime = re.getParameter("Etime");	
    	pVacationdo.pVacationDo(Sid, reason, Pnum, Btime, Etime);
    	modelandview.addObject("Sid", Sid);
    	modelandview.addObject("reson", reason);
    	modelandview.addObject("Pnum", Pnum);
    	modelandview.addObject("Btime", Btime);
    	modelandview.addObject("Etime", Etime);
		return modelandview;
	}
}
