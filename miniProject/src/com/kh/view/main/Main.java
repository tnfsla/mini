package com.kh.view.main;

import java.awt.EventQueue;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.controller.admin.AdminEventController;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;
import com.kh.view.admin.AdminViewManager;
import com.kh.view.crew.CrewViewManager;
import com.kh.view.exercise.RecordMainPanel;
import com.kh.view.login.LoginMainView;
import com.kh.view.result.ResultMainView;
import com.kh.view.update.EditViewManager;
import com.kh.view.update.PasswordChangeView;

public class Main {

	private JFrame frame;

	/////////////////////////////////////
	// 각 파트별 panel 정리

	private MainPanel mainPanel; // Main Panel

	private LoginMainView loginView; // Login Part 시작 Panel
	private AdminViewManager adminManager; // Admin Part 시작 Panel
	private RecordMainPanel recordMain; // Record Part 시작 Panel
	private ResultMainView resultView; // Result Part 시작 Panel
	private CrewViewManager crewManager; // Crew Part 시작 Panel
	private EditViewManager editView; // Update Part 시작 Panel
	private AdminEventController aec;
	private long sTimeI;
	private int eventGoal;
	private String eventFlag;

	// Panel 전환을 위한 Map
	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

	/////////////////////////////////////

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setBounds(0, 0, 376, 639);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void run() {
		frame.setBounds(0, 0, 376, 639);
		frame.setVisible(true);
	}

	public Main() {
		panelMap = new LinkedHashMap<String, JPanel>();

		initialize();
		initPanel();
	}

	// 각 파트별 Panel 객체 생성 후 panelMap의 추가
	public void initPanel() {
		aec = new AdminEventController();
		loginView = new LoginMainView(this,aec);
		adminManager = new AdminViewManager(this,aec); // loginView에서
		mainPanel = new MainPanel(this,aec);

		recordMain = new RecordMainPanel(this); // 추후 user가 들어가야함
		resultView = new ResultMainView(this);
		crewManager = new CrewViewManager(this);
		editView = new EditViewManager(this);

		panelMap.put("main", mainPanel);
		panelMap.put("admin", adminManager.getMainPanel());
		panelMap.put("record", recordMain);
		panelMap.put("result", resultView);
		panelMap.put("crew", crewManager.getMainPanel());
		panelMap.put("update", editView.getEditMain());

		sTimeI = adminManager.getEventSetting().getsTimeI();
//		System.out.println("sTimeI : " + sTimeI);

		addPanels(frame);

		// test
//		loginView.loginUser();
//		convertPanel("main");

		convertPanel("login");
	}

	// 로그인된 user 객체 각 파트에 update
	public void updateUser(User user) {
		// main도 user 안써서 미진행
		// admin은 안써서 미진행
		mainPanel.setUser(user);
		recordMain.setUser(user);
		resultView.setUser(user);
		crewManager.setUser(user);
		editView.setUser(user);
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 360, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}

	public Map<String, JPanel> getPanelMap() {
		return panelMap;
	}

	public long getsTimeI() {
		return adminManager.getEventSetting().getsTimeI();
	}

	public void setsTimeI(long sTimeI) {
		this.sTimeI = sTimeI;
	}

	public int getEventGoal() {
		return adminManager.getEventSetting().getEventGoal();
	}

	public void setEventGoal(int eventGoal) {
		this.eventGoal = eventGoal;
	}

	public String getEventFlag() {
		return adminManager.getEventSetting().getEventFlag();
	}

	public void setEventFlag(String eventFlag) {
		this.eventFlag = eventFlag;
	}

	public LoginMainView getLoginView() {
		return loginView;
	}
	
	public CrewViewManager getCrewManager() {
		return crewManager;
	}
}