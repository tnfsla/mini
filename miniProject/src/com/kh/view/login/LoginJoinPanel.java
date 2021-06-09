package com.kh.view.login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginJoinPanel extends Panel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new JFrame();
					LoginJoinPanel joinPanel = new LoginJoinPanel();
					window.setBounds(100, 100, 360, 600);
					window.getContentPane().add(joinPanel);
					window.setVisible(true);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginJoinPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 360, 600);
		setLayout(null);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/UserJoinPage.png").getImage());
		add(panel);

		
		File f = new File("./resources/UserJoinpage.jpg");
		System.out.println(f.exists()?"Exists":"doesnt exists");// 파일 경로 찾기 방법.
		
		JLabel lblNewLabel = new JLabel("  Name:");
		lblNewLabel.setBounds(33, 146, 62, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  ID :");
		lblNewLabel_1.setBounds(45, 187, 34, 18);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PWS:");
		lblNewLabel_2.setBounds(45, 230, 50, 18);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setBounds(50, 273, 50, 18);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("성별 (M / F)");
		lblNewLabel_4.setBounds(121, 320, 93, 18);
		add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(101, 144, 131, 24);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 185, 131, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 228, 131, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(101, 270, 131, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(101, 425, 131, 24);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 477, 131, 24);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("회원 정보를 입력하세요");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(79, 74, 209, 36);
		add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("확인");
		btnNewButton_2.setBounds(121, 513, 93, 27);
		add(btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("남(M)");
		chckbxNewCheckBox.setBounds(94, 369, 73, 27);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("여(F)");
		chckbxNewCheckBox_1.setBounds(191, 369, 82, 27);
		add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnNewButton.setBounds(244, 183, 89, 27);
		add(btnNewButton);
	}
}


