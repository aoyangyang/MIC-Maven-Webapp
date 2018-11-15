/**
 * lei
 * com.mic.service
 * tBCourseDo.java
 * 创建人:lei
 * 时间：2018年9月28日-下午20:20:04 
 * 2018雷-版权所有
 */

package com.mic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.eClassBean;
import com.mic.dao.eClassDao;


/**
 * 
 * eClassDo
 * 创建人:lei
 * 时间：2018年9月28日-下午20:20:04 
 * @version 1.0.0
 * 
 */

@Service
public class eClassDo {
	@Autowired
	private eClassDao eclassdao;
	/**
	 *
	 * 建立课程
	 * 方法名：eClassDo
	 * 创建人：lei
	 * 时间：2018年9月28日-下午20:20:04
	 * 手机:15873169121
	 * @param 
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
     public void eClassDo(Integer C_id, String name,String Introduction, String b_time, String e_time, String courseware)
     {
    	 eClassBean eclassbean = new eClassBean();
    	 eclassbean.setId(C_id);
    	 eclassbean.setName(name);
    	 eclassbean.setIntroduction(Introduction);
    	 eclassbean.setBegin_time(b_time);
    	 eclassbean.setEnd_time(e_time);
    	 eclassbean.setCourseware(courseware);
    	 eclassdao.addCourseNote(eclassbean);
     }
}
