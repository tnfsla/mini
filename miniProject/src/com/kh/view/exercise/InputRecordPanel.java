
package com.kh.view.exercise;

import java.awt.Color;
import java.awt.Font;
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

	private RecordMainPanel recordMainPanel;
	private User user;
	private Main main;

	public InputRecordPanel() {

		setBackground(Color.WHITE);
		ImageIcon ss1 = new ImageIcon("./images/star1.png");
		ImageIcon ss2 = new ImageIcon("./images/star2.png");

		setBounds(0, 0, 360, 600);
		setLayout(null);
		
		JButton bar = new JButton(new ImageIcon("./images/inputbar.png"));
		bar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.convertPanel("record");
			}
		});
		bar.setBounds(0, 0, 360, 40);
		bar.setBorderPainted(false);
		bar.setContentAreaFilled(false);
		bar.setFocusPainted(false);
		add(bar);

		JLabel explain = new JLabel();
		explain.setBounds(47, 45, 260, 90);
		explain.setIcon(new ImageIcon("./images/inputrecordexplain.png"));
		add(explain);

		// 시간 입력
		JLabel time = new JLabel("시간");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setLocation(30, 150);
		time.setSize(50, 40);
		time.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		add(time);

		JLabel slash1 = new JLabel(":");
		slash1.setLocation(145, 150);
		slash1.setSize(10, 40);
		slash1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		add(slash1);

		JLabel slash2 = new JLabel(":");
		slash2.setLocation(225, 150);
		slash2.setSize(10, 40);
		slash2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		add(slash2);

		JTextField h = new JTextField("00");
		h.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField m = new JTextField("00");
		m.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField s = new JTextField("00");
		s.setHorizontalAlignment(SwingConstants.CENTER);

		h.setLocation(80, 150);
		m.setLocation(155, 150);
		s.setLocation(240, 150);
		
		h.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		m.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		s.setFont(new Font("맑은 고딕", Font.BOLD, 13));

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
		km1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		add(km1);

		JTextField km2 = new JTextField("0.0");
		km2.setHorizontalAlignment(SwingConstants.CENTER);
		km2.setLocation(105, 210);
		km2.setSize(150, 40);
		km2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		add(km2);

		JLabel km3 = new JLabel("km");
		km3.setHorizontalAlignment(SwingConstants.CENTER);
		km3.setLocation(273, 210);
		km3.setSize(50, 40);
		km3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		add(km3);

		km2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				km2.setText("");
			}
		});

		// 페이스 출력
		JLabel paceT = new JLabel("페이스");
		paceT.setHorizontalAlignment(SwingConstants.CENTER);
		paceT.setLocation(40, 331);
		paceT.setSize(140, 30);
		paceT.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(paceT);

		JLabel pacef = new JLabel("00.00");
		pacef.setHorizontalAlignment(SwingConstants.CENTER);
		pacef.setLocation(60, 366);
		pacef.setSize(100, 30);
		pacef.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(pacef);

		// 칼로리
		JLabel kcalT = new JLabel("칼로리");
		kcalT.setHorizontalAlignment(SwingConstants.CENTER);
		kcalT.setLocation(200, 331);
		kcalT.setSize(100, 30);
		kcalT.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(kcalT);

		JLabel kcalf = new JLabel("0");
		kcalf.setHorizontalAlignment(SwingConstants.CENTER);
		kcalf.setLocation(200, 366);
		kcalf.setSize(100, 30);
		kcalf.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(kcalf);

		// 확인
		JButton cf = new JButton();
		cf.setIcon(new ImageIcon("./Images/confirm.png"));
		cf.setLocation(145, 270);
		cf.setSize(60, 30);
		cf.setBorderPainted(false);
		cf.setContentAreaFilled(false);
		cf.setFocusPainted(false);
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

		JLabel starT = new JLabel("운동 평가");
		starT.setLocation(45, 420);
		starT.setSize(115, 30);
		starT.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(starT);

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
		JButton save = new JButton(new ImageIcon("./Images/save.png"));
		save.setLocation(145, 540);
		save.setSize(70, 40);
		save.setBorderPainted(false);
		save.setContentAreaFilled(false);
		save.setFocusPainted(false);
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
				main.getLoginView().getLoginController().getUserDao().saveUserList();
				
				System.out.println("운동기록이 저장되었습니다.");
				System.out.println(user.getExercises());
				main.updateUser(user);

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
