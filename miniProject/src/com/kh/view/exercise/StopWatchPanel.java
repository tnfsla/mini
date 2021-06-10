package com.kh.view.exercise;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.controller.exercise.StopWatchController;

public class StopWatchPanel extends JPanel {
	
	
	private StopWatchController stopWatchController;

	JButton startB;
	JButton stopB;
	
	JLabel hour = new JLabel("00", 2);
	JLabel min = new JLabel("00", 2);
	JLabel sec = new JLabel("00", 2);
	JLabel slash1 = new JLabel(":");
	JLabel slash2 = new JLabel(":");
	
	public StopWatchPanel() {
		
		setBounds(100, 100, 360, 600);
		setLayout(null);
		
		
		JTextArea t1 = new JTextArea(
				"운동 시간 측정을 위해" + "\n" + "운동시작 버튼을 눌러주세요." + "\n" + "운동이 끝난 후에는" + "\n" + "반드시 종료버튼을 눌러 시간을 기록해 주세요.");
		t1.setLocation(30, 80);
		t1.setSize(270, 100);
		add(t1);
		
		JLabel hour = new JLabel("00", 2);
		JLabel min = new JLabel("00", 2);
		JLabel sec = new JLabel("00", 2);
		hour.setSize(100, 100);
		min.setSize(100, 100);
		sec.setSize(100, 100);
		hour.setFont(new Font("Agency FB", Font.BOLD, 70));
		min.setFont(new Font("Agency FB", Font.BOLD, 70));
		sec.setFont(new Font("Agency FB", Font.BOLD, 70));
		hour.setLocation(40, 200);
		min.setLocation(140, 200);
		sec.setLocation(232, 200);
		
		add(hour);
		add(min);
		add(sec);
		
		JLabel slash1 = new JLabel(":",2);
		JLabel slash2 = new JLabel(":",2);
		
		slash1.setLocation(118, 225);
		slash1.setSize(20, 40);
		slash1.setFont(new Font("Agency FB", Font.BOLD, 50));

		slash2.setLocation(213, 225);
		slash2.setSize(20, 40);
		slash2.setFont(new Font("Agency FB", Font.BOLD, 50));
		
		add(slash1);
		add(slash2);
		
		JButton startB = new JButton("Start");
		startB.setLocation(110, 350);
		startB.setSize(120, 50);
		add(startB);
		
		JButton stopB = new JButton("Stop");
		stopB.setLocation(110, 420);
		stopB.setSize(120, 50);
		add(stopB);
		
	}
}

