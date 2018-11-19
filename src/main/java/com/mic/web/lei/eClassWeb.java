/**
 * lei
 * com.mic.web
 * eClassWeb.java
 * 创建人:lei
 * 时间：2018年9月28日-下午21:03:04 
 * 2018雷-版权所有
 */

package com.mic.web.lei;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mic.core.FileUp1;
import com.mic.service.lei.eClassDo;


/**
 * 老师建立课程执行
 * eClassWeb
 * 创建人:lei
 * 时间：2018年9月28日-下午21:03:04  
 * @version 1.0.0
 * 
 */
@Controller
public class eClassWeb {
	@Autowired
	private eClassDo eclassdo;
	
	@Autowired
	private HttpSession se;
	
	@Autowired
	private HttpServletRequest re;

	/**
	 * 老师添加每堂课信息
	 * 方法名：eClassDo
	 * 创建人：chenPeng
	 * 时间：2018年11月17日-下午4:56:21 
	 * 手机:17673111810
	 * @param file
	 * @param re
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/eClassWeb", method = RequestMethod.POST)
	public ModelAndView eClassDo(@RequestParam MultipartFile file, HttpServletRequest re) throws IllegalStateException, IOException{
		String path = se.getServletContext().getRealPath("/ppt");
        FileUp1 fileup1 = new FileUp1();
        String Path = fileup1.fileUp(file, path);

        Integer cId = Integer.parseInt(re.getSession().getAttribute("C_id").toString());
		eclassdo.esClassDo( cId,
				            re.getParameter("className"),
							re.getParameter("Introduction"), 
							re.getParameter("begintime"), 
							re.getParameter("begain"),
							re.getParameter("end"),
							Path);
		
		return  new ModelAndView("redirect:/teacher/class/"+cId);
	}
	
	
	
	/**
	 * 修改课程信息
	 * 方法名：upClassDo
	 * 创建人：chenPeng
	 * 时间：2018年11月19日-下午1:15:46 
	 * 手机:17673111810
	 * @param file
	 * @param className
	 * @param Introduction
	 * @param begintime
	 * @param begain
	 * @param end
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/teacher/upDateClass", method = RequestMethod.POST)
	public ModelAndView upClassDo(
						@RequestParam MultipartFile file,
						String className,
						String Introduction,
						String begintime,
						String begain,
						String end
			){
		
		String path = se.getServletContext().getRealPath("/ppt");
        FileUp1 fileup1 = new FileUp1();
        String Path = fileup1.fileUp(file, path);

        Integer cId = Integer.parseInt(re.getSession().getAttribute("C_id").toString());
		eclassdo.upClassDo( cId,
							className,
							Introduction, 
							begintime, 
							begain,
							end,
							Path);
		
		return  new ModelAndView("redirect:/teacher/class/"+cId);
	}
}
