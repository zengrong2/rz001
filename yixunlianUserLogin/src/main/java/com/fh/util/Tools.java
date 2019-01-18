package com.fh.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/** 
 * 说明：常用工具
 * 创建人：FH Q728971035
 * 修改时间：2015年11月24日
 * @version
 */
public class Tools {
	
	
	
	/**
	 * 随机生成六位数验证码 
	 * @return
	 */
	public static int getRandomNum(){
		 Random r = new Random();
		 return r.nextInt(900000)+100000;//(Math.random()*(999999-100000)+100000)
	}
	
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}
	
	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s){
		return s==null || "".equals(s) || "null".equals(s);
	}
	
	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str,String splitRegex){
		if(isEmpty(str)){
			return null;
		}
		return str.split(splitRegex);
	}
	
	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str	字符串
	 * @return
	 */
	public static String[] str2StrArray(String str){
		return str2StrArray(str,",\\s*");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date){
		return date2Str(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date){
		if(notEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}
	
	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
	
	/**
	 * 把时间根据时、分、秒转换为时间段
	 * @param StrDate
	 */
	public static String getTimes(String StrDate){
		String resultTimes = "";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    java.util.Date now;
	    
	    try {
	    	now = new Date();
	    	java.util.Date date=df.parse(StrDate);
	    	long times = now.getTime()-date.getTime();
	    	long day  =  times/(24*60*60*1000);
	    	long hour = (times/(60*60*1000)-day*24);
	    	long min  = ((times/(60*1000))-day*24*60-hour*60);
	    	long sec  = (times/1000-day*24*60*60-hour*60*60-min*60);
	        
	    	StringBuffer sb = new StringBuffer();
	    	//sb.append("发表于：");
	    	if(day>0) {
	    		sb.append(day+"天前");
	    	}
	    	else if(hour>0 ){
	    		sb.append(hour+"小时前");
	    	} else if(min>0){
	    		sb.append(min+"分钟前");
	    	} else{
	    		sb.append(sec+"秒前");
	    	}
	    		
	    	resultTimes = sb.toString();
	    } catch (ParseException e) {
	    	e.printStackTrace();
	    }
	    
	    return resultTimes;
	}
	
	/**
	 * 写txt里的单行内容
	 * @param filePath  文件路径
	 * @param content  写入的内容
	 */
	public static void writeFile(String fileP,String content){
		String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
		filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
		if(filePath.indexOf(":") != 1){
			filePath = File.separator + filePath;
		}
		try {
	        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");      
	        BufferedWriter writer=new BufferedWriter(write);          
	        writer.write(content);      
	        writer.close(); 

	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * 验证邮箱
	  * @param email
	  * @return
	  */
	 public static boolean checkEmail(String email){
	  boolean flag = false;
	  try{
	    String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	    Pattern regex = Pattern.compile(check);
	    Matcher matcher = regex.matcher(email);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
	
	 /**
	  * 验证手机号码
	  * @param mobiles
	  * @return
	  */
	 public static boolean checkMobileNumber(String mobileNumber){
	  boolean flag = false;
	  try{
	    Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	    Matcher matcher = regex.matcher(mobileNumber);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
	 
	/**
	 * 检测KEY是否正确
	 * @param paraname  传入参数
	 * @param FKEY		接收的 KEY
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean checkKey(String paraname, String FKEY){
		paraname = (null == paraname)? "":paraname;
		return MD5.md5(paraname+DateUtil.getDays()+",fh,").equals(FKEY);
	}
	 
	/**
	 * 读取txt里的单行内容
	 * @param filePath  文件路径
	 */
	public static String readTxtFile(String fileP) {
		try {
			
			String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
			filePath = filePath.replaceAll("file:/", "");
			filePath = filePath.replaceAll("%20", " ");
			filePath = filePath.trim() + fileP.trim();
			if(filePath.indexOf(":") != 1){
				filePath = File.separator + filePath;
			}
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { 		// 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
				new FileInputStream(file), encoding);	// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					return lineTxt;
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件,查看此路径是否正确:"+filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
		}
		return "";
	}
	/*
	 * 截取上传富文本的内容中的第一张图片
	 * 
	 */
	public static String ueditorStrArray(String str){
			if(isEmpty(str)){
				return null;
			}
			String arr[] =  str2StrArray(str,"<img");
	
			if(arr.length>1) {
				String ueditoraArrFirstImg[] = arr[1].split("/>");
				return ueditoraArrFirstImg[0];
			}else {
				return null;
			}
			
		}
	/*public static String[] hongbao(int num,int money){
		int sum =0;
		for(int i=0;i<num;i++) {
			int a = (int)(Math.random()*money);
			
		}
		
	}*/
	
	public static void main(String[] args) {
	/*	Tools tools = new Tools();
		System.out.println("a"+tools.getTimes("2018-10-13 23:49:16"));*/
		/*String arr[] =  str2StrArray("<p>这是<img src=\"/yixunlianht/plugins/ueditor/jsp/upload1/20181012/20961539311294927.jpg\" title=\"公司.jpg\"/></p><p><br/></p><img src=\\\"/yixunlianht/plugins/ueditor/jsp/upload1/20181012/20961539311294927.jpg\\\" title=\\\"公司.jpg\\\"/><p>啊是","<img");
		System.out.println("a"+arr.length);
		String arr2[] = arr[1].split("/>");
		System.out.println("b"+arr2[0]);*/
		
/*		String CONTENT =  ueditorStrArray("<p>这是<img src=\"/yixunlianht/plugins/ueditor/jsp/upload1/20181012/20961539311294927.jpg\" title=\"公司.jpg\"/></p><p><br/></p><img src=\\\"/yixunlianht/plugins/ueditor/jsp/upload1/20181012/20961539311294927.jpg\\\" title=\\\"公司.jpg\\\"/><p>啊是");
*/		/*String CONTENT =  ueditorStrArray("<p>这是</p>啊是");*/

		
		
		/*	System.out.println("1"+CONTENT);*/
		
		/*System.out.println(getRandomNum());*/
		
		/*
		 * -------
		 */
		System.out.println("请输入你要加密的数字：");
		Scanner in = new Scanner(System.in);
		String num = in.next();
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(num.trim());
		if (isNum.matches()) {
			// 执行加密的方法
			encrypt(num);
		} else {
			System.out.println("输入的不是数字，请输入数字");
		}


	}
	/*
	 * 数字加密
	 */
	public static void encrypt(String stuNum){
		String  	encrypt =   "";					//加密后的字符串
		String  	yuan    =   "";					//交换位置前
		int  		num   	=   0;               	//拆分成单个数字
		int  		sNum  	=   0;               	//每个数字加5之后
		int  		yNum  	=   0;               	//每个数字的和除以10的余数 
		
		
		
		int n [] = new int[stuNum.length()];
		//将每个数字转换成int类型的
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(String.valueOf(stuNum.charAt(i)));
			
		}
		
		//通过冒泡排序法进行降序排序
		for (int i = 0; i < n.length - 1; i++) {
			for (int j = 0; j < n.length - 1 - i; j++) {
				if (n[j] < n[j + 1]) {
					int temp;
					temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
				}
			}
		}
		
		for (int i = 0; i < n.length; i++) {
			String cNum = n[i]+"";
			num = Integer.parseInt(cNum);
			//进行每个数字加5
			sNum = num+5;
			//再用和除以6的余数代替该数字
			yNum = sNum % 6;
			//该和除以6的余数
			num  = yNum; 
			//把每个数字都放在yuan的字符串里面
			yuan += num;
		}
		//将最后一个数字和第一个数字交换位置
		int m [] = new int[yuan.length()];
		//将每个数字转换成int类型的
		for (int i = 0; i < m.length; i++) {
			m[i] = Integer.parseInt(String.valueOf(yuan.charAt(i)));
		}
		//交换位置
		int fristNum = m[0];
		m[0]= m[m.length-1];
		m[m.length-1] = fristNum;
		for (int i = 0; i < m.length; i++) {
			encrypt += m[i];
		}
		//把加密后的数组放在字符串中
		System.out.println("原来的电话号码："+stuNum);
		System.out.println("加密后的电话号码："+encrypt);
	}


	
}
