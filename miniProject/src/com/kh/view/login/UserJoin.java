package com.kh.view.login;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserJoin {

	private JFrame frame;
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
					UserJoin window = new UserJoin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserJoin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("UserJoin");
		frame.setBounds(100, 100, 360, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/UserJoinPage.png").getImage());
		frame.getContentPane().add(panel);

		
		File f = new File("./resources/UserJoinpage.jpg");
		System.out.println(f.exists()?"Exists":"doesnt exists");// 파일 경로 찾기 방법.
		
		JLabel lblNewLabel = new JLabel("  Name:");
		lblNewLabel.setBounds(33, 146, 62, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  ID :");
		lblNewLabel_1.setBounds(45, 187, 34, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PWS:");
		lblNewLabel_2.setBounds(45, 230, 50, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setBounds(50, 273, 50, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("성별 (M / F)");
		lblNewLabel_4.setBounds(121, 320, 93, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(101, 144, 131, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 185, 131, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 228, 131, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(101, 270, 131, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(101, 425, 131, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 477, 131, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("회원 정보를 입력하세요");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(79, 74, 209, 36);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("확인");
		btnNewButton_2.setBounds(121, 513, 93, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("남(M)");
		chckbxNewCheckBox.setBounds(94, 369, 73, 27);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("여(F)");
		chckbxNewCheckBox_1.setBounds(191, 369, 82, 27);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnNewButton.setBounds(244, 183, 89, 27);
		frame.getContentPane().add(btnNewButton);
	}
}
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}


