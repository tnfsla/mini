package com.kh.view.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;

public class LoginCheckDialog extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginCheckDialog dialog = new LoginCheckDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginCheckDialog() {
		setBounds(100, 100, 300, 142);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton.setBounds(87, 60, 108, 40);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("해당 아이디가 존재합니다.");
		textField.setBounds(28, 10, 225, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
	}

}
