package com.kh.view.update;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.controller.update.PasswordChangeController;
import com.kh.model.vo.User;
import com.kh.view.main.Main;

public class PasswordChangeView extends JPanel {
	private Main main;

	private JPasswordField textField;//비밀번호 입력내용 가림
	private JPasswordField textField_1;
	private User user;
	private PasswordChangeController passwordchangeController;
	private EditViewManager viewManager;

	/**
	 * Create the panel.
	 */
	public PasswordChangeView(EditViewManager viewManager, User user) {
		this.viewManager = viewManager;
		this.user = user;

		if (viewManager != null)
			this.main = viewManager.getMain();

		passwordchangeController = new PasswordChangeController();

		setLayout(null);
		setBounds(0, 0, 360, 600);

		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(53, 155, 115, 39);
		add(lblNewLabel);

		
		textField = new JPasswordField();
		textField.setEchoChar('*');// 비밀번호 '*'로 출력
		textField.setBounds(52, 191, 219, 24);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("새 비밀번호");
		textField.getText();
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(53, 268, 196, 18);
		add(lblNewLabel_1);

		textField_1 = new JPasswordField();
		textField_1.setEchoChar('*');
		textField_1.setBounds(52, 298, 219, 24);
		add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("취소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.convertPanel("userMain");
			}
		});
		btnNewButton.setBounds(73, 358, 79, 27);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//비밀번호 변경
				if(textField.getText().equals(viewManager.getUser().getPw())){
					viewManager.getUser().setPw(textField_1.getText());
					JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				}
			}
		});
		btnNewButton_1.setBounds(180, 358, 79, 27);
		add(btnNewButton_1);

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
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//
//		frame.setBounds(100, 100, 360, 600);
//
//		frame.setVisible(true);
//		PasswordChangeView cmain = new PasswordChangeView(null);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(cmain);
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
	}

	public void updateUser() {
		//textField.setText(user.getPw());
	}

}
