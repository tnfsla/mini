package com.kh.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kh.controller.CrewControllerManager;

public class CrewViewManager {

	private JFrame mainFrame; // 메인 - 시작 page
	private CrewCreateFrame createFrame; // 크루 만들기 page
	private CrewFrame crewFrame; // 특정 크루 page
	private CrewRankFrame rankFrame; // 특정 크루 랭킹 page

	private Map<String, JFrame> frameMap; // 프레임 전환을 위하여 map 사용
	
	private CrewControllerManager controllerManager; // 메인 controller

	public CrewViewManager() {
		initialize();
		initFrame();
	}

	// 프레임 객체 생성 및 컨트롤러 이어주기
	private void initFrame() {
		controllerManager = new CrewControllerManager();
		
		createFrame = new CrewCreateFrame(this, controllerManager.getCrewCreateController());
		crewFrame = new CrewFrame(this, controllerManager.getCrewController());
		rankFrame = new CrewRankFrame(this, controllerManager.getCrewController().getCrewRankController());
		
		frameMap = new LinkedHashMap<String, JFrame>(); 
		// frameMap에 crew에서 쓰이는 frame들 다 넣어둠
		frameMap.put("main", mainFrame);
		frameMap.put("create", createFrame);
		frameMap.put("crew", crewFrame);
		frameMap.put("rank", rankFrame);
	}

	// 프레임 전환 메소드
	// frameMap에서 해당 frame을 찾아 setVisible true 후 나머지는 다 false로 변경
	public void convertFrame(String frameName) {
		
		// 모든 frame setVisible false로 하기
		for (String key : frameMap.keySet()) {
			frameMap.get(key).setVisible(false);
		}
		
		frameMap.get(frameName).setVisible(true);
	}

	private void initialize() {

		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 360, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("크루 만들기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertFrame("create"); // 크루 만들기 page로
			}
		});
		btnNewButton.setBounds(79, 31, 182, 87);
		mainFrame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("특정 크루");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertFrame("crew"); // 특정 크루 page로
			}
		});
		btnNewButton_1.setBounds(39, 272, 262, 100);
		mainFrame.getContentPane().add(btnNewButton_1);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewViewManager window = new CrewViewManager();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
