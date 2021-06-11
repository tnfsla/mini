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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConfirm.setFont(new Font("굴림", Font.PLAIN, 16));
		btnConfirm.setBounds(87, 60, 108, 40);
		getContentPane().add(btnConfirm);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("해당 아이디가 존재합니다.");
		textField.setBounds(28, 10, 225, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
	}

}
