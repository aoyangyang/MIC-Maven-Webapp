/**
 * lei
 * com.mic.Web
 * AholidayWeb.java
 * 创建人:lei
 * 时间：2018年11月03日-下午7:44:04
 * 2018lei-版权所有
 */
package com.mic.web.lei;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.AholidayBean;
import com.mic.service.lei.AholidayDo;
import com.mic.service.lei.approvalHolidayDo;
import com.mic.bean.approvalHolidayBean;

/**
 * 批假
 * AholidayWeb
 * 创建人:lei
 * 时间：2018年11月03日-下午7:44:04
 * @version 1.0.0
 * 
 */
@Controller
public class AholidayWeb {
	@Autowired
	private AholidayDo aholidaydo;
	@Autowired
	private approvalHolidayDo approvalHolidaydo;
	@Autowired
	private HttpServletRequest re;
	
	
	@RequestMapping("/AHoliday")
	public ModelAndView AHoliday(){
		ModelAndView mo = new ModelAndView();
		
		Integer caClassId = (Integer) re.getSession().getAttribute("adClassId");
    	List<AholidayBean> aholidayBean = aholidaydo.AholidayDos(caClassId);
    	
    	mo.setViewName("instructor/AHoliday");
    	mo.addObject("aholidaybean", aholidayBean);
		return mo;
	}
	
	@RequestMapping(value="/AHolidayWeb ", method = RequestMethod.POST)
	public ModelAndView ID(HttpServletRequest re){
		ModelAndView modelandview = new ModelAndView();
		List<String> CourseName = new ArrayList<String>();
		Integer id = Integer.parseInt(re.getParameter("id"));
		re.getSession().setAttribute("id", id);
		approvalHolidayBean aholidaybean = approvalHolidaydo.approvalHolidayDo(
				Integer.parseInt(re.getSession().getAttribute("id").toString()));
		CourseName = approvalHolidaydo.GetCoursename(aholidaybean.getId(), aholidaybean.getE_time());
		modelandview.addObject("CourseName", CourseName);
		modelandview.addObject("studentname", aholidaybean.getStudentname());
		modelandview.addObject("id", aholidaybean.getId());
		modelandview.addObject("school", aholidaybean.getSchool());
		modelandview.addObject("classname", aholidaybean.getClassname());
		modelandview.addObject("s_phone", aholidaybean.getS_phone());
		modelandview.addObject("b_time", aholidaybean.getB_time());
		modelandview.addObject("e_time", aholidaybean.getE_time());
		modelandview.addObject("reason", aholidaybean.getReason());
		modelandview.setViewName("/instructor/approvalHoliday");
		return modelandview;
 }
}
