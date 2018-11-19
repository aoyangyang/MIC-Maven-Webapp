/**
 * lei
 * com.mic.service
 * tBCourseDo.java
 * 创建人:lei
 * 时间：2018年9月28日-下午20:20:04 
 * 2018雷-版权所有
 */

package com.mic.service.lei;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	private HttpServletRequest re;
	
	/**
	 *
	 * 建立课程
	 * 方法名：eClassDo
	 * 创建人：lei
	 * 时间：2018年9月28日-下午20:20:04
	 * 手机:15873169121
	 * @param path 
	 * @param 
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
     public void esClassDo(Integer C_id, String name,String Introduction, 
    		 	String b_time, String begain, String end, String path){
    	 
    	 eClassBean eclassbean = new eClassBean();
    	 eclassbean.setId(C_id);
    	 eclassbean.setName(name);
    	 eclassbean.setIntroduction(Introduction);
    	 eclassbean.setBegin_time(b_time+"/"+begain);
    	 eclassbean.setEnd_time(b_time+"/"+end);
    	 eclassbean.setCourseware(path);
    	 eclassdao.addCourseNote(eclassbean);
     }
     
     /**
      * 修改已经建立的课程
      * 方法名：upClassDo
      * 创建人：chenPeng
      * 时间：2018年11月19日-下午1:28:40 
      * 手机:17673111810
      * @param C_id
      * @param name
      * @param Introduction
      * @param b_time
      * @param begain
      * @param end
      * @param path void
      * @exception 
      * @since  1.0.0
      */
     public void upClassDo(Integer C_id, String name,String Introduction, 
 		 	String b_time, String begain, String end, String path){
    	 Integer noteId = (Integer) re.getSession().getAttribute("noteId");
    	 
    	 eClassBean eclassbean = new eClassBean();
    	 eclassbean.setId(C_id);
    	 eclassbean.setName(name);
    	 eclassbean.setIntroduction(Introduction);
    	 eclassbean.setBegin_time(b_time+"/"+begain);
    	 eclassbean.setEnd_time(b_time+"/"+end);
    	 eclassbean.setCourseware(path);
    	 eclassbean.setNoteId(noteId);
    	 
    	 eclassdao.upCourseNote(eclassbean);
     }
}
