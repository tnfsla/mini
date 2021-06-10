package com.kh.view.crew;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewFeedSelectController;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class CrewFeedSelectPanel extends JPanel {

	private CrewViewManager crewManager;
	private JTextField textField;


	
	public CrewFeedSelectPanel() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.setBounds(12, 10, 90, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("게시글");
		lblNewLabel.setBounds(114, 14, 57, 15);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setBounds(224, 10, 60, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setBounds(288, 10, 60, 23);
		add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 55, 336, 150);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("유저 아이디");
		lblNewLabel_1.setBounds(12, 10, 72, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2021.06.10 오후 17:25");
		lblNewLabel_2.setBounds(12, 35, 130, 15);
		panel.add(lblNewLabel_2);
		
		JTextArea txtrn = new JTextArea();
		txtrn.setText("오늘 힘내서 달려요");
		txtrn.setEditable(false);
		txtrn.setBounds(12, 61, 312, 79);
		panel.add(txtrn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 215, 336, 50);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("파도아가라님 외 6명이 좋아합니다.");
		lblNewLabel_4.setBounds(87, 18, 237, 15);
		panel_1.add(lblNewLabel_4);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("좋아요");
		tglbtnNewToggleButton.setBounds(0, 14, 75, 23);
		panel_1.add(tglbtnNewToggleButton);
		
		JList list = new JList();
		list.setBounds(12, 275, 336, 265);
		add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 550, 336, 40);
		add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setText("댓글을 남겨주세요");
		textField.setBounds(12, 0, 250, 40);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("보내기");
		btnNewButton_3.setBounds(261, 0, 75, 40);
		panel_2.add(btnNewButton_3);
		
		
	}
}
