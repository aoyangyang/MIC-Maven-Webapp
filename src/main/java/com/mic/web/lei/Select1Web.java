/**
 * lei
 * com.mic.Web
 * Select1Web.java
 * 创建人:lei
 * 时间：2018年9月30日-下午13:19:04
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Select1Bean;
import com.mic.service.Select1Do;

/**
 * 
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
	
	@RequestMapping("/select1")
	public ModelAndView select1(){
		ModelAndView mo = new ModelAndView();
		mo.setViewName("/student/select1");
		return mo;
	}
	
	@RequestMapping(value="/select1", method = RequestMethod.POST)
	public ModelAndView eClassDo(HttpServletRequest re){
    	ModelAndView modelandview = new ModelAndView();
    	Select1Bean select1bean = new Select1Bean();
    	select1bean =  select1do.Select1(re.getParameter("sname"), Integer.parseInt(re.getParameter("c_id")));
    	modelandview.addObject("Cname", select1bean.getCname());
    	modelandview.addObject("Tname", select1bean.getTname());
    	re.getSession().setAttribute("C_id", select1bean.getCid());	
    	re.getSession().setAttribute("S_id", select1bean.getS_id());	
    	modelandview.setViewName("/student/select2");
		return modelandview;
	}
	
     
}
