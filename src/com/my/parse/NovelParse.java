package com.my.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class NovelParse {

	public static void main(String[] args) {
		//WriteFile("��ð�","");
	String str="������7395�� �� ����һ������������ˬ���糿";
	  System.out.println(str);
	  for(int ta=0;ta<str.length();ta++) {
			 //if(liststr.contains(str.charAt(ta))) {
				 System.out.println("-----ƥ��--------"+str.charAt(ta));
			 //}
		 }
	
	}

	
	//
	
	
	public  static void WriteFile(String name,String cont) {
		boolean ft=false;
		String des="D://ok//"+name+".txt";
		try {
			File f = new File(des);
			if(!f.exists()) {//������
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
				 * sb.append("���ǵ�"+i+"��:ǰ����ܵĸ��ַ�����������,Ϊʲô������ֵ����� ");
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
