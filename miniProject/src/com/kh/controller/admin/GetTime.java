package com.kh.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.kh.view.admin.AdminViewManager;
import com.kh.view.admin.EventSettingP;

public class GetTime extends Thread{
	
	public Bridge ts;

	public void run() {
		try {

			while(true) {			
				long dTimeI = 0L;
				long systemTime = System.currentTimeMillis();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss", Locale.KOREA);
				String dTime = formatter.format(systemTime);
				dTimeI = Long.parseLong(dTime);

				System.out.println(dTimeI);
				ts.setSharedData(dTimeI);
				ts.setReady(true);
				
				sleep(2000);
			}
		}catch(Exception e ) {
			
		}
	}



	
	
}
