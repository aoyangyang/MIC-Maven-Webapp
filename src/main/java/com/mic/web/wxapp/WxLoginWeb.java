/**
 * chenPeng
 * com.mic.web.wxapp
 * WxLogin.java
 * 创建人:chenpeng
 * 时间：2019年4月21日-下午1:49:36 
 * 2019陈鹏-版权所有
 */
package com.mic.web.wxapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mic.service.wxapp.WxLoginDo;

/**
 * 
 * WxLogin
 * 创建人:chenPeng
 * 时间：2019年4月21日-下午1:49:36 
 * @version 1.0.0
 * 
 */
@Controller
public class WxLoginWeb {
	@Autowired
	private WxLoginDo wxLoginDo;
	/**
	 * 
	 * 微信登录接口
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2019年4月21日-下午1:52:56 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return String
	 * @exceptios
	 * @since  1.0.0
	 */
	@PostMapping(value="/wxapp",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String login(String username,String password){
		return wxLoginDo.login(username,password);
	}
	
	/**
	 * 微信扫描签到
	 * 方法名：qc
	 * 创建人：chenPeng
	 * 时间：2019年4月21日-下午9:59:35 
	 * 手机:17673111810
	 * @param username
	 * @param url
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/wxapp/qc",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String qc(String username,String url){
		return wxLoginDo.qc(username,url);
	}
	
	/**
	 * 微信人脸签到 
	 * 方法名：face
	 * 创建人：chenPeng 
	 * 时间：2019年4月21日-下午9:59:52 
	 * 手机:17673111810
	 * @param file
	 * @param user
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/wxapp/face",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String face(MultipartFile file,
						String username,
						String latitude,
						String longitude,
						String accuracy,
						String classname){
		return wxLoginDo.face(file,username,latitude,longitude,accuracy,classname);
	}
}
