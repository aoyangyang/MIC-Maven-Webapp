package com.mic.core;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.GpsDirectory;


//getDirectoryList(GpsDirectory.class);
public class ImgTestCore {
	public static void test1(){
		File file = new File("C:/Users/81022/Desktop/1.jpg");
        Metadata metaData = null;
		try {
			metaData = ImageMetadataReader.readMetadata(file);
		} catch (Exception e) { 
            // To do deal exception
		}
		Collection<GpsDirectory> directory = metaData.getDirectoriesOfType(GpsDirectory.class);
		Iterator<GpsDirectory> it = directory.iterator();
		while(it.hasNext()){
			GpsDirectory next = it.next();
			//维度
			String latitude = next.getString(GpsDirectory.TAG_LATITUDE);
			//经度
			String longitude = next.getString(GpsDirectory.TAG_LONGITUDE);
			System.out.println(latitude);
			System.out.println(longitude);
			
			String[] number = longitude.split(" ");
			String[] hs = number[0].split("/");// 度
			String[] ms = number[1].split("/");// 分
			String[] ss = number[2].split("/");// 秒
			// 秒转分
			double md = Double.valueOf(ms[0])/Double.valueOf(ms[1]) + Double.valueOf(ss[0])/(Double.valueOf(ss[1])*60);
			// 分转度
			double sd = Double.valueOf(hs[0])/Double.valueOf(hs[1]) + md/60;
			System.out.println(sd);
		}
	}
	

	
	public static void main(String[] args) throws JpegProcessingException, IOException{
		test1();
		
	}
}
