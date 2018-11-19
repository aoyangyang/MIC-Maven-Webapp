/**
 * chenPeng
 * com.mic.service
 * LeaderWorkAddDO.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午10:13:23 
 * 2018陈鹏-版权所有
 */
package com.mic.service.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.AdDepartments;
import com.mic.bean.Departments;
import com.mic.bean.Leader;
import com.mic.bean.School;
import com.mic.core.CpJudge;
import com.mic.core.NoteIsNull;
import com.mic.dao.LeaderWorkAddDao;

/**
 * 
 * LeaderWorkAddDO
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午10:13:23 
 * @version 1.0.0
 * 
 */
@Service
public class LeaderWorkAddDo {
	@Autowired
	private LeaderWorkAddDao leaderWorkAddDao;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 得到all的学校
	 * 方法名：getSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-上午11:04:06 
	 * 手机:17673111810
	 * @return List<School>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<School> getSchool(){
		return leaderWorkAddDao.getSchool();
	}
	
	/**
	 * 得到指定学部、学院
	 * 方法名：getDepartments
	 * 创建人：chenPeng
	 * 时间：2018年8月5日-上午11:05:21 
	 * 手机:17673111810
	 * @param schoolNo
	 * @return List<Departments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Departments> getDepartments(Integer schoolNo){
		return leaderWorkAddDao.getDepartments(schoolNo);
	}
	
	public ModelAndView addLeaderWorkAdd(
			Leader leader, String schoolName, String departments){
		ModelAndView andView = new ModelAndView();
		NoteIsNull noteIsNull = new NoteIsNull();
		CpJudge cpJudge = new CpJudge();
		
		//判断空
		if(!noteIsNull.noteIsNull(leader.getAddress())||
					!noteIsNull.noteIsNull(leader.getEmail())||
					!noteIsNull.noteIsNull(leader.getPassword())||
					!noteIsNull.noteIsNull(leader.getPhone())||
					!noteIsNull.noteIsNull(leader.getUsername())||
					!noteIsNull.noteIsNull(schoolName)||
					!noteIsNull.noteIsNull(departments)){
			re.getSession().setAttribute("errorMessage", "填写信息中有空值");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//判断规范
		if(!cpJudge.isEmail(leader.getEmail())||
				!cpJudge.isPhone(leader.getPhone())){
			re.getSession().setAttribute("errorMessage", "信息填写未按规范");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//写入数据
		AdDepartments adDepartments = new AdDepartments();
		leaderWorkAddDao.setLeader(leader);
		
		adDepartments.setDepartments_id(Integer.parseInt(departments));
		adDepartments.setLeader_id(leader.getId());
		leaderWorkAddDao.setAdDepartments(adDepartments);
		
		andView.setViewName("Login");
		return andView;
	}
}
