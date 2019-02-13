/**
 * chenPeng
 * com.mic.web
 * TestFIle.java
 * 创建人:chenpeng
 * 时间：2019年2月10日-下午9:39:06 
 * 2019陈鹏-版权所有
 */
package com.mic.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpServer;

/**
 * 
 * TestFIle
 * 创建人:chenPeng
 * 时间：2019年2月10日-下午9:39:06 
 * @version 1.0.0
 * 
 */
public class TestFIle {
	public static void main(String[] args) {
		File file = new File("probPPT/新建Microsoft PowerPoint 演示文稿180b5a17-b794-4f1a-bcf8-0b617cb330e4");
		boolean temp = file.exists();
		if(temp){
			file.mkdirs();
		}
	}
}
