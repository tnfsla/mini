package com.kh.view.crew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.kh.controller.crew.CrewController;
import com.kh.model.vo.Crew;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class CrewPanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewController crewController;

	private boolean isJoinCrew; // 크루 가입하는지 확인용 boolean

	private Crew crew; // 현재 페이지의 크루, 크루 메인 페이지에서 특정 크루 선택시 해당 크루의 정보를 가져와서 여기 세팅

	private JTextArea textAreaNotJoinCrewInfo;

	private JLabel lblCrewName;

	private JTextArea textAreaCrewContent;

	private JLabel lblCrewUserCount;

	private JLabel lblCrewDistance;

	private JLabel lblCrewTime;

	private JLabel lblCrewNum;

	public CrewPanel(CrewViewManager crewManager, CrewController crewController) {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		this.crewManager = crewManager;
		this.crewController = crewController;
		initialize();
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
		
		lblCrewName.setText(crew.getCrewName());
		textAreaCrewContent.setText(crew.getCrewContents());
		lblCrewUserCount.setText(String.valueOf(crew.getCrewUserCount()));
		
		lblCrewNum.setText(crewController.getCrewNum(crew));
		lblCrewDistance.setText(crewController.getCrewDistance(crew));
		lblCrewTime.setText(crewController.getCrewTime(crew));
	}

	public void setIsJoinCrew(boolean isJoinCrew) {
		this.isJoinCrew = isJoinCrew;
	}

	// panel 초기 설정 crewManager, crewController 설정 후에 호출해야해서 initialize 메소드로 따로 뺌
	private void initialize() {
		isJoinCrew = crewManager.getUser().getCrewName() == null ? false : true; // user의 크루네임이 null이면 미가입이라 false 아니면
																					// true

		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JPanel panelCrewNameContent = new JPanel();
		panelCrewNameContent.setBounds(12, 30, 336, 147);
		add(panelCrewNameContent);
		panelCrewNameContent.setLayout(null);

		JPanel panelCrewName = new JPanel();
		panelCrewName.setBackground(Color.GRAY);
		panelCrewName.setBounds(0, 0, 336, 68);
		panelCrewNameContent.add(panelCrewName);
		panelCrewName.setLayout(null);

		lblCrewName = new JLabel("크루명");
		lblCrewName.setBounds(41, 10, 113, 33);
		panelCrewName.add(lblCrewName);

		JButton btnJoinCrew = new JButton("가입하기");
		btnJoinCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewJoinDialog dialog = new CrewJoinDialog(crewManager.getCrewPanel());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

				dialog.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// dialog dispose시 호출
//						System.out.println("dialog dispose test!");

						// dialog에서 ok button 클릭 시 isJoinCrew가 됨
						if (isJoinCrew == true) {
							// 크루 컨트롤러에서 가입 진행
							crewController.joinCrew(crew, crewManager.getUser());
							crewManager.updateCrewJoinState();
						}

						btnJoinCrew.setVisible(!isJoinCrew); // 크루 가입 상태에 따라 가입하기 버튼 보이기 처리 isJoinCrew false면 보여주기
						textAreaNotJoinCrewInfo.setVisible(!isJoinCrew); // 가입 상태에 따라 해당 텍스트 보일지 말지 정하기
					}
				});

//				System.out.println("test");
			}
		});
		btnJoinCrew.setBounds(227, 15, 97, 23);
		btnJoinCrew.setVisible(!isJoinCrew); // 가입 상태에 따라 버튼 보이기 상태 바꾸기
		panelCrewName.add(btnJoinCrew);

		textAreaCrewContent = new JTextArea();
		textAreaCrewContent.setText("크루 내용");
		textAreaCrewContent.setEditable(false);
		textAreaCrewContent.setBounds(10, 78, 314, 59);
		panelCrewNameContent.add(textAreaCrewContent);

		JPanel panelCrewInfo = new JPanel();
		panelCrewInfo.setBackground(Color.GRAY);
		panelCrewInfo.setBounds(12, 250, 336, 155);
		add(panelCrewInfo);
		panelCrewInfo.setLayout(null);

		JPanel panelCrewUserInfo = new JPanel();
		panelCrewUserInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crewManager.convertPanel("rank");
			}
		});
		panelCrewUserInfo.setBounds(94, 10, 155, 135);
		panelCrewInfo.add(panelCrewUserInfo);
		panelCrewUserInfo.setLayout(null);

		JLabel lblCrewUserInfo = new JLabel("크루원");
		lblCrewUserInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewUserInfo.setBounds(49, 10, 57, 15);
		panelCrewUserInfo.add(lblCrewUserInfo);

		JPanel panelCrewUserCount = new JPanel();
		panelCrewUserCount.setBounds(26, 42, 103, 72);
		panelCrewUserInfo.add(panelCrewUserCount);
		panelCrewUserCount.setLayout(new BorderLayout(0, 0));

		lblCrewUserCount = new JLabel("0");
		lblCrewUserCount.setHorizontalAlignment(SwingConstants.CENTER);
		panelCrewUserCount.add(lblCrewUserCount, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 415, 310, 136);

		add(tabbedPane);

		JPanel panelShortInfo = new JPanel();
		tabbedPane.addTab("요약", null, panelShortInfo, null);
		panelShortInfo.setLayout(null);
		
				textAreaNotJoinCrewInfo = new JTextArea();
				textAreaNotJoinCrewInfo.setLineWrap(true);
				textAreaNotJoinCrewInfo.setText("크루원들의 활동 정보는 크루원에게만 공개됩니다.");
				textAreaNotJoinCrewInfo.setBackground(Color.WHITE);
				textAreaNotJoinCrewInfo.setEditable(false);
				textAreaNotJoinCrewInfo.setBounds(12, 10, 281, 87);
				textAreaNotJoinCrewInfo.setVisible(!isJoinCrew); // 가입 상태에 따라 해당 텍스트 보일지 말지 정하기
				panelShortInfo.add(textAreaNotJoinCrewInfo);

		JPanel panelCrewInfoDistance = new JPanel();
		panelCrewInfoDistance.setBounds(108, 0, 96, 107);
		panelShortInfo.add(panelCrewInfoDistance);
		panelCrewInfoDistance.setLayout(null);

		lblCrewDistance = new JLabel("거리");
		lblCrewDistance.setBounds(12, 45, 57, 15);
		panelCrewInfoDistance.add(lblCrewDistance);

		JPanel panelCrewInfoTime = new JPanel();
		panelCrewInfoTime.setBounds(209, 0, 96, 107);
		panelShortInfo.add(panelCrewInfoTime);
		panelCrewInfoTime.setLayout(null);

		lblCrewTime = new JLabel("시간");
		lblCrewTime.setBounds(12, 44, 57, 15);
		panelCrewInfoTime.add(lblCrewTime);

		JPanel panelCrewInfoCrewNum = new JPanel();
		panelCrewInfoCrewNum.setBounds(0, 0, 96, 107);
		panelShortInfo.add(panelCrewInfoCrewNum);
		panelCrewInfoCrewNum.setLayout(null);

		lblCrewNum = new JLabel("인원");
		lblCrewNum.setBounds(12, 42, 57, 15);
		panelCrewInfoCrewNum.add(lblCrewNum);

		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 561, 360, 29);
		add(footerPanel);

		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				crewManager.convertPanel("main");
				crewManager.updateCrewJoinState();
			}
		});
		footerPanel.add(lblHome);

	}
	
}
