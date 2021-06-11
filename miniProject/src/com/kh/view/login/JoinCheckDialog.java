package com.kh.view.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class JoinCheckDialog extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinCheckDialog dialog = new JoinCheckDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoinCheckDialog() {
		setBounds(100, 100, 300, 142);
		getContentPane().setLayout(null);
		{
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("사용가능한 아이디 입니다.");
			textField.setBounds(56, 10, 177, 22);
			getContentPane().add(textField);
			textField.setColumns(10);
		}
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(87, 63, 108, 40);
		getContentPane().add(btnNewButton);
	}

}
