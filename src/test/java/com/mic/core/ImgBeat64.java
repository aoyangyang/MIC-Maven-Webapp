/**
 * chenPeng
 * com.mic.core
 * ImgBeat64.java
 * 创建人:chenpeng
 * 时间：2018年9月10日-下午8:19:05 
 * 2018陈鹏-版权所有
 */
package com.mic.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

/**
 * 
 * ImgBeat64
 * 创建人:chenPeng
 * 时间：2018年9月10日-下午8:19:05 
 * @version 1.0.0
 * 
 */
public class ImgBeat64 {
	/**
	 * 得到baet64格式
	 * 方法名：getBeat64
	 * 创建人：chenPeng
	 * 时间：2018年9月10日-下午8:41:22 
	 * 手机:17673111810
	 * @param src
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getBeat64(String src){
		File file = new File(src);
		InputStream in = null;
		byte[] date = null;
		
		try {
			in = new FileInputStream(file);
			date = new byte[in.available()];
			in.read(date);
			in.close();
			if (date==null||date.length==0) {
				System.out.println("读取失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String base64 = Base64.getEncoder().encodeToString(date);
		return base64;
	}
}
