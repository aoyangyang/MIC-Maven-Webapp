package com.mic.web.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mic.core.NoteIsNull;

@Controller
public class TeaIndexWeb {
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 登陆之后跳转到这个页面
	 * 方法名：initStuIndex
	 * 创建人：chenPeng
	 * 时间：2018年10月30日-上午3:24:42 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/TeaIndex")
	public ModelAndView initStuIndex(){
		//拿到域里面的东西用作潘盾
		String stuName = (String)re.getSession().getAttribute("teacherName");
		
		NoteIsNull noteIsNull = new NoteIsNull();
		
		//判断是否已经登陆了 如果未登陆就跳转到登陆
		if (noteIsNull.noteIsNull(stuName)) {
			ModelAndView andView = new ModelAndView();
			andView.setViewName("teacher/teaIndex");
			return andView;
		}else {
			re.getSession().setAttribute("errorMessage", "请登陆！！");
			return new ModelAndView("redirect:/500.jsp");
		}
	}
}
