package com.my.urldown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Vcl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test3_1();
		check();
	}
	
	
	
	public  static  void check() {
        try {
			Runtime runtime = Runtime.getRuntime();
			Process process = null;
			/*
			 * process = runtime
			 * .exec("cmd /c reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\"
			 * );
			 */
			
			process = runtime.exec("cmd /c reg query HKEY_CLASSES_ROOT\\Applications\\vlc.exe\\shell\\Open\\command");
			        
			//
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
			        

			String string = null;
			while ((string = in.readLine()) != null) {
			    System.out.println(string);
			    if(string.contains("vlc.exe")) {
			    	System.out.println("oko");
			    	queryValue( string) ;
			    }
			    process = runtime.exec("cmd /c reg query " + string  + " /v DisplayName");
			           
			    System.out.println(process);

			    BufferedReader name = new BufferedReader(new InputStreamReader(
			            process.getInputStream(),"GBK"));
			  
			}
			in.close();
			process.destroy();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	
	
	//具体查询每一个软件的详细信息
    private static String[] queryValue(String string) throws IOException {
        String nameString = "";
        String versionString = "";

        String publisherString="";
        String uninstallPathString = "";

        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        BufferedReader br = null;

        process = runtime.exec("cmd /c reg query " + string + " /v DisplayName");
        br = new BufferedReader(new InputStreamReader(process
                .getInputStream(),"GBK"));
        br.readLine();br.readLine();//去掉前两行无用信息
        if((nameString=br.readLine())!=null){
            nameString=nameString.replaceAll("DisplayName    REG_SZ    ", "");  //去掉无用信息
        }


        process = runtime.exec("cmd /c reg query " + string + " /v DisplayVersion");
        br = new BufferedReader(new InputStreamReader(process
                .getInputStream(),"GBK"));
        br.readLine();br.readLine();//去掉前两行无用信息
        if((versionString=br.readLine())!=null){
            versionString=versionString.replaceAll("DisplayVersion    REG_SZ    ", ""); //去掉无用信息
        }

        process = runtime.exec("cmd /c reg query " + string + " /v Publisher");
        br = new BufferedReader(new InputStreamReader(process
                .getInputStream(),"GBK"));
        br.readLine();br.readLine();//去掉前两行无用信息
        if((publisherString=br.readLine())!=null){
            publisherString =publisherString.replaceAll("Publisher    REG_SZ    ", ""); //去掉无用信息
        }

        process = runtime.exec("cmd /c reg query " + string + " /v UninstallString");
        br = new BufferedReader(new InputStreamReader(process
                .getInputStream(),"GBK"));
        br.readLine();br.readLine();//去掉前两行无用信息
        if((uninstallPathString=br.readLine())!=null){
            uninstallPathString=uninstallPathString.replaceAll("UninstallString    REG_SZ    ", "");    //去掉无用信息
        }

        String[] resultString=new String[4];
        resultString[0]= nameString ;//== null ? null : new String(nameString.getBytes(),"GB-2312");
        resultString[1]= versionString ;//== null ? null : new String(versionString.getBytes(),"GB-2312");
        resultString[2]= publisherString ;//== null ? null : new String(publisherString.getBytes(),"GB-2312");
        resultString[3]= uninstallPathString ;//== null ? null : new String(uninstallPathString.getBytes(),"GB-2312");
        if(resultString[0]==null) resultString=null;    //没有名字的不显示
        
        for(String tt:resultString) {
        	System.out.println("----"+tt);
        }
        return resultString;
    }

	
	
	
	
	
	
	
	
	
	
	public static void test3_1() {
		try {
			List<String>str = new ArrayList<String>();
			/*
			 * str.
			 * add("xfplay://dna=Ewi0mHfcEdiWAZIdBeD5EdpYmZD1DGpXDGyfmefbBeD2DZp3Dwx3AD|dx=305841920|mz=Tokyo-Hot n1233.rmvb|zx=nhE0pdOVl2D0lwIZrNxUozI0BwxWBdaVrgMSnJ5R|zx=nhE0pdOVl3uzlwIXqJX1lzAVoGO5mdtWl3uzogyUnW"
			 * );
			 * 
			 * str.add(
			 * "xfplay://dna=BHL1AwDXAeH1DGybAZAfA0i5DwDYAHIbDHfgDxMbEdp3EwqeDHm2mW|dx=2020176270|mz=carib-071716-210.mp4|zx=nhE0pdOVlZp0lwxXlwe4lweZmdO5mdtWl3uzogyUnW|zx=nhE0pdOVlZp0lwxXlwe4lweZmdO5mdtWl3uzogyUnW"
			 * ); str.
			 * add("xfplay://dna=mZHXEGD3mwx1Ewp0mdueExAdBdD2mxe0DGjdA0Icmde0mZt1ExjcAa|dx=257504732|mz=Tokyo-Hot n1234.rmvb|zx=nhE0pdOVl2D0lwIZrNxUozI0BwxWBdaVrgMSnJ5R|zx=nhE0pdOVl3uzlwIXqJX1lzAVoGO5mdtWl3uzogyUnW"
			 * );
			 */
			str.add("http://localhost:8080/Test/tt.mp4");
			for(int i=0;i<str.size();i++) {
				//String st= "D:\\xfplay\\xfplay.exe";// 启动windows应用程序
				//Process process = Runtime.getRuntime().exec(st);
				Runtime runtime=Runtime.getRuntime(); 
				String[] commandArgs={"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe",str.get(i)}; 
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
}
