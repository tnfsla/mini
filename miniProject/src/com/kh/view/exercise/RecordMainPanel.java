package com.kh.view.exercise;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.controller.exercise.RecordMainController;
import com.kh.model.vo.User;

import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class RecordMainPanel extends JPanel {
	
private RecordMainController recoMainController;
private User user;
	
	private JPanel mainPanel; //메인 - 시작
	private RecordMainPanel rmp; // 기록하기메인
	private InputRecordPanel irp; // 시간, 거리 입력
	private AutoRecordPanel arp; // 스탑워치로 입력
	private StopWatchPanel swp; //스탑워치 패널
	private ExStart es; //시간 기록
	
	private Map<String, JPanel> panelMap;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JButton b1; //auto로 연결
	private JButton b2; //input으로 연결
	private JButton cf; //input 확인
	private JButton save; //input 저장
	private JButton cfA; //auto 확인
	private JButton saveA; //auto 저장
	
	public RecordMainPanel() {

		setBounds(100, 100, 360, 600);
		setLayout(null);

		JTextArea t1 = new JTextArea("나에게 맞는 목표를 세우고" + "\n" + "자유롭게 훈련하세요." + "\n" + "처음에는 부담 없는 목표를 설정하고" + "\n"
				+ "조금씩 목표를 높이는 것이 바람직합니다." + "\n" + "지금부터 목표를 향해 달리세요!");
		t1.setLocation(30, 80);
		t1.setSize(270, 120);
		add(t1);

		JButton b1 = new JButton("시간 측정 기록");
		b1.setLocation(80, 250);
		b1.setSize(180, 80);
		add(b1);
		
		JButton b2 = new JButton("자율 운동 기록");
		b2.setLocation(80, 401);
		b2.setSize(180, 80);
		add(b2);

	}

}
