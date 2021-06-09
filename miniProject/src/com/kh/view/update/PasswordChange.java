package com.kh.view.update;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.kh.model.vo.User;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class PasswordChange extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	protected User user;
	private PasswordChange passwordchange;
	/**
	 * Create the panel.
	 */
	public PasswordChange() {
		
		PasswordChange passwordchange = new PasswordChange();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(53, 155, 115, 39);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(52, 191, 219, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("새 비밀번호");
		textField.getText();
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(53, 268, 196, 18);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(52, 298, 219, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(73, 358, 79, 27);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordchange.newPassword(user, textField.getText());
			}
		});
		btnNewButton_1.setBounds(180, 358, 79, 27);
		add(btnNewButton_1);

	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setBounds(100, 100, 360, 600);
		frame.setResizable(false);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PasswordChange cmain = new PasswordChange();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(cmain);
		
		
		
	}
}
