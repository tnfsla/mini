//package com.kh.controller.admin;
//
//public class Bridge{
//
//	private int sharedData ;
//	private boolean startEvent;
//	
//	public boolean isStartEvent() {
//		return startEvent;
//	}
//	public void setStartEvent(boolean startEvent) {
//		this.startEvent = startEvent;
//	}
//	public int getSharedData() {
//		return sharedData;
//	}
//	public void setSharedData(int sharedData) {
//		this.sharedData = sharedData;
//	}
//
//}


package com.kh.controller.admin;

import javax.swing.JLabel;

public class Bridge{

   private JLabel sharedLabel;
   private long sharedData = 0;
   private boolean isReady = true;
   
   public void setSharedLabel(JLabel sharedLabel) {
      this.sharedLabel = sharedLabel;
   }
   
   public JLabel getSharedLabel() {
      return sharedLabel;
   }
   
   public long getSharedData() {
      System.out.println("받아갔다 : " + sharedData);
      return sharedData;
   }
   public void setSharedData(long sharedData) {
      System.out.println("설정했다 : " + sharedData);
      this.sharedData = sharedData;
   }
   public boolean isReady() {
      return isReady;
   }
   public void setReady(boolean isReady) {
      this.isReady = isReady;
   }
   
}