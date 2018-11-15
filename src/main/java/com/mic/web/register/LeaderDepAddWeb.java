/**
 * chenPeng
 * com.mic.web
 * LeaderDepAddWeb.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午3:34:46 
 * 2018陈鹏-版权所有
 */
package com.mic.web.register;

 import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Leader;
import com.mic.service.LeaderDepAddDo;


/**
 * 
 * 院领导注册
 * LeaderDepAddWeb
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午3:34:46 
 * @version 1.0.0
 * 
 */
@Controller
public class LeaderDepAddWeb {
	@Autowired
	private LeaderDepAddDo leaderDepAddDo;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 初始化领导注册页面
	 * 方法名：initLeaderDepAdd
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午5:28:14 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("LeaderDepAdd")
	public ModelAndView initLeaderDepAdd(){
		 ModelAndView andView = new ModelAndView();
		 andView.addObject("schoolList", leaderDepAddDo.getAllSchool());
		 andView.setViewName("add/LeaderDepAdd");
		 return andView;
	}
	
	/**
	 * 写入院领导注册
	 * 方法名：LeaderDepAddDo
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-下午4:14:18 
	 * 手机:17673111810
	 * @param username
	 * @param tel
	 * @param password1
	 * @param password2
	 * @param address
	 * @param email
	 * @param school
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="LeaderDepAddDo",method = RequestMethod.POST)
	public ModelAndView LeaderDepAddDo(
			String username,
			String tel,
			String password1,
			String password2,
			String address,
			String email,
			String school){
		if(!password1.equals(password2)){
			re.getSession().setAttribute("errorMessage", "两次密码不一致");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		Leader leader= new Leader();
		
		leader.setAddress(address);
		leader.setEmail(email);
		leader.setPassword(password1);
		leader.setPhone(tel);
		leader.setUsername(username);
		
		return leaderDepAddDo.leaderDepAdd(leader,school);
	}
}
