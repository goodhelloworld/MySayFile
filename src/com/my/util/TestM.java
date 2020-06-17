package com.my.util;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class TestM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取鼠标当前坐标
		 Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
         // System.out.println("Location:x=" + point.x + ", y=" +
         // point.y);
         System.out.println("坐标---------"+point.x+"----"+point.y);
         
		try {
			
			
			for(int i=0;i<10000;) {
				Robot bt=new Robot();
				bt.mouseMove(978, 758);
				bt.mousePress(InputEvent.BUTTON1_MASK); 
				bt.delay(300);  
				bt.mouseRelease(InputEvent.BUTTON1_MASK); 
				Thread.sleep(3000);
				//Robot bt=new Robot();
				//bt.mouseMove(200+i, 600);	
				//Thread.sleep(2000);
				//i+=50;
				 //Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
                 // System.out.println("Location:x=" + point.x + ", y=" +
                 // point.y);
                 System.out.println("坐标---------"+point.x+"----"+point.y);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
