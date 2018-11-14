/**
 * lei
 * com.mic.Web
 * Select2Web.java
 * 创建人:lei
 * 时间：2018年10月10日-下午8:39:04
 * 2018lei-版权所有
 */
package com.mic.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mic.service.Select2Do;

/**
 * 
 * Select2Web
 * 创建人:lei
 * 时间：2018年9月30日-下午13:19:04
 * @version 1.0.0
 * 
 */
@Controller
public class Select2Web {
	@Autowired
	private Select2Do select2do;
	
	@RequestMapping(value="/select2", method = RequestMethod.POST)
	public ModelAndView eClassDo(HttpServletRequest re){
		Integer t1 = Integer.parseInt(re.getSession().getAttribute("S_id").toString());
		Integer t2 = Integer.parseInt(re.getSession().getAttribute("C_id").toString());
    	ModelAndView modelandview = new ModelAndView();
    	select2do.Select2(t1, t2);
		return modelandview;
	}
	
     
}
