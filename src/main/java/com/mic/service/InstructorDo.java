/**
 * chenPeng
 * com.mic.service
 * Instructor.java
 * 创建人:chenpeng
 * 时间：2018年8月12日-下午8:48:04 
 * 2018陈鹏-版权所有
 */
package com.mic.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.Classs;
import com.mic.bean.Information;
import com.mic.bean.PancakeDate;
import com.mic.bean.StudentArrive;
import com.mic.bean.TimeAndId;
import com.mic.core.NoToClass;
import com.mic.dao.InstructorDao;

/**
 * 辅导员
 * Instructor
 * 创建人:chenPeng
 * 时间：2018年8月12日-下午8:48:04 
 * @version 1.0.0
 * 
 */
@Service
public class InstructorDo {
	@Autowired
	private HttpServletRequest re;
	@Autowired
	private InstructorDao instructorDao;
	/**
	 * 得到辅导员的全部班级
	 * 方法名：getClasss
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午9:07:20 
	 * 手机:17673111810
	 * @return List<Classs>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getClasss(){
		//get辅导员id
		Integer adClassId = 
				(Integer) re.getSession().getAttribute("adClassId");
		return instructorDao.getClasss(1);
	}
	
	public ModelAndView addDate(TimeAndId timeAndId){
		ModelAndView andView = new ModelAndView();
		List<Information> informationList = 
				instructorDao.getAllInfMation(timeAndId);
		
		//饼状图
		PancakeDate pancakeDate = new PancakeDate();
		
		//状态
		String staus = "";
		int studentId = 0;
		
		//缺勤
		Integer absence = 0;
		//请假
		Integer leave = 0;
		//正常
		Integer attendance = 0;
		
		//时间转换
		NoToClass noToClass = new NoToClass();
		String times = timeAndId.getTime();
		String time = noToClass.getTime(times);
		time = time+"   第"+noToClass.classToNo(times)+"大节";
		
		//得到学校名称
		String panckeName = instructorDao.getClassName(timeAndId.getId());
		
		//缺勤
		List<StudentArrive> absenceList = new ArrayList<StudentArrive>();
		StudentArrive student;
		
		//请假
		List<StudentArrive> leaveList = new ArrayList<StudentArrive>();
		
		//遍历得到的考情信息
		for (Information information : informationList) {
			staus = information.getStatus();
			studentId = information.getStudent_id();
			if (staus.equals("到课")) {
				attendance++;
			}else if (staus.equals("请假")) {
				student = instructorDao.getAbsence(studentId);
				student.setTime(time);
				leaveList.add(student);
				leave++;
			}else if(staus.equals("缺勤")){
				student = instructorDao.getAbsence(studentId);
				student.setTime(time);
				absenceList.add(student);
				absence++;
			}
		}
		//放入饼图
		pancakeDate.setAbsence(absence);
		pancakeDate.setAttendance(attendance);
		pancakeDate.setLeave(leave);
		pancakeDate.setPanckeName(panckeName);
		
		
		//ModelAndview
		andView.addObject("pancakeDate", pancakeDate);
		andView.addObject("absenceList", absenceList);
		andView.addObject("leaveList", leaveList);
		andView.setViewName("statistics/details");
		return andView;
	}
}
