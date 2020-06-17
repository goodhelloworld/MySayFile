package com.my.parse;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.my.database.GetConnection;
import com.my.urldown.DownLoad;

public class PaesePage {

	public static void main(String[] args) {
		//textList
		//test3();
		
		
		  for(int i=90;i<92;i++) {
		  test4("http://xxxxdyw66.vip/html/tupian/1/index"+i+".html");
		  
		  }
		 
//		test5("http://xxxxdyw66.vip/html/xiaoshuo/4/6761/index.html");
		
		
		
		
//		  for(int i=38;i<40;i++) { if(i==1) {
//		  List<String>mylist=test6("http://xxxxdyw66.vip/html/xiaoshuo/4/index.html");
//		    test5(mylist);
//		   mylist.clear(); 
//		  }else {
//		  System.out.println("��ҳ��---"+"http://xxxxdyw66.vip/html/xiaoshuo/4/index"+i+".html");
//		  List<String>mylist=test6("http://xxxxdyw66.vip/html/xiaoshuo/4/index"+i+".html");
//		  test5(mylist); 
//		  mylist.clear(); 
//		  }
//		 
//		 }
		
		
		
//		 if(!FilterString("�������ڹ�����������ɧŮ  - ��������")) {
//			 System.out.println("---");
//		 }
		for(int i=1;i<43;i++) { 
		if(i==1) {
			List<String>ff= test8("http://new04.xyz/?m=art-type-id-1.html");
			 test8_1(ff);
				 ff.clear();
			}else {
  			List<String>ff= test8("http://new04.xyz/?m=art-type-id-"+i+".html");
				test8_1(ff);
			 ff.clear();
		}
		}
		 
		
		
		
		//  http://www.ay3y.com/njf/16/1.html
		
		
		
		
		
		
//		  for(int i=21;i<160;i++) {
//		   System.out.println("=============================="+i); 
//		  if(i==1) {
//		     List<String>ff= test9("http://www.ay3y.com/njf/16/1.html"); 
//		     test9_1(ff);
//		     ff.clear(); 
//		  }else {
//			  List<String>ff=test9("http://www.ay3y.com/njf/16/"+i+".html");
//			  test9_1(ff); 
//			  ff.clear(); 
//		   }
//		 
//		  }
		 
		
		/*
		 * for(int i=0;i<100000;i++) {
		 * getStringA("http://localhost:8080/MyJquery/test1.jsp");
		 * 
		 * }
		 */
		
		
		//test3_1();
		
		//test3();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	  public static Map<String,String> getStringA(String strurl) {
	    	Map<String,String>mp = new HashMap<String,String>();
	    	try {
	    		Document doc = Jsoup.connect(strurl).get();
	    		System.out.println(doc);
	    		return mp;
	    	}catch(Exception e) {
	    		e.getSuppressed();
	    	}
	    	return null;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<String> test9(String strurl) {
		Map<String,String>mp = new HashMap<String,String>();
		List<String>list = new ArrayList<String>();
    	try {
    		Document doc = Jsoup.connect(strurl).get();
    		 Elements enm=doc.getElementsByClass("box list channel");
    		for (Element postItem : enm) {
    			Elements titleEle = postItem.select("li");
    			//System.out.println("11---"+titleEle.size());
    			for (int i=0;i<titleEle.size();i++) {
    				Elements mm=titleEle.get(i).select("a");
    				//System.out.println("22---"+mm.get(0).attr("href")+"----"+i);
    				list.add("http://www.ay3y.com" +mm.get(0).attr("href"));
    				//http://www.ay3y.com/njg/70028/read.html
    			}
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

	    		Document doc = Jsoup.connect(mylist.get(t)).get();
			
			 Elements title=doc.getElementsByClass("page_title");

			 
			 Elements enm=doc.getElementsByClass("content");
			 
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
					  //System.out.println("fff====="+postItem.html());
					  String fn= fn=postItem.html().replaceAll("<br>", "\n").replaceAll("<br />", "\n");
					   // System.out.println(postItem.text());
				     NovelParse.WriteFile(title.text(),fn);
				 }
				 
			 }
			 
    			 Thread.sleep(3*1000);
    		}
    		
    	}catch(Exception e) {
    		e.getSuppressed();
    	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// http://xxxxdyw66.vip/html/xiaoshuo/4/6761/index.html
	
	
	
	public static List<String> test8(String strurl) {
		Map<String,String>mp = new HashMap<String,String>();
		List<String>list = new ArrayList<String>();
    	try {
    		Document doc = Jsoup.connect(strurl).get();
    		//xslist text-bg-c
    		Elements enm=doc.getElementsByClass("textList");//Ŀ�꼯��
    		for (Element postItem : enm) {
    			//System.out.println("22---"+enm);

    			Elements titleEle = postItem.select("li > a");
    		
    			Iterator<Element> ff=titleEle.iterator();
    			while(ff.hasNext()) {
    				//System.out.println("11---"+ff.next().attr("href"));
    				list.add("http://new04.xyz" + ff.next().attr("href"));
    			}
    			
    			 //list.add("http://xxxxdyw66.vip" + titleEle.attr("href"));
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return list;
	}
	
	
	public static void test8_1(List<String>mylist) {

		Map<String,String>mp = new HashMap<String,String>();
    	try {
    		for(int t=0;t<mylist.size();t++) {
        		//System.out.println("aaa----"+mylist.get(t));

	    		Document doc = Jsoup.connect(mylist.get(t)).get();
	    		//System.out.println(doc);
			
			 Elements title=doc.getElementsByTag("title");
			
			 Elements enm=doc.getElementsByClass("novelContent");
			 
			 for (Element postItem : enm) { //��jqueryѡ����һ������ȡ���±���Ԫ�� 
			  ///Elements titleEle = postItem.select("td"); 
				  System.out.println("���±���:"+title.text());
				 if(!FilterString(title.text())) {
					 String  fn=postItem.text().replaceAll("<br>", "\t\n").replaceAll("<br />", "\t\n").replaceAll(" ����", "\t\n");
					   NovelParse.WriteFile(title.text(),fn);
				 }
			     //System.out.println(postItem.text());
				  //String fn=titleEle.text().replaceAll(" ����", "\t\n");//��������
				 
			 }
			 
    			 Thread.sleep(3*1000);
    		}
    		
    	}catch(Exception e) {
    		e.getSuppressed();
    	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��ȡ�б�
		public static List<String> test7(String strurl) {
			Map<String,String>mp = new HashMap<String,String>();
			List<String>list = new ArrayList<String>();
	    	try {
	    		Document doc = Jsoup.connect(strurl).get();
	    		//xslist text-bg-c
	    		Elements enm=doc.getElementsByClass("textList");//Ŀ�꼯��
	    		for (Element postItem : enm) {
	    			//System.out.println("22---"+enm);

	    			Elements titleEle = postItem.select("li > a");
	    		
	    			Iterator<Element> ff=titleEle.iterator();
	    			while(ff.hasNext()) {
	    				//System.out.println("11---"+ff.attr("href")+"---"+titleEle.text());
	    				//System.out.println("11---"+ff.next().attr("href"));
	    				list.add("http://www.yazhoupian.info" + ff.next().attr("href"));
	    			}
	    			
	    			 //list.add("http://xxxxdyw66.vip" + titleEle.attr("href"));
	    		}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return list;
		}
		//http://www.yazhoupian.info/luanlunxiaoshuo/214064.html
	//����
		public static void test7_1(List<String>mylist) {

			Map<String,String>mp = new HashMap<String,String>();
	    	try {
	    		for(int t=0;t<mylist.size();t++) {
	        		//System.out.println("aaa----"+mylist.get(t));

		    		Document doc = Jsoup.connect(mylist.get(t)).get();
		    		//System.out.println(doc);
				
				 Elements title=doc.getElementsByTag("title");
				
				 Elements enm=doc.getElementsByClass("novelContent");
				 
				 for (Element postItem : enm) { //��jqueryѡ����һ������ȡ���±���Ԫ�� 
				  Elements titleEle = postItem.select("td"); 
					  System.out.println("���±���:"+title.text());
					  
				 // System.out.println(titleEle.text());
					  //String fn=titleEle.text().replaceAll(" ����", "\t\n");//��������
					  String  fn=titleEle.text().replaceAll("<br>", "\t\n");
					  
				   NovelParse.WriteFile(title.text(),fn);
				 }
				 
	    			 Thread.sleep(3*1000);
	    		}
	    		
	    	}catch(Exception e) {
	    		e.getSuppressed();
	    	}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��ȡ�б�
	public static List<String> test6(String strurl) {
		Map<String,String>mp = new HashMap<String,String>();
		List<String>list = new ArrayList<String>();
    	try {
    		Document doc = Jsoup.connect(strurl).get();
    		//xslist text-bg-c
    		Elements enm=doc.getElementsByClass("col-md-14 col-sm-16 col-xs-12 clearfix news-box");//Ŀ�꼯��
    		for (Element postItem : enm) {
    			Elements titleEle = postItem.select("a");
    			 list.add("http://xxxxdyw66.vip" + titleEle.attr("href"));
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return list;
	}
	
	//С˵
	public static void test5(List<String>mylist) {
		Map<String,String>mp = new HashMap<String,String>();
    	try {
    		for(int t=0;t<mylist.size();t++) {
	    		Document doc = Jsoup.connect(mylist.get(t)).get();
	    		Elements tt=doc.getElementsByClass("text-overflow");//Ŀ�꼯��
	    		Elements enm=doc.getElementsByClass("details-content text-justify");//Ŀ�꼯��
    			 for (Element postItem : enm) { //��jqueryѡ����һ������ȡ���±���Ԫ�� Elements titleEle =
    				 Elements titleEle = postItem.select("p");
    				 System.out.println("���±���:" +tt.get(0).text());;
    				 String fn=titleEle.text().replaceAll(" ����", "\t\n");//��������
    				 NovelParse.WriteFile(tt.get(0).text(),fn);
    			 }
    	    		
    			 Thread.sleep(3*1000);
    		}
    		
			/*
			 * Elements enm=doc.getElementsByClass("details-content text-justify");//Ŀ�꼯��
			 * 
			 * 
			 * 
			 * for (Element postItem : enm) { //��jqueryѡ����һ������ȡ���±���Ԫ�� 
			 * 
			 * Elements titleEle =
			 * postItem.select("p"); System.out.println("���±���:" + titleEle.text());;
			 * System.out.println("���µ�ַ:" + titleEle.attr("href")); //��jqueryѡ����һ������ȡ��������Ԫ��
			 * Elements footEle = postItem.select(".post_item_foot a[class='lightblue']");
			 * System.out.println("��������:" + footEle.text());; System.out.println("������ҳ:" +
			 * footEle.attr("href"));
			 * System.out.println("*********************************");
			 * System.out.println("���±���:" + titleEle.text().replaceAll(" ����", "\t\n")); }
			 */	
    	}catch(Exception e) {
    		e.getSuppressed();
    	}
	}
	
	
	
	
	
	
	
	
	
	
	public static void test4(String url) {
		  //Map<String,String>sss=getString("http://xxxxdyw66.vip/html/tupian/1/index.html");
		  Map<String,String>sss=getString(url);

		  //http://xxxxdyw66.vip/html/tupian/1/index2.html
		  System.out.println("pp--:"+sss.size()); 
		  String cnt="";
		  Map<String,String> mistr=test(sss); 
		  String nn="";
		  for(Map.Entry<String, String> entry : mistr.entrySet()){
		       String mapKey = entry.getKey(); 
		      String mapValue = entry.getValue(); //
		        System.out.println(mapKey+":"+mapValue); // DownLoad.downLoadFromUrl(); 
		  try {
		     System.out.println("׼������---"+mapKey);
		     nn=mapKey+".mp3";
		    DownLoad.downLoadFromUrl(mapValue,mapKey+".mp3","D:\\ok");
		  
		    } catch (Exception e) {
		    	GetConnection.DbStoreHelper(mapKey+".mp3",url,mapValue);
		        e.printStackTrace(); 
		        }
		  
		 }
		 
	}
	
	public static void test3_1() {
		try {
			List<String>str = new ArrayList<String>();
			str.add("xfplay://dna=Ewi0mHfcEdiWAZIdBeD5EdpYmZD1DGpXDGyfmefbBeD2DZp3Dwx3AD|dx=305841920|mz=Tokyo-Hot n1233.rmvb|zx=nhE0pdOVl2D0lwIZrNxUozI0BwxWBdaVrgMSnJ5R|zx=nhE0pdOVl3uzlwIXqJX1lzAVoGO5mdtWl3uzogyUnW");
			
			str.add("xfplay://dna=BHL1AwDXAeH1DGybAZAfA0i5DwDYAHIbDHfgDxMbEdp3EwqeDHm2mW|dx=2020176270|mz=carib-071716-210.mp4|zx=nhE0pdOVlZp0lwxXlwe4lweZmdO5mdtWl3uzogyUnW|zx=nhE0pdOVlZp0lwxXlwe4lweZmdO5mdtWl3uzogyUnW");
			str.add("xfplay://dna=mZHXEGD3mwx1Ewp0mdueExAdBdD2mxe0DGjdA0Icmde0mZt1ExjcAa|dx=257504732|mz=Tokyo-Hot n1234.rmvb|zx=nhE0pdOVl2D0lwIZrNxUozI0BwxWBdaVrgMSnJ5R|zx=nhE0pdOVl3uzlwIXqJX1lzAVoGO5mdtWl3uzogyUnW");
			
			for(int i=0;i<str.size();i++) {
				//String st= "D:\\xfplay\\xfplay.exe";// ����windowsӦ�ó���
				//Process process = Runtime.getRuntime().exec(st);
				Runtime runtime=Runtime.getRuntime(); 
				String[] commandArgs={"D:\\xfplaynew\\xfplay.exe",str.get(i)}; 
				runtime.exec(commandArgs);
				try {
					Thread.sleep(1000*40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//
	public static void test3() {
		try {
			List<String>str = new ArrayList<String>();
			str.add("xfplay://dna=Ewi0mHfcEdiWAZIdBeD5EdpYmZD1DGpXDGyfmefbBeD2DZp3Dwx3AD|dx=305841920|mz=Tokyo-Hot n1233.rmvb|zx=nhE0pdOVl2D0lwIZrNxUozI0BwxWBdaVrgMSnJ5R|zx=nhE0pdOVl3uzlwIXqJX1lzAVoGO5mdtWl3uzogyUnW");
			
			str.add("xfplay://dna=BHL1AwDXAeH1DGybAZAfA0i5DwDYAHIbDHfgDxMbEdp3EwqeDHm2mW|dx=2020176270|mz=carib-071716-210.mp4|zx=nhE0pdOVlZp0lwxXlwe4lweZmdO5mdtWl3uzogyUnW|zx=nhE0pdOVlZp0lwxXlwe4lweZmdO5mdtWl3uzogyUnW");
			str.add("xfplay://dna=mZHXEGD3mwx1Ewp0mdueExAdBdD2mxe0DGjdA0Icmde0mZt1ExjcAa|dx=257504732|mz=Tokyo-Hot n1234.rmvb|zx=nhE0pdOVl2D0lwIZrNxUozI0BwxWBdaVrgMSnJ5R|zx=nhE0pdOVl3uzlwIXqJX1lzAVoGO5mdtWl3uzogyUnW");
			
			for(int i=0;i<str.size();i++) {
				//String st= "D:\\xfplay\\xfplay.exe";// ����windowsӦ�ó���
				//Process process = Runtime.getRuntime().exec(st);
				Runtime runtime=Runtime.getRuntime(); 
				String[] commandArgs={"D:\\xfplay\\xfplay.exe",str.get(i)}; 
				runtime.exec(commandArgs);
				try {
					Thread.sleep(1000*40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test2() {
		try {
			String st= "D:\\xunlei\\Program\\ThunderStart.exe";// ����windowsӦ�ó���
			Process process = Runtime.getRuntime().exec(st);
			Runtime runtime=Runtime.getRuntime(); 
			String[] commandArgs={"D:\\xunlei\\Program\\ThunderStart.exe","https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E5%B0%8F%E8%AF%B4%2F%E6%B7%AB%E6%B5%AA%E5%A5%B3%E5%85%AC%E5%85%B3.mp3"}; 
			runtime.exec(commandArgs);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test1() {
		String website="https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E5%B0%8F%E8%AF%B4%2F%E6%B7%AB%E6%B5%AA%E5%A5%B3%E5%85%AC%E5%85%B3.mp3";
				try {
					Desktop desktop = Desktop.getDesktop();
					URI uri = new URI(website);
					desktop.browse(uri);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	
	//������ҳ
    public static Map<String,String> getString(String strurl) {
    	Map<String,String>mp = new HashMap<String,String>();
    	try {
    		Document doc = Jsoup.connect(strurl).get();
    		Elements enm=doc.getElementsByClass("xslist text-bg-c");//Ŀ�꼯��
    		//System.out.println(enm);
    		List<String> textlist =	enm.eachText();
    		for(int i=0;i<textlist.size();i++) {
    			String str=textlist.get(i);
    			//System.out.println("pppp---:"+textlist.get(i).indexOf("��")+"-----:"+textlist.get(i).indexOf("��"));
    			if(textlist.get(i).indexOf("��")!=-1&&textlist.get(i).indexOf("��")!=-1) {
    				//System.out.println("okoko---:"+str.substring(textlist.get(i).indexOf("��")+1,textlist.get(i).indexOf("��")));
    				String laststr=str.substring(textlist.get(i).indexOf("��")+1,textlist.get(i).indexOf("��"));
    				mp.put(strurl+"___"+i, laststr);//url   ��ȡ���
    				//System.out.println("ttt----"+mp.size());
    			}else {
    				System.out.println("����Ҫ��---"+strurl+"-----:"+str);
    			}
    		}
    		return mp;
    	}catch(Exception e) {
    		e.getSuppressed();
    	}
    	return null;
    }
    
    //��һ������
    public static Map<String,String>  test(Map<String,String> map) {
    	Map<String,String>  ok = new HashMap<String,String>();
		try {
	     	//System.out.println(URLEncoder.encode("��ƪС˵/tt.mp3","UTF-8"));
		   //https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E5%B0%8F%E8%AF%B4/%E6%88%91%E6%98%AF%E5%A4%A7%E9%AA%9A%E5%8C%85.mp3
	     	for(Map.Entry<String, String> entry : map.entrySet()){
	     	    String mapKey = entry.getKey();
	     	    String mapValue = entry.getValue();
	     	    System.out.println(mapKey+":"+mapValue);
	     	   // System.out.println(URLEncoder.encode("��ƪС˵/"+mapValue+".mp3","UTF-8"));	
	     	    String tt=URLEncoder.encode("��ƪС˵/"+mapValue+".mp3","UTF-8");
	     	    //System.out.println("���ܺ�----"+tt);	
	     	   ok.put(mapValue,"https://mmssxs1.com/"+tt); //ԭʼֵ  ����ֵ
	     	  }
		  return ok;
		
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return ok;
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
