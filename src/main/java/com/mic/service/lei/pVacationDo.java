/**
 * lei
 * com.mic.dao
 * pVacationDo.java
 * 创建人:lei
 * 时间：2018年9月29日-下午17:28:04 
 * 2018雷-版权所有
 */
package com.mic.service.lei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.eClassBean;
import com.mic.bean.pVacationBean;
import com.mic.dao.pVacationDao;

/**
 * 
 * pVacationDo
 * 创建人:lei
 * 时间：2018年9月29日-下午17:28:04
 * @version 1.0.0
 * 
 */
@Service
public class pVacationDo {
	@Autowired
	private pVacationDao pvacationdao;
	/**
	 *
	 * 建立课程
	 * 方法名：pVacationDo
	 * 创建人：lei
	 * 时间：2018年9月28日-下午20:20:04
	 * 手机:15873169121
	 * @param 
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	 public void pVacationDo(Integer student_id, String reason, String s_phone, String begin_time, String end_time)
     {
    	 pVacationBean pvacation = new pVacationBean();
    	 pvacation.setStudent_id(student_id);
    	 pvacation.setReason(reason);
    	 pvacation.setS_phone(s_phone);
    	 pvacation.setBegin_time(begin_time);
    	 pvacation.setEnd_time(end_time);
    	 pvacation.setState(0);
    	 pvacationdao.addPVacation(pvacation);
     }
}
