package com.mic.service.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.LoginUser;
import com.mic.bean.NameAndId;
import com.mic.dao.LoginUserDao;
/**
 * 
 * 
 * LoginUserDo
 * 创建人:Shanice
 * 时间：2018年8月16日-下午5:34:14 
 * @version 1.0.0
 *
 */
@Service
public class LoginUserDo {
	@Autowired
	private LoginUserDao loginUserDao;
	@Autowired
	private HttpServletRequest re;
	
	
	/**
	 * 
	 * 学生登录
	 * 方法名：studentLogin
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午8:55:39 
	 * 手机:15873158820
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	public ModelAndView studentLogin(String username, String password){
		
		LoginUser loginUser = new LoginUser();
		loginUser.setPassword(password);
		loginUser.setUsername(username);
		
		NameAndId nameAndId = loginUserDao.studentLogin(loginUser);
		if (nameAndId==null) {
			re.getSession().setAttribute("errorMessage", "账号或者密码错误");
			return new ModelAndView("redirect:/500.jsp");
		}  
		
		re.getSession().setAttribute("studentId", nameAndId.getId());
		re.getSession().setAttribute("studentName", nameAndId.getUsername());
		
		return new ModelAndView("redirect:/stuIndex");
	}
	
	/**
	 * 
	 * 老师登录
	 * 方法名：teacherLogin
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午8:56:08 
	 * 手机:15873158820
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	public ModelAndView teacherLogin(String username, String password){
		LoginUser loginUser = new LoginUser();
		loginUser.setUsername(username);
		loginUser.setPassword(password);
		
		NameAndId nameAndId =loginUserDao.teacherLogin(loginUser);
		if(nameAndId == null){
			re.getSession().setAttribute("errorMessage", "账号或者密码错误");
			return new ModelAndView("redirect:/500.jsp");
		}

		re.getSession().setAttribute("teacherId", nameAndId.getId());
		re.getSession().setAttribute("teacherName", nameAndId.getUsername());
		
		return new ModelAndView("redirect:/TeaIndex");
	}
	
	/**
	 * 
	 * 管理员登录
	 * 方法名：departmentLogin
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午8:56:41 
	 * 手机:15873158820
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	public ModelAndView departmentLogin(String username, String password){
		
		LoginUser loginUser = new LoginUser();
		loginUser.setPassword(password);
		loginUser.setUsername(username);
		
		NameAndId nameAndId = loginUserDao.leaderLogin(loginUser);
		
		if(nameAndId == null){
			re.getSession().setAttribute("errorMessage", "账户或者密码错误");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		
		return getAd(nameAndId);
		
	}
	
	/**
	 * 
	 * 判断是哪个管理员登录
	 * 方法名：getAd
	 * 创建人：Shanice
	 * 时间：2018年9月14日-下午9:02:36 
	 * 手机:15873158820
	 * @param nameAndId void
	 * @exception 
	 * @since  1.0.0
	 */
	public ModelAndView getAd(NameAndId nameAndId){
		Integer adClass = loginUserDao.adClassLogin(nameAndId.getId());
		Integer adDepartment = loginUserDao.adDepartmentLogin(nameAndId.getId());
		Integer adSchool = loginUserDao.adSchoolLogin(nameAndId.getId());
		if(adClass != null){ //辅导员
			re.getSession().setAttribute("adClassId", nameAndId.getId());
			re.getSession().setAttribute("adClassName", nameAndId.getUsername());
			return new ModelAndView("redirect:/InsIndex");
		}
		if(adDepartment != null){//学工组
			re.getSession().setAttribute("adDepartmentId", nameAndId.getId());
			re.getSession().setAttribute("adDepartmentName", nameAndId.getUsername());
			return new ModelAndView("redirect:/DepIndex");
		}
		if(adSchool != null){//院领导
			re.getSession().setAttribute("adSchoolId", nameAndId.getId());
			re.getSession().setAttribute("adSchoolName", nameAndId.getUsername());
			return new ModelAndView("redirect:/SchIndex");
		}
		re.getSession().setAttribute("errorMessage", "账户或者密码错误");
		return new ModelAndView("redirect:/500.jsp");
	}
}
