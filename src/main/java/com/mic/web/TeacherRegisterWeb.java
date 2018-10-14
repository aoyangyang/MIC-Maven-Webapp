/**
 * Shanice
 * com.mic.web;
 * TeacherRegisterWeb.java
 * 创建人:Shanice
 * 时间：2018年8月5日-下午7:44:01  
 * 2018李向阳-版权所有
 */
package com.mic.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.TeacherRegister;
import com.mic.service.TeacherRegisterDo;

                                                     
/**
 * 
 * 
 * TeacherRegisterWeb
 * 创建人:Shanice
 * 时间：2018年8月5日-下午7:44:01 
 * @version 1.0.0
 *
 */
@Controller
public class TeacherRegisterWeb {
	@Autowired
	private HttpServletRequest re;
	@Autowired
	private TeacherRegisterDo teacherRegisterDo;
	/**
	 * 
	 * 老师登录跳转到注册界面
	 * 方法名：teacherRegister
	 * 创建人：Shanice
	 * 时间：2018年8月5日-下午9:03:02 
	 * 手机:15873158820
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	
	@RequestMapping("/add/teacherRegister")
	public ModelAndView teacherRegister(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("add/teacherRegister");
		return modelAndView;
	}
	
	/**
	 * 
	 * 提取数据装起来写入
	 * 方法名：teacherRegisterDo
	 * 创建人：Shanice
	 * 时间：2018年8月8日-下午5:50:17 
	 * 手机:15873158820
	 * @param name
	 * @param password
	 * @param password1
	 * @param email
	 * @param address
	 * @param phone
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/TeacherRegisterDo",method = RequestMethod.POST)
	public ModelAndView teacherRegisterDo(
			String name,
			String password,
			String password1,
			String email,
			String address,
			String phone
			){
		ModelAndView andView =new ModelAndView();
		if(!password.equals(password1)){
			re.getSession().setAttribute("errorMessage","两次的密码不一致");
			return new ModelAndView("redirect:/500.jsp");
			
		}
		//装起来
		TeacherRegister register = new TeacherRegister();
		register.setUsername(name);
		register.setPassword(password);
		register.setEmail(address);
		register.setEmail(email);
		register.setPhone(phone);
		  
		//写入
		teacherRegisterDo.TeacherRegisterDao(register);
		andView.setViewName("Login");
		return andView;
	}
	
	
	
}
