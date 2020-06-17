package com.my.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.my.parse.NovelParse;

public class MyUtil {
	
	public static void main(String[] args) {
		for(int i=1;i<33;i++) {//33 总页数
		List<String>	nn=test7("https://1024fff.com/news-show-id-73-p-"+i+".html");
			test8_1(nn);
			nn.clear();
		}
	}
	
	//解析连接，获取文章
	public static void test8_1 (List<String>mylist) {

			Map<String,String>mp = new HashMap<String,String>();
	    	try {
	    		for(int t=0;t<mylist.size();t++) {
	        		//System.out.println("aaa----"+mylist.get(t));

		    		Document doc = Jsoup.connect(mylist.get(t)).get();
		    		//System.out.println(doc);
				
				 Elements title=doc.getElementsByTag("h1");
	        		//System.out.println("aaa----"+title.text());
				 Elements enm=doc.getElementsByClass("content");
				 
				 for (Element postItem : enm) { //像jquery选择器一样，获取文章标题元素 
				  ///Elements titleEle = postItem.select("td"); 
					  //System.out.println("文章标题:"+title.text());
					 //if(!FilterString(title.text())) {
						 String  fn=postItem.text().replaceAll("</p>", "\t\n").replaceAll("<p>", "\t\n").replaceAll(" 　　", "\t\n");
						   NovelParse.WriteFile(title.text(),fn);
					// }
				     //System.out.println(postItem.text());
					  //String fn=titleEle.text().replaceAll(" 　　", "\t\n");//文章内容
					 
				 }
				 
	    			 Thread.sleep(3*1000);
	    		}
	    		
	    	}catch(Exception e) {
	    		e.getSuppressed();
	    	}
		
	}
	
	//获取连接列表
	public static List<String> test7(String strurl) {
		Map<String,String>mp = new HashMap<String,String>();
		List<String>list = new ArrayList<String>();
    	try {
    		Document doc = Jsoup.connect(strurl).get();
    		//xslist text-bg-c
    		Elements  ms=doc.select("td a");
    		for(int i=0;i<ms.size();i++) {
    			if(ms.get(i).attr("href").endsWith(".html")&&!"/news-show-id-73-p-1.html".equals(ms.get(i).attr("href"))) {
        			//System.out.println("test----"+("https://1024fff.com"+ms.get(i).attr("href")));

    				list.add("https://1024fff.com"+ms.get(i).attr("href"));
    			}
    			String n=ms.get(i).attr("href");
    		}
    		System.out.println(ms.size());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return list;
	}

}
