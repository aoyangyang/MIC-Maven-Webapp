/**
 * chenPeng
 * com.mic.web.question
 * TeacherQuestion.java
 * 创建人:chenpeng
 * 时间：2019年2月9日-下午4:52:22 
 * 2019陈鹏-版权所有
 */
package com.mic.web.question;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.course.CourseNote;
import com.mic.bean.db.Problems;
import com.mic.core.ppt.PptToImg;
import com.mic.service.question.TeacherQuestionDo;

/**
 * 
 * TeacherQuestion
 * 创建人:chenPeng
 * 时间：2019年2月9日-下午4:52:22 
 * @version 1.0.0
 * 
 */
@Controller
public class TeacherQuestionWeb {
	@Autowired
	private TeacherQuestionDo teacherQuestionDo;
	@Autowired
	private HttpSession se;
	
	
	/**
	 * 初始化提问题页面
	 * 方法名：problem
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午4:53:12 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/teacher/problem/{no}")
	public ModelAndView problem(@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();

		//提问图片清零
		se.setAttribute("imgPath"+no, "");
		
		//传入的no为课堂编号
		
		//填充数据进入页面，将已有的问题写入
		CourseNote courseNote = teacherQuestionDo.getCourseNote(no);
		
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
		
		//查询是否有题目
		List<Problems> proList = teacherQuestionDo.getProList(no);
		
		andView.addObject("proList", proList);
		andView.addObject("pptImgList", pptImgList);
		andView.addObject("pptPath", pptPath);
		andView.addObject("courseNote", courseNote);
		andView.setViewName("question/teaQuestion");
		return andView;
	}
	
	/**
	 * 统计答题结果
	 * 方法名：getQuStatistics
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午5:39:04 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value = "/teacher/problem/quStatistics",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getQuStatistics(Integer no){
		return teacherQuestionDo.getQuStatistics(no);
	}
	
	/**
	 * 老师查看回答详情 
	 * 方法名：showAnsDetails
	 * 创建人：chenPeng
	 * 时间：2019年2月15日-下午11:08:04 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/problem/showAnsDetails")
	public ModelAndView showAnsDetails(Integer no){
		return teacherQuestionDo.getDetailsList(no);
	}
	
	
	/**
	 * 提问的图片上传 
	 * 方法名：upImg
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午4:53:15 
	 * 手机:17673111810
	 * @param upl
	 * @param imgNo
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/problem/photoUpload")
	@ResponseBody
	public String upImg(@RequestParam MultipartFile[] upl,
							  Integer imgNo
			) throws IllegalStateException, IOException{
		
		String path = se.getServletContext().getRealPath("/probImg");
		String[] fileName = upl[0].getOriginalFilename().split("\\.");
		
		
		String endName = fileName[fileName.length-1];
		if (!(endName.equals("jpg")||endName.equals("jpeg")||endName.equals("png"))) {
			return "error";
		} 		
		
		String tempFileName = "/temp"+imgNo+"."+endName;
		
		upl[0].transferTo(new File(path+tempFileName));
		
		se.setAttribute("imgPath"+imgNo, tempFileName);
		
		return "success";
	}
	
	/**
	 * 开始提问
	 * 方法名：doQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午10:22:31 
	 * 手机:17673111810
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/problem/doQu")
	@ResponseBody
	public String doQu(Integer no){
		teacherQuestionDo.doQu(no);
		return "success";
	} 
	
	
	/**
	 * 提问题
	 * 方法名：addQu
	 * 创建人：chenPeng
	 * 时间：2019年2月11日-下午5:43:24 
	 * 手机:17673111810
	 * @param no
	 * @param quText
	 * @param quAns
	 * @param exampleQu
	 * @return String
	 * @throws IOException 
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/problem/addQu")
	@ResponseBody
	public String addQu(Integer no,String quText,String quAns,String exampleQu) throws IOException{
		//判断是否有图片
		String tempFileName = (String) se.getAttribute("imgPath"+no);
		String newFilePath = null;
		if(!tempFileName.equals("")){
			//图片处理
			System.out.println("有照片！");
			String path = se.getServletContext().getRealPath("/probImg");
			String[] imgNameArr = tempFileName.split("\\.");
			String imgEndName = imgNameArr[imgNameArr.length-1];
			newFilePath = "/img"+no+"/"+UUID.randomUUID().toString()+"."+imgEndName;
			
			FileUtils.copyFile(new File(path+tempFileName), 
					new File(path+newFilePath), true);
		}
		teacherQuestionDo.addQu(no,quText,quAns,exampleQu,newFilePath);
		
		//提问图片清零
		se.setAttribute("imgPath"+no, "");
		return "success";
	}
	
	
	
	/**
	 * 删除ppt  
	 * 方法名：deletePpt
	 * 创建人：chenPeng
	 * 时间：2019年2月10日-下午10:49:52 
	 * 手机:17673111810
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/teacher/problem/deletPPt")
	@ResponseBody
	public String deletePpt(String no){
		Integer res = teacherQuestionDo.deletePpt(no);
		if (res==0) {
			return "error";
		}
		return "success";
	}
	
	
	/**
	 * 上传ppt
	 * 方法名：upPpt
	 * 创建人：chenPeng
	 * 时间：2019年2月9日-下午10:12:18 
	 * 手机:17673111810
	 * @param file
	 * @param courseNoteId
	 * @param se
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/teacher/problem/upPPt")
	public String upPpt(@RequestParam MultipartFile[] file,
						Integer courseNoteId,
						HttpSession se) throws IllegalStateException, IOException{
		
		String fileName = file[0].getOriginalFilename();
		String[] fileEndName = fileName.split("\\.");
		
		String path = se.getServletContext().getRealPath("/probPPT");
		String imgPath = fileEndName[0]+UUID.randomUUID();
		String pptImgPath =  path+"/"+imgPath;
		
		File pptFile;
		List<String> list = new ArrayList<String>();
		
		
		if (fileEndName[fileEndName.length-1].equals("ppt")) {
			pptFile = new File(pptImgPath+".ppt");
			file[0].transferTo(pptFile);
			new File(pptImgPath).mkdir();
			
			PptToImg.doPPT2003toImage(pptFile, new File(pptImgPath), list);
		}else if(fileEndName[fileEndName.length-1].equals("pptx")){
			pptFile = new File(pptImgPath+".pptx");
			file[0].transferTo(pptFile);
			new File(pptImgPath).mkdir();
			
			PptToImg.doPPT2007toImage(pptFile, new File(pptImgPath), list);
		}else{
			return null;
		}
		
		//将文件位置写入数据库
		teacherQuestionDo.addPPt(courseNoteId,"probPPT/"+imgPath);
		
		return null;
	}
}
