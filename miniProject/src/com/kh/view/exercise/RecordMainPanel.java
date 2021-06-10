package com.kh.view.exercise;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.kh.controller.exercise.RecordMainController;
import com.kh.model.vo.User;
import com.kh.view.main.Main;

public class RecordMainPanel extends JPanel {

	
	private RecordMainController recordMainController;
	private User user;
	private Main main;

	public RecordMainPanel() {

		setBounds(0, 0, 360, 600);
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

	public RecordMainPanel(Main main, User user) {
		this();
		this.main = main;
		this.user = user;
	}

}
