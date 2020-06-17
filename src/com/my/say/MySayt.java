package com.my.say;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.my.parse.NovelParse;

public class MySayt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> mp=null;
		for(int i=1;i<=4;i++) {
			if(i==1) {
				 mp=getString_zjjndz("http://www.beijingotes.com/book/type/21/1.html",".col-md-14 a");
				getfile_zjjndz(mp);
			}else {
			    mp=getString_zjjndz("http://www.beijingotes.com/book/type/21/"+i+".html",".col-md-14 clearfix news-box a");
				getfile_zjjndz(mp);
			}
			mp.clear();
		}
		
	}
	
	
 //获取列表数据 小说列表获取所有url
    public static Map<String,String> getString_zjjndz(String strurl,String ptype) {
    	Map<String,String>mp = new HashMap<String,String>();
    	try {
    		Document doc = Jsoup.connect(strurl).get();
			//System.out.println(doc);

    		Elements enm=doc.select(ptype);//目标集合
    		for(int i=0;i<enm.size();i++) {
    			System.out.println(enm.get(i).attr("href")+"--ff--"+enm.get(i).attr("title"));
    			mp.put(enm.get(i).attr("title"), "http://www.beijingotes.com"+enm.get(i).attr("href"));
    		}
    		System.out.println(mp+"----mp------");
    		return mp;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return mp;
    }
    
    
    public static void getfile_zjjndz(Map<String,String>mp) {

    	try {
    		for(Map.Entry<String, String>tt : mp.entrySet()) {
    			 String title=tt.getKey();
 				System.out.println("ttt---"+tt+"----"+tt.getValue());

    			 Document doc = Jsoup.connect(tt.getValue()).get();//文章url
    			 Elements enm=doc.select("<book> p");//文章的class
    			 for (Element postItem : enm) { //像jquery选择器一样，获取文章标题元素 
    				System.out.println("ok000---"+postItem.text());
    				 String  fn=postItem.text().replaceAll("<br>", "\t\n").replaceAll("<br />", "\t\n").replaceAll(" 　　", "\t\n");
        			 NovelParse.WriteFile(title,fn);
    				 
    			 }
    			 Thread.sleep(3*1000);
    		}
    	}catch(Exception e) {
    		e.getSuppressed();
    	}
	}
    
    
    //写文件
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
