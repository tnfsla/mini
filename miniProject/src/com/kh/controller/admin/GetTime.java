//package com.kh.controller.admin;
//
//import java.text.SimpleDateFormat;
//import java.util.Locale;
//
//import com.kh.view.admin.AdminViewManager;
//import com.kh.view.admin.EventSettingP;
//
//public class GetTime extends Thread{
//	
//	public Bridge ts;
//	public AdminViewManager avm;
//
//	public void run() {
//		try {
//
//			while(true) {			
//				
//				int dTimeI = 0;
//				long systemTime = System.currentTimeMillis();
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
//				String dTime = formatter.format(systemTime);
//				dTimeI = Integer.parseInt(dTime);
//
//				System.out.println(dTimeI);
//				ts.setSharedData(dTimeI);
//				
//				sleep(2000);
//				
//				System.out.println(ts.getSharedData());
//				System.out.println(avm.getEventSetting().getsTimeI());
//				if(ts.getSharedData()<=avm.getEventSetting().getsTimeI()) {
//					ts.setStartEvent(true);
//				}
//			}
//		}catch(Exception e ) {
//			
//		}
//	}
//	
//}


package com.kh.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class GetTime extends Thread{
   
   public Bridge ts;

   public void run() {
      try {

         while(true) {         
            long dTimeI = 0L;
            long systemTime = System.currentTimeMillis();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
            String dTime = formatter.format(systemTime);
            SimpleDateFormat formatter1 = new SimpleDateFormat("현재시각 : yyyy년 MM월 dd일 HH시 mm분 ss초", Locale.KOREA);
            String dTime1 = formatter1.format(systemTime);
            dTimeI = Long.parseLong(dTime);

//            System.out.println(dTimeI);
            ts.getSharedLabel().setText(dTime1);
            ts.setSharedData(dTimeI);
            
            
            ts.setReady(true);
            
            sleep(1000);
         }
      }catch(Exception e ) {
         
      }
   }
   
}