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
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;

public class LoginJoinPanel {

	private JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField pw;
	private JTextField age;
	private JTextField Height;
	private JTextField Weight;
	private JTextField txty;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJoinPanel window = new LoginJoinPanel();
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
	public LoginJoinPanel() {
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
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/LoginJoinPanelImage.jpg").getImage());
		frame.getContentPane().add(panel);
		
		JTextField textfield = new JTextField();
		
		name = new JTextField();
		name.setBounds(101, 142, 150, 24);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setBounds(101, 190, 150, 24);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		pw = new JTextField();
		pw.setBounds(101, 237, 150, 24);
		frame.getContentPane().add(pw);
		pw.setColumns(10);
		
		age = new JTextField();
		age.setBounds(101, 282, 150, 24);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		Height = new JTextField();
		Height.setBounds(101, 412, 150, 24);
		frame.getContentPane().add(Height);
		Height.setColumns(10);
		
		Weight = new JTextField();
		Weight.setBounds(101, 475, 150, 24);
		frame.getContentPane().add(Weight);
		Weight.setColumns(10);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("회원 정보를 입력하세요");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(79, 74, 209, 36);
		frame.getContentPane().add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox_M = new JCheckBox("남자");
		chckbxNewCheckBox_M.setBounds(103, 343, 56, 23);
		frame.getContentPane().add(chckbxNewCheckBox_M);
		
		JCheckBox chckbxNewCheckBox_F = new JCheckBox("여자");
		chckbxNewCheckBox_F.setBounds(187, 343, 64, 23);
		frame.getContentPane().add(chckbxNewCheckBox_F);
		
		txty = new JTextField();
		txty.setText("성 별 (Y / N)");
		txty.setBounds(111, 316, 116, 21);
		frame.getContentPane().add(txty);
		txty.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("가입 완료");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.getContentPane().add(textfield, BorderLayout.CENTER);
				
				
				
				System.out.println("완료되었습니다 ");
			}
		});
		btnNewButton_1.setBounds(130, 511, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton = new JButton("중복확인");
		btnNewButton.setBounds(248, 189, 90, 24);
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


