package com.kh.view.update;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
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
		setBackground(Color.white);

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

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 255, 241));
		panel.setBounds(0, 61, 360, 455);
		add(panel);
		
		//****연필 이미지 추가****
		JPanel personIcon = new JPanel();
		personIcon.setBounds(120, 120, 50, 49);
		personIcon.setLayout(null);
		add(personIcon);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.setBounds(172, 292, 79, 27);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(77, 292, 79, 27);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
						
		textField_1 = new JPasswordField();
		textField_1.setBounds(55, 242, 219, 24);
		panel.add(textField_1);
		textField_1.setEchoChar('*');
		textField_1.setColumns(10);
								
		JLabel lblNewLabel_1 = new JLabel("새 비밀번호");
		lblNewLabel_1.setBounds(55, 215, 196, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
										
												
		textField = new JPasswordField();
		textField.setBounds(55, 145, 219, 24);
		panel.add(textField);
		textField.setEchoChar('*');
		textField.setColumns(10);
												
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setBounds(55, 113, 115, 39);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		EditImagePanel editImagePanel = new EditImagePanel("images/pencil.png",personIcon.getSize());
		editImagePanel.setBounds(144, 31, 50, 50);
		panel.add(editImagePanel);
		textField.getText();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					main.convertPanel("userMain");
							}
						});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						//비밀번호 변경
						if(textField.getText().equals(viewManager.getUser().getPw())){
							viewManager.getUser().setPw(textField_1.getText());
							//처음으로 돌아가 앱실행시 저장된 정보들을 읽어옴
							viewManager.getMain().getLoginView().getLoginController().getUserDao().saveUserList();
							JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.");
						}else {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						}
					}
				});
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
