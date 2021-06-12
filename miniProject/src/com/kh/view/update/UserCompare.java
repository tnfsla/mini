package com.kh.view.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.view.main.Main;

public class UserCompare extends JPanel {
	private Main main;
	
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;
	private EditViewManager viewManager;

	/**
	 * Create the panel.
	 */
	public UserCompare(EditViewManager viewManager) {

		if (viewManager != null)
			this.main = viewManager.getMain();	
		
		
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

		textField2 = new JTextField();
		textField2.setBounds(120, 310, 60, 33);
		add(textField2);
		textField2.setColumns(10);

		if (viewManager.getUser() != null ){
			double diffHeight = viewManager.getUser().getHeight() - viewManager.getUser().getPrevHeight();
			textField.setText(String.valueOf(diffHeight));
		}


		textField3 = new JTextField();
		textField3.setBounds(120, 408, 60, 33);
		add(textField3);
		textField3.setColumns(10);

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
		lblNewLabel_2.setBounds(179, 317, 62, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setBounds(179, 415, 62, 18);
		add(lblNewLabel_3);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(104, 488, 105, 27);
		add(btnNewButton);

		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(150, 561, 60, 29);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				main.convertPanel("main");
			}
		});
		add(lblHome);
		
		JLabel lblNewLabel_4 = new JLabel("이전 기록보다");
		lblNewLabel_4.setBounds(29, 309, 107, 26);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이전 기록보다");
		lblNewLabel_5.setBounds(29, 415, 96, 18);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("입니다.");
		lblNewLabel_6.setBounds(209, 317, 62, 18);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("입니다");
		lblNewLabel_7.setBounds(209, 415, 62, 18);
		add(lblNewLabel_7);
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
		textField2.setText(String.valueOf(diffHeight));

		
		double diffWeight = viewManager.getUser().getWeight() - viewManager.getUser().getPrevWeight();
		textField3.setText(String.valueOf(diffWeight));
	}
}
