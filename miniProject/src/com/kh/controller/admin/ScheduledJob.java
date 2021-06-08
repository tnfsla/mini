package com.kh.controller.admin;

import java.util.Date;
import java.util.TimerTask;

public class ScheduledJob extends TimerTask {
	  public void run() {
	      System.out.println(new Date());
	   }
}
