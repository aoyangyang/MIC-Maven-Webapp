package com.mic.core;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CpDate {
	Date date = new Date();
	
	/**
	 * 得到Date时钟时间
	 * 方法名：getClockTime
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午7:56:04 
	 * 手机:17673111810
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public long getClockTime() {
		return date.getTime();
	}
	
	/**
	 * 传入时间格式和时间 得到毫秒时间
	 * 方法名：getClockTime
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午11:02:42 
	 * 手机:17673111810
	 * @param format
	 * @param time
	 * @return long
	 * @exception 
	 * @since  1.0.0
	 */
	public long getClockTime(String format,String time) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(format);
		try {
			date = bartDateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("传入的格式与时间格式不符合");
		}
		return date.getTime();
	}
	
	/**
	 * 得到完整时间sql
	 * 方法名：Timestamp
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午8:10:15 
	 * 手机:17673111810
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getTimestamp() {
		java.sql.Timestamp stp = new java.sql.Timestamp(date.getTime());
		return stp+"";
	}
	
	/**
	 * 传入毫秒级得到完整时间sql
	 * 方法名：getTimestamp
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午10:56:28 
	 * 手机:17673111810
	 * @param clockTime
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getTimestamp(long clockTime) {
		java.sql.Timestamp stp = new java.sql.Timestamp(clockTime);
		return stp+"";
	}

	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 得到格式化时间
	 * y	年; M	年中的月份; 
	 * w 年中的周数;
	 * W月份中的周数；
	 * D	年中的天数	；
	 * d	月份中的天数	；
	 * F	月份中的星期	；
	 * E	星期中的天数	；
	 * a	Am/pm	标记；
	 * H	一天中的小时数（0-23）;
	 * k	一天中的小时数（1-24）；
	 * K	am/pm 中的小时数（0-11）
	 * h	am/pm 中的小时数（1-12）
	 * m	小时中的分钟数	
	 * s	分钟中的秒数	
	 * S	毫秒数	
	 * z	时区	
	 * Z	时区
	 * 方法名：getTimeFormat
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午8:27:12 
	 * 手机:17673111810
	 * @param format
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getTimeFormat(String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	/**
	 * 得到指定毫秒级时间的时间
	 * 方法名：getTimeFormat
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午8:50:31 
	 * 手机:17673111810
	 * @param format
	 * @param clockTime
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getTimeFormat(String format,long clockTime) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(clockTime);
	}
	/**
	 * 得到指定date的时间 
	 * 方法名：getTimeFormat
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午8:51:00 
	 * 手机:17673111810
	 * @param date
	 * @param format
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getTimeFormat(Date date,String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	/**
	 * 传入改变time（传入int -为倒退多少天） 与 格式 
	 * 方法名：changeTime
	 * 创建人：chenPeng
	 * 时间：2018年4月16日-下午8:53:11 
	 * 手机:17673111810
	 * @param time
	 * @param format
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String changeTime(int time,String format) {
		CpDate cpDate = new CpDate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, time);
		return cpDate.getTimeFormat(calendar.getTime(), format);
	}
	
}
