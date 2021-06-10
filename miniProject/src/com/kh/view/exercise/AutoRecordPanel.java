package com.kh.view.exercise;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.controller.exercise.AutoRecordController;

public class AutoRecordPanel extends JPanel {

	private AutoRecordController autoRecordController;
	
	
	public AutoRecordPanel() {

		ImageIcon ss1 = new ImageIcon("./image/star1.png");
		ImageIcon ss2 = new ImageIcon("./image/star2.png");

		setBounds(0, 0, 360, 600);
		setLayout(null);

		// 시간 입력

		JLabel time = new JLabel("시간");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setLocation(30, 40);
		time.setSize(50, 40);
		add(time);

		JLabel slash1 = new JLabel(":");
		slash1.setHorizontalAlignment(SwingConstants.CENTER);
		slash1.setLocation(145, 40);
		slash1.setSize(10, 40);
		add(slash1);

		JLabel slash2 = new JLabel(":");
		slash2.setHorizontalAlignment(SwingConstants.CENTER);
		slash2.setLocation(225, 40);
		slash2.setSize(10, 40);
		add(slash2);

		JLabel h = new JLabel("00");
		h.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel m = new JLabel("00");
		m.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel s = new JLabel("00");
		s.setHorizontalAlignment(SwingConstants.CENTER);

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
		km1.setHorizontalAlignment(SwingConstants.CENTER);
		km1.setLocation(30, 120);
		km1.setSize(50, 40);
		add(km1);

		JTextField km2 = new JTextField("0.0");
		km2.setHorizontalAlignment(SwingConstants.RIGHT);
		km2.setLocation(80, 120);
		km2.setSize(150, 40);
		add(km2);

		JLabel km3 = new JLabel("km");
		km3.setHorizontalAlignment(SwingConstants.CENTER);
		km3.setLocation(250, 120);
		km3.setSize(50, 40);
		add(km3);

		km2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				km2.setText("");
			}
		});

		// 페이스 출력
		JLabel pace1 = new JLabel("달리기 페이스");
		pace1.setHorizontalAlignment(SwingConstants.CENTER);
		pace1.setLocation(50, 230);
		pace1.setSize(100, 30);
		add(pace1);

		JLabel pacef = new JLabel("00.00");
		pacef.setHorizontalAlignment(SwingConstants.CENTER);
		pacef.setLocation(50, 270);
		pacef.setSize(100, 30);
		add(pacef);

		// 칼로리
		JLabel kcal1 = new JLabel("칼로리 소모량");
		kcal1.setHorizontalAlignment(SwingConstants.CENTER);
		kcal1.setLocation(200, 230);
		kcal1.setSize(100, 30);
		add(kcal1);

		JLabel kcalf = new JLabel("0 kcal");
		kcalf.setHorizontalAlignment(SwingConstants.CENTER);
		kcalf.setLocation(200, 270);
		kcalf.setSize(100, 30);
		add(kcalf);

		// 확인
		JButton cfA = new JButton("확인");
		cfA.setLocation(145, 180);
		cfA.setSize(70, 40);
		add(cfA);

		cfA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String h1 = h.getText();
				String m1 = m.getText();
				String s1 = s.getText();
				String kmm = km3.getText();

				// 계산하기 위해 형변환
				int hi = Integer.parseInt(h1);
				int mi = Integer.parseInt(m1);
				int si = Integer.parseInt(s1);
				double ki = Double.valueOf(kmm).doubleValue();

				double rrp = (((hi * 60) + mi + (si / 60)) / ki); // 페이스 계산
				String fp = String.format("%.2f", rrp); // 계산된 페이스값 문자열로 저장

				int kc = ((hi * 60) + mi + (si / 60)) * 6; // 칼로리계산 (분당 6kcal로리 소모)
				String kcf = Integer.toString(kc);

				pacef.setText(fp); // 페이스값을 보여주기
				kcalf.setText(kcf + " kcal"); // 칼로리값 보여주기

			}
		});

		JLabel star1 = new JLabel("운동 평가");
		star1.setLocation(50, 350);
		star1.setSize(80, 30);
		add(star1);

		JButton s1 = new JButton();
		s1.setIcon(ss1);
		s1.setLocation(35, 390);
		s1.setSize(60, 60);
		add(s1);

		JButton s2 = new JButton(ss1);
		s2.setLocation(95, 390);
		s2.setSize(60, 60);
		add(s2);

		JButton s3 = new JButton(ss1);
		s3.setLocation(155, 390);
		s3.setSize(60, 60);
		add(s3);

		JButton s4 = new JButton(ss1);
		s4.setLocation(215, 390);
		s4.setSize(60, 60);
		add(s4);
		JButton s5 = new JButton(ss1);
		s5.setLocation(275, 390);
		s5.setSize(60, 60);
		add(s5);

		s1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss1);
				s3.setIcon(ss1);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
			}
		});
		s2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss1);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
			}
		});
		s3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss2);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
			}
		});
		s4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss2);
				s4.setIcon(ss2);
				s5.setIcon(ss1);
			}
		});
		s5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss2);
				s4.setIcon(ss2);
				s5.setIcon(ss2);

			}
		});

		// 저장
		JButton saveA = new JButton("저장");
		saveA.setLocation(145, 480);
		saveA.setSize(70, 40);
		add(saveA);

		saveA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 운동기록 저장

			}
		});

		setVisible(true);

	}
}