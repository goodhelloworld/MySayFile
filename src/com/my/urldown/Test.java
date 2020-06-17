package com.my.urldown;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test() {
			try {
			
			
			//https://mmssxs1.com/%E7%9F%AD%E7%AF%87%E5%B0%8F%E8%AF%B4/%E6%88%91%E6%98%AF%E5%A4%A7%E9%AA%9A%E5%8C%85.mp3

			
			System.out.println(URLEncoder.encode("This*string*has*asterisks","UTF-8"));
			System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This+string+has+pluses","UTF-8"));
			System.out.println(URLEncoder.encode("This/string/has/slashes","UTF-8"));
			System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
			System.out.println(URLEncoder.encode("This:string:has:colons","UTF-8"));
			System.out.println(URLEncoder.encode("This~string~has~tildes","UTF-8"));
			System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
			System.out.println(URLEncoder.encode("This.string.has.periods","UTF-8"));
			System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This&string&has&ersands","UTF-8"));
			System.out.println(URLEncoder.encode("Thiséstringéhasé non-ASCII characters","UTF-8"));
			// System.out.println(URLEncoder.encode("this中华人民共和国","UTF-8"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}

}
