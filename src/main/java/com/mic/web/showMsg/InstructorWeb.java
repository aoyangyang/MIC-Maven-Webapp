/**
 * chenPeng
 * com.mic.web
 * InstructorWeb.java
 * 创建人:chenpeng
 * 时间：2018年8月12日-下午8:38:21 
 * 2018陈鹏-版权所有
 */
package com.mic.web.showMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.other.TimeAndId;
import com.mic.core.NoToClass;
import com.mic.service.showMsg.InstructorDo;


/**
 * 辅导员
 * InstructorWeb
 * 创建人:chenPeng
 * 时间：2018年8月12日-下午8:38:21 
 * @version 1.0.0
 * 
 */
@Controller
public class InstructorWeb {
	@Autowired
	private InstructorDo instructorDo;
	
	/**
	 * 得到辅导员的全部班级
	 * 方法名：initInstructor
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午9:06:36 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/instructor")
	public ModelAndView initInstructor(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("statistics/instructorChoose");
		andView.addObject("ClasssList", instructorDo.getClasss());
		return andView;
	}
	 
	@RequestMapping(value="/instructor/fond",method=RequestMethod.POST)
	public ModelAndView instructorFond(
			String date,Integer classs,Integer section){
		
		NoToClass noToClass = new NoToClass();
		TimeAndId timeAndId = new TimeAndId();
		
		date = date+noToClass.noToClass(section);
		
		timeAndId.setId(classs);
		timeAndId.setTime(date);
		
		return instructorDo.addDate(timeAndId);
	}
}
