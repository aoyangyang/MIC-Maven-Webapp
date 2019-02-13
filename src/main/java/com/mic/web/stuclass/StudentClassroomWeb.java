/**
 * chenPeng
 * com.mic.web.stuclass
 * StudentClassroom.java
 * 创建人:chenpeng
 * 时间：2019年2月12日-下午3:22:48 
 * 2019陈鹏-版权所有
 */
package com.mic.web.stuclass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.course.CourseNote;
import com.mic.bean.course.StuCourse;
import com.mic.bean.db.Problems;
import com.mic.service.question.TeacherQuestionDo;
import com.mic.service.stuclass.StudentClassroomDo;

/**
 * 
 * StudentClassroom
 * 创建人:chenPeng
 * 时间：2019年2月12日-下午3:22:48 
 * @version 1.0.0
 * 
 */
@Controller
public class StudentClassroomWeb {
	@Autowired
	private StudentClassroomDo studentClassroomDo;
	@Autowired
	private TeacherQuestionDo teacherQuestionDo;
	@Autowired
	private HttpSession se;
	
	/**
	 * 初始化页面
	 * 方法名：initStuClassroom
	 * 创建人：chenPeng
	 * 时间：2019年2月12日-下午3:28:43 
	 * 手机:17673111810 
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/student/stuClassroom")
	public ModelAndView initStuClassroom(){
		ModelAndView andView = new ModelAndView();
		
		Integer studentId = (Integer) se.getAttribute("studentId");
		
		//查询出学生选的全部的课程 倒序
		List<StuCourse> couList = studentClassroomDo.getCourse(studentId);
		
		int pageNub = 0;
		if (couList!=null) {
			pageNub = (couList.size()/10)+1;
		}
		
		andView.addObject("pageNub", pageNub);
		andView.addObject("couList", couList);
		andView.setViewName("student/stuClass");
		return andView;
	}
	
	/**
	 * 点入某个课程查看课堂
	 * 方法名：initStuClass
	 * 创建人：chenPeng
	 * 时间：2019年2月12日-下午10:31:33 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/student/class/{no}")
	public ModelAndView initStuClass(@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();
		
		List<CourseNote> couNoteList = studentClassroomDo.getCouNoteList(no);
		int pageNub = 0;
		if (couNoteList!=null) {
			pageNub = (couNoteList.size()/10)+1;
		}
		andView.addObject("pageNub", pageNub);
		andView.addObject("couNoteList", couNoteList);
		andView.setViewName("student/stuClassNote");
		return andView;
	}
	
	/**
	 * 初始化课堂页面 
	 * 方法名：initStuClsPage
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午4:05:48 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/student/class/page")
	public ModelAndView initStuClsPage(Integer no){
		ModelAndView andView = new ModelAndView();
		
		//查询出是否有ppt 如果有
		String path = se.getServletContext().getRealPath("/");
		String pptPath = teacherQuestionDo.getPptPath(no);
		List<String> pptImgList = new ArrayList<String>();
		
		File[] files = new File(path+pptPath).listFiles();
		if (files!=null) {
			for (File file : files) {
				pptImgList.add(file.getName());
			}
		}
		
		//查询出提问题
		List<Problems> problemsList = studentClassroomDo.getProblemsList(no);
		
		//回答过的设置标记
		List<Integer> stuAnsProb = studentClassroomDo.getStuAnsProb((Integer) se.getAttribute("studentId"));
		for (Problems problems : problemsList) {
			problems.setCourse_note_id(0);
			for (Integer integer : stuAnsProb) {
				if (problems.getId()==integer) {
					//懒得修改bean 就将是否回答问题写入Course_note_id
					problems.setCourse_note_id(1);
				}
			}
		}
		
		
		andView.addObject("problemsList", problemsList);
		andView.addObject("pptImgList", pptImgList);
		andView.addObject("pptPath", pptPath);
		
		andView.setViewName("student/stuClassPage");
		return andView;
	}
	
	/**
	 * 回答问题
	 * 方法名：stuAnswer
	 * 创建人：chenPeng
	 * 时间：2019年2月13日-下午5:29:48 
	 * 手机:17673111810
	 * @param ans
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/student/class/page/answer")
	@ResponseBody
	public String stuAnswer(String ans,Integer no){
		Integer studentId = (Integer) se.getAttribute("studentId");
		studentClassroomDo.stuAnswer(studentId,ans,no);
		return "success";
	}
}
