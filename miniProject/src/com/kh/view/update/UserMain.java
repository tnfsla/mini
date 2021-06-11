package com.kh.view.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserMain extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private EditViewManager viewManager;
	
	public UserMain(EditViewManager viewManager) {
		this.viewManager = viewManager;
		setLayout(null);
		setBounds(0, 0, 360, 600);
		
		textField = new JTextField();
		textField.setBounds(55, 252, 239, 41);
		add(textField);
		textField.setColumns(10);
		String userName = this.viewManager.getUser().getName();
		textField.setText(userName);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 343, 239, 41);
		add(textField_1);
		textField_1.setColumns(10);
		int userAge = this.viewManager.getUser().getAge();
		textField_1.setText(String.valueOf(userAge));
		
		JButton btnNewButton = new JButton("비밀번호 변경");
		btnNewButton.setBounds(109, 437, 146, 35);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {//3.버튼을 누르면 에디트 패널 꺼지고 유저체인지 패널 출력
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("passwordChange");
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(67, 321, 62, 18);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(67, 222, 62, 18);
		add(lblNewLabel_1);
	
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//
//		frame.setBounds(100, 100, 360, 600);
//
//		frame.setVisible(true);
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		UserMain um = new UserMain();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(um);
//		frame.getContentPane().add(um.passwordChange);
//		frame.setResizable(false);
//		
//		
//	}
}