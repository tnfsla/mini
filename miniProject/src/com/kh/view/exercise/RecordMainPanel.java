package com.kh.view.exercise;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.kh.controller.exercise.RecordMainController;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecordMainPanel extends JPanel {
	
	private AutoRecordPanel autoRecordPanel;
	private InputRecordPanel inputRecordPanel;
	private StopWatchPanel stopWatchPanel;
	
	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용
	
	private RecordMainController recordMainController;

	private Main main;
	
	private User user;
	
	public RecordMainPanel() {

		setBounds(0, 0, 360, 600);
		setLayout(null);

		JTextArea t1 = new JTextArea("나에게 맞는 목표를 세우고" + "\n" + "자유롭게 훈련하세요." + "\n" + "처음에는 부담 없는 목표를 설정하고" + "\n"
				+ "조금씩 목표를 높이는 것이 바람직합니다." + "\n" + "지금부터 목표를 향해 달리세요!");
		t1.setLocation(30, 80);
		t1.setSize(270, 120);
		add(t1);

		JButton b1 = new JButton("시간 측정 기록");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("record_stopWatch");
			}
		});
		b1.setLocation(80, 250);
		b1.setSize(180, 80);
		add(b1);

		JButton b2 = new JButton("자율 운동 기록");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("record_input");
			}
		});
		b2.setLocation(80, 401);
		b2.setSize(180, 80);
		add(b2);

		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(150, 561, 60, 29);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				main.convertPanel("main");
			}
		});
		add(lblHome);
	}

	public RecordMainPanel(Main main) {
		this();
		this.main = main;
		
		initPanel();
	}
	
	public void initPanel() {
		autoRecordPanel = new AutoRecordPanel(main);
		inputRecordPanel = new InputRecordPanel(main);
		stopWatchPanel = new StopWatchPanel(main);
		
		panelMap = main.getPanelMap();
		
		panelMap.put("record_auto", autoRecordPanel);
		panelMap.put("record_input", autoRecordPanel);
		panelMap.put("record_stopWatch", autoRecordPanel);
	}

	public void setUser(User user) {
		this.user = user;
	}

}
