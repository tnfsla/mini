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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.controller.admin.AdminEventController;
import com.kh.controller.login.LoginController;
import com.kh.model.vo.SystemUser;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class LoginMainView extends JPanel {

	private JTextField textFieldId;
	private JPasswordField passwordFieldPwd;

	private User user;
	private Main main;
	private LoginJoinPanel joinPanel;
	private LoginController loginController;
	private AdminEventController aec;

	// Panel 전환을 위한 Map
	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용
	private JButton btnJoin;
	private JLabel lblJoin;

	public LoginMainView() {
		initialize();

		loginController = new LoginController();
	}

	public LoginMainView(Main main, AdminEventController aec) {
		this();
		this.aec = aec;
		this.main = main;

		aec.setUserDao(loginController.getUserDao());
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
		if (user == null)
			user = new User("test", "1234", "김태훈", 20, 100, 100, '남', false);

		System.out.println("로그인 유저 : " + user);

		main.updateUser(user);
	}

	private void initialize() {

		setBounds(0, 0, 360, 600);
		setLayout(null);


		ImagePanel panel = new ImagePanel(new ImageIcon("./images/LoginImage.jpg").getImage());
		panel.setForeground(Color.WHITE);
		panel.setSize(getSize());
		add(panel);

		lblJoin = new JLabel("심BOX 회원이 아니신가요?");
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setBounds(85, 494, 182, 25);
		panel.add(lblJoin);

		btnJoin = new JButton("");
		btnJoin.setIcon(new ImageIcon("./images/JoinAdd.png"));
		btnJoin.setBounds(128, 520, 89, 25);
		panel.add(btnJoin);

		passwordFieldPwd = new JPasswordField();
		passwordFieldPwd.setBounds(124, 267, 114, 44);
		panel.add(passwordFieldPwd);

		textFieldId = new JTextField();
		textFieldId.setForeground(new Color(0, 0, 0));
		textFieldId.setBounds(124, 219, 161, 45);
		panel.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnLogin = new JButton("");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setIcon(new ImageIcon("./images/LoginNext.jpg"));
		btnLogin.setBounds(241, 267, 43, 43);
		panel.add(btnLogin);
		btnLogin.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textFieldId.getText();
				String password = String.valueOf(passwordFieldPwd.getPassword());

				user = loginController.selectUser(id, password);

				// login 성공
				if (user != null) {
					System.out.println("로그인 성공");
					loginUser();

					if (user.isAdminFlag() == false) {
						main.convertPanel("main"); // 일반 유저인 경우 main page로
					} else {
						main.convertPanel("admin"); // admin인 경우 admin page로
					}

				} else { // login 실패
					System.out.println("로그인 실패");
				}
			}

		});
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("회원 가입으로 이동");
				main.convertPanel("login_join");
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