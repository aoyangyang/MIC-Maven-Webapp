/**
 * chenPeng
 * com.mic.core
 * FileUp.java
 * 创建人:chenpeng
 * 时间：2018年8月6日-下午2:43:01 
 * 2018陈鹏-版权所有
 */
package com.mic.core;

import java.io.File;
import java.io.IOException;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * FileUp
 * 创建人:chenPeng
 * 时间：2018年8月6日-下午2:43:01 
 * @version 1.0.0
 * 
 */
public class FileUp {
	/**
	 * 判断空
	 * 方法名：isNull
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午3:35:02 
	 * 手机:17673111810
	 * @param file
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isNull(MultipartFile file){
		if(file.getSize()==0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 取得md5值为文件名
	 * 方法名：getMd5
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午3:35:13 
	 * 手机:17673111810
	 * @param file
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getMd5(MultipartFile file){
		String md5 = "";
		try {
			md5 = DigestUtils.md5Digest(file.getBytes()).toString();
		} catch (IOException e) {
			System.out.println("计算MD5值失败");
			e.printStackTrace();
		}
		return md5;
	}
	/**
	 * 得到文件后缀名
	 * 方法名：getEndFileName
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午3:35:24 
	 * 手机:17673111810
	 * @param file
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getEndFileName(MultipartFile file){
		String endFileName = "";
		String fileName = file.getOriginalFilename();
		endFileName = fileName.substring(fileName.lastIndexOf(".")+1);
		return endFileName;
	}
	
	/**
	 * 文件上传
	 * 方法名：fileUp
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午3:35:34 
	 * 手机:17673111810
	 * @param file
	 * @param path
	 * @param fileName void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void fileUpDo(
			MultipartFile file,String path,String fileName){
		
		File fileUp = new File(path,fileName);
		try {
			
			file.transferTo(fileUp);
			
		} catch (IllegalStateException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件写入io异常");
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件上传
	 * 方法名：fileUp
	 * 创建人：chenPeng
	 * 时间：2018年8月6日-下午3:40:38 
	 * 手机:17673111810
	 * @param file
	 * @param path
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String fileUp(MultipartFile file,String path){
		if(isNull(file)){
			return null;
		}
		String firstName =  getMd5(file);
		String endName = getEndFileName(file);
		
		String fileName = firstName+"."+endName;
		fileUpDo(file, path, fileName);
		return fileName;
	}
}
