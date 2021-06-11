//package com.kh.view.exercise;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ExStart extends StopWatchPanel implements ActionListener, Runnable{
//
//	int s_hour, s_min, s_sec;
//	int e_hour, e_min, e_sec;
//	int f_hour, f_min, f_sec;
//	int start_time, stop_time, for_time;
//	String save_time;
//	boolean flag;
//	int ms = 0;
//	int s = 0;
//	int m = 0;
//	int h = 0;
//	long start;
//	long end;
//	long actTime; // 동작한 시간을 저장하기 위한 변수
//	Thread thread;
//	
//	public ExStart() {
//		// TODO Auto-generated constructor stub
//		
//		startB.addActionListener(this);
//		stopB.addActionListener(this);
//		
//	}
//	public static void main(String[] args) {
//		new ExStart();
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String str = e.getActionCommand();
//		if (str.equals("Start")) {
//			if (!flag) {
//				start = System.currentTimeMillis();
//				if (actTime > 0) {
//					start = (start - actTime);
//				}
//				flag = true;
//				thread = new Thread(this);
//				thread.start();
//			}
//
//		} else {
//			flag = false;
//
//			}
//		}
//	
//	@Override
//	public void run() {
//		while (flag) {
//			end = System.currentTimeMillis();
//			ms = (int) ((end - start) / 10);
//			h = (ms / (3600 * 100));
//			m = ((ms - h * 3600 * 100) / (60 * 100));
//			s = ((ms - h * 3600 * 100 - m * 60 * 100) / 100);
//			ms = (ms - h * 3600 * 100 - m * 60 * 100 - s * 100);
//
//			// lbl1.setText(ms < 10 ? "0" + ms : "" + ms);
//			sec.setText(s < 10 ? "0" + s : "" + s);
//			min.setText(m < 10 ? "0" + m : "" + m);
//			hour.setText(h < 10 ? "0" + h : "" + h);
//			
//		}
//		try {
//			Thread.sleep(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//actTime = end - start;
//		
//		//운동정보 저장
//		System.out.println("운동 시간 : " + h + "시간" + m + "분" + s + "초");
//		long runTime = (h*3600)+(m*60)+s;
//		System.out.println(runTime);
//		
//	}
//}
//
