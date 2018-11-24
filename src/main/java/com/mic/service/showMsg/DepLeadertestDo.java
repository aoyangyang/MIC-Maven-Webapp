/**
 * chenPeng
 * com.mic.service
 * DepLeadertestDo.java
 * 创建人:chenpeng
 * 时间：2018年8月8日-下午2:34:23 
 * 2018陈鹏-版权所有
 */
package com.mic.service.showMsg;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.classs.Classs;
import com.mic.bean.departments.DepLeaderDetail;
import com.mic.bean.departments.Departments;
import com.mic.bean.departments.Information;
import com.mic.bean.departments.PancakeDate;
import com.mic.bean.other.TimeAndId;
import com.mic.dao.showMsg.DepLeadertestDao;

/**
 * 院领导
 * DepLeadertestDo
 * 创建人:chenPeng
 * 时间：2018年8月8日-下午2:34:23 
 * @version 1.0.0
 * 
 */
@Service
public class DepLeadertestDo {
	@Autowired
	private DepLeadertestDao depLeadertestDao;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 通过id得到全部的学校
	 * 方法名：getAllDepart
	 * 创建人：chenPeng
	 * 时间：2018年8月9日-下午9:56:51 
	 * 手机:17673111810
	 * @return List<Departments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Departments> getAllDepart (){
		Integer adSchoolId = 
				(Integer) re.getSession().getAttribute("adSchoolId");
		
		return depLeadertestDao.getAllDepart(adSchoolId);
	}
	/**
	 * 得到饼状图
	 * 方法名：getPancakeDate
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午3:39:39 
	 * 手机:17673111810
	 * @param departmentsId
	 * @param dName
	 * @param nowDate
	 * @return PancakeDate
	 * @exception 
	 * @since  1.0.0
	 */
	public PancakeDate getPancakeDate(
			Integer departmentsId, String dName, String nowDate){
		
		
		//一个数据饼图
		PancakeDate pancakeDate = new PancakeDate();
		pancakeDate.setAbsence(0);
		pancakeDate.setAttendance(0);
		pancakeDate.setLeave(0);
		pancakeDate.setPanckeName(dName);
		pancakeDate.setId(departmentsId);
		
		//一个时间与id（in）
		TimeAndId timeAndId = new TimeAndId();
		timeAndId.setId(departmentsId);
		timeAndId.setTime(nowDate+"%");
		re.getSession().setAttribute("time", nowDate);
		
		//得到全部的信息
		List<Information> InformationList = 
				depLeadertestDao.getAllInfMation(timeAndId);
		
		//状态
		String staus = "";
		
		//数据统计
		for (Information information : InformationList) {
			staus = information.getStatus();
			if (staus.equals("到课")) {
				pancakeDate.setAttendance(pancakeDate.getAttendance()+1);
			}else if (staus.equals("请假")) {
				pancakeDate.setLeave(pancakeDate.getLeave()+1);
			}else if(staus.equals("缺勤")){
				pancakeDate.setAbsence(pancakeDate.getAbsence()+1);
			}
		}
		
		return pancakeDate;
	}
	
	/**
	 * 得到全部的班级
	 * 方法名：getAllClass
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午4:03:55 
	 * 手机:17673111810
	 * @param no
	 * @return List<Departments>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Classs> getAllClass(Integer no){
		return depLeadertestDao.getAllClass(no);
	}
	
	/**
	 * 得到统计数据
	 * 方法名：getDepLeaderDetail
	 * 创建人：chenPeng
	 * 时间：2018年8月12日-下午7:35:57 
	 * 手机:17673111810
	 * @param classList
	 * @param time
	 * @return List<DepLeaderDetail>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<DepLeaderDetail> 
			getDepLeaderDetail(List<Classs> classList, String time){
		//需要返回的List
		List<DepLeaderDetail> depLDList = 
				new ArrayList<DepLeaderDetail>();
		//时间和id
		TimeAndId timeAndId = new TimeAndId();
		timeAndId.setTime(time);
		//缺勤
		Integer absence;
		//请假
		Integer leave;
		//班级名
		String className;
		//状态
		String staus = "";
		
		
		
		//遍历得到数据
		for (Classs classs : classList) {
			DepLeaderDetail depLD = new DepLeaderDetail();
			absence = 0;
			leave = 0;
			className = "";
			timeAndId.setId(classs.getId());
			
			List<Information> InformationList = 
					depLeadertestDao.getClassInfMation(timeAndId);
			
			for (Information information : InformationList) {
				staus = information.getStatus();
				if (staus.equals("请假")) {
					leave++;
				}else if (staus.equals("缺勤")) {
					absence++;
				}
			}
			depLD.setAbsence(absence);
			depLD.setLeave(leave);
			depLD.setClassName(classs.getClassname());
			depLDList.add(depLD);
		}
		return depLDList;
	}
	
}
