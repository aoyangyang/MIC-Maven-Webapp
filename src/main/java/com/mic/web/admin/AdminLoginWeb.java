/**
 * chenPeng
 * com.mic.web.admin
 * AdminLogin.java
 * 创建人:chenpeng
 * 时间：2018年12月29日-上午1:58:36 
 * 2018陈鹏-版权所有
 */
package com.mic.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Admin;
import com.mic.bean.Leader;
import com.mic.bean.Teacher;
import com.mic.bean.school.School;
import com.mic.bean.student.Student;
import com.mic.service.admin.AdminLoginDo;


/**
 * 
 * AdminLogin
 * 创建人:chenPeng
 * 时间：2018年12月29日-上午1:58:36 
 * @version 1.0.0
 * 
 */
@Controller
public class AdminLoginWeb {
	@Autowired
	private AdminLoginDo adminLoginDo;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 初始化登录页面
	 * 方法名：initAdminLogin
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午2:04:01 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/adminLogin")
	public ModelAndView initAdminLogin(){
		ModelAndView andView = new ModelAndView();
		
		andView.setViewName("adminLogin");
		return andView;
	}
	
	/**
	 * 
	 * 登陸
	 * 方法名：adminLoginDo
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午2:09:31 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/adminLoginDo",method = RequestMethod.POST )
	public ModelAndView adminLoginDo(String username,String password){
		ModelAndView andView = new ModelAndView();
		
		if (username.equals("")||password.equals("")) {
			andView.setViewName("adminLogin");
			return andView;
		}
		
		Admin admin = adminLoginDo.adminLogin(username,password);
		
		if (admin==null) {
			andView.setViewName("adminLogin");
			return andView;
		}
		re.getSession().setAttribute("admin", admin);
		
		return new ModelAndView("redirect:/admin/adminIndex");
	}
	
	/**
	 * 初始化admjin首页
	 * 方法名：initAdminIndex
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午2:37:13 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/admin/adminIndex")
	public ModelAndView initAdminIndex(){
		ModelAndView andView = new ModelAndView();
			
		List<Leader> leaderList = adminLoginDo.getLeaderList(1);
		List<Student> stuList = adminLoginDo.getStuList(1);
		List<Teacher> teaList = adminLoginDo.getTeaList(1);
		List<School> schList = adminLoginDo.getSchList(1);
		
		Integer leaderPage = adminLoginDo.getLeaderPage();
		Integer stuPage = adminLoginDo.getStuPage();
		Integer teaPage = adminLoginDo.getTeaPage();
		Integer schPage = adminLoginDo.getSchPage();
		
		andView.addObject("leaderList", leaderList);
		andView.addObject("stuList", stuList);
		andView.addObject("teaList", teaList);
		andView.addObject("schList", schList);
		
		andView.addObject("leaderPage", leaderPage);
		andView.addObject("stuPage", stuPage);
		andView.addObject("teaPage", teaPage);
		andView.addObject("schPage", schPage);
		
		andView.setViewName("admin/adminIndex");
		
		return andView;
	}
	
}
