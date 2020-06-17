package com.my.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class GetConnection {
	 public static void main(String arg[]) {
	        try {
	            
	        	DbStoreHelper("a","v","c");
	            
	            
	            
	        } catch (Exception e) {
	            System.out.print("MYSQL ERROR:" + e.getMessage());
	        }

	    }
	 
	 public static void DbStoreHelper(String b,String c,String d) {  
		   PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Connection con = null; //����һ��MYSQL���Ӷ���
		 try {
			 String uuid = UUID.randomUUID().toString().replaceAll("-","");
	            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL����
	            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=CTT&characterEncoding=utf-8&useSSL=false", "root", "123456"); //���ӱ���MYSQL
	            System.out.print(con);
	            
	            String sql = "insert into mytest(id,name,pageinfo,url) values(?,?,?,?)";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, uuid);
	            stmt.setString(2, b);
	            stmt.setString(3, c);
	            stmt.setString(4, d);

	            int result =stmt.executeUpdate();// ����ֵ�����յ�Ӱ�������
	            System.out.println("����ɹ�");
	            
	        } catch (Exception e) {
	        	e.printStackTrace();
	            System.out.print("MYSQL ERROR:" + e.getMessage());
	        }finally {
	        	try {
					if(con!=null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	
	        	try {
					if(stmt!=null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	try {
					if(rs!=null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        }

	    }  
	 
}
