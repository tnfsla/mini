package com.kh.view.main;

import java.awt.EventQueue;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.model.vo.User;
import com.kh.view.admin.AdminViewManager;
import com.kh.view.crew.CrewViewManager;
import com.kh.view.exercise.RecordMainPanel;
import com.kh.view.login.LoginMainView;
import com.kh.view.result.ResultMainView;
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
	private PasswordChangeView pwdChangeView; // Update Part 시작 Panel
	private long sTimeI;
	private int eventGoal;
	private String eventFlag;
	

	// Panel 전환을 위한 Map
	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용

	/////////////////////////////////////
	User user = null; // 로그인시 접속하게 되는 사용자, 로그인이 되기 전까진 null 상태
	// 로그인 후 User 객체를 넣게 됨

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

	/**
	 * Create the application.
	 */
	public Main() {
		panelMap = new LinkedHashMap<String, JPanel>();

		initialize();
		initPanel();
	}

	// 각 파트별 Panel 객체 생성 후 panelMap의 추가
	public void initPanel() {

		loginView = new LoginMainView(this, user); // 매개변수로 들어간 user가 추후에 객체가 생성되게 됨
		
		addPanels(frame);
		
		convertPanel("main");
	}

	// 바로 new로 객체 생성하지 않고 로그인에서 user 객체가 생성이 되면 호출
	public void lazeInitPanel(User user) {


		adminManager = new AdminViewManager(this, user); // loginView에서
		mainPanel = new MainPanel(this);
		recordMain = new RecordMainPanel(this, user); // 추후 user가 들어가야함
		resultView = new ResultMainView(this, user);
		crewManager = new CrewViewManager(this, user);
		pwdChangeView = new PasswordChangeView(this, user);

		panelMap.put("main", mainPanel);
		panelMap.put("admin", adminManager.getMainPanel());
		panelMap.put("record", recordMain);
		panelMap.put("result", resultView);
		panelMap.put("crew", crewManager.getMainPanel());
		panelMap.put("update", pwdChangeView);
		
		sTimeI = adminManager.getEventSetting().getsTimeI();
		System.out.println("sTimeI : "+sTimeI);

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


	
}