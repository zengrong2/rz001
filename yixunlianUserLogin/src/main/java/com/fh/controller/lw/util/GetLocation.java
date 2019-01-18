package com.fh.controller.lw.util;

import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 根据经纬度获取地址信息
 * @author a55660000
 *
 */
public class GetLocation {
	
	public static void main(String[] args) {

		 String []add = getArea("104.093638", "30.647143");   
		System.out.println(add);
	}
	
	 public static String[] getArea(String log, String lat ) {    
	        String add = getAdd(log, lat);    
	        JSONObject jsonObject = JSONObject.fromObject(add);    
	        JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("addrList"));    
	        JSONObject j_2 = JSONObject.fromObject(jsonArray.get(0)); 
	        String allAdd = j_2.getString("admName");    
	        String arr[] = allAdd.split(","); 
	        if(arr.length<3) {
	        	return null;
	        }
	       return arr;
	    }    
	        
	 public static String getAdd(String log, String lat ){    
	        //lat 小  log  大    
	        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)   
	        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";    
	        String res = "";       
	        try {       
	            URL url = new URL(urlString);      
	            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();      
	            conn.setDoOutput(true);      
	            conn.setRequestMethod("POST");      
	            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));      
	            String line;      
	           while ((line = in.readLine()) != null) {      
	               res += line+"\n";      
	         }      
	            in.close();      
	        } catch (Exception e) {      
	            System.out.println("error in wapaction,and e is " + e.getMessage());      
	        }     
	        return res;      
	    }    

}
