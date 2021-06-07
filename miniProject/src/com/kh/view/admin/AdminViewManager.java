package com.kh.view.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminViewManager {

	private JPanel mainPanel; // 메인 - 시작 page
	private CrewListP crewList; //  크루 리스트 page
	private EventSettingP eventSetting; // 이벤트 설정 page
	private PendingApprovalP pendingApproval; // 크루 승인대기 page
	private EventEndAlertD eventAlert; //이벤트 마감 알림 page

	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

//	private CrewControllerManager controllerManager; // 메인 controller

	public AdminViewManager() {
		initialize();
		initPanel();
	}

	// 패널 객체 생성 및 컨트롤러 이어주기
	private void initPanel() {
//		controllerManager = new CrewControllerManager();
//
//		createPanel = new CrewCreatePanel(this, controllerManager.getCrewCreateController());
//		crewPanel = new CrewPanel(this, controllerManager.getCrewController());
//		rankPanel = new CrewRankPanel(this, controllerManager.getCrewController().getCrewRankController());
		crewList = new CrewListP(this);
		eventSetting = new EventSettingP(this);
		pendingApproval = new PendingApprovalP(this);
		eventAlert = new EventEndAlertD();
		
		panelMap = new LinkedHashMap<String, JPanel>();
		// frameMap에 crew에서 쓰이는 패널들 다 넣어둠
		panelMap.put("main", mainPanel);
		panelMap.put("list", crewList);
		panelMap.put("eventSetting",eventSetting);
		panelMap.put("pendingApproval", pendingApproval);
//		panelMap.put("eventAlert", eventAlert); //패널이 아니어서 못넣음 새로운 방법 강구 프레임으로 쓰던지
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
		mainPanel.setBounds(0, 0, 360, 600);
		mainPanel.setLayout(null);

		JButton btnNewButton = new JButton("EVENT 설정");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnNewButton.setBounds(27, 83, 286, 96);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("eventSetting"); 
			}
		});
		mainPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EVENT 마감");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnNewButton_1.setBounds(27, 189, 286, 96);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("evnetAlert"); 
			}
		}); //알럿은 알림이기때문에 아직 구현 안됨. 수정요망
		mainPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("크루 승인 관리");
		btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(27, 295, 286, 96);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("pendingApproval"); // 크루 만들기 page로
			}
		});
		mainPanel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("전체 크루 명단");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertPanel("list");
			}
		});
		btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnNewButton_1_1_1.setBounds(27, 401, 286, 96);
		mainPanel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_2 = new JButton("종료");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});//이전 로그인화면 아니면 종료로 구현
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_2.setBounds(216, 512, 97, 23);
		mainPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("관리자 메뉴");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(104, 16, 128, 57);
		mainPanel.add(lblNewLabel);
	}

	public static void test() {
		// 테스트 용

		JFrame frame = new JFrame();
		AdminViewManager avm = new AdminViewManager();
		frame.setBounds(100, 100, 360, 600);
		frame.setLayout(null);
		avm.addPanels(frame);
		avm.convertPanel("main");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminViewManager avm = new AdminViewManager();
//					avm.mainPanel.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		test();
	}
}
