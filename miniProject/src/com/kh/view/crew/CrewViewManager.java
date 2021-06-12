package com.kh.view.crew;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import com.kh.view.main.Main;
import java.awt.Font;

public class CrewViewManager {

	private Main main;

	private User user; // 현재 접속 중인 사용자

	private JPanel mainPanel; // 메인 - 시작 page
	private CrewCreatePanel createPanel; // 크루 만들기 page
	private CrewPanel crewPanel; // 특정 크루 page
	private CrewRankPanel rankPanel; // 특정 크루 랭킹 page
	private CrewFeedPanel feedPanel; // 특정 크루 피드 page
	private CrewFeedCreatePanel feedCreatePanel; // 특정 크루 피드 작성 page
	private CrewFeedSelectPanel feedSelectPanel; // 특정 크루 특정 피드 선택 page

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

	private JPanel panelCrewCreateCancel;

	public CrewViewManager(User user) {
		this.user = user;

		initialize();
		initPanel();

		controllerManager.loadCrewList(); // 저장된 크루 정보 읽어오기
		setPanel();

		updateCrewJoinState(false); // 크루 가입 상태에 따라 처리하는 메소드
	}

	public CrewViewManager(Main main) {
		this.main = main;

		initialize();
		initPanel();

		controllerManager.loadCrewList(); // 저장된 크루 정보 읽어오기
		setPanel();
	}

