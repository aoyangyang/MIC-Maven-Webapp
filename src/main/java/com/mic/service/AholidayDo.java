/**
 * lei
 * com.mic.dao
 * AholidayDo.java
 * 创建人:lei
 * 时间：2018年11月3日-下午3:22:04 
 * 2018雷-版权所有
 */
package com.mic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.mic.bean.AholidayBean;
import com.mic.dao.AholidayDao;

/**
 * 
 * AholidayDo
 * 创建人:lei
 * 时间：2018年11月3日-下午3:23:04 
 * @version 1.0.0
 * 
 */

@Service
public class AholidayDo {
	@Autowired
	private AholidayDao aholidaydao;
	/**
	 *
	 * 得到假条信息list
	 * 方法名：AholidayDo
	 * 创建人：lei
	 * 时间：2018年11月3日-下午3:25:04 
	 * 手机:15873169121
	 * @param 
	 * @return List<AholidayBean>
	 * @exception
	 * @since  1.0.0
	 */
	public List<AholidayBean> AholidayDo(String username) {
		List<AholidayBean> aholidaybean = new ArrayList<AholidayBean>();
		List<Integer> id = new ArrayList<Integer>();
		List<Integer> Studentid = aholidaydao.GetStudentIds(username);
		for (Integer integer : Studentid) {
			List<Integer> id1 = aholidaydao.GetleaveId(integer);
			for (Integer integer2 : id1) {
				id.add(integer2);
			}
		}
        for (Integer integer : id) {
        	AholidayBean Taholidaybean = new AholidayBean();
			Taholidaybean.setId(integer);
			Taholidaybean.setClassname(aholidaydao.GetStudentclassname(integer));
			Taholidaybean.setStudentname(aholidaydao.GetStudentName(integer));
			aholidaybean.add(Taholidaybean);
		}
		return aholidaybean;
	}

}
