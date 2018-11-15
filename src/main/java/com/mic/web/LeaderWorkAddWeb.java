/**
 * chenPeng
 * com.mic.web
 * LeaderWorkAddWeb.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午10:13:51 
 * 2018陈鹏-版权所有
 */
package com.mic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Departments;
import com.mic.bean.Leader;
import com.mic.service.LeaderWorkAddDo;

import net.sf.json.JSONArray;

/**
 * 
 * LeaderWorkAddWeb
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午10:13:51 
 * @version 1.0.0
 * 
 */
@Controller
public class LeaderWorkAddWeb {
	@Autowired
	private LeaderWorkAddDo leaderWorkAddDo;
	@Autowired
	private HttpServletRequest re;
	
	
	/**
	 * 初始化LeaderWorkAdd
	 * 方法名：initLeaderWorkAdd
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午10:19:49 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/LeaderWorkAdd")
	public ModelAndView initLeaderWorkAdd(){
		ModelAndView andView = new ModelAndView();
		andView.addObject("schoolList", leaderWorkAddDo.getSchool());
		andView.setViewName("add/LeaderWorkAdd");
		return andView;
	}
	
	/**
	 * ajax动态刷新学部信息
	 * 方法名：logined
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-上午11:56:33 
	 * 手机:17673111810
	 * @param request
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,
						value="/getDepartments",
							produces = "application/String; charset=utf-8")
	@ResponseBody
	public String logined(HttpServletRequest request){
		Integer schoolNo = 
				Integer.parseInt(request.getParameter("schoolName"));
		
		List<Departments> departmentsList = 
				leaderWorkAddDo.getDepartments(schoolNo);
		 
		JSONArray jsonArray = new JSONArray();
		for (Departments departments : departmentsList) {
			jsonArray.add(departments);
		}
		
		return jsonArray.toString();
	}
	
	
	
	/**
	 * 学工组注册
	 * 方法名：addLeaderWorkAdd
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午3:59:01 
	 * 手机:17673111810
	 * @param username
	 * @param phone
	 * @param password1
	 * @param password2
	 * @param home
	 * @param email
	 * @param schoolName
	 * @param departments
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/addLeaderWorkAdd",method=RequestMethod.POST)
	public ModelAndView addLeaderWorkAdd(
				String username,
				String phone,
				String password1,
				String password2,
				String home,
				String email,
				String schoolName,
				String departments
			){
		
		if(!password1.equals(password2)){
			re.getSession().setAttribute("errorMessage", "两次密码不一致");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		
		
		
		Leader leader = new Leader();
		leader.setAddress(home);
		leader.setEmail(email);
		leader.setPassword(password1);
		leader.setPhone(phone);
		leader.setUsername(username);
		
		return leaderWorkAddDo.addLeaderWorkAdd(leader,schoolName,departments);
	}
}
