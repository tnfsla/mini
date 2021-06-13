package com.kh.view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.controller.login.JoinController;
import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import javax.swing.JPasswordField;

public class LoginJoinPanel extends JPanel {

	private JoinController joinController;

	private User user;

	private Main main;

	private JTextField textFieldName;
	private JTextField textFieldId;
	private JTextField textFieldAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JPasswordField passwordFieldPwd;

	private JCheckBox chckbxMan;

	private JCheckBox chckbxWoman;

	private JButton btnJoin;

	public LoginJoinPanel() {
		initialize();
	}

	public LoginJoinPanel(Main main) {
		this();
		this.main = main;
	}

	public LoginJoinPanel(Main main, UserDao userDao) {
		this(main);
		joinController = new JoinController(userDao);
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		ImagePanel panel = new ImagePanel(new ImageIcon("./images/LoginJoinPanelImage.jpg").getImage());
		panel.setLocation(0, 0);
		panel.setForeground(Color.WHITE);
		panel.setSize(getSize());
		add(panel);

		JPanel panelAge = new JPanel();
		panelAge.setBounds(101, 292, 131, 24);
		panel.add(panelAge);
		panelAge.setLayout(null);

		textFieldAge = new JTextField();
		textFieldAge.setBounds(0, 0, 131, 24);
		panelAge.add(textFieldAge);
		textFieldAge.setColumns(10);

		JPanel panelGender = new JPanel();
		panelGender.setBackground(Color.WHITE);
		panelGender.setBounds(90, 355, 158, 27);
		panel.add(panelGender);
		panelGender.setLayout(null);

		chckbxMan = new JCheckBox("남(M)");
		chckbxMan.setBackground(Color.WHITE);
		buttonGroup.add(chckbxMan);
		chckbxMan.setBounds(0, 0, 73, 27);
		panelGender.add(chckbxMan);

		chckbxWoman = new JCheckBox("여(F)");
		chckbxWoman.setBackground(Color.WHITE);
		buttonGroup.add(chckbxWoman);
		chckbxWoman.setBounds(97, 0, 82, 27);
		panelGender.add(chckbxWoman);

		textFieldHeight = new JTextField();
		textFieldHeight.setBounds(101, 413, 131, 24);
		panel.add(textFieldHeight);
		textFieldHeight.setColumns(10);

		JLabel lblHeight = new JLabel("cm");
		lblHeight.setBounds(256, 421, 23, 15);
		panel.add(lblHeight);

		btnJoin = new JButton("확인");
		btnJoin.setBounds(119, 510, 93, 27);
		panel.add(btnJoin);

		JPanel panelName = new JPanel();
		panelName.setBounds(101, 147, 131, 24);
		panel.add(panelName);
		panelName.setLayout(null);

		textFieldName = new JTextField();
		textFieldName.setBounds(0, 0, 131, 24);
		panelName.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldWeight = new JTextField();
		textFieldWeight.setBounds(101, 469, 131, 24);
		panel.add(textFieldWeight);
		textFieldWeight.setColumns(10);

		JLabel lblWeight = new JLabel("kg");
		lblWeight.setBounds(256, 474, 23, 15);
		panel.add(lblWeight);

		JPanel panelId = new JPanel();
		panelId.setBounds(101, 196, 228, 26);
		panel.add(panelId);
		panelId.setLayout(null);

		textFieldId = new JTextField();
		textFieldId.setBounds(0, 0, 131, 25);
		panelId.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnCheckId = new JButton("중복확인");
		btnCheckId.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCheckId.setHorizontalAlignment(SwingConstants.LEADING);
		btnCheckId.setBounds(135, 0, 90, 25);
		panelId.add(btnCheckId);

		JPanel panelPwd = new JPanel();
		panelPwd.setBounds(101, 245, 131, 24);
		panel.add(panelPwd);
		panelPwd.setLayout(null);

		passwordFieldPwd = new JPasswordField();
		passwordFieldPwd.setBounds(0, 0, 131, 24);
		panelPwd.add(passwordFieldPwd);
		btnCheckId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String id = textFieldId.getText();

				if (joinController.hasUserId(id) == false) {
					System.out.println("사용가능한 아이디 입니다.");
					JoinCheckDialog dialog = new JoinCheckDialog();
					dialog.setVisible(true);
					updateJoinState(true);
				} else {
					System.out.println("해당 아이디가 존재합니다.");
					LoginCheckDialog dialog = new LoginCheckDialog();
					dialog.setVisible(true);
					updateJoinState(false);
				}

				joinController.printUser();
			}

			private void updateJoinState(boolean b) {
				btnJoin.setEnabled(b);
			}
		});
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String id = textFieldId.getText();
				String password = String.valueOf(passwordFieldPwd.getPassword());
				int age = Integer.parseInt(textFieldAge.getText());
				char gender = chckbxMan.isSelected() ? '남' : '여';
				double height = Double.parseDouble(textFieldHeight.getText());
				double weight = Double.parseDouble(textFieldWeight.getText());

				joinController.createUser(name, id, password, age, gender, height, weight);

				// 회원가입 이후 로그인 페이지로 이동
				JoinCompleteDialog dialog = new JoinCompleteDialog();
				dialog.setVisible(true);

				dialog.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// dialog dispose시 호출
						main.convertPanel("login");

						joinController.saveUserList(); // 유저 정보 저장
						joinController.printUser();
					}
				});
			}
		});

		//File f = new File("./image/UserJoinPage.png");
//		System.out.println(f.exists() ? "Exists" : "doesnt exists");// 파일 경로 찾기 방법.

		JLabel lblName = new JLabel("  Name:");
		lblName.setBounds(33, 146, 50, 18);
		add(lblName);

		JLabel lblId = new JLabel("  ID :");
		lblId.setBounds(49, 185, 34, 18);
		add(lblId);

		JLabel lblPwd = new JLabel("PWS:");
		lblPwd.setBounds(49, 228, 34, 18);
		add(lblPwd);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(49, 272, 34, 18);
		add(lblAge);

		JLabel lblNGender = new JLabel("성별 (M / F)");
		lblNGender.setBounds(121, 328, 93, 18);
		add(lblNGender);

		JPanel panelHeight = new JPanel();
		panelHeight.setBounds(44, 425, 244, 42);
		add(panelHeight);
		panelHeight.setLayout(null);

		JPanel panelWeight = new JPanel();
		panelWeight.setBounds(45, 477, 243, 42);
		add(panelWeight);
		panelWeight.setLayout(null);

		JLabel lblJoinTitle = new JLabel("회원정보를 입력하세요");
		lblJoinTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinTitle.setFont(new Font("굴림", Font.PLAIN, 18));
		lblJoinTitle.setBounds(35, 81, 300, 40);
		add(lblJoinTitle);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new JFrame();
					LoginJoinPanel joinPanel = new LoginJoinPanel();
					window.setBounds(100, 100, 360, 600);
					window.getContentPane().add(joinPanel);
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
