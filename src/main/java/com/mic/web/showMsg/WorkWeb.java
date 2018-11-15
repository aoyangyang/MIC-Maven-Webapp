/**
 * chenPeng
 * com.mic.web
 * WorkWeb.java
 * 创建人:chenpeng
 * 时间：2018年8月16日-下午10:27:00 
 * 2018陈鹏-版权所有
 */
package com.mic.web.showMsg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.PancakeDate;
import com.mic.bean.TimeAndId;
import com.mic.core.NoToClass;
import com.mic.service.InstructorDo;
import com.mic.service.WorkDo;

/**
 * 学工组
 * WorkWeb
 * 创建人:chenPeng
 * 时间：2018年8月16日-下午10:27:00 
 * @version 1.0.0
 * 
 */
@Controller
public class WorkWeb {
	@Autowired
	private WorkDo workDo;
	@Autowired
	private InstructorDo instructorDo;
	
	/**
	 * 初始化学工组页面
	 * 方法名：initWorkChoose
	 * 创建人：chenPeng
	 * 时间：2018年8月16日-下午10:54:18 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/work")
	public ModelAndView initWorkChoose(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("statistics/workChoose");
		return andView;
	}
	
	/**
	 * 
	 * 方法名：workChooseDo
	 * 创建人：chenPeng
	 * 时间：2018年8月19日-上午11:58:59 
	 * 手机:17673111810
	 * @param time
	 * @param classs
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/work/fond",method=RequestMethod.POST)
	public ModelAndView workChooseDo(
				String time,Integer classs
			){
		ModelAndView andView = new ModelAndView();
		
		//拼装好时间
		NoToClass noToClass = new NoToClass();
		time = time + noToClass.noToClass(classs);
		
		//得到表图List
		List<PancakeDate> pancakeList = workDo.fond(time);
		
		for (PancakeDate pancakeDate : pancakeList) {
			System.out.println(pancakeDate.getPanckeName());
			System.out.println(pancakeDate.getAbsence());
		}
		
		andView.addObject("pancakeList", pancakeList);
		andView.addObject("classs", classs);
		andView.addObject("time", time);
		
		andView.setViewName("statistics/workView");
		return andView;
	}
	
	/**
	 * 详情页面
	 * 方法名：workView
	 * 创建人：chenPeng
	 * 时间：2018年8月19日-下午1:02:39 
	 * 手机:17673111810
	 * @param time
	 * @param no
	 * @param classs
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/work/fond/{time}/{no}/{classs}")
	public ModelAndView workView(
			@PathVariable String time,
			@PathVariable String no,
			@PathVariable Integer classs
		){
		TimeAndId timeAndId = new TimeAndId();
		timeAndId.setId(classs);
		timeAndId.setTime(time+"/"+no);
		return instructorDo.addDate(timeAndId);
	}
}
