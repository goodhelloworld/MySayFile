package com.my.util;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Mymp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<String>mylist=	test7("https://1024fff.com/news-show-id-78-p-3.html");
		//test8_1 (mylist);
		 //test2("https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E6%9C%89%E5%A3%B0%E5%B0%8F%E8%AF%B4/201904/%E8%8D%89%E9%98%BF%E5%A7%A8.mp3");
		//saveToFile("https://mmssxs1.com/短篇有声小说/201904/草阿姨.mp3", "d://aa.mp3") ;
		/*
		 * try {//https://mmssxs1.com/ String urlString =
		 * URLEncoder.encode("短篇有声小说/201904/草阿姨.mp3", "utf-8"); //输出%C4%E3%BA%C3
		 * System.out.println(urlString); } catch (UnsupportedEncodingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		//https://1024fff.com/news-show-id-78-p-1.html
		// https://1024fff.com/news-show-id-78-p-2.html
		
		//获取所有地址，写入文本
		for(int i=1;i<=164;i++) {
			List<String>mylist=	test7("https://1024fff.com/news-show-id-78-p-"+i+".html");//liebiao
			Map<String,String>mp = test8_2 (mylist);//获取MP3地址
			Filet(mp);
			mp.clear();
		}
		
		//读取包含地址的mp3地址，进行下载
		//FileR();
		
		/*for(Map.Entry<String, String>mk:mp.entrySet()) {
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			System.out.println(mk.getValue());
	        Transferable tText = new StringSelection(mk.getValue());  
	        clip.setContents(tText, null); 
	        try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 */

	}

	/*
	 * 
	 运行前准备：
	   1.手动启动迅雷
	   2.本地aa.txt中已经把网络资源地址获取到了，这样是为了不用经常访问网络
	   3.将aa.txt读到剪贴板中
	   4.迅雷会自动检查剪贴班中的内容
	   5.迅雷检测到后，会弹出框让确认下载任务，需要获取确认按钮坐标，这样可以自动化
	   6。本方法已经设定了弹出框的位置，要是不准确，需要运行MOuserInfo去获取
	 * 
	 */
	public static void FileR() {
		try {
			BufferedReader br  = new BufferedReader(new FileReader(new File("C:\\Users\\huawei\\Desktop\\aa.txt")));
			int t=0;
			while(br.readLine()!=null) {
				if(t<30) {
					System.out.println(br.readLine());
					Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			        Transferable tText = new StringSelection(br.readLine());  
			        clip.setContents(tText, null); 
						t++;
						Robot bt=new Robot();
						bt.mouseMove(978, 758);
						bt.mousePress(InputEvent.BUTTON1_MASK); //点击鼠标左键
						bt.delay(300);  
						bt.mouseRelease(InputEvent.BUTTON1_MASK); //释放左键
						Thread.sleep(10000);
						 //new Robot().mousePress(InputEvent.BUTTON1_MASK);  
						// new Robot().keyRelease(KeyEvent.VK_ENTER);  
						 //new Robot().delay(500);  
				
				}
				
			}
			
		  br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Filet(Map<String,String>mp) {
		try {
			FileWriter br = new FileWriter(new File("C:\\Users\\huawei\\Desktop\\aa.txt"),true);
			for(Map.Entry<String, String>mk:mp.entrySet()) {
			  br.write(mk.getValue()+"\n");
			}
			br.flush();
			br.close();
		}catch(Exception e) {
			
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
	    		System.out.println("a===="+ms.size());
	    		for(int i=0;i<ms.size();i++) {
	    			if(ms.get(i).attr("href").endsWith(".html")&&(ms.get(i).text().contains("NJ"))) {
	    				list.add("https://1024fff.com"+ms.get(i).attr("href"));
	    			}
	    		}
	    		System.out.println(ms.size());
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return list;
		}
		
		
		
		public static void test8_1 (List<String>mylist) {

			Map<String,String>mp = new HashMap<String,String>();
	    	try {
	    		for(int t=0;t<mylist.size();t++) {
	        		//System.out.println("aaa----"+mylist.get(t));

		    		Document doc = Jsoup.connect(mylist.get(t)).get();
		    		//System.out.println(doc);
					 Elements tt=doc.getElementsByTag("h1");

				 Elements urls=doc.getElementsByTag("source");
	        		//System.out.println("aaa----"+title.text());
				 
				 for (Element postItem : urls) { //像jquery选择器一样，获取文章标题元素 
					 String ok=postItem.attr("src");
					 System.out.println("地址----"+ok+"------------"+tt.text());
					 String fn =ok.substring("https://mmssxs1.com/".length(),ok.length());
						//String urlString = URLEncoder.encode(fn, "utf-8");  //输出%C4%E3%BA%C3
						//String f1="https://mmssxs1.com/"+urlString;
						////System.out.println("加密后地址-------"+f1);
						//mp.put(tt.text()+".mp3", ok);
					// saveToFile(f1, "D://ok//"+tt.text()+".mp3"); 
					 //test2("https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E6%9C%89%E5%A3%B0%E5%B0%8F%E8%AF%B4/201904/%E8%8D%89%E9%98%BF%E5%A7%A8.mp3");
				 }
				 
	    			 Thread.sleep(3*1000);
	    		}
	    		
	    	}catch(Exception e) {
	    		e.getSuppressed();
	    	}
	}
		
		
		
		
		public static Map<String,String> test8_2 (List<String>mylist) {

			Map<String,String>mp = new HashMap<String,String>();
	    	try {
	    		for(int t=0;t<mylist.size();t++) {
	        		//System.out.println("aaa----"+mylist.get(t));

		    		Document doc = Jsoup.connect(mylist.get(t)).get();
		    		//System.out.println(doc);
					 Elements tt=doc.getElementsByTag("h1");

				 Elements urls=doc.getElementsByTag("source");
				 
				 for (Element postItem : urls) { //像jquery选择器一样，获取文章标题元素 
					 String ok=postItem.attr("src");
					// System.out.println("地址----"+ok+"------------"+tt.text());
					// String fn =ok.substring("https://mmssxs1.com/".length(),ok.length());
						mp.put(tt.text()+".mp3", ok);
				 }
				 
	    		}
	    		
	    	}catch(Exception e) {
	    		e.getSuppressed();
	    	}
		return mp;
	}
		
		
		
		
		public static void test2(String str) {
			try {
				String st= "D:\\xunlei\\Program\\ThunderStart.exe";// 启动windows应用程序
				Process process = Runtime.getRuntime().exec(st);
				Runtime runtime=Runtime.getRuntime(); 
				String[] commandArgs={"D:\\xunlei\\Program\\ThunderStart.exe",str}; 
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
		
		
		
		
		
		
		
		
		
 //mp3		
		
		// 将网络文件保存为本地文件的方法
		// @param destUrl
		// @param fileName
		// @throws IOException

		public static  void saveToFile(String destUrl, String fileName)  {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpconn = null;
		URL url = null;
		byte[] buf = new byte[1024];
		int size = 0;
		try {
			url = new URL(destUrl);
			httpconn = (HttpURLConnection) url.openConnection();
			// 连接指定的资源
			httpconn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

	            //setRequestProperty添加相同的key会覆盖value信息
	            //setRequestProperty方法，如果key存在，则覆盖；不存在，直接添加。
	            //addRequestProperty方法，不管key存在不存在，直接添加。
			httpconn.setRequestProperty("accept-encoding", "identity;q=1, *;q=0");  //访问申请用户
			httpconn.setRequestProperty("set-cookie", "__cfduid=d40c3368d0b7a615070bdf80a466764df1585347066; expires=Sun, 26-Apr-20 22:11:06 GMT; path=/; domain=.mmssxs1.com; HttpOnly; SameSite=Lax");  //请求来源IP
			httpconn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
			httpconn.setRequestProperty("accept","*/*");
			httpconn.setRequestProperty("scheme","https");
			httpconn.setRequestProperty("authority","mmssxs1.com");
			httpconn.setRequestProperty("method","GET");

			
			httpconn.connect();
			System.out.println("连接对象---"+httpconn);
			// 获取网络输入流
			bis = new BufferedInputStream(httpconn.getInputStream());
			// 建立文件
			fos = new FileOutputStream(fileName);
			System.out.println("正在获取链接[" + destUrl + "]的内容\n将其保存为文件[" + fileName
					+ "]");

					// 保存文件
			while ((size = bis.read(buf)) != -1) {
				System.out.println(size);
				fos.write(buf, 0, size);
			}
			fos.flush();
			fos.close();
			
			httpconn.disconnect();   
		}catch(Exception e) {
			e.printStackTrace();
		}
		// 建立链接
		
		}
		
		
		
}













