package com.my.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class NovelParse {

	public static void main(String[] args) {
		//WriteFile("你好啊","");
	String str="字数：7395字 　 　　一个令人神清气爽的早晨";
	  System.out.println(str);
	  for(int ta=0;ta<str.length();ta++) {
			 //if(liststr.contains(str.charAt(ta))) {
				 System.out.println("-----匹配--------"+str.charAt(ta));
			 //}
		 }
	
	}

	
	//
	
	
	public  static void WriteFile(String name,String cont) {
		boolean ft=false;
		String des="D://ok//"+name+".txt";
		try {
			File f = new File(des);
			if(!f.exists()) {//不存在
				ft=f.createNewFile();
			}else {
				ft=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
	    }
		
		if(ft){
			try {
				FileOutputStream out=new FileOutputStream(des,true);        
				/*
				 * for(int i=0;i<10000;i++){ StringBuffer sb=new StringBuffer();
				 * sb.append("这是第"+i+"行:前面介绍的各种方法都不关用,为什么总是奇怪的问题 ");
				 * out.write(sb.toString().getBytes("utf-8")); }
				 */     
				//out.write(cont);
				out.write(cont.toString().getBytes("utf-8"));
				 out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
