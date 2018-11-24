/**
 * lei
 * com.mic.service
 * Select2Do.java
 * 创建人:lei
 * 时间：2018年10月10日-下午21:07:04 
 * 2018雷-版权所有
 */
package com.mic.service.lei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.lei.Select1Bean;
import com.mic.bean.lei.Select2Bean;
import com.mic.dao.lei.Select2Dao;

/**
 * 
 * Select2Do
 * 创建人:lei
 * 时间：2018年10月10日-下午21:07:04 
 * @version 1.0.0
 * 
 */
@Service
public class Select2Do {
	@Autowired
	private Select2Dao select2;
	
	/**
	 *
	 * 建立课程
	 * 方法名：Select2
	 * 创建人：lei
	 * 时间：2018年10月10日-下午21:07:04
	 * 手机:15873169121
	 * @param 
	 * @return void
	 * @exception
	 * @since  1.0.0
	 */
	public void Select2(Integer Sid, Integer Cid)
	{
		Select2Bean select2bean = new Select2Bean();
		select2bean.setSid(Sid);
		select2bean.setCid(Cid);
		select2.addelective(select2bean);
	}

}
