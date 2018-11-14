/**
 * lei
 * com.mic.Web
 * approvalHolidayWeb.java
 * 创建人:lei
 * 时间：2018年11月05日-下午1:07:04
 * 2018lei-版权所有
 */
package com.mic.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.service.approvalHolidayDo;;

/**
 * 
 * AholidayWeb
 * 创建人:lei
 * 时间：2018年11月03日-下午7:44:04
 * @version 1.0.0
 * 
 */
@Controller
public class approvalHolidayWeb {
	@Autowired
	private approvalHolidayDo approvalHolidaydo;
	
	@RequestMapping(value="/approvalHolidayWeb", method = RequestMethod.POST)
	public ModelAndView AHoliday(HttpServletRequest re){
		ModelAndView mo = new ModelAndView();
		approvalHolidaydo.modify(Integer.parseInt(re.getSession().getAttribute("id").toString()), re.getParameter("state"));
		return mo;
	}
}
