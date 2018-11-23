/**
 * lei
 * com.mic.service
 * Select1Do.java
 * 创建人:lei
 * 时间：2018年9月30日-下午13:03:04 
 * 2018雷-版权所有
 */
package com.mic.service.lei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.lei.Select1Bean;
import com.mic.dao.lei.Select1Dao;

/**
 * 
 * Select1Do
 * 创建人:lei
 * 时间：2018年9月30日-下午13:03:04 
 * @version 1.0.0
 * 
 */
@Service
public class Select1Do {
	@Autowired
	private Select1Dao select1;
	
	/**
	 *
	 * 建立课程
	 * 方法名：Select1
	 * 创建人：lei
	 * 时间：2018年9月26日-下午21:39:04
	 * 手机:15873169121
	 * @param 
	 * @return Select1Bean
	 * @exception
	 * @since  1.0.0
	 */
	public Select1Bean Select1(String sname, Integer Cid ){
		Select1Bean select1bean = new Select1Bean();
		select1bean.setCid(Cid);
		select1bean.setCname(select1.getCouresname(Cid));
		select1bean.setS_id(select1.getStudentId(sname));
		
		select1bean.setTname(select1.getTeachername(Cid));
		return select1bean;
	}

}
