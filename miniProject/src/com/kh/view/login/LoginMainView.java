package com.kh.view.login;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginMainView {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMainView window = new LoginMainView();
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
	public LoginMainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/LoginImage.jpg").getImage());
		frame.getContentPane().add(panel);
	
		
		
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String id = "admin";
					String pass = "1234";
					
					if(id.equals(textField.getText())&& pass.equals(passwordField.getText())) {
						JOptionPane.showMessageDialog(null, "인증되었습니다");
						//로그인 성공이 되었을때 
						
						//메인 페이지로 이동
					}else {
						JOptionPane.showConfirmDialog(null, "다시 확인하십시오");
					}
					
				}
			
		});
		btnNewButton.setBounds(129, 334, 70, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Login : ");
		lblNewLabel.setBounds(56, 256, 51, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW : ");
		JPasswordField txtPass = new JPasswordField(10);
		lblNewLabel_1.setBounds(68, 293, 37, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 287, 127, 35);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_1.setBounds(111, 514, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(128, 248, 127, 35);
		frame.getContentPane().add(textField);
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
	}//수정 내용 test
}
