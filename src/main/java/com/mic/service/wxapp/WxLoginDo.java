/**
 * chenPeng
 * com.mic.service.wxapp
 * WxLoginDo.java
 * 创建人:chenpeng
 * 时间：2019年4月21日-下午2:30:46 
 * 2019陈鹏-版权所有
 */
package com.mic.service.wxapp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.mic.bean.student.Student;
import com.mic.bean.wxapp.WxAppQc;
import com.mic.bean.wxapp.WxClass;
import com.mic.bean.wxapp.WxUser;
import com.mic.core.FaceComp;
import com.mic.core.FileUp;
import com.mic.dao.wxapp.WxLoginDao;

/**
 * 
 * WxLoginDo
 * 创建人:chenPeng
 * 时间：2019年4月21日-下午2:30:46 
 * @version 1.0.0
 * 
 */
@Service
public class WxLoginDo {
	@Autowired
	private HttpServletRequest re;
	@Autowired
	private WxLoginDao wxLoginDao;
	/**
	 * 登录
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2019年4月21日-下午2:42:41 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		Map<String, String> user = new HashMap<String, String>();  
		user.put("username", username);
		user.put("password", password);
		Student student = wxLoginDao.login(user);
		
		
		if (student==null) {
			return "NoFondUser";
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", student.getId());
		jsonObject.put("username", student.getUsername());
		jsonObject.put("classname", student.getPassword());
		jsonObject.put("email", student.getEmail());
		jsonObject.put("phone", student.getPhone());
		jsonObject.put("point", student.getPoint());
		return jsonObject.toString();
	}
	/**
	 * 
	 * 方法名：微信小程序 二维码签到
	 * 创建人：chenPeng
	 * 时间：2019年4月21日-下午7:25:14 
	 * 手机:17673111810
	 * @param username
	 * @param url
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String qc(String username, String url) {
		// TODO Auto-generated method stub
		
		//解析url
		String[] strs = url.split(",");
		String courseId = strs[0];
		
		//获取密码
		Integer pwd = Integer.parseInt(
				wxLoginDao.getQCpwd(Integer.parseInt(courseId)));
		
		Long key = Long.parseLong(strs[1]);
		
		Date date = new Date();
		
		Integer time = (int) (date.getTime()-key/pwd);
		
		if (time>3000) {
			return "no";
		}
		
		//更改状态
		int st = 0;
		st = wxLoginDao.upInfoStatrt(
			new WxAppQc(username, pwd+"", Integer.parseInt(courseId)));
		
		System.out.println(st);
		return "success";
	}
	/**
	 * 人脸识别
	 * 方法名：face
	 * 创建人：chenPeng
	 * 时间：2019年4月21日-下午10:13:52 
	 * 手机:17673111810
	 * @param file
	 * @param username
	 * @param latitude
	 * @param longitude
	 * @param accuracy
	 * @param classname 
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String face(MultipartFile file, String username, String latitude, String longitude, String accuracy, String classname) {
		// TODO Auto-generated method stub
		//头像上传
		String picSrc = 
				re.getSession().getServletContext().getRealPath("/img/faceTemp");
		FileUp fileUp = new FileUp();
		String fileName = fileUp.fileUp(file, picSrc);
		
		
		
		//范围no则为位置不正确 签到失败
		
		//通过 username 获取到student id ，照片，
		WxUser user = wxLoginDao.getWxUser(username);
		
		//获取到classname或取到  gps以及attendanceid
		WxClass wxClass = wxLoginDao.getWxClass(Integer.parseInt(classname));
		if (wxClass==null) {
			return "error";
		}
		
		if (wxClass.getCan()==0) {
			return "noTime";
		}
		
		
		//对比gps未做
		
		
		
		if (wxClass.getState()==10) {
			return "success";
		}
		//对比人脸识别
		String picSrcY = 
				re.getSession().getServletContext().getRealPath("/img/head");
		
		String faceStr = FaceComp.faceComp(picSrcY+user.getPic(), picSrc+fileName);
		
		//处理返回结果
		String temp = faceStr.split(",")[0];
		String temp2 = temp.split(":")[1];
		Double temp3 = Double.parseDouble(temp2);
		if (temp3<80) {
			return "no";
		}
		
		return "success";
	}
	
}
