package com.kh.view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private Main main;

	public MainPanel() {
		setLayout(null);
		setBounds(0, 0, 360, 600);

		JButton btnNewButton = new JButton("개인정보 변경");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("update");
				System.out.println("Update Part 이동");
			}
		});
		btnNewButton.setBounds(12, 10, 124, 51);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("달리기 실행");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("record");
				System.out.println("Record Part 이동");
			}
		});
		btnNewButton_1.setBounds(41, 159, 118, 118);
		add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("기록 확인");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("result");
				System.out.println("Result Part 이동");
			}
		});

		btnNewButton_1_1.setBounds(185, 159, 118, 118);
		add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("크루메뉴");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.convertPanel("crew");
				System.out.println("Crew Part 이동");
			}
		});
		btnNewButton_1_2.setBounds(41, 315, 262, 118);
		add(btnNewButton_1_2);

		JLabel lblNewLabel = new JLabel("event");
		lblNewLabel.setBounds(42, 71, 57, 15);
		add(lblNewLabel);

		JLabel label = new JLabel("러닝 프로그램");
		label.setBounds(41, 122, 146, 27);
		add(label);
		
		JButton btnNewButton_2 = new JButton("admin test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("admin");
			}
		});
		btnNewButton_2.setBounds(185, 24, 97, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("login test");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("login");
			}
		});
		btnNewButton_3.setBounds(185, 67, 97, 23);
		add(btnNewButton_3);
	}

	public MainPanel(Main main) {
		this();
		this.main = main;
	}
}
