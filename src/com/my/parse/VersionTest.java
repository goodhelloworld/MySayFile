package com.my.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VersionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=2;i<69;i++) {
			List<String>ff= test9("https://www.39461.xyz/news-show-id-44-p-"+i+".html");//��ȡ����
			test9_1(ff);
			ff.clear();
		}
	}

	
	public static List<String> test9(String strurl) {
		Map<String,String>mp = new HashMap<String,String>();
		List<String>list = new ArrayList<String>();
    	try {

    		Document doc = Jsoup.connect(strurl).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
.get();
			System.out.println("ÿҳ��url---"+strurl+"---"+doc);

    		 Elements enm=doc.getElementsByClass("col-md-14 col-sm-16 col-xs-12 clearfix news-box");
    		for (Element postItem : enm) {
    			Elements titleEle = postItem.select("a");
    			System.out.println("11---"+titleEle.size());
				System.out.println("22---"+titleEle.get(0).attr("href")+"----");
				//http://ddxx99.com/htm/novel5/193508.htm
				list.add("https://www.39461.xyz"+titleEle.get(0).attr("href"));

//    			for (int i=0;i<titleEle.size();i++) {
//    				Elements mm=titleEle.get(i).select("a");
//    				//System.out.println("22---"+mm.get(0).attr("href")+"----"+i);
//    				list.add("http://www.ay3y.com" +mm.get(0).attr("href"));
//    				//http://www.ay3y.com/njg/70028/read.html
//    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return list;
	}

	
	public static List<String> mystr(){
		List<String> liststr = new ArrayList<String>();
		liststr.add("��");
		liststr.add("��");
		liststr.add("�̸�");
		liststr.add("����");
		liststr.add("Ů��");
		liststr.add("��");
		liststr.add("��");
		liststr.add("��");
		liststr.add("ʦ");
		liststr.add("����");
		liststr.add("��");
		liststr.add("����");
		liststr.add("����");
		liststr.add("��Ů");
		liststr.add("ʦ");
		liststr.add("ҽ��");
		liststr.add("ɩ");
		liststr.add("ͬѧ");
		liststr.add("����");
		liststr.add("��");
		liststr.add("����");
		liststr.add("��");
		liststr.add("��");
		liststr.add("��");

		return liststr;
		
	}
	
  public  static boolean FilterString(String str) {
		List<String> liststr =mystr();
		 boolean f=false;
		 for(int ta=0;ta<liststr.size();ta++) {//����
			 String data=liststr.get(ta);
			if(str.contains(data)) {
				f=true;
				break;
			}
		 }
		 return f;
  }
	
	
	public static void test9_1(List<String>mylist) {
		List<String> liststr =mystr();
		 System.out.println("-----sss--------"+liststr.size());

		Map<String,String>mp = new HashMap<String,String>();
    	try {
    		
    		for(int t=0;t<mylist.size();t++) {
System.out.println("====="+mylist.get(t));
	    		Document doc = Jsoup.connect(mylist.get(t)).header("User-Agent","Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
.get();
			
			 Elements title=doc.getElementsByClass("text-overflow");

			 
			 Elements enm=doc.getElementsByClass("details-content text-justify");
			 
			 for (Element postItem : enm) { //��jqueryѡ����һ������ȡ���±���Ԫ�� 
			  ///Elements titleEle = postItem.select("td"); 
				 boolean f=false;
				 for(int ta=0;ta<liststr.size();ta++) {//����
					if(title.text().contains(liststr.get(ta))) {
						f=true;
						break;
					}
				 }
				 if(!f) {//
					 System.out.println("���±���:"+title.text());
					 String nn="";
					 if(title.text().length()>8) {
						 nn=title.text().substring(0, 8);
					 }else {
						 nn=title.text();
					 }
					  //System.out.println("fff====="+postItem.html());
					  String fn= fn=postItem.html().replaceAll("<br>", "\n").replaceAll("<br />", "\n").replaceAll("</p>", "\n");
					   // System.out.println(postItem.text());
				     NovelParse.WriteFile(nn,fn);
				 }
				 
			 }
			 
    			 Thread.sleep(3*1000);
    		}
    		
    	}catch(Exception e) {
    		e.getSuppressed();
    	}
	}

	
	
	
}
