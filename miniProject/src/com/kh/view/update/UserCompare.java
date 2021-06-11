package com.kh.view.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserCompare extends JPanel {
	private JTextField textField;
	private EditViewManager viewManager;

	/**
	 * Create the panel.
	 */
	public UserCompare(EditViewManager viewManager) {
		this.viewManager = viewManager;

		setLayout(null);
		setBounds(0, 0, 300, 600);

		textField = new JTextField();
		textField.setBounds(47, 198, 116, 32);
		add(textField);
		textField.setColumns(10);
		if (viewManager.getUser() != null) {
			String userName = viewManager.getUser().getName();
			textField.setText(userName);
		}

		textField = new JTextField();
		textField.setBounds(42, 300, 228, 33);
		add(textField);
		textField.setColumns(10);

		if (viewManager.getUser() != null) {
			double diffHeight = viewManager.getUser().getHeight() - viewManager.getUser().getPrevHeight();
			System.out.println(" getHeight() = " + viewManager.getUser().getHeight());
			System.out.println("getPrevHeight() = " + viewManager.getUser().getPrevHeight());
			textField.setText(String.valueOf(diffHeight));
		}

		// 이거 받은 값 - 원래 회원가입값 이 지금 오류가남

		textField = new JTextField();
		textField.setBounds(42, 413, 228, 33);
		add(textField);
		textField.setColumns(10);

		if (viewManager.getUser() != null) {
			double diffWeight = viewManager.getUser().getWeight() - viewManager.getUser().getPrevWeight();
			textField.setText(String.valueOf(diffWeight));
		}

		JLabel lblNewLabel = new JLabel("님의 신체기록 정보");
		lblNewLabel.setBounds(179, 195, 181, 39);
		add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel("Height");
		lblNewLabel1.setBounds(42, 270, 62, 18);
		add(lblNewLabel1);

		JLabel lblNewLabel_1 = new JLabel("Weight");
		lblNewLabel_1.setBounds(42, 383, 62, 18);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cm");
		lblNewLabel_2.setBounds(284, 302, 62, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setBounds(284, 415, 62, 18);
		add(lblNewLabel_3);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(104, 488, 105, 27);
		add(btnNewButton);

	}
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//
//		frame.setBounds(100, 100, 360, 600);
//
//		frame.setVisible(true);
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		UserCompare ucompare = new UserCompare();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(ucompare);
//		frame.setResizable(false);
//		
//		
//	}

	public void updateUser() {
		String userName = viewManager.getUser().getName();
		textField.setText(userName);

		double diffHeight = viewManager.getUser().getHeight() - viewManager.getUser().getPrevHeight();
		System.out.println(" getHeight() = " + viewManager.getUser().getHeight());
		System.out.println("getPrevHeight() = " + viewManager.getUser().getPrevHeight());
		textField.setText(String.valueOf(diffHeight));

		double diffWeight = viewManager.getUser().getWeight() - viewManager.getUser().getPrevWeight();
		textField.setText(String.valueOf(diffWeight));
	}
}
