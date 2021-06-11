package com.kh.view.result;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;

import com.kh.model.vo.Exercise;
import javax.swing.JLabel;
import java.awt.Color;

public class ResultExerciseListPanel extends JPanel {

	// 각각의 라벨등을 선언
	
	
	private JLabel lblDate;
	private JLabel lblDistance;
	private JLabel lblRunTime;
	private JLabel lblPace;
	private JPanel panel;

	// 각각의 라벨 등을 객체 생성 후 위치,색깔등을 조정
	public ResultExerciseListPanel() {
		// 크기 조정 flowLayout에 들어가는거라 setPreferredSize 이용
		this.setPreferredSize(new Dimension(360, 100));
		// absoulteLayout으로 진행 변경 원하면 변경 요망
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 360, 95);
		add(panel);
		panel.setLayout(null);
		
		lblDate = new JLabel("date");
		lblDate.setBounds(12, 10, 150, 15);
		panel.add(lblDate);
		
		lblDistance = new JLabel("distance");
		lblDistance.setBounds(55, 26, 150, 15);
		panel.add(lblDistance);
		
		lblRunTime = new JLabel("runtime");
		lblRunTime.setBounds(55, 50, 150, 15);
		panel.add(lblRunTime);
		
		lblPace = new JLabel("pace");
		lblPace.setBounds(55, 75, 150, 15);
		panel.add(lblPace);

	}

	// 해당 라벨 등의 exercise로부터의 값 설정
	public void setExercise(Exercise exercise) {
		lblDate.setText(convertCalToDate(exercise.getDates()));
		lblDistance.setText(String.valueOf(exercise.getDistance()));
		lblRunTime.setText(secToHHMMSS(exercise.getRunTime()));
		lblPace.setText(String.valueOf(exercise.getPace()));
	}
	
	// Cal to Date Calendar 객체 날짜로 변환하는거 참고
	private String convertCalToDate(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss");
		return sdf.format(cal.getTime());
	}
	
	private String secToHHMMSS(long secs) {
		long hour, min, sec;
		sec = secs % 60;
		min = secs / 60 % 60;
		hour = secs / 3600;

		return String.format("%02d:%02d:%02d", hour, min, sec);
	}
}
