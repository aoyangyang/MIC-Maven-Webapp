package com.mic.web.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mic.core.NoteIsNull;

@Controller
public class SchIndex {
	@Autowired
	private HttpServletRequest re;
	/**
	 * 登陆之后跳转到这个页面
	 * 方法名：initInsIndex
	 * 创建人：chenPeng
	 * 时间：2018年10月30日-上午3:25:32 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/SchIndex")
	public ModelAndView initSchIndex(){
		
		String adClassName = (String)re.getSession().getAttribute("adSchoolName");
		NoteIsNull noteIsNull = new NoteIsNull();
		
		if (noteIsNull.noteIsNull(adClassName)) {
			ModelAndView andView = new ModelAndView();
			andView.setViewName("statistics/schIndex");
			return andView;
		}else {
			re.getSession().setAttribute("errorMessage", "请登陆！！");
			return new ModelAndView("redirect:/500.jsp");
		}
	}
}
