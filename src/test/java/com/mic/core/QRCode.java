/**
 * chenPeng
 * com.mic.core
 * QRCode.java
 * 创建人:chenpeng
 * 时间：2018年9月10日-下午9:54:21 
 * 2018陈鹏-版权所有
 */
package com.mic.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * QRCode
 * 创建人:chenPeng
 * 时间：2018年9月10日-下午9:54:21 
 * @version 1.0.0
 * 
 */
public class QRCode {
	 public static void main(String[] args) {
	        int width = 300;
	        int height = 300;
	        String format = "png";
	        String content = "www.baidu.com";
	        //定义二维码的参数
	        HashMap<EncodeHintType, Comparable> map = new HashMap<EncodeHintType, Comparable>();
	        //设置编码
	        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
	        //设置纠错等级
	        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
	        map.put(EncodeHintType.MARGIN, 2);

	        try {
	            //生成二维码
	            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
	            Path file = new File("D:/1.png").toPath();
	            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
	        } catch (WriterException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
