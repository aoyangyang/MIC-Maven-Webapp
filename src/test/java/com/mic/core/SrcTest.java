/**
 * chenPeng
 * com.mic.core
 * SrcTest.java
 * 创建人:chenpeng
 * 时间：2019年4月22日-下午11:06:00 
 * 2019陈鹏-版权所有
 */
package com.mic.core;

/**
 * 
 * SrcTest
 * 创建人:chenPeng
 * 时间：2019年4月22日-下午11:06:00 
 * @version 1.0.0
 * 
 */
public class SrcTest {
	public static void main(String[] args) {
		String str = "{\"confidence\":16.529254913330078,\"thresholds\":[61.0,69.0,75.0],\"rectA\":[146,123,450,595],\"rectB\":[208,191,332,489],\"errno\":0,\"request_id\":\"B0045205-5171-4A51-8947-9F3FF604A839\"}";
		System.out.println(str);
		String temp = str.split(",")[0];
		String temp2 = temp.split(":")[1];
		Double temp3 = Double.parseDouble(temp2);
		System.out.println(temp3);
	}
}
