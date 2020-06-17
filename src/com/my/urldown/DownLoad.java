package com.my.urldown;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoad {

	
	/**
     * ������Url�������ļ�
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
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
		conn.setRequestProperty("Connection", "Keep-Alive");

        
        
        //�õ�������
        InputStream inputStream = conn.getInputStream();  
        //��ȡ�Լ�����
        byte[] getData = readInputStream(inputStream);    

        //�ļ�����λ��
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);    
        FileOutputStream fos = new FileOutputStream(file);     
        fos.write(getData); 
        if(fos!=null){
            fos.close();  
        }
        if(inputStream!=null){
            inputStream.close();
        }


        System.out.println("info:"+url+" download success"); 

    }


    /**
     * ���������л�ȡ�ֽ�����
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        while((len = inputStream.read(buffer)) != -1) {  
            bos.write(buffer, 0, len);  
        }  
        bos.close();  
        return bos.toByteArray();  
    }  

    public static void main(String[] args) {
        try{
           downLoadFromUrl("https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E5%B0%8F%E8%AF%B4%2F%E6%B7%AB%E6%B5%AA%E5%A5%B3%E5%85%AC%E5%85%B3.mp3","aa.mp3","C:\\Users\\huawei\\Desktop");
// 
           //http://xxxxdyw66.vip/html/tupian/1/index.html
        }catch (Exception e) {
        	e.printStackTrace();
            // TODO: handle exception
        }
    }
}
