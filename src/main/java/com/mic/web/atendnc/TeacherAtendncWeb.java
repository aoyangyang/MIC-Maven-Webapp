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
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.atendnc.Attendance;
import com.mic.bean.course.CourseNote;
import com.mic.bean.departments.Information;
import com.mic.bean.departments.PancakeDate;
import com.mic.bean.student.StudentArrive;
import com.mic.core.NoToClass;
import com.mic.service.atendnc.TeacherAtendncDo;

import net.sf.json.JSONArray;

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
	@Autowired
	private HttpSession se;
	
	/**
	 * 开始点到
	 * 添加考情表
	 * 添加考情信息表
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
		//拿到gps信息
		String mylat = re.getParameter("mylat");
		String mylong = re.getParameter("mylong");
		String temp = re.getParameter("temp");
		//获取状态
		Integer state = Integer.parseInt("1"+re.getParameter("state"));
		//----建立考勤数据-------
		//查询出课堂时间
		CourseNote couNote = teacherAtendncDo.getTimeMsg(noteId);
		
		
		
		String beginTime = couNote.getBegin_time();
		String endTime = couNote.getEnd_time();
		String time = noToClass.getTime(beginTime)+"/"+
						noToClass.getNo(beginTime)+"-"+
							noToClass.getNo(endTime);
		//记录地理位置
		String gpsMsg = mylat+"/"+mylong+"/"+temp;
		//写入数据库 并得到id
		
		
		Attendance atd = new Attendance();
		atd.setClassroom(gpsMsg);
		atd.setCourse_note_id(noteId);
		atd.setState(state);
		atd.setTime(time);
		Integer atdId = teacherAtendncDo.addAtendnc(atd);
		re.getSession().setAttribute("atdId", atdId);
		
		//2700000为45min
		//先填充全学生为缺勤
		//如果学生在这段时间有请假那么填充为请假
		//学生段可以选择考勤 然后替换为到课
		//得到时钟周期
		long bTime = teacherAtendncDo.getClockTimeDo(beginTime);
		long eTime = teacherAtendncDo.getClockTimeDo(endTime)+2700000;
		List<Integer> stuIdList = 
					teacherAtendncDo.getStuIdList(noteId);
		//执行操作 将信息核对并写入 考勤信息 表
		teacherAtendncDo.addInFoMation(stuIdList,atdId,bTime,eTime);
		
		
		//写入状态 以及模式
		Integer can = 1;
		Integer mode = 1;
		teacherAtendncDo.setCanAndMode(can,mode,noteId);
		
		
		return null;
	}
	
	/**
	 * 开始第二种点到
	 * 方法名：atendncPlayQc
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午11:19:56 
	 * 手机:17673111810
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/atendnc/play/qc")
	@ResponseBody
	public String atendncPlayQc(Integer noteId){
		NoToClass noToClass = new NoToClass();
		
		//----建立考勤数据-------
		//查询出课堂时间
		CourseNote couNote = teacherAtendncDo.getTimeMsg(noteId);
		
		String beginTime = couNote.getBegin_time();
		String endTime = couNote.getEnd_time();
		String time = noToClass.getTime(beginTime)+"/"+
						noToClass.getNo(beginTime)+"-"+
							noToClass.getNo(endTime);

		//写入数据库 并得到id
		
		Attendance atd = new Attendance();
		atd.setCourse_note_id(noteId);
		atd.setTime(time);
		Integer atdId = teacherAtendncDo.addAtendnc(atd);
		se.setAttribute("atdId", atdId);
		
		//2700000为45min
		//先填充全学生为缺勤
		//如果学生在这段时间有请假那么填充为请假
		//学生段可以选择考勤 然后替换为到课
		//得到时钟周期
		long bTime = teacherAtendncDo.getClockTimeDo(beginTime);
		long eTime = teacherAtendncDo.getClockTimeDo(endTime)+2700000;
		List<Integer> stuIdList = 
					teacherAtendncDo.getStuIdList(noteId);
		//执行操作 将信息核对并写入 考勤信息 表
		teacherAtendncDo.addInFoMation(stuIdList,atdId,bTime,eTime);
		
		
		//产生6位随机密码
		Random rand = new Random();
		Integer timeKey = rand.nextInt(999999);
		if (timeKey < 100000) {
			timeKey += 100000;
		}
		
		//将key 写入数据库
		teacherAtendncDo.setPword(timeKey,noteId);
		
		//写入状态 以及模式
		Integer can = 1;
		Integer mode = 2;
		teacherAtendncDo.setCanAndMode(can,mode,noteId);
		
		return timeKey+"";
	}
	
	/**
	 * 实时刷新课程 信息
	 * 方法名：getMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月29日-上午12:45:42 
	 * 手机:17673111810
	 * @param re
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/teacher/atendnc/getMsg",method = RequestMethod.POST,
			produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getMsg(HttpServletRequest re){
		JSONArray json = new JSONArray();
		Integer noteId = (Integer)re.getSession().getAttribute("atdId");
		Integer[] msg = {0,0,0};
		
		//如果没有就去查询
		if (noteId == null) {
			Integer couNoteId = (Integer) se.getAttribute("couNoteId");
			noteId = teacherAtendncDo.getAMsgId(couNoteId);
		}
		
		
		List<Information> ifomtionList = 
				teacherAtendncDo.getAMsg(noteId);
		for (Information information : ifomtionList) {
			if (information.getStatus().equals("到课")) {
				msg[0]++;
			}else if (information.getStatus().equals("请假")) {
				msg[1]++;
			}else{
				msg[2]++;
			}
		}
		json.add(msg[0]);
		json.add(msg[1]);
		json.add(msg[2]);
		return json.toString();
	}

	/**
	 * 停止点到
	 * 方法名：stopAtendnc
	 * 创建人：chenPeng
	 * 时间：2019年2月18日-下午9:04:01 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/atendnc/stop")
	public ModelAndView stopAtendnc(Integer noteId){
		ModelAndView andView = new ModelAndView("forward:/teacher/atendnc");
		
		teacherAtendncDo.stopAtendnc(noteId);
		
		andView.addObject("noteId", noteId);
		return andView;
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
		
		//初始化值
		andView.addObject("teaTemp", "0");
		
		se.setAttribute("couNoteId", noteId);
		
		//先查询是否已经点到了
		Integer atendncId = teacherAtendncDo.getAtendncId(noteId);

		//如果没有点到 那么建立点到  点到里面默认状态为0 
		//如果开始点到 那么状态变为1 结束点到 那么状态变为0
		//如果点到了 那么反馈到课信息  需要用ajax刷新  可以设置停止点到
		if (atendncId==null) {
			andView.addObject("noteId", noteId);
			andView.setViewName("teacher/atendenc");
		}else{
			//判断是否已经结束点到
			Integer can = teacherAtendncDo.getCan(noteId);
			if (can == 0) {
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
			}else{
				//判断是那种
				teacherAtendncDo.JudgeMode(andView, atendncId,noteId);
			}
		}
		return andView;
	}
	
	/**
	 * 第二种点到方式
	 * 方法名：initAtendnc2
	 * 创建人：chenPeng
	 * 时间：2019年2月17日-下午8:33:24 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/atendnc2")
	public ModelAndView initAtendnc2(Integer noteId){
		ModelAndView andView = new ModelAndView();
		
		//初始化值
		andView.addObject("teaTemp", "0");
		
		se.setAttribute("couNoteId", noteId);
		
		//先查询是否已经点到了
		Integer atendncId = teacherAtendncDo.getAtendncId(noteId);

		//如果没有点到 那么建立点到  点到里面默认状态为0 
		//如果开始点到 那么状态变为1 结束点到 那么状态变为0
		//如果点到了 那么反馈到课信息  需要用ajax刷新  可以设置停止点到
		if (atendncId==null) {
			andView.addObject("noteId", noteId);
			andView.setViewName("teacher/atendenc2");
		}else{
			//判断是否已经结束点到
			Integer can = teacherAtendncDo.getCan(noteId);
			if (can == 0) {
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
			}else{
				//判断是那种
				teacherAtendncDo.JudgeMode(andView, atendncId, noteId);
			}
		}
		return andView;
	}
	
}
