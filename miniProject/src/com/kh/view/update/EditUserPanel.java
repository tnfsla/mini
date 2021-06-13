package com.kh.view.update;

import java.awt.Color;
import java.awt.Dimension;
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

import com.kh.controller.update.EditUserController;
import com.kh.model.vo.User;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class EditUserPanel extends JPanel {
	
	
	private JTextField textField;
	private JTextField textField_1;
	private EditUserController controller;
	private EditViewManager viewManager;

	/**
	 * Create the panel.
	 */
	public EditUserPanel(EditViewManager viewManager) {
		this.viewManager = viewManager;
		initialize();

	}

	public void initialize() {
		controller = new EditUserController();

	
		setLayout(null);
		setBounds(0, 0, 360, 600);
		setBackground(Color.WHITE);//배경 색 변경
		textField_1 = new JTextField();
		textField_1.setBounds(52, 229, 270, 40);
		add(textField_1);
		textField_1.setColumns(10);
		if (viewManager.getUser() != null)
			textField_1.setText(viewManager.getUser().getId());//아이디 가져오기
		textField_1.setEditable(false);//편집 불가
		textField_1.setBackground(Color.white);
	
		
		JButton btnNewButton = new JButton("계정 정보");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(215, 255, 241));//rgb색으로 변경
		btnNewButton.setBorderPainted(false);//버튼테두리 안보이게 만들기
		btnNewButton.setBounds(52, 318, 270, 60);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("userMain");
			}
		});

		JButton btnNewButton_1 = new JButton("신체 정보");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(215, 255, 241));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("userChange");

			}
		});

		btnNewButton_1.setBounds(52, 424, 270, 60);
		add(btnNewButton_1);
		
		JPanel personIcon = new JPanel();
		personIcon.setBounds(121, 107, 111, 95);
		personIcon.setLayout(null);
		add(personIcon);
		EditImagePanel editImagePanel = new EditImagePanel("images/person1.png",personIcon.getSize());
		editImagePanel.setBounds(0, 0, 111, 95);
		personIcon.add(editImagePanel);
		
	
	}

//
//	public static void main(String[] args) {
//
//
//}

	public void updateUser() {
		textField_1.setText(viewManager.getUser().getId());
	}
}
