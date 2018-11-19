/**
 * chenPeng
 * com.mic.service
 * LeaderDepAddDo.java
 * 创建人:chenpeng
 * 时间：2018年8月4日-下午5:23:19 
 * 2018陈鹏-版权所有
 */
package com.mic.service.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.AdSchool;
import com.mic.bean.Leader;
import com.mic.bean.School;
import com.mic.core.CpJudge;
import com.mic.core.NoteIsNull;
import com.mic.dao.LeaderDepAddDao;

/**
 * 
 * LeaderDepAddDo
 * 创建人:chenPeng
 * 时间：2018年8月4日-下午5:23:19 
 * @version 1.0.0
 * 
 */
@Service
public class LeaderDepAddDo {
	@Autowired
	private LeaderDepAddDao leaderDepAddDao;
	@Autowired
	private HttpServletRequest re;
	/**
	 * 得到all的学校
	 * 方法名：getAllSchool
	 * 创建人：chenPeng
	 * 时间：2018年8月4日-下午5:25:18 
	 * 手机:17673111810
	 * @return List<AddSchool>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<School> getAllSchool(){
		return leaderDepAddDao.getSchool();
	}
	
	public ModelAndView leaderDepAdd(Leader leader, String school){
		ModelAndView andView = new ModelAndView();
		NoteIsNull noteIsNull = new NoteIsNull();
		CpJudge cpJudge = new CpJudge();
		
		//判断空
		if(!noteIsNull.noteIsNull(leader.getUsername())||
					!noteIsNull.noteIsNull(leader.getPhone())||
					!noteIsNull.noteIsNull(leader.getPassword())||
					!noteIsNull.noteIsNull(leader.getAddress())||
					!noteIsNull.noteIsNull(leader.getEmail())||
					!noteIsNull.noteIsNull(school)){
			re.getSession().setAttribute("errorMessage", "填写信息中有空值");
			return new ModelAndView("redirect:/500.jsp");
		}
		//信息规范
		if(!cpJudge.isEmail(leader.getEmail())||
				!cpJudge.isPhone(leader.getPhone())){
			re.getSession().setAttribute("errorMessage", "信息填写未按规范");
			return new ModelAndView("redirect:/500.jsp");
		}
		
		//写入数据库
		AdSchool adSchool = new AdSchool();
		
		leaderDepAddDao.setLeader(leader);
		
		
		adSchool.setLeader_id(leader.getId());
		adSchool.setSchool_id(Integer.parseInt(school));
		leaderDepAddDao.setAdSchool(adSchool);
		
		andView.setViewName("Login");
		return andView;
	}
}
