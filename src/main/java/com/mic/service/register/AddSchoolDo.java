/**
 * chenPeng
 * com.mic.server
 * AddSchoolDo.java
 * 创建人:chenpeng
 * 时间：2018年7月31日-下午6:42:37 
 * 2018陈鹏-版权所有
 */
package com.mic.service.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mic.bean.AddSchool;
import com.mic.dao.AddSchoolDao;

/**
 * 
 * AddSchoolDo
 * 创建人:chenPeng
 * 时间：2018年7月31日-下午6:42:37 
 * @version 1.0.0
 * 
 */
@Service
public class AddSchoolDo {
	@Autowired
	private AddSchoolDao addSchoolDao;
	
	/**
	 * 添加学校
	 * 方法名：addSchool
	 * 创建人：chenPeng
	 * 时间：2018年7月31日-下午7:36:42 
	 * 手机:17673111810
	 * @param schoolName
	 * @param nameList void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addSchool(String schoolName,List<String> nameList){
		addSchoolDao.AddSchoolName(schoolName);
		Integer id = addSchoolDao.getSchoolId(schoolName);
		AddSchool school = new AddSchool();
		for (String name : nameList) {
			school.setD_name(name);
			school.setId(id);
			addSchoolDao.AddDepartments(school);
		}
	}
}
