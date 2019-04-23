/**
 * chenPeng
 * com.mic.core
 * FaceComp.java
 * 创建人:chenpeng
 * 时间：2019年4月22日-下午10:53:17 
 * 2019陈鹏-版权所有
 */
package com.mic.core;

import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * 
 * FaceComp
 * 创建人:chenPeng
 * 时间：2019年4月22日-下午10:53:17 
 * @version 1.0.0
 * 
 */
public class FaceComp {
	public static String faceComp(String imgSrc1,String imgSrc2){
		ImgBeat64 imgBeat64 = new ImgBeat64();
		
	    String host = "http://rlsbbd.market.alicloudapi.com";
	    String path = "/face/verify";
	    String method = "POST";
	    String appcode = "b400dde4904541f2b832975111886291";
	    
	    
	    String img01 = imgBeat64.getBeat64(imgSrc1);
	    String img02 = imgBeat64.getBeat64(imgSrc2);
	    
	    
	    String img1 = ""; 
	    String img2 = "";
	    String returnStr = "";
	    HashMap<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    //根据API的要求，定义相对应的Content-Type
	    headers.put("Content-Type", "application/json; charset=UTF-8");
	    HashMap<String, String> querys = new HashMap<String, String>();
	    String bodys =
	    		"{"
	    		+ "\"type\":1,"
	    		+ "\"image_url_1\":\""+img1+"\","
	    		+ "\"content_1\":\""+img01+"\","
	    		+ "\"image_url_2\":\""+img2+"\","
	    		+ "\"content_2\":\""+img02+"\""
	    		+ "}";
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	//System.out.println(response.toString());
	    	//获取response的body
	    	returnStr = EntityUtils.toString(response.getEntity());
	    	System.out.println(returnStr);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return returnStr;
	}
}
