package com.kh.view.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinCompleteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinCompleteDialog dialog = new JoinCompleteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoinCompleteDialog() {
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
		textField.setText("회원가입이 완료되었습니다.");
		textField.setBounds(28, 10, 225, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
	}

}
