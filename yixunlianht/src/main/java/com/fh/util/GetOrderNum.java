package com.fh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GetOrderNum {
	 public static String getRandomFileName() {
		  SimpleDateFormat simpleDateFormat;
		  simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		  Date date = new Date();
		  String str = simpleDateFormat.format(date);
		  Random random = new Random();
		  int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		  return rannum + str;// 当前时间  
		  }
}
