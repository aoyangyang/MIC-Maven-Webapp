/**
 * chenPeng
 * com.mic.web
 * DepLeadertest.java
 * 创建人:chenpeng
 * 时间：2018年8月8日-下午2:32:21 
 * 2018陈鹏-版权所有
 */
package com.mic.web.showMsg;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.DepLeaderDetail;
import com.mic.bean.departments.Departments;
import com.mic.bean.departments.PancakeDate;
import com.mic.core.CpDate;
import com.mic.service.showMsg.DepLeadertestDo;

/**
 * 院领导
 * DepLeadertest
 * 创建人:chenPeng
 * 时间：2018年8月8日-下午2:32:21 
 * @version 1.0.0
 * 
 */
@Controller
public class DepLeadertestWeb {
	@Autowired
	private DepLeadertestDo depLeadertestDo;
	
	/**
	 * 未指定日期的查询
	 * 方法名：initDepLeadertest
	 * 创建人：chenPeng
	 * 时间：2018年8月11日-下午11:26:33 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/depLeader")
	public	ModelAndView initDepLeadertest(){
		ModelAndView andView = new ModelAndView();
		
		//获取到学院的信息
		List<Departments> departmentsList = 
					depLeadertestDo.getAllDepart();
		
		//获取当前时间
		CpDate cpDate = new CpDate();
		String nowDate = cpDate.getTimeFormat("yyyy-MM-dd");
		//饼状图数据
		List<PancakeDate> pancakeDateList = new ArrayList<PancakeDate>();
		for (Departments departments : departmentsList) {
			PancakeDate	pancakeDate = depLeadertestDo.getPancakeDate(
							departments.getId(),
							departments.getD_name(),
							nowDate);
			
			pancakeDateList.add(pancakeDate);
		}
		
		andView.addObject("pancakeDateList", pancakeDateList);
		andView.setViewName("statistics/depLeader");
		return andView;
	}
	
	/**
	 * 指定日期的查询
	 * 方法名：getDepLeaderDate
	 * 创建人：chenPeng
	 * 时间：2018年8月11日-下午11:26:55 
	 * 手机:17673111810
	 * @param MyDate
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/depLeader/DepLeaderDate",
					method = RequestMethod.POST)
	public ModelAndView getDepLeaderDate(String MyDate){
		ModelAndView andView = new ModelAndView();
		
		//获取到学院的信息
		List<Departments> departmentsList = 
					depLeadertestDo.getAllDepart();
		
		//获取时间
		String nowDate = MyDate;
		
		//饼状图数据
		List<PancakeDate> pancakeDateList = new ArrayList<PancakeDate>();
		for (Departments departments : departmentsList) {
			PancakeDate pancakeDate = depLeadertestDo.getPancakeDate(
							departments.getId(),
							departments.getD_name(),
							nowDate);
			
			pancakeDateList.add(pancakeDate);
		}
		
		andView.addObject("pancakeDateList", pancakeDateList);
		andView.setViewName("statistics/depLeader");
		return andView;
	}
	
	/**
	 * 详情页面
	 * 方法名：getDepLeaderDetail
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午7:35:36 
	 * 手机:17673111810
	 * @param depLeader
	 * @param time
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/depLeader/depLeaderDetail/{depLeader}/{time}/{no}")
	public ModelAndView getDepLeaderDetail(
						@PathVariable String depLeader,
						@PathVariable String time,
						@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();
		//查询出点击的详情的班级
		List<Classs> classList = depLeadertestDo.getAllClass(no);
		
		//得到矩形统计图的数据
		List<DepLeaderDetail> depLDList = 
				depLeadertestDo.getDepLeaderDetail(classList,time+"%");
		andView.setViewName("statistics/depLeaderDetail");
		andView.addObject("depLDList", depLDList);
		andView.addObject("depLeader", depLeader);
		return andView;
	}
}
