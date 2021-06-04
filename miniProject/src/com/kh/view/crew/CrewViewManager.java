package com.kh.view.crew;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewControllerManager;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrewViewManager {

	private JPanel mainPanel; // 메인 - 시작 page
	private CrewCreatePanel createPanel; // 크루 만들기 page
	private CrewPanel crewPanel; // 특정 크루 page
	private CrewRankPanel rankPanel; // 특정 크루 랭킹 page

	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

	private CrewControllerManager controllerManager; // 메인 controller
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public CrewViewManager() {
		initialize();
		initPanel();
	}

	// 패널 객체 생성 및 컨트롤러 이어주기
	private void initPanel() {
		controllerManager = new CrewControllerManager();

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

	private void initialize() {

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 360, 600);
		mainPanel.setLayout(null);

		JButton btnCreatePage = new JButton("크루 만들기");
		btnCreatePage.setContentAreaFilled(false);
		btnCreatePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JLabel lblCrewName = new JLabel("KH");
		lblCrewName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName.setBounds(60, 10, 80, 30);
		panel.add(lblCrewName);
		
		JLabel lblCrewCount1 = new JLabel("100 명");
		lblCrewCount1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount1.setBounds(180, 10, 70, 30);
		panel.add(lblCrewCount1);
		
		
		JButton btnCrewPage1 = new JButton("");
		btnCrewPage1.setContentAreaFilled(false);
		btnCrewPage1.addMouseListener(new MouseAdapter() {
		});
		btnCrewPage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("crew");
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
		
		JLabel lblCrewName2 = new JLabel("크루명");
		lblCrewName2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName2.setBounds(60, 10, 80, 30);
		panel_1.add(lblCrewName2);
		
		JLabel lblCrewCount2 = new JLabel("15 명");
		lblCrewCount2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount2.setBounds(180, 10, 70, 30);
		panel_1.add(lblCrewCount2);
		
		JButton btnCrewPage2 = new JButton("");
		btnCrewPage2.setContentAreaFilled(false);
		btnCrewPage2.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrewPage2.setBounds(0, 0, 280, 55);
		panel_1.add(btnCrewPage2);
		
		JPanel crewItemPanel3 = new JPanel();
		crewItemPanel3.setLayout(null);
		crewListPanel.add(crewItemPanel3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 280, 55);
		crewItemPanel3.add(panel_2);
		
		JLabel lblCrewName3 = new JLabel("크루명");
		lblCrewName3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewName3.setBounds(60, 10, 80, 30);
		panel_2.add(lblCrewName3);
		
		JLabel lblCrewCount3 = new JLabel("6021 명");
		lblCrewCount3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount3.setBounds(180, 10, 70, 30);
		panel_2.add(lblCrewCount3);
		
		JButton btnCrewPage3 = new JButton("");
		btnCrewPage3.setContentAreaFilled(false);
		btnCrewPage3.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrewPage3.setBounds(0, 0, 280, 55);
		panel_2.add(btnCrewPage3);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 561, 360, 29);
		mainPanel.add(footerPanel);
		
		JLabel lblHome = new JLabel("Home");
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

	}

	public static void test() {
		// 테스트 용
		CrewViewManager crewViewManager = new CrewViewManager();

		JFrame frame = new JFrame();

		frame.setBounds(100, 100, 360, 630);
		frame.getContentPane().setLayout(null);
		crewViewManager.addPanels(frame);
//				frame.pack(); // 이거 안먹힘
		crewViewManager.convertPanel("main");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CrewViewManager window = new CrewViewManager();
//					window.mainPanel.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		test();
	}
}
