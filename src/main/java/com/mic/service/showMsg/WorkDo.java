/**
 * chenPeng
 * com.mic.service
 * WorkService.java
 * 创建人:chenpeng
 * 时间：2018年8月16日-下午10:27:17 
 * 2018陈鹏-版权所有
 */
package com.mic.service.showMsg;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.Information;
import com.mic.bean.departments.PancakeDate;
import com.mic.bean.other.TimeAndId;
import com.mic.dao.showMsg.WorkDao;

/**
 * 学工组
 * WorkService
 * 创建人:chenPeng
 * 时间：2018年8月16日-下午10:27:17 
 * @version 1.0.0
 * 
 */
@Service
public class WorkDo {
	@Autowired
	private HttpServletRequest re;
	@Autowired
	private WorkDao workDao;
	
	public List<PancakeDate> fond(String time){
		//得到登陆的人是谁
		Integer adDepartmentsId = 
				(Integer) re.getSession().getAttribute("adDepartmentId");
		//得到全部的班级
		List<Classs> classList = workDao.getAllClass(adDepartmentsId);
		//实列化一个饼图List
		List<PancakeDate> pancakeList = new ArrayList<PancakeDate>();
		
		List<Information> infmTionList;
		
		//时间与id
		TimeAndId timeAndId = new TimeAndId();
		timeAndId.setTime(time);
		
		for (Classs classs : classList) {
			timeAndId.setId(classs.getId());
			//得到数据
			infmTionList = workDao.getInfmTion(timeAndId);
			
			PancakeDate pancakeDate = getPancke(infmTionList);
			pancakeDate.setPanckeName(classs.getClassname());
			pancakeDate.setId(classs.getId());
			
			pancakeList.add(pancakeDate);
		}
		
		return pancakeList;
	}
	
	/**
	 * 分析数据得到饼图
	 * 方法名：getPancke
	 * 创建人：chenPeng
	 * 时间：2018年8月18日-下午10:44:45 
	 * 手机:17673111810
	 * @param infmTionList
	 * @return PancakeDate
	 * @exception 
	 * @since  1.0.0
	 */
	public PancakeDate getPancke(List<Information> infmTionList){
		PancakeDate pancakeDate = new PancakeDate();
		//状态
		String staus = "";
		
		//缺勤
		Integer absence = 0;
		//请假
		Integer leave = 0;
		//正常
		Integer attendance = 0;
		
		for (Information information : infmTionList) {
			staus = information.getStatus();
			if (staus.equals("到课")) {
				attendance++;
			}else if (staus.equals("请假")) {
				leave++;
			}else if(staus.equals("缺勤")){
				absence++;
			}
		}
		pancakeDate.setAbsence(absence);
		pancakeDate.setAttendance(attendance);
		pancakeDate.setLeave(leave);
		return pancakeDate;
	}
}
