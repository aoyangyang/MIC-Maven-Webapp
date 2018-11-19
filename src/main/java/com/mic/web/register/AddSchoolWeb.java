/**
 * chenPeng
 * com.mic.web
 * AddSchool.java
 * 创建人:chenpeng
 * 时间：2018年7月31日-上午11:39:04 
 * 2018陈鹏-版权所有
 */
package com.mic.web.register;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.core.NoteIsNull;
import com.mic.service.register.AddSchoolDo;

/**
 * 
 * AddSchool
 * 创建人:chenPeng
 * 时间：2018年7月31日-上午11:39:04 
 * @version 1.0.0
 * 
 */
@Controller
public class AddSchoolWeb {
	@Autowired
	private AddSchoolDo addSchoolDo;
	
	
	/**
	 * 管理员到跳转添加学校的页面 
	 * 方法名：goToAddSchool
	 * 创建人：chenPeng
	 * 时间：2018年7月31日-下午12:01:50 
	 * 手机:17673111810
	 * 
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/admin/addSchool")
	public ModelAndView initAddSchool(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/addSchool");
		return modelAndView;
	}
	
	/**
	 * 执行添加学校
	 * 方法名：addSchoolDo
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午1:40:59 
	 * 手机:17673111810
	 * @param re
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/admin/addSchoolDo",method = RequestMethod.POST)
	public ModelAndView addSchoolDo(HttpServletRequest re){
		ModelAndView modelAndView = new ModelAndView();
		NoteIsNull noteIsNull = new NoteIsNull();
		int numbers = 0;
		String name = "";
		
		String schoolName = re.getParameter("schoolName");
		//学校名为空
		if(!noteIsNull.noteIsNull(schoolName)){
			re.getSession().setAttribute("errorMessage", "学校名为空");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		List<String> nameList = new ArrayList<String>();
		for (int i = 0;;i++) {
			name = re.getParameter("button"+i);
			//为空即未添加到这里
			if(name == null){
				break;
			}
			//值为空那么用户添加数据有问题
			if(!noteIsNull.noteIsNull(name)){
				//提示错误信息
				re.getSession().setAttribute("errorMessage", "学院/学部名称有值为空");
				return new ModelAndView("redirect:/500.jsp");	
			}
			nameList.add(name);
		}
		addSchoolDo.addSchool(schoolName, nameList);
		
		return modelAndView;
	}
	
	
}
