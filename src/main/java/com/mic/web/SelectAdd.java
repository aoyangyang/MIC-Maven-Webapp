/**
 * chenPeng
 * com.mic.web
 * SelectAdd.java
 * 创建人:chenpeng
 * 时间：2018年10月14日-下午2:51:32 
 * 2018陈鹏-版权所有
 */
package com.mic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * SelectAdd
 * 创建人:chenPeng
 * 时间：2018年10月14日-下午2:51:32 
 * @version 1.0.0
 * 
 */
@Controller
public class SelectAdd {
	/**
	 * 调转到选择注册
	 * 方法名：selectAdd
	 * 创建人：chenPeng
	 * 时间：2018年10月14日-下午3:05:58 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/selectAdd")
	public ModelAndView selectAdd(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("add/selectAdd");
		return andView;
	}
}
