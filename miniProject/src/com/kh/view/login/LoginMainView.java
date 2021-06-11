package com.kh.view.login;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.controller.login.LoginController;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import javax.swing.SwingConstants;

public class LoginMainView extends JPanel {

	private JTextField textField;
	private JPasswordField passwordField;

	private User user;

	private Main main;

	private LoginJoinPanel joinPanel;

	private LoginController loginController;

	// Panel 전환을 위한 Map
	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

	public LoginMainView() {
		initialize();

		loginController = new LoginController();
	}

	public LoginMainView(Main main) {
		this();

		this.main = main;

		panelMap = main.getPanelMap();

		initPanel();
	}

	public void initPanel() {
		// 해당 panel들 map에 추가
		panelMap.put("login", this);

		joinPanel = new LoginJoinPanel(main, loginController.getUserDao());

		// 해당 panel들 map에 추가
		panelMap.put("login_join", joinPanel);
	}

	public void loginUser() {
		User user = new User("test", "1234", "김태훈", 20, 100, 100, '남', false);
		main.updateUser(user);
	}

	private void initialize() {

		setBounds(0, 0, 360, 600);
		setLayout(null);
		JPasswordField txtPass = new JPasswordField(10);

		// 테스트 용
//		JLabel lblHome = new JLabel("Home");
//		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
//		lblHome.setBounds(150, 561, 60, 29);
//		lblHome.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("메인 페이지로 이동");
//				main.convertPanel("main");
//			}
//		});
//		add(lblHome);

		ImagePanel panel = new ImagePanel(new ImageIcon("./image/LoginImage.jpg").getImage());
		panel.setSize(getSize());
		add(panel);

		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 46));
		lblNewLabel_2.setBounds(47, 180, 268, 72);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("심BOX 회원이 아니신가요?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(100, 473, 172, 25);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(142, 519, 80, 25);
		panel.add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(124, 309, 172, 42);
		panel.add(passwordField);

		textField = new JTextField();
		textField.setBounds(124, 262, 172, 42);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setBounds(142, 362, 80, 25);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("RBt");
		btnNewButton_2.setBounds(320, 7, 28, 28);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LBt");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(12, 10, 24, 24);
		panel.add(btnNewButton_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = "admin";
				String pass = "1234";

				if (id.equals(textField.getText()) && pass.equals(passwordField.getText())) {
					JOptionPane.showMessageDialog(null, "인증되었습니다");
					// 로그인 성공이 되었을때

					// 메인 페이지로 이동
				} else {
					JOptionPane.showConfirmDialog(null, "다시 확인하십시오");
				}

			}

		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

	}

	public LoginController getLoginController() {
		return loginController;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new JFrame();
					LoginMainView loginView = new LoginMainView();
					window.setBounds(100, 100, 360, 600);
					window.getContentPane().add(loginView);
					window.setVisible(true);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;

		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));

		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}