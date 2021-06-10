package com.kh.view.crew;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewFeedCreateController;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CrewFeedCreatePanel extends JPanel {

	private CrewViewManager crewManager;
	private JTextField textField;


	
	public CrewFeedCreatePanel() {
		initialize();
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.setBounds(12, 10, 90, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("글쓰기");
		lblNewLabel.setBounds(114, 14, 57, 15);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("게시");
		btnNewButton_1.setBounds(251, 10, 97, 23);
		add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setText("제목을 입력해주세요");
		textField.setBounds(12, 50, 336, 50);
		add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("내용을 입력해주세요");
		textArea.setBounds(12, 110, 336, 480);
		add(textArea);
	}

}
