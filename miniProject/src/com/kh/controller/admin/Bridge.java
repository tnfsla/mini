package com.kh.controller.admin;

public class Bridge{

	private long sharedData = 0;
	private boolean isReady = true;
	
	public long getSharedData() {
		System.out.println("받아갔다");
		return sharedData;
	}
	public void setSharedData(long sharedData) {
		System.out.println("설정했다");
		this.sharedData = sharedData;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	
}
