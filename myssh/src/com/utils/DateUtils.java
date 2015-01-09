package com.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	/**
	 * 将日期转换成"yyyy-MM-dd"字符串
	 * @param date
	 * @return
	 */
	public static String converDate(Date date){
		
//		SimpleDateFormat sf = new SimpleDateFormat("MMM d, yyyy ",Locale.ENGLISH );
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = null;
		
		currentDate = sf.format(date);
		
		return currentDate;
	}
	
	public static String converDateTime(Date date){
		
//		SimpleDateFormat sf = new SimpleDateFormat("MMM d, yyyy ",Locale.ENGLISH );
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentDate = null;
		
		currentDate = sf.format(date);
		
		return currentDate;
	}
	
//	public static void main(String []args){
//		System.out.println(converDate(new Date()));
//	}
}
