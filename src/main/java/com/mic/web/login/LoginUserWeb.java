/**
 * Shanice
 * com.mic.web
 * LoginUserWeb.java
 * 创建人:Shanice
 * 时间：2018年8月8日-下午6:03:34 
 * 2018李向阳-版权所有
 */
package com.mic.web.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.core.LoginClean;
import com.mic.service.login.LoginUserDo;

/**
 * 
 * 
 * LoginWeb
 * 创建人:Shanice
 * 时间：2018年8月8日-下午6:03:47 
 * @version 1.0.0
 *
 */
@Controller
public class LoginUserWeb {
	@Autowired
	private LoginUserDo loginUserDo;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 跳转到登录
	 * 方法名：loginUser
	 * 创建人：Shanice
	 * 时间：2018年8月16日-下午4:23:29 
	 * 手机:15873158820
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/Login")
	public ModelAndView loginUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	/**
	 * 登录执行
	 * 方法名：loginDo
	 * 创建人：Shanice
	 * 时间：2018年8月16日-下午5:14:56 
	 * 手机:15873158820
	 * @param username
	 * @param password
	 * @param defined
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/loginDo",method=RequestMethod.POST)
	public ModelAndView loginDo(
				String username,
				String password,
				Integer defined
			){
		//先清除登录状态
		LoginClean claen = new LoginClean();
		claen.clearAll(re);
		
		//判断信息是否正确
		if(username.equals("")||password.equals("")||defined.equals("")){
			re.getSession().setAttribute("errorMessage", "填写信息有误");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//更具用户的选择进行相应的登陆
		if(defined == 3){
			return loginUserDo.studentLogin(username,password);
		}else if (defined == 2) {
			return loginUserDo.teacherLogin(username,password);
		}else if (defined == 1) {
			return loginUserDo.departmentLogin(username,password);
		}else {
			re.getSession().setAttribute("errorMessage", "选择有误");
			return new ModelAndView("redirect:/stuIndex");
		}
	}
	
	/**
	 * 
	 * 登出
	 * 方法名：loginOut
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午3:47:50 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(){
		ModelAndView andView = new ModelAndView();
		
		//先清除登录状态
		LoginClean claen = new LoginClean();
		claen.clearAll(re);
		
		andView.setViewName("login");
		return andView;
	}
}
