package com.kh.view.login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.controller.login.JoinController;
import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import javax.swing.SwingConstants;

public class LoginJoinPanel extends JPanel {

	private JoinController joinController;

	private User user;

	private Main main;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_6;
	private JTextField textField_4;

	public LoginJoinPanel() {
		initialize();
	}

	public LoginJoinPanel(Main main, User user) {
		this();
		this.main = main;
		this.user = user;
	}

	public LoginJoinPanel(Main main, User user, UserDao userDao) {
		this(main, user);
		joinController = new JoinController(userDao);
	}

	private void initialize() {
		setBounds(100, 100, 360, 600);
		setLayout(null);

		File f = new File("./resources/UserJoinpage.jpg");
		System.out.println(f.exists() ? "Exists" : "doesnt exists");// 파일 경로 찾기 방법.

		JLabel lblNewLabel = new JLabel("  Name:");
		lblNewLabel.setBounds(33, 146, 50, 18);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("  ID :");
		lblNewLabel_1.setBounds(49, 185, 34, 18);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PWS:");
		lblNewLabel_2.setBounds(49, 228, 34, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setBounds(49, 272, 34, 18);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("성별 (M / F)");
		lblNewLabel_4.setBounds(121, 320, 93, 18);
		add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.setBounds(101, 144, 131, 24);
		add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(0, 0, 131, 24);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(101, 185, 234, 24);
		add(panel_1);
		panel_1.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(0, 0, 131, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setBounds(143, -2, 89, 27);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(101, 228, 131, 24);
		add(panel_2);
		panel_2.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(0, 0, 131, 24);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(101, 270, 131, 24);
		add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(44, 425, 244, 42);
		add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("cm");
		lblNewLabel_5.setBounds(209, 14, 23, 15);
		panel_4.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(61, 10, 131, 24);
		panel_4.add(textField_6);
		textField_6.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(45, 477, 243, 42);
		add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("kg");
		lblNewLabel_6.setBounds(208, 5, 23, 15);
		panel_5.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(61, 1, 131, 24);
		panel_5.add(textField_4);

		JLabel lblNewLabel_7 = new JLabel("회원정보를 입력하세요");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(35, 81, 300, 40);
		add(lblNewLabel_7);

		JButton btnNewButton_2 = new JButton("확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(121, 513, 93, 27);
		add(btnNewButton_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(94, 369, 179, 27);
		add(panel_3);
		panel_3.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("남(M)");
		buttonGroup.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setBounds(0, 0, 73, 27);
		panel_3.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("여(F)");
		buttonGroup.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setBounds(97, 0, 82, 27);
		panel_3.add(chckbxNewCheckBox_1);
		
		JButton LBt2 = new JButton("");
		LBt2.setBounds(12, 10, 24, 24);
		add(LBt2);
	}

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
}