	public void setUser(User user) {
		this.user = user;
		controllerManager.getCrewDao().updateUser(user);
		updateCrewJoinState(false); // 크루 가입 상태에 따라 처리하는 메소드
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
		controllerManager = new CrewControllerManager();

		createPanel = new CrewCreatePanel(this, controllerManager.getCrewCreateController());
		crewPanel = new CrewPanel(this, controllerManager.getCrewController());
		rankPanel = new CrewRankPanel(this, controllerManager.getCrewController().getCrewRankController());
		feedPanel = new CrewFeedPanel(this, controllerManager.getCrewController().getCrewFeedController());
		feedCreatePanel = new CrewFeedCreatePanel(this,
				controllerManager.getCrewController().getCrewFeedController().getCrewFeedCreateController());
		feedSelectPanel = new CrewFeedSelectPanel(this,
				controllerManager.getCrewController().getCrewFeedController().getCrewFeedSelectController());

		if (main == null)
			panelMap = new LinkedHashMap<String, JPanel>();
		else
			panelMap = main.getPanelMap();
		// frameMap에 crew에서 쓰이는 frame들 다 넣어둠
		panelMap.put("crew_main", mainPanel);
		panelMap.put("crew_create", createPanel);
		panelMap.put("crew_crew", crewPanel);
		panelMap.put("crew_rank", rankPanel);
		panelMap.put("crew_feed", feedPanel);
		panelMap.put("crew_feed_create", feedCreatePanel);
		panelMap.put("crew_feed_select", feedSelectPanel);
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
	public void updateCrewJoinState(boolean isCrewMainPanel) {
		// 크루 미가입 상태
		if (user == null || user.getCrewName() == null) {
			System.out.println("현재 유저 크루 미가입 상태");

			panelCrewCreateCancel.setVisible(false);

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

			panelCrewCreateCancel.setVisible(true);

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

		if (isCrewMainPanel) {
			System.out.println("특정 크루로 이동");
			convertPanel("crew_crew");
			crewPanel.updateJoinState();
		}
	}

	private void initialize() {

		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 360, 600);
		mainPanel.setLayout(null);

		JPanel panelCreatePage = new JPanel();
		panelCreatePage.setBounds(25, 60, 310, 100);
		mainPanel.add(panelCreatePage);
		panelCreatePage.setBackground(new Color(215, 255, 241));
		panelCreatePage.setLayout(null);

		btnCreatePage = new JButton("크루 만들기");
		btnCreatePage.setBounds(0, 0, 310, 100);
		panelCreatePage.add(btnCreatePage);
		btnCreatePage.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		btnCreatePage.setContentAreaFilled(false);
		btnCreatePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createPanel.initPanel();
				convertPanel("crew_create"); // 크루 만들기 page로
			}
		});

		JLabel lblCrewLabel = new JLabel("-心BOX 크루 추천");
		lblCrewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCrewLabel.setBounds(30, 200, 150, 50);
		mainPanel.add(lblCrewLabel);

		JPanel crewListPanel = new JPanel();
		crewListPanel.setBackground(new Color(215, 255, 241));
		crewListPanel.setBorder(new EmptyBorder(30, 15, 30, 15));
		crewListPanel.setBounds(25, 270, 310, 270);
		mainPanel.add(crewListPanel);
		crewListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel crewItemPanel1 = new JPanel();
		crewItemPanel1.setBackground(new Color(215, 255, 241));
		crewListPanel.add(crewItemPanel1);
		crewItemPanel1.setLayout(null);

		JPanel panelCrew1 = new JPanel();
		panelCrew1.setBackground(Color.WHITE);
		panelCrew1.setBounds(0, 0, 280, 55);
		crewItemPanel1.add(panelCrew1);
		panelCrew1.setLayout(null);

		lblCrewName1 = new JLabel("크루명");
		lblCrewName1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblCrewName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName1.setBounds(60, 10, 80, 30);
		panelCrew1.add(lblCrewName1);

		lblCrewCount1 = new JLabel("0 명");
		lblCrewCount1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblCrewCount1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount1.setBounds(180, 10, 70, 30);
		panelCrew1.add(lblCrewCount1);

		btnCrewPage1 = new JButton("");
		btnCrewPage1.setContentAreaFilled(false);
		btnCrewPage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblCrewName1.getText().equals("크루명")) {// 크루가 리스트에 출력되어 있는 경우
					Crew crew = controllerManager.selectCrew(lblCrewName1.getText());
					crewPanel.setCrew(crew);
					System.out.println("크루 이동 : " + crew);
					crewPanel.updateJoinState();
					convertPanel("crew_crew");
				} else {
					System.out.println("해당 페이지는 크루가 아직 존재하지 않습니다.");
				}
			}
		});
		btnCrewPage1.setBounds(0, 0, 280, 55);
		panelCrew1.add(btnCrewPage1);
		btnCrewPage1.setHorizontalAlignment(SwingConstants.LEFT);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_crew.png", panelCrew1.getSize());
		panelCrew1.add(crewImagePanel); // 이미지 추가

		JPanel crewItemPanel2 = new JPanel();
		crewItemPanel2.setBackground(new Color(215, 255, 241));
		crewItemPanel2.setLayout(null);
		crewListPanel.add(crewItemPanel2);

		JPanel panelCrew2 = new JPanel();
		panelCrew2.setBackground(Color.WHITE);
		panelCrew2.setLayout(null);
		panelCrew2.setBounds(0, 0, 280, 55);
		crewItemPanel2.add(panelCrew2);

		lblCrewName2 = new JLabel("크루명");
		lblCrewName2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblCrewName2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName2.setBounds(60, 10, 80, 30);
		panelCrew2.add(lblCrewName2);

		lblCrewCount2 = new JLabel("0 명");
		lblCrewCount2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblCrewCount2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount2.setBounds(180, 10, 70, 30);
		panelCrew2.add(lblCrewCount2);

		btnCrewPage2 = new JButton("");
		btnCrewPage2.setContentAreaFilled(false);
		btnCrewPage2.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrewPage2.setBounds(0, 0, 280, 55);
		btnCrewPage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblCrewName2.getText().equals("크루명")) {// 크루가 리스트에 출력되어 있는 경우
					Crew crew = controllerManager.selectCrew(lblCrewName2.getText());
					crewPanel.setCrew(crew);
					System.out.println("크루 이동 : " + crew);
					crewPanel.updateJoinState();
					convertPanel("crew_crew");
				} else {
					System.out.println("해당 페이지는 크루가 아직 존재하지 않습니다.");
				}
			}
		});
		panelCrew2.add(btnCrewPage2);
		CrewImagePanel crewImagePanel2 = new CrewImagePanel("./images/crew_crew.png", panelCrew2.getSize());
		panelCrew2.add(crewImagePanel2); // 이미지 추가

		JPanel crewItemPanel3 = new JPanel();
		crewItemPanel3.setBackground(new Color(215, 255, 241));
		crewItemPanel3.setLayout(null);
		crewListPanel.add(crewItemPanel3);

		JPanel panelCrew3 = new JPanel();
		panelCrew3.setBackground(Color.WHITE);
		panelCrew3.setLayout(null);
		panelCrew3.setBounds(0, 0, 280, 55);
		crewItemPanel3.add(panelCrew3);

		lblCrewName3 = new JLabel("크루명");
		lblCrewName3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblCrewName3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName3.setBounds(60, 10, 80, 30);
		panelCrew3.add(lblCrewName3);

		lblCrewCount3 = new JLabel("0 명");
		lblCrewCount3.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblCrewCount3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount3.setBounds(180, 10, 70, 30);
		panelCrew3.add(lblCrewCount3);

		btnCrewPage3 = new JButton("");
		btnCrewPage3.setContentAreaFilled(false);
		btnCrewPage3.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrewPage3.setBounds(0, 0, 280, 55);
		btnCrewPage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblCrewName3.getText().equals("크루명")) {// 크루가 리스트에 출력되어 있는 경우
					Crew crew = controllerManager.selectCrew(lblCrewName3.getText());
					crewPanel.setCrew(crew);
					System.out.println("크루 이동 : " + crew);
					crewPanel.updateJoinState();
					convertPanel("crew_crew");
				} else {
					System.out.println("해당 페이지는 크루가 아직 존재하지 않습니다.");
				}
			}
		});
		panelCrew3.add(btnCrewPage3);
		CrewImagePanel crewImagePanel3 = new CrewImagePanel("./images/crew_crew.png", panelCrew3.getSize());
		panelCrew3.add(crewImagePanel3); // 이미지 추가

		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.WHITE);
		footerPanel.setBounds(0, 560, 360, 20);

		JButton btnHome = new JButton("");
		btnHome.setBounds(170, 0, 20, 20);
		btnHome.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnHome.setBorderPainted(false); // 외곽선 제거
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("메인 페이지로 이동");
				if (main != null)
					main.convertPanel("main");
				else
					convertPanel("crew_main");
				updateCrewJoinState(true);
			}
		});
		btnHome.setPreferredSize(new Dimension(40, 30));
		footerPanel.add(btnHome);
		footerPanel.add(new CrewImagePanel("./images/home2.png", footerPanel.getSize())); // 이미지 추가
		mainPanel.add(footerPanel);
		footerPanel.setLayout(null);

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

		panelCrewCreateCancel = new JPanel();
		panelCrewCreateCancel.setBounds(215, 37, 120, 23);
		panelCrewCreateCancel.setVisible(false);
		panelCrewCreateCancel.setBackground(new Color(215, 255, 241));
		mainPanel.add(panelCrewCreateCancel);
		panelCrewCreateCancel.setLayout(null);

		btnCrewCreateCancel = new JButton("만들기 취소");
		btnCrewCreateCancel.setBounds(0, 0, 120, 23);
		panelCrewCreateCancel.add(btnCrewCreateCancel);
		btnCrewCreateCancel.setFont(new Font("굴림", Font.BOLD, 12));
		btnCrewCreateCancel.setContentAreaFilled(false);
		btnCrewCreateCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerManager.removeCrew(user.getCrewName());
				user.setCrewName(null); // 다시 미가입 상태로 변경

				updateCrewJoinState(true);

				controllerManager.getCrewDao().saveCrewList(); // 해당 크루 정보 저장
				main.getLoginView().getLoginController().getUserDao().saveUserList(); // 변경된 유저 정보 저장
			}
		});

	}

	public User getUser() {
		return user;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public CrewPanel getCrewPanel() {
		return crewPanel;
	}

	public CrewRankPanel getRankPanel() {
		return rankPanel;
	}

	public CrewFeedPanel getFeedPanel() {
		return feedPanel;
	}

	public CrewFeedSelectPanel getFeedSelectPanel() {
		return feedSelectPanel;
	}

	public CrewControllerManager getControllerManager() {
		return controllerManager;
	}

	public Main getMain() {
		return main;

	}

	public static void test() {
		User user = new User("test", "1234", "김태훈", 20, 100, 100, '남', false); // 크루 미가입 유저
//		User user = new User("test", "1234", "문대훈", 20, 100, 50, '남', false); // 크루 가입한 유저 (크루장)
//		User user = new User("test", "1234", "최용석", 20, 100, 50, '남', false); // 크루 가입한 유저

		// 테스트 용
		CrewViewManager crewViewManager = new CrewViewManager(user);

		JFrame frame = new JFrame();

		frame.setBounds(0, 0, 376, 639);
		frame.getContentPane().setLayout(null);
		crewViewManager.addPanels(frame);
//				frame.pack(); // 이거 안먹힘
		crewViewManager.convertPanel("crew_main");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		test();
	}
}
