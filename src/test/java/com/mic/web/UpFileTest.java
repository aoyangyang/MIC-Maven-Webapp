/**
 * chenPeng
 * com.mic.web
 * UpFileTest.java
 * 创建人:chenpeng
 * 时间：2019年2月11日-下午12:34:39 
 * 2019陈鹏-版权所有
 */
package com.mic.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * UpFileTest
 * 创建人:chenPeng
 * 时间：2019年2月11日-下午12:34:39 
 * @version 1.0.0
 * 
 */
@Controller
public class UpFileTest {
	@Autowired
	private HttpSession se;
	
	
	@PostMapping("/test/photoUploadTest")
	@ResponseBody
	public String upFileTest(@RequestParam MultipartFile[] upl) throws IllegalStateException, IOException{
		String path = se.getServletContext().getRealPath("/probImg");
		upl[0].transferTo(new File(path+"/test.png"));
		System.out.println(1);
		return "success";
	}
}
