/**
 * chenPeng
 * com.mic.web.atendnc
 * TeacherAtendnc.java
 * 创建人:chenpeng
 * 时间：2018年11月20日-下午4:31:40 
 * 2018陈鹏-版权所有
 */
package com.mic.web.atendnc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.course.CourseNote;
import com.mic.bean.departments.Information;
import com.mic.bean.departments.PancakeDate;
import com.mic.bean.student.StudentArrive;
import com.mic.core.NoToClass;
import com.mic.service.atendnc.TeacherAtendncDo;

/**
 * 先判断这堂课点到了没
 * 如果点到了 那么久调到点到页面去
 * 如果没有点到 就执行点到操作
 * 
 * 老师点击点到
 * TeacherAtendnc
 * 创建人:chenPeng
 * 时间：2018年11月20日-下午4:31:40 
 * @version 1.0.0
 * 
 */
@Controller
public class TeacherAtendncWeb {
	@Autowired
	private TeacherAtendncDo teacherAtendncDo;
	
	/**
	 * 开始点到
	 * 方法名：play
	 * 创建人：chenPeng
	 * 时间：2018年11月22日-下午7:18:12 
	 * 手机:17673111810
	 * @param re
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method = RequestMethod.POST, 
						value = "/teacher/atendnc/play", 
						produces = "application/String; charset=utf-8")
	@ResponseBody
	public String play(HttpServletRequest re){
		NoToClass noToClass = new NoToClass();
		//拿到课堂id
		Integer noteId = Integer.parseInt(re.getParameter("noteId"));
		
		
		//建立考勤数据
		//查询出课堂时间
		CourseNote couNote = teacherAtendncDo.getTimeMsg(noteId);
		
		String beginTime = couNote.getBegin_time();
		String endTime = couNote.getEnd_time();
		String time = noToClass.getTime(beginTime)+"/"+
						noToClass.getNo(beginTime)+"-"+
							noToClass.getNo(endTime);
		
		
		
		//先填充全学生为缺勤
		//如果学生在这段时间有请假那么填充为请假
		//学生段可以选择考勤 然后替换为到课
		List<Integer> stuIdList = teacherAtendncDo.getStuIdList(noteId);
		for (Integer integer : stuIdList) {
			System.out.println(integer);
		}
		
		
		
		return null;
	}
	
	
	
	/**
	 * 
	 * 点到操作
	 * 判断是否以及点到了的
	 * 如果点到了的那么久直接展示出统计结果
	 * 如果没有点到那么就建立一个新的点到
	 * 
	 * 方法名：initAtendnc
	 * 创建人：chenPeng
	 * 时间：2018年11月22日-下午7:16:08 
	 * 手机:17673111810
	 * @param noteId
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/teacher/atendnc",method = RequestMethod.POST)
	public ModelAndView initAtendnc(Integer noteId){
		ModelAndView andView = new ModelAndView();
		
		//先查询是否已经点到了
		Integer atendncId = teacherAtendncDo.getAtendncId(noteId);

		//如果没有点到 那么建立点到  点到里面默认状态为0 
		//如果开始点到 那么状态变为1 结束点到 那么状态变为0
		//如果点到了 那么反馈到课信息  需要用ajax刷新  可以设置停止点到
		if (atendncId==null) {
			andView.addObject("noteId", noteId);
			andView.setViewName("teacher/atendenc");
		}else{
			//传入考勤id拿到该节课的全部考勤信息
			List<Information> ifomtionList = 
					teacherAtendncDo.getAMsg(atendncId);	
			
			//拿到饼图
			PancakeDate pancakeDate = 
					teacherAtendncDo.getPancakeDate(ifomtionList);
			
			pancakeDate.setPanckeName("考勤信息");
			//拿到缺勤信息
			List<StudentArrive> absenceList = 
					teacherAtendncDo.getAbsenceList(ifomtionList);
					
			//拿到请假信息
			List<StudentArrive> leaveList = 
					teacherAtendncDo.getLeaveList(ifomtionList);
			
			andView.addObject("pancakeDate", pancakeDate);
			andView.addObject("absenceList", absenceList);
			andView.addObject("leaveList", leaveList);
			andView.setViewName("teacher/atendncMsg");
		}
		return andView;
	}
}
