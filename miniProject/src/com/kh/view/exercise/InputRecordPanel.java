package com.kh.view.exercise;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.controller.exercise.InputRecordController;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;
import com.kh.view.main.Main;

public class InputRecordPanel extends JPanel {

	private InputRecordController inputRecordController;
	private RecordMainPanel recordMainPanel;

	private User user;

	private Main main;

	public InputRecordPanel() {

		setBackground(Color.WHITE);
		ImageIcon ss1 = new ImageIcon("./image/star1.png");
		ImageIcon ss2 = new ImageIcon("./image/star2.png");

		setBounds(0, 0, 360, 600);
		setLayout(null);

		// 시간 입력

		JLabel time = new JLabel("시간");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setLocation(30, 140);
		time.setSize(50, 40);
		add(time);

		JLabel slash1 = new JLabel(":");
		slash1.setLocation(145, 140);
		slash1.setSize(10, 40);
		add(slash1);

		JLabel slash2 = new JLabel(":");
		slash2.setLocation(225, 140);
		slash2.setSize(10, 40);
		add(slash2);

		JTextField h = new JTextField("시간");
		h.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField m = new JTextField("분");
		m.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField s = new JTextField("초");
		s.setHorizontalAlignment(SwingConstants.CENTER);

		h.setLocation(80, 140);
		m.setLocation(155, 140);
		s.setLocation(240, 140);

		h.setSize(50, 40);
		m.setSize(50, 40);
		s.setSize(50, 40);

		add(h);
		add(m);
		add(s);

		h.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				h.setText("");
			}
		});
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				m.setText("");
			}
		});
		s.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s.setText("");
			}
		});

		// 거리 입력

		JLabel km1 = new JLabel("거리");
		km1.setHorizontalAlignment(SwingConstants.CENTER);
		km1.setLocation(37, 210);
		km1.setSize(50, 40);
		add(km1);

		JTextField km2 = new JTextField("0.0");
		km2.setHorizontalAlignment(SwingConstants.RIGHT);
		km2.setLocation(105, 210);
		km2.setSize(150, 40);
		add(km2);

		JLabel km3 = new JLabel("km");
		km3.setHorizontalAlignment(SwingConstants.CENTER);
		km3.setLocation(273, 210);
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
		pace1.setLocation(50, 350);
		pace1.setSize(100, 30);
		add(pace1);

		JLabel pacef = new JLabel("00.00");
		pacef.setHorizontalAlignment(SwingConstants.CENTER);
		pacef.setLocation(50, 390);
		pacef.setSize(100, 30);
		add(pacef);

		// 칼로리
		JLabel kcal1 = new JLabel("칼로리 소모량");
		kcal1.setHorizontalAlignment(SwingConstants.CENTER);
		kcal1.setLocation(200, 350);
		kcal1.setSize(100, 30);
		add(kcal1);

		JLabel kcalf = new JLabel("0");
		kcalf.setHorizontalAlignment(SwingConstants.CENTER);
		kcalf.setLocation(200, 390);
		kcalf.setSize(100, 30);
		add(kcalf);

		// 확인
		JButton cf = new JButton("확인");
		cf.setLocation(150, 290);
		cf.setSize(60, 40);
		add(cf);

		cf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 사용자가 입력한 값을 계산하기 위해 형변환
				int hi = Integer.parseInt(h.getText());
				int mi = Integer.parseInt(m.getText());
				int si = Integer.parseInt(s.getText());
				double ki = Double.valueOf(km2.getText()).doubleValue();

				double rrp = (((hi * 60) + mi + (si / 60)) / ki); // 페이스 계산
				String fp = String.format("%.2f", rrp); // 계산된 페이스값 문자열로 저장

				int kc = ((hi * 60) + mi + (si / 60)) * 6; // 칼로리계산 (분당 6kcal로리 소모)
				String kcf = Integer.toString(kc);

				pacef.setText(fp); // 페이스값을 보여주기
				kcalf.setText(kcf); // 칼로리값 보여주기

			}
		});

		JLabel star1 = new JLabel("운동 평가");
		star1.setLocation(45, 430);
		star1.setSize(80, 30);
		add(star1);

		// star 값 반환을 위한 장치
		JLabel starf = new JLabel();

		JButton s1 = new JButton();
		s1.setIcon(ss1);
		s1.setLocation(35, 460);
		s1.setSize(60, 60);
		s1.setBorderPainted(false);
		s1.setContentAreaFilled(false);
		s1.setFocusPainted(false);
		add(s1);

		JButton s2 = new JButton(ss1);
		s2.setLocation(95, 460);
		s2.setSize(60, 60);
		s2.setBorderPainted(false);
		s2.setContentAreaFilled(false);
		s2.setFocusPainted(false);
		add(s2);

		JButton s3 = new JButton(ss1);
		s3.setLocation(155, 460);
		s3.setSize(60, 60);
		s3.setBorderPainted(false);
		s3.setContentAreaFilled(false);
		s3.setFocusPainted(false);
		add(s3);

		JButton s4 = new JButton(ss1);
		s4.setLocation(215, 460);
		s4.setSize(60, 60);
		s4.setBorderPainted(false);
		s4.setContentAreaFilled(false);
		s4.setFocusPainted(false);
		add(s4);

		JButton s5 = new JButton(ss1);
		s5.setLocation(275, 460);
		s5.setSize(60, 60);
		s5.setBorderPainted(false);
		s5.setContentAreaFilled(false);
		s5.setFocusPainted(false);
		add(s5);

		s1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss1);
				s3.setIcon(ss1);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
				starf.setText("1");
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
				starf.setText("2");
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
				starf.setText("3");
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
				starf.setText("4");
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
				starf.setText("5");
			}
		});

		// 저장
		JButton save = new JButton("저장");
		save.setLocation(145, 530);
		save.setSize(70, 40);
		add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar dates = Calendar.getInstance();

				int runHour = Integer.parseInt(h.getText());
				int runMin = Integer.parseInt(m.getText());
				int runSec = Integer.parseInt(s.getText());
				long runTime = (runHour * 3600) + (runMin * 60) + runSec;
				double distance = Double.valueOf(km2.getText()).doubleValue();
				double calorie = Double.valueOf(kcalf.getText()).doubleValue();
				double pace = Double.valueOf(pacef.getText()).doubleValue();
				int star = Integer.parseInt(starf.getText());

				user.addExercise(new Exercise(dates, runHour, runMin, runSec, runTime, distance, calorie, pace, star));

				System.out.println("운동기록이 저장되었습니다.");
				System.out.println(user.getExercises());

				main.convertPanel("main");
			}
		});

		setVisible(true);

	}

	public InputRecordPanel(Main main) {
		this();
		this.main = main;
	}

	public void setUser(User user) {
		this.user = user;

	}
}
