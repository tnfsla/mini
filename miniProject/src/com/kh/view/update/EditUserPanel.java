package com.kh.view.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.controller.update.EditUserController;
import com.kh.model.vo.User;

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
		textField_1 = new JTextField();
		textField_1.setBounds(52, 253, 260, 36);
		add(textField_1);
		textField_1.setColumns(10);
		if (viewManager.getUser() != null)
			textField_1.setText(viewManager.getUser().getId());

		JButton btnNewButton = new JButton("계정 정보");
		btnNewButton.setBounds(52, 318, 260, 60);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {// 3.버튼을 누르면 에디트 패널 꺼지고 유저체인지 패널 출력
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("userMain");

			}
		});

		JButton btnNewButton_1 = new JButton("신체 정보");
		btnNewButton_1.addActionListener(new ActionListener() {// 3.버튼을 누르면 에디트 패널 꺼지고 유저체인지 패널 출력
			public void actionPerformed(ActionEvent arg0) {
				viewManager.convertPanel("userChange");

			}
		});

		btnNewButton_1.setBounds(52, 424, 260, 60);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(52, 211, 80, 30);
		add(lblNewLabel);

	}

	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setBounds(100, 100, 360, 600);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		frame.setResizable(false);
//		
//		
//		EditViewManager viewManager = new EditViewManager();
//		viewManager.addPanels(frame);
//		viewManager.convertPanel("main");
//		

//		frame.getContentPane().add(cm);
//		frame.getContentPane().add(cm.userChange);//1.프레임안에 패널이 2개
//		frame.getContentPane().add(cm.userMain);
//		JPanel mm = cm.userMain;

//		frame.setResizable(false);

	}

	public void updateUser() {
		textField_1.setText(viewManager.getUser().getId());
	}
}
