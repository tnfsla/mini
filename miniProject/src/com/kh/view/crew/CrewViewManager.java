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

public class CrewViewManager {

	private JPanel mainPanel; // 메인 - 시작 page
	private CrewCreatePanel createPanel; // 크루 만들기 page
	private CrewPanel crewPanel; // 특정 크루 page
	private CrewRankPanel rankPanel; // 특정 크루 랭킹 page

	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

	private CrewControllerManager controllerManager; // 메인 controller

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

			frame.add(panel);
		}
	}

	private void initialize() {

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 360, 600);
		mainPanel.setLayout(null);

		JButton btnNewButton = new JButton("크루 만들기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("create"); // 크루 만들기 page로
			}
		});
		btnNewButton.setBounds(79, 31, 182, 87);
		mainPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("특정 크루");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("crew"); // 특정 크루 page로
			}
		});
		btnNewButton_1.setBounds(39, 272, 262, 100);
		mainPanel.add(btnNewButton_1);
	}

	public void test() {
		// 테스트 용
		CrewViewManager crewViewManager = new CrewViewManager();

		JFrame frame = new JFrame();

		frame.setBounds(100, 100, 360, 600);
		frame.setLayout(null);
		crewViewManager.addPanels(frame);
//				frame.pack(); // 이거 안먹힘
		crewViewManager.convertPanel("main");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewViewManager window = new CrewViewManager();
					window.mainPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		test();
	}
}
