package com.fh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*Date date = new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String curDate = s.format(date);  //当前当前天
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, +1);  
		String nextDate_1 = s.format(cal.getTime());  //获取当前天的后一天
		System.err.println("after"+nextDate_1);
		System.out.println("curDate"+curDate);*/
		Calendar cal = Calendar.getInstance();  				
		String year =  cal.get(Calendar.YEAR)+"";
		String month =  cal.get(Calendar.MONTH)+"";
		SimpleDateFormat s=new SimpleDateFormat(year +"-"+month+"-dd 00:00:00");
		cal.add(Calendar.DAY_OF_YEAR, +0); 
		String curDate = s.format(cal.getTime());//获取当前天
		cal.add(Calendar.DAY_OF_YEAR, +1);  
		String nextDate_1 = s.format(cal.getTime());  //获取当前天的后一天
		System.out.println("a"+curDate+"b"+nextDate_1);
	}

}
