package com.my.urldown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MuTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			test("https://m3u8.cdnpan.com/ELxuciDw.m3u8");
	}
   public static void test(String urlStr) {
	   

       
       
       //�õ�������
       try {
    	   URL url = new URL(urlStr);  
           HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
                   //���ó�ʱ��Ϊ3��
           conn.setConnectTimeout(10*1000);
           //��ֹ���γ���ץȡ������403����
           //conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

           conn.setRequestProperty(
    				"Accept",
    				"image/gif, image/jpeg, image/pjpeg, image/pjpeg, " +
    				"application/x-shockwave-flash, application/xaml+xml, " +
    				"application/vnd.ms-xpsdocument, application/x-ms-xbap, " +
    				"application/x-ms-application, application/vnd.ms-excel, " +
    				"application/vnd.ms-powerpoint, application/msword, */*");
    		conn.setRequestProperty("Accept-Language", "zh-CN");
    		conn.setRequestProperty("Charset", "UTF-8");
    		//������������ͺͰ汾������ϵͳ��ʹ�����Ե���Ϣ
    		conn.setRequestProperty(
    				"User-Agent",
    				"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2; Trident/4.0; " +
    				".NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; " +
    				".NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
    		//����Ϊ������
    		 StringBuilder sb = new StringBuilder();
    		conn.setRequestProperty("Connection", "Keep-Alive");
	    	InputStream inputStream = conn.getInputStream();
		      InputStreamReader rs = new InputStreamReader(inputStream);
		      BufferedReader br = new BufferedReader(rs);
		      String data = br.readLine();//��ȡ����   
		      while (data != null) {//ѭ����ȡ����        
		    	  sb.append(data);        
		    	  data = br.readLine();    
		  		System.out.println(data);

		    	  }    
		      rs.close();   
		      br.close();    
		      inputStream.close();
	} catch (IOException e) {
		e.printStackTrace();
	}  
       //��ȡ�Լ�����
       
       
   }
}
