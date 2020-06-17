package com.my.urldown;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
 
public class MyX509TrustManager implements X509TrustManager {
 
	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
 
	}
 
	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
 
	}
 
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public static String httpsRequest(String requestUrl,String requestMethod,String outputStr){
		StringBuffer buffer=null;
		try{
		//����SSLContext
		SSLContext sslContext=SSLContext.getInstance("SSL");
		TrustManager[] tm={new MyX509TrustManager()};
		//��ʼ��
		sslContext.init(null, tm, new java.security.SecureRandom());;
		//��ȡSSLSocketFactory����
		SSLSocketFactory ssf=sslContext.getSocketFactory();
		URL url=new URL(requestUrl);
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod(requestMethod);
		//���õ�ǰʵ��ʹ�õ�SSLSoctetFactory
		conn.setSSLSocketFactory(ssf);
		conn.connect();
		//����������д����
		if(null!=outputStr){
			OutputStream os=conn.getOutputStream();
			os.write(outputStr.getBytes("utf-8"));
			os.close();
		}
		
		//��ȡ�������˷��ص�����
		InputStream is=conn.getInputStream();
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		buffer=new StringBuffer();
		String line=null;
		while((line=br.readLine())!=null){
			buffer.append(line);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	
	
	
	public static void main(String[] args){
		String s=httpsRequest("https://p0.ssl.qhimgs4.com/t0165615d35a59f3497.jpg","POST",null);
		System.out.println(s);
	}
	
	
	
	
	
	
}