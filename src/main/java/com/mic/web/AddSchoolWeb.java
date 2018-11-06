/**
 * chenPeng
 * com.mic.web
 * AddSchool.java
 * 创建人:chenpeng
 * 时间：2018年7月31日-上午11:39:04 
 * 2018陈鹏-版权所有
 */
package com.mic.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.service.AddSchoolDo;

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
		System.out.println("122");
		modelAndView.setViewName("admin/addSchool");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/admin/addSchoolDo",method = RequestMethod.POST)
	public ModelAndView addSchoolDo(HttpServletRequest re){
		ModelAndView modelAndView = new ModelAndView();
		String schoolName = re.getParameter("schoolName");
		int numbers = 0;
		String name = "";
		List<String> nameList = new ArrayList<String>();
		for (int i = 0;;i++) {
			name = re.getParameter("button"+i);
			if(name == null){
				break;
			}
			nameList.add(name);
		}
		
		addSchoolDo.addSchool(schoolName, nameList);
		
		return modelAndView;
	}
	
	
}
