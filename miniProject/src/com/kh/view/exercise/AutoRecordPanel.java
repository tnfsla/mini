package com.kh.view.exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AutoRecordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AutoRecordPanel() {

		setBounds(0, 0, 360, 600);
		setLayout(null);

		// 시간 입력

		JLabel time = new JLabel("시간");
		time.setLocation(30, 40);
		time.setSize(50, 40);
		add(time);

		JLabel slash1 = new JLabel(":");
		slash1.setLocation(145, 40);
		slash1.setSize(10, 40);
		add(slash1);

		JLabel slash2 = new JLabel(":");
		slash2.setLocation(225, 40);
		slash2.setSize(10, 40);
		add(slash2);

		JLabel h = new JLabel("00");
		JLabel m = new JLabel("00");
		JLabel s = new JLabel("00");

		h.setLocation(80, 40);
		m.setLocation(160, 40);
		s.setLocation(240, 40);

		h.setSize(50, 40);
		m.setSize(50, 40);
		s.setSize(50, 40);

		add(h);
		add(m);
		add(s);

		// 거리 입력

		JLabel km1 = new JLabel("거리");
		km1.setLocation(30, 120);
		km1.setSize(50, 40);
		add(km1);

		JTextField km2 = new JTextField("0.0");
		km2.setLocation(80, 120);
		km2.setSize(150, 40);
		add(km2);

		JLabel km3 = new JLabel("km");
		km3.setLocation(250, 120);
		km3.setSize(50, 40);
		add(km3);

		// 확인
		JButton cfA = new JButton("확인");
		cfA.setLocation(140, 180);
		cfA.setSize(70, 40);
		add(cfA);

		cfA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String h1 = h.getText();
				String m1 = m.getText();
				String s1 = s.getText();
				String kmm = km3.getText();

				int hi = Integer.parseInt(h1);
				int mi = Integer.parseInt(m1);
				int si = Integer.parseInt(s1);
				int ki = Integer.parseInt(kmm);

				//00.00으로 표시되는 라벨을 만들고 그걸 바꾸는 방법으로 할지 고민
				JLabel pacef = new JLabel((hi * 60) + m1 + (si / 60) / ki);
				pacef.setLocation(50, 270);
				pacef.setSize(100, 30);
				add(pacef);

			}
		});

		// 페이스 출력
		JLabel pace1 = new JLabel("달리기 페이스");
		pace1.setLocation(50, 230);
		pace1.setSize(100, 30);
		add(pace1);

		// 칼로리
		JLabel kcal1 = new JLabel("칼로리 소모량");
		kcal1.setLocation(200, 230);
		kcal1.setSize(100, 30);
		add(kcal1);

		// 운동평가
		JLabel star1 = new JLabel("운동 평가");
		star1.setLocation(50, 350);
		star1.setSize(80, 30);
		add(star1);

		JButton s1 = new JButton("1");
		s1.setLocation(50, 400);
		s1.setSize(50, 50);
		add(s1);
		JButton s2 = new JButton("2");
		s2.setLocation(100, 400);
		s2.setSize(50, 50);
		add(s2);
		JButton s3 = new JButton("3");
		s3.setLocation(150, 400);
		s3.setSize(50, 50);
		add(s3);
		JButton s4 = new JButton("4");
		s4.setLocation(200, 400);
		s4.setSize(50, 50);
		add(s4);
		JButton s5 = new JButton("5");
		s5.setLocation(250, 400);
		s5.setSize(50, 50);
		add(s5);

		// 저장
		JButton saveA = new JButton("저장");
		saveA.setLocation(140, 480);
		saveA.setSize(70, 40);
		add(saveA);

		setVisible(true);

	}

}