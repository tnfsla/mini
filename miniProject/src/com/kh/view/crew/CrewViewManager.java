package com.kh.view.crew;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kh.controller.crew.CrewControllerManager;
import com.kh.model.vo.Crew;
import com.kh.model.vo.User;

public class CrewViewManager {

	private User user; // 현재 접속 중인 사용자

	private JPanel mainPanel; // 메인 - 시작 page
	private CrewCreatePanel createPanel; // 크루 만들기 page
	private CrewPanel crewPanel; // 특정 크루 page
	private CrewRankPanel rankPanel; // 특정 크루 랭킹 page

	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

	private CrewControllerManager controllerManager; // 메인 controller

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JLabel lblCrewName1;

	private JLabel lblCrewCount1;

	private JLabel lblCrewName2;

	private JLabel lblCrewCount2;

	private JLabel lblCrewName3;

	private JLabel lblCrewCount3;

	private JButton btnCreatePage;

	private JButton btnCrewPage1;

	private JButton btnCrewPage2;

	private JButton btnCrewPage3;

	private JButton btnCrewCreateCancel;

	public CrewViewManager(User user) {
		this.user = user;
		initialize();
		initPanel();

		controllerManager.loadCrewList(); // 저장된 크루 정보 읽어오기
		setPanel();

		updateCrewJoinState(); // 크루 가입 상태에 따라 처리하는 메소드
	}

	// 읽어온 크루 정보로 페널 세팅하기
	private void setPanel() {
		ArrayList<Crew> crewList = controllerManager.getCrewDao().getCrewList();

		Crew crew = null;
		if (crewList.size() >= 1) {
			crew = crewList.get(0);
			lblCrewName1.setText(crew.getCrewName());
			lblCrewCount1.setText(String.valueOf(crew.getCrewUserCount()) + " 명");
		}

		if (crewList.size() >= 2) {
			crew = crewList.get(1);
			lblCrewName2.setText(crew.getCrewName());
			lblCrewCount2.setText(String.valueOf(crew.getCrewUserCount()) + " 명");
		}

		if (crewList.size() >= 3) {
			crew = crewList.get(2);
			lblCrewName3.setText(crew.getCrewName());
			lblCrewCount3.setText(String.valueOf(crew.getCrewUserCount()) + " 명");
		}
	}

	// 패널 객체 생성 및 컨트롤러 이어주기
	private void initPanel() {
		controllerManager = new CrewControllerManager(user);

		createPanel = new CrewCreatePanel(this, controllerManager.getCrewCreateController());
		crewPanel = new CrewPanel(this, controllerManager.getCrewController());
		rankPanel = new CrewRankPanel(this, controllerManager.getCrewController().getCrewRankController());

		panelMap = new LinkedHashMap<String, JPanel>();
		// frameMap에 crew에서 쓰이는 frame들 다 넣어둠
		panelMap.put("main", mainPanel);
		panelMap.put("create", createPanel);
		panelMap.put("crew", crewPanel);
		panelMap.put("rank", rankPanel);
	}

	// 패널 전환 메소드
	// panelMap에서 해당 panel을 찾아 setVisible true 후 나머지는 다 false로 변경
	public void convertPanel(String panelName) {

		// 모든 frame setVisible false로 하기
		for (String key : panelMap.keySet()) {
			JPanel panel = panelMap.get(key);

			panel.setVisible(false);
		}

		panelMap.get(panelName).setVisible(true);

	}

	// 특정 프레임에 패널들 다 넣어주는 메소드
	public void addPanels(JFrame frame) {
		for (String key : panelMap.keySet()) {
			JPanel panel = panelMap.get(key);
			panel.setVisible(false);

			frame.getContentPane().add(panel);
		}
	}

	// 크루 가입 상태 세팅하기
	public void updateCrewJoinState() {
		// 크루 미가입 상태
		if (user.getCrewName() == null) {
			System.out.println("현재 유저 크루 미가입 상태");
			
			btnCrewCreateCancel.setVisible(false);

			btnCreatePage.setText("크루 만들기");
			btnCreatePage.setEnabled(true);

			btnCrewPage1.setEnabled(true);
			btnCrewPage2.setEnabled(true);
			btnCrewPage3.setEnabled(true);

			return;
		}

		// 크루 만들기 상태 (가입 상태)이나 크루 승인이 나지 않은 경우
		if (controllerManager.selectCrew(user.getCrewName()).isAccept() == false) {
			System.out.println("현재 유저 크루 만들기 상태 승인 안남");
			
			btnCrewCreateCancel.setVisible(true);

			btnCreatePage.setText("크루 승인을 요청하고 있습니다.");
			btnCreatePage.setEnabled(false);

			btnCrewPage1.setEnabled(false);
			btnCrewPage2.setEnabled(false);
			btnCrewPage3.setEnabled(false);

			return;
		}

		// 크루 가입 상태
		// 해당 크루로 이동
		System.out.println("현재 유저 크루 가입 상태");
		crewPanel.setCrew(controllerManager.selectCrew(user.getCrewName()));
		System.out.println("크루 이동");
		convertPanel("crew");
	}

