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

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JLabel;

public class Bridge {

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
		return sharedData;
	}


	public void setSharedData(long sharedData) {
		this.sharedData = sharedData;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	

	public int getSharedDataI() {
		long systemTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String dTime = formatter.format(systemTime);
		System.out.println(dTime);
		int dTimeI = Integer.parseInt(dTime);
		
		return dTimeI;
	}

}