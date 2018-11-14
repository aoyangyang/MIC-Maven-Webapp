/**
 * lei
 * com.mic.dao
 * approvalHolidayDo.java
 * 创建人:lei
 * 时间：2018年11月5日-下午0:57:04 
 * 2018雷-版权所有
 */
package com.mic.service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.approvalHolidayBean;
import com.mic.bean.approvalholidayBean2;
import com.mic.dao.approvalHolidayDao;

/**
 * 
 * approvalHolidayDo
 * 创建人:lei
 * 时间：2018年11月5日-下午0:57:04
 * @version 1.0.0
 * 
 */

@Service
public class approvalHolidayDo {
	@Autowired
	private approvalHolidayDao approvalHolidaydao;
	/**
	 *
	 * 得到请假信息
	 * 方法名：approvalHolidayDo
	 * 创建人：lei
	 * 时间：2018年11月5日-下午1:00:04
	 * 手机:15873169121
	 * @param id
	 * @return approvalHolidayBean
	 * @exception
	 * @since  1.0.0
	 */
	public approvalHolidayBean approvalHolidayDo(Integer id) {
		approvalHolidayBean aholidaybean = new approvalHolidayBean();
		aholidaybean.setStudentname(approvalHolidaydao.Getstudentname(id));
		aholidaybean.setB_time(approvalHolidaydao.Getbtime(id));
		aholidaybean.setClassname(approvalHolidaydao.Getclassname(id));
		aholidaybean.setE_time(approvalHolidaydao.Getetime(id));
		aholidaybean.setId(approvalHolidaydao.GetstudentId(id));
		aholidaybean.setReason(approvalHolidaydao.Getreason(id));
		aholidaybean.setS_phone(approvalHolidaydao.Getphone(id));
		aholidaybean.setSchool(approvalHolidaydao.Getschoolname(id));
        return aholidaybean;
	}
	
	/**
	 *
	 * 修改假条状态（是否同意）
	 * 方法名：modify
	 * 创建人：lei
	 * 时间：2018年11月5日-下午17:52:04
	 * 手机:15873169121
	 * @param id,state
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	public void modify(Integer id, String state){
		if(state.equals("是"))
		{
			approvalHolidaydao.modify1(id);
		}
		else
		{
			approvalHolidaydao.modify2(id);
		}
	}
	/**
	 *
	 * 得到未上的课程名
	 * 方法名：GetCoursename
	 * 创建人：lei
	 * 时间：2018年11月6日-下午14:20:04
	 * 手机:15873169121
	 * @param studentid,b_tiem,e_time
	 * @return List<String>
	 * @exception
	 * @since  1.0.0
	 */
	
	public  List<String> GetCoursename(Integer studentid, String e_time){
		  List<String> coursename = new ArrayList<String>();
		  ParsePosition pos = new ParsePosition(0);
		  SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date Etime = formatter2.parse(e_time, pos);
		   List<Integer> courseid = approvalHolidaydao.GetcoursesId(2);
		   Map<Integer, List<String>> btime = new HashMap<Integer, List<String>>();
		   List<approvalholidayBean2> B_time = new ArrayList<approvalholidayBean2>();
		   for (Integer integer : courseid) {
			   btime.put(integer, approvalHolidaydao.Getcbtime(integer));	
		   }
		   for (Map.Entry<Integer, List<String>> entry : btime.entrySet()) {
				   for (String bt : entry.getValue()) {
					   approvalholidayBean2 apph2 = new approvalholidayBean2();
					   ParsePosition p = new ParsePosition(0);
						SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						apph2.setCourseid(entry.getKey());
						apph2.setCoursebtime(formatter3.parse(bt, p));
						B_time.add(apph2);
				}
			}
		   for (approvalholidayBean2 ahb2 : B_time) {
				if((ahb2.getCoursebtime().getTime()) < Etime.getTime())
				{
					coursename.add(approvalHolidaydao.Getcoursename(ahb2.getCourseid()));
				}
			}
		return coursename;
	}
}