	private void initialize() {

		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainPanel.setBackground(Color.GRAY);
		mainPanel.setBounds(0, 0, 360, 600);
		mainPanel.setLayout(null);

		btnCreatePage = new JButton("크루 만들기");
		btnCreatePage.setContentAreaFilled(false);
		btnCreatePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createPanel.initPanel();
				convertPanel("create"); // 크루 만들기 page로
			}
		});
		btnCreatePage.setBounds(25, 60, 310, 100);
		mainPanel.add(btnCreatePage);

		JLabel lblNewLabel = new JLabel("-心BOX 크루 추천");
		lblNewLabel.setBounds(30, 200, 110, 50);
		mainPanel.add(lblNewLabel);

		JPanel crewListPanel = new JPanel();
		crewListPanel.setBorder(new EmptyBorder(30, 15, 30, 15));
		crewListPanel.setBounds(25, 270, 310, 270);
		mainPanel.add(crewListPanel);
		crewListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel crewItemPanel1 = new JPanel();
		crewListPanel.add(crewItemPanel1);
		crewItemPanel1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 280, 55);
		crewItemPanel1.add(panel);
		panel.setLayout(null);

		lblCrewName1 = new JLabel("크루명");
		lblCrewName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName1.setBounds(60, 10, 80, 30);
		panel.add(lblCrewName1);

		lblCrewCount1 = new JLabel("0 명");
		lblCrewCount1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount1.setBounds(180, 10, 70, 30);
		panel.add(lblCrewCount1);

		btnCrewPage1 = new JButton("");
		btnCrewPage1.setContentAreaFilled(false);
		btnCrewPage1.addMouseListener(new MouseAdapter() {
		});
		btnCrewPage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblCrewName1.equals("크루명")) {// 크루가 리스트에 출력되어 있는 경우
					Crew crew = controllerManager.selectCrew(lblCrewName1.getText());
					crewPanel.setCrew(crew);
					System.out.println("크루 이동 : " + crew);
					convertPanel("crew");
				}
			}
		});
		btnCrewPage1.setBounds(0, 0, 280, 55);
		panel.add(btnCrewPage1);
		btnCrewPage1.setHorizontalAlignment(SwingConstants.LEFT);

		JPanel crewItemPanel2 = new JPanel();
		crewItemPanel2.setLayout(null);
		crewListPanel.add(crewItemPanel2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 280, 55);
		crewItemPanel2.add(panel_1);

		lblCrewName2 = new JLabel("크루명");
		lblCrewName2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName2.setBounds(60, 10, 80, 30);
		panel_1.add(lblCrewName2);

		lblCrewCount2 = new JLabel("0 명");
		lblCrewCount2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount2.setBounds(180, 10, 70, 30);
		panel_1.add(lblCrewCount2);

		btnCrewPage2 = new JButton("");
		btnCrewPage2.setContentAreaFilled(false);
		btnCrewPage2.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrewPage2.setBounds(0, 0, 280, 55);
		btnCrewPage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblCrewName2.equals("크루명")) {// 크루가 리스트에 출력되어 있는 경우
					Crew crew = controllerManager.selectCrew(lblCrewName2.getText());
					crewPanel.setCrew(crew);
					System.out.println("크루 이동 : " + crew);
					convertPanel("crew");
				}
			}
		});
		panel_1.add(btnCrewPage2);

		JPanel crewItemPanel3 = new JPanel();
		crewItemPanel3.setLayout(null);
		crewListPanel.add(crewItemPanel3);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 280, 55);
		crewItemPanel3.add(panel_2);

		lblCrewName3 = new JLabel("크루명");
		lblCrewName3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName3.setBounds(60, 10, 80, 30);
		panel_2.add(lblCrewName3);

		lblCrewCount3 = new JLabel("0 명");
		lblCrewCount3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount3.setBounds(180, 10, 70, 30);
		panel_2.add(lblCrewCount3);

		btnCrewPage3 = new JButton("");
		btnCrewPage3.setContentAreaFilled(false);
		btnCrewPage3.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrewPage3.setBounds(0, 0, 280, 55);
		btnCrewPage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblCrewName3.equals("크루명")) {// 크루가 리스트에 출력되어 있는 경우
					Crew crew = controllerManager.selectCrew(lblCrewName3.getText());
					crewPanel.setCrew(crew);
					System.out.println("크루 이동 : " + crew);
					convertPanel("crew");
				}
			}
		});
		panel_2.add(btnCrewPage3);

		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 561, 360, 29);
		mainPanel.add(footerPanel);

		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				convertPanel("main");
				updateCrewJoinState();
			}
		});
		footerPanel.add(lblHome);

		JPanel radioBtnPanel = new JPanel();
		radioBtnPanel.setBackground(Color.WHITE);
		radioBtnPanel.setBounds(215, 220, 120, 30);
		mainPanel.add(radioBtnPanel);
		radioBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JRadioButton rdbtnCrew1 = new JRadioButton("");
		rdbtnCrew1.setBackground(Color.WHITE);
		radioBtnPanel.add(rdbtnCrew1);

		JRadioButton rdbtnCrew2 = new JRadioButton("");
		rdbtnCrew2.setBackground(Color.WHITE);
		radioBtnPanel.add(rdbtnCrew2);

		JRadioButton rdbtnCrew3 = new JRadioButton("");
		rdbtnCrew3.setBackground(Color.WHITE);
		radioBtnPanel.add(rdbtnCrew3);

		JRadioButton rdbtnCrew4 = new JRadioButton("");
		rdbtnCrew4.setBackground(Color.WHITE);
		radioBtnPanel.add(rdbtnCrew4);

		buttonGroup.add(rdbtnCrew1);
		buttonGroup.add(rdbtnCrew2);
		buttonGroup.add(rdbtnCrew3);
		buttonGroup.add(rdbtnCrew4);

		rdbtnCrew3.setSelected(true);

		btnCrewCreateCancel = new JButton("만들기 해제");
		btnCrewCreateCancel.setVisible(false);
		btnCrewCreateCancel.setContentAreaFilled(false);
		btnCrewCreateCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerManager.removeCrew(user.getCrewName());
				user.setCrewName(null); // 다시 미가입 상태로 변경

				updateCrewJoinState();
			}
		});
		btnCrewCreateCancel.setBounds(215, 37, 120, 23);
		mainPanel.add(btnCrewCreateCancel);

	}

	public User getUser() {
		return user;
	}

	public CrewPanel getCrewPanel() {
		return crewPanel;
	}

	public CrewRankPanel getRankPanel() {
		return rankPanel;
	}
	
	public static void test() {
		User user = new User("김태훈", 20, 100, 100, '남', false); // 크루 미가입 유저
//		User user = new User("문대훈", 20, 100, 50, '남', false); // 크루 가입한 유저 (크루장)
//		User user = new User("최용석", 20, 100, 50, '남', false); // 크루 가입한 유저

		// 테스트 용
		CrewViewManager crewViewManager = new CrewViewManager(user);

		JFrame frame = new JFrame();

		frame.setBounds(0, 0, 376, 639);
		frame.getContentPane().setLayout(null);
		crewViewManager.addPanels(frame);
//				frame.pack(); // 이거 안먹힘
		crewViewManager.convertPanel("main");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		test();
	}
}
