package com.kh.view.update;

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

import com.kh.view.crew.CrewImagePanel;
import com.kh.view.main.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class UserChange extends JPanel {
	private Main main;
	
	private JTextField textField;
	private JTextField textField_1;
	private EditViewManager viewManager;

	/**
	 * Create the panel.
	 */
	public UserChange(EditViewManager viewManager) {
		this.viewManager = viewManager;
		setLayout(null);
		setBounds(0, 0, 360, 600);
		setBackground(Color.white);

		textField = new JTextField();
		textField.setBounds(42, 300, 228, 33);
		add(textField);
		textField.setColumns(10);

		if (viewManager != null)
			this.main = viewManager.getMain();


		if (viewManager.getUser() != null) {
			Double userHeight = this.viewManager.getUser().getHeight();
			textField.setText(userHeight.toString());
		}

		textField_1 = new JTextField();
		textField_1.setBounds(42, 413, 228, 33);
		add(textField_1);
		textField_1.setColumns(10);

		if (viewManager.getUser() != null) {
			Double userWeight = this.viewManager.getUser().getWeight();
			textField_1.setText(userWeight.toString());
		}

		JLabel lblNewLabel = new JLabel("Height");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(47, 255, 62, 33);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Weight");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(47, 367, 67, 33);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cm");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(284, 302, 62, 31);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(284, 415, 62, 31);
		add(lblNewLabel_3);
		
		//뒤로가기
		JPanel panelCrewPageBack = new JPanel();
		panelCrewPageBack.setBounds(15, 10, 30, 30);
		panelCrewPageBack.add(new CrewImagePanel("./images/back.png", panelCrewPageBack.getSize()));
		add(panelCrewPageBack);
		panelCrewPageBack.setLayout(null);

		//뒤로가기 버튼 누르면 계정정보로 돌아가기
		JButton btnCrewPageBack = new JButton("");
		btnCrewPageBack.setContentAreaFilled(false);
		btnCrewPageBack.setBorderPainted(false);
		btnCrewPageBack.setBounds(0, 0, 30, 30);
		panelCrewPageBack.add(btnCrewPageBack);
		btnCrewPageBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 특정 crew 페이지로 다시 이동
				viewManager.convertPanel("update_main");
			}
		});

		
		//버튼에 확인이미지 삽입
		ImageIcon check = new ImageIcon("images/check_UserChange.PNG");
		Image checkImg = check.getImage();
		Image checkImgIcon = checkImg.getScaledInstance(116, 40, Image.SCALE_SMOOTH);
		ImageIcon checkImg1 = new ImageIcon(checkImgIcon);
		JButton btnNewButton = new JButton(checkImg1);
		btnNewButton.setBorderPainted(false);//테두리 제거
		btnNewButton.setContentAreaFilled(false);//뒷배경제거
		btnNewButton.setBounds(93, 490, 145, 39);
		add(btnNewButton);
	
		
		//이미지 삽입
		JPanel personIcon = new JPanel();
		personIcon.setBounds(119, 98, 99, 94);
		personIcon.setLayout(null);
		add(personIcon);
		EditImagePanel editImagePanel = new EditImagePanel("images/person1.png",personIcon.getSize());
		editImagePanel.setBounds(0, 0, 99, 94);
		personIcon.add(editImagePanel);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewManager.getUser().setPrevHeight(viewManager.getUser().getHeight());
				viewManager.getUser().setHeight(Double.parseDouble(textField.getText()));
			
				viewManager.getUser().setPrevWeight(viewManager.getUser().getWeight());
				viewManager.getUser().setWeight(Double.parseDouble(textField_1.getText()));
								
				viewManager.convertPanel("userCompare");//화면전환
				viewManager.updateUser();

			}
		});
		
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
		
		//뒤로가기 버튼
		JButton BackButton = new JButton("New button");
		BackButton.setBounds(14, 12, 105, 27);
		add(BackButton);
	}

	public void updateUser() {
		Double userHeight = this.viewManager.getUser().getHeight();
		textField.setText(userHeight.toString());
		
		Double userWeight = this.viewManager.getUser().getWeight();
		textField_1.setText(userWeight.toString());
	}
}
