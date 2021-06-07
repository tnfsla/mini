package com.kh.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EventSettingP extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private AdminViewManager avm;

	/**
	 * Create the panel.
	 */
	public EventSettingP() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JLabel lblEvent = new JLabel("EVENT 설정");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(29, 49, 257, 58);
		add(lblEvent);

		JLabel lblNewLabel = new JLabel("시작 날짜(yyyy-mm-dd)");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 152, 199, 23);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(29, 185, 257, 32);
		add(textField);

		JLabel lblNewLabel_1 = new JLabel("수치 입력");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 242, 199, 23);
		add(lblNewLabel_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("거리 (KM)");
		rdbtnNewRadioButton.setBounds(29, 271, 90, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("시간 (H)");
		rdbtnNewRadioButton_1.setBounds(119, 271, 121, 23);
		add(rdbtnNewRadioButton_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(29, 300, 257, 32);
		add(textField_1);

		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avm.convertPanel("main"); // 크루 만들기 page로 
			}
		});
		btnNewButton.setBounds(29, 478, 113, 39);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("설정");
		btnNewButton_1.setBounds(173, 478, 113, 39);
		add(btnNewButton_1);

	}

	public EventSettingP(AdminViewManager avm) {
		this();
		this.avm = avm;

	}
}
