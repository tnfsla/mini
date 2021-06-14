package com.kh.view.update;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.view.main.Main;
import java.awt.Font;
import java.awt.Image;

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
		setBounds(0, 0, 360, 600);
		setBackground(Color.white);
		
		
		JLabel lblNewLabel = new JLabel("님의 신체기록 정보");
		lblNewLabel.setBounds(179, 195, 181, 39);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(47, 198, 116, 32);
		add(textField);
		textField.setColumns(10);
		if (viewManager.getUser() != null) {
			String userName = viewManager.getUser().getName();
			textField.setText(userName);
		}

		textField2 = new JTextField();
		textField2.setBounds(150, 310, 50, 33);
		add(textField2);
		textField2.setColumns(10);

		if (viewManager.getUser() != null ){
			double diffHeight = viewManager.getUser().getHeight() - viewManager.getUser().getPrevHeight();
			textField.setText(String.valueOf(diffHeight));
		}


		textField3 = new JTextField();
		textField3.setBounds(150, 408, 60, 33);
		add(textField3);
		textField3.setColumns(10);

		if (viewManager.getUser() != null) {
			double diffWeight = viewManager.getUser().getWeight() - viewManager.getUser().getPrevWeight();
			textField.setText(String.valueOf(diffWeight));
		}
		
		//이미지 삽입
		JPanel personIcon = new JPanel();
		personIcon.setBounds(0, 120, 452, 141);
		personIcon.setLayout(null);
		add(personIcon);
		EditImagePanel editImagePanel = new EditImagePanel("images/userPersonImg.png",personIcon.getSize());
		editImagePanel.setBounds(-87, 0, 564, 149);
		personIcon.add(editImagePanel);

		JLabel lblNewLabel1 = new JLabel("Height");
		lblNewLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel1.setBounds(29, 283, 62, 32);
		add(lblNewLabel1);

		JLabel lblNewLabel_1 = new JLabel("Weight");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 385, 62, 32);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cm");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(209, 315, 62, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(222, 406, 38, 32);
		add(lblNewLabel_3);

		//확인 이미지 삽입
		ImageIcon check = new ImageIcon("images/check_UserChange.PNG");
		Image checkImg = check.getImage();
		Image checkImgIcon = checkImg.getScaledInstance(116, 40, Image.SCALE_SMOOTH);
		ImageIcon checkImg1 = new ImageIcon(checkImgIcon);
		JButton btnNewButton = new JButton(checkImg1);
		btnNewButton.setBorderPainted(false);//테두리 제거
		btnNewButton.setContentAreaFilled(false);//뒷배경제거
		btnNewButton.setBounds(93, 490, 145, 39);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {// 3.버튼을 누르면 에디트 패널 꺼지고 유저체인지 패널 출력
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("userChange");

			}
		});
		
		//홈으로
		JLabel lblHome = new JLabel();
		lblHome.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon("./Images/home2.png"));
		lblHome.setBounds(0, 570, 360, 30);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				main.convertPanel("main");
			}
		});
		add(lblHome);
	
		
		JLabel lblNewLabel_4 = new JLabel("이전 기록보다");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(39, 311, 107, 26);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이전 기록보다");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(40, 413, 96, 28);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("입니다.");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(253, 315, 62, 18);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("입니다");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(253, 413, 62, 18);
		add(lblNewLabel_7);
	}


	public void updateUser() {
		String userName = viewManager.getUser().getName();
		textField.setText(userName);
	
	
		double diffHeight = viewManager.getUser().getHeight() - viewManager.getUser().getPrevHeight();
		textField2.setText(String.valueOf(diffHeight));

		
		double diffWeight = viewManager.getUser().getWeight() - viewManager.getUser().getPrevWeight();
		textField3.setText(String.valueOf(diffWeight));
	}
}
