package com.kh.view.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.view.crew.CrewImagePanel;
import com.kh.view.main.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class UserMain extends JPanel {
	private Main main;
	
	private JTextField textField;
	private JTextField textField_1;
	private EditViewManager viewManager;
	private JLabel lblHome;
	
	public UserMain(EditViewManager viewManager) {
	
		this.viewManager = viewManager;
		setLayout(null);
		setBounds(0, 0, 360, 600);
		setBackground(Color.white);
		
		textField = new JTextField();
		textField.setBounds(55, 269, 239, 41);
		add(textField);
		textField.setColumns(10);

		if (viewManager != null)
			this.main = viewManager.getMain();
		
		if (viewManager.getUser() != null) {
			String userName = this.viewManager.getUser().getName();
			textField.setText(userName);
		}

		textField_1 = new JTextField();
		textField_1.setBounds(55, 360, 239, 41);
		add(textField_1);
		textField_1.setColumns(10);

		if (viewManager.getUser() != null) {
			int userAge = this.viewManager.getUser().getAge();
			textField_1.setText(String.valueOf(userAge));
		}
		
		ImageIcon passwordChange = new ImageIcon("images/passwordChange1.PNG");
		Image passwordChangeImg = passwordChange.getImage();
		Image passwordChangeIcon = passwordChangeImg.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon passwordChangeIcon2 = new ImageIcon(passwordChangeImg);
		JButton btnNewButton = new JButton(passwordChangeIcon2);
		btnNewButton.setBorderPainted(false);//테두리 제거
		btnNewButton.setContentAreaFilled(false);//뒷배경제거
		btnNewButton.setBounds(98, 441, 178, 35);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {// 3.버튼을 누르면 에디트 패널 꺼지고 유저체인지 패널 출력
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("passwordChange");

			}
		});

		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(55, 328, 62, 35);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(55, 237, 62, 35);
		add(lblNewLabel_1);
		
		//*****라벨에 이미지 넣기*****
		JPanel personIcon = new JPanel();
		personIcon.setBounds(120, 120, 99, 94);
		personIcon.setLayout(null);
		add(personIcon);
		EditImagePanel editImagePanel = new EditImagePanel("images/person1.png",personIcon.getSize());
		editImagePanel.setBounds(0, 0, 99, 94);
		personIcon.add(editImagePanel);
		
		//두번째 배경패널
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 255, 241));
		panel.setBounds(0, 23, 360, 530);
		add(panel);
		
		//홈으로 가기
		ImageIcon backhome = new ImageIcon("images/home2.PNG");
		Image backHomeImg = backhome.getImage();
		Image updateBackHomeImg = backHomeImg.getScaledInstance(360, 20, Image.SCALE_SMOOTH);
		ImageIcon Home = new ImageIcon(updateBackHomeImg);

		lblHome = new JLabel(Home);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				main.convertPanel("main");

			}
		});
		
	}
	


	public void updateUser() {
		String userName = this.viewManager.getUser().getName();
		textField.setText(userName);

		int userAge = this.viewManager.getUser().getAge();
		textField_1.setText(String.valueOf(userAge));
	}
}
