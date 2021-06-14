package com.kh.view.crew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kh.controller.crew.CrewController;
import com.kh.model.vo.Crew;

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

	private JLabel lblCrewFeedCount;

	private JButton btnJoinCrew;

	private JPanel panelJoinCrew;

	private JPanel panelNotJoinCrewInfo;

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
		lblCrewFeedCount.setText(String.valueOf(crew.getFeedCount()));

		lblCrewNum.setText(crewController.getCrewNum(crew));
		lblCrewDistance.setText(crewController.getCrewDistance(crew));
		lblCrewTime.setText(crewController.getCrewTime(crew));
	}

	public void setIsJoinCrew(boolean isJoinCrew) {
		this.isJoinCrew = isJoinCrew;
	}

	// panel 초기 설정 crewManager, crewController 설정 후에 호출해야해서 initialize 메소드로 따로 뺌
	private void initialize() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JPanel panelCrewNameContent = new JPanel();
		panelCrewNameContent.setBounds(12, 30, 336, 180);
		add(panelCrewNameContent);
		panelCrewNameContent.setLayout(null);

		JPanel panelCrewName = new JPanel();
		panelCrewName.setBackground(CrewViewManager.COLOR_MINT);
		panelCrewName.setBounds(0, 0, 336, 68);
		panelCrewNameContent.add(panelCrewName);
		panelCrewName.setLayout(null);

		lblCrewName = new JLabel("크루명");
		lblCrewName.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 20));
		lblCrewName.setBounds(35, 10, 140, 45);
		panelCrewName.add(lblCrewName);

		panelJoinCrew = new JPanel();
		panelJoinCrew.setBounds(230, 15, 80, 30);
		panelJoinCrew.setBackground(CrewViewManager.COLOR_MINT);
		panelCrewName.add(panelJoinCrew);
		panelJoinCrew.setLayout(null);

		btnJoinCrew = new JButton("");
		btnJoinCrew.setBounds(0, 0, 80, 30);
		btnJoinCrew.setContentAreaFilled(false);
		btnJoinCrew.setBorderPainted(false);
		btnJoinCrew.setFocusPainted(false);
		panelJoinCrew.add(btnJoinCrew);
		btnJoinCrew.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_crew_join.png", panelJoinCrew.getSize());
		panelJoinCrew.add(crewImagePanel); // 이미지 추가
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
							crewManager.updateCrewJoinState(true);

							crewManager.getControllerManager().getCrewDao().saveCrewList(); // 해당 크루 정보 저장
							crewManager.getMain().getLoginView().getLoginController().getUserDao().saveUserList(); // 변경된
																													// 유저
																													// 정보
																													// 저장
						}

						btnJoinCrew.setVisible(!isJoinCrew); // 크루 가입 상태에 따라 가입하기 버튼 보이기 처리 isJoinCrew false면 보여주기
						textAreaNotJoinCrewInfo.setVisible(!isJoinCrew); // 가입 상태에 따라 해당 텍스트 보일지 말지 정하기
					}
				});

//				System.out.println("test");
			}
		});

		textAreaCrewContent = new JTextArea();
		textAreaCrewContent.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 13));
		textAreaCrewContent.setText("크루 내용");
		textAreaCrewContent.setEditable(false);
		textAreaCrewContent.setBounds(10, 80, 315, 85);
		panelCrewNameContent.add(textAreaCrewContent);

		JPanel panelCrewInfo = new JPanel();
		panelCrewInfo.setBackground(CrewViewManager.COLOR_MINT);
		panelCrewInfo.setBounds(12, 240, 336, 155);
		add(panelCrewInfo);
		panelCrewInfo.setLayout(null);

		JPanel panelCrewUserInfo = new JPanel();
		panelCrewUserInfo.setBackground(CrewViewManager.COLOR_MINT);
		panelCrewUserInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 크루 가입 상태일때만 랭킹 페이지로 이동
				if (crewManager.getUser().getCrewName() != null
						&& crewManager.getUser().getCrewName().equals(crew.getCrewName())) {
					crewManager.getRankPanel().setRank(crew);
					crewManager.convertPanel("crew_rank");
					System.out.println("랭킹 이동");
				} else {
					System.out.println("크루 가입이 필요합니다 크루에 가입하세요");
				}
			}
		});
		panelCrewUserInfo.setBounds(12, 10, 150, 135);
		panelCrewInfo.add(panelCrewUserInfo);
		panelCrewUserInfo.setLayout(null);

		JLabel lblCrewUserInfo = new JLabel("크루원");
		lblCrewUserInfo.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		lblCrewUserInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewUserInfo.setBounds(45, 15, 60, 15);
		panelCrewUserInfo.add(lblCrewUserInfo);

		JPanel panelCrewUserCount = new JPanel();
		panelCrewUserCount.setBackground(Color.WHITE);
		panelCrewUserCount.setBounds(25, 42, 100, 72);
		panelCrewUserInfo.add(panelCrewUserCount);
		panelCrewUserCount.setLayout(new BorderLayout(0, 0));

		lblCrewUserCount = new JLabel("0");
		lblCrewUserCount.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 24));
		lblCrewUserCount.setHorizontalAlignment(SwingConstants.CENTER);
		panelCrewUserCount.add(lblCrewUserCount, BorderLayout.CENTER);

		JPanel panelCrewFeedrInfo = new JPanel();
		panelCrewFeedrInfo.setBackground(CrewViewManager.COLOR_MINT);
		panelCrewFeedrInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 크루 가입 상태일때만 피드 페이지로 이동
				if (crewManager.getUser().getCrewName() != null
						&& crewManager.getUser().getCrewName().equals(crew.getCrewName())) {
					crewManager.getFeedPanel().setFeed(crew);
					crewManager.convertPanel("crew_feed");
					System.out.println("피드 이동");
				} else {
					System.out.println("크루 가입이 필요합니다 크루에 가입하세요");
				}
			}
		});
		panelCrewFeedrInfo.setLayout(null);
		panelCrewFeedrInfo.setBounds(174, 10, 150, 135);
		panelCrewInfo.add(panelCrewFeedrInfo);

		JLabel lblCrewFeedInfo = new JLabel("피드");
		lblCrewFeedInfo.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		lblCrewFeedInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewFeedInfo.setBounds(45, 15, 60, 15);
		panelCrewFeedrInfo.add(lblCrewFeedInfo);

		JPanel panelCrewFeedCount = new JPanel();
		panelCrewFeedCount.setBackground(Color.WHITE);
		panelCrewFeedCount.setBounds(25, 42, 100, 72);
		panelCrewFeedrInfo.add(panelCrewFeedCount);
		panelCrewFeedCount.setLayout(new BorderLayout(0, 0));

		lblCrewFeedCount = new JLabel("0");
		lblCrewFeedCount.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 24));
		lblCrewFeedCount.setHorizontalAlignment(SwingConstants.CENTER);
		panelCrewFeedCount.add(lblCrewFeedCount, BorderLayout.CENTER);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(CrewViewManager.COLOR_MINT);
		tabbedPane.setBounds(22, 410, 315, 136);

		add(tabbedPane);

		JPanel panelShortInfo = new JPanel();
		panelShortInfo.setBackground(CrewViewManager.COLOR_MINT);
		tabbedPane.addTab("", new ImageIcon("./images/crew_crew_summary.png"), panelShortInfo, null);
		panelShortInfo.setLayout(null);

		panelNotJoinCrewInfo = new JPanel();
		panelNotJoinCrewInfo.setBackground(CrewViewManager.COLOR_MINT);
		panelNotJoinCrewInfo.setBounds(0, 0, 310, 107);
		panelShortInfo.add(panelNotJoinCrewInfo);
		panelNotJoinCrewInfo.setLayout(null);

		textAreaNotJoinCrewInfo = new JTextArea();
		textAreaNotJoinCrewInfo.setBounds(10, 10, 281, 87);
		panelNotJoinCrewInfo.add(textAreaNotJoinCrewInfo);
		textAreaNotJoinCrewInfo.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 13));
		textAreaNotJoinCrewInfo.setLineWrap(true);
		textAreaNotJoinCrewInfo.setText("크루원들의 활동 정보는 크루원에게만 공개됩니다.");
		textAreaNotJoinCrewInfo.setBackground(Color.WHITE);
		textAreaNotJoinCrewInfo.setEditable(false);

		JPanel panelCrewInfoDistance = new JPanel();
		panelCrewInfoDistance.setBackground(Color.WHITE);
		panelCrewInfoDistance.setBounds(115, 5, 85, 100);
		panelShortInfo.add(panelCrewInfoDistance);
		panelCrewInfoDistance.setLayout(null);

		lblCrewDistance = new JLabel("거리");
		lblCrewDistance.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		lblCrewDistance.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewDistance.setBounds(10, 60, 65, 15);
		panelCrewInfoDistance.add(lblCrewDistance);
		CrewImagePanel crewImagePanelCrewDistance = new CrewImagePanel("./images/crew_crew_distance.png",
				panelCrewInfoDistance.getSize());
		panelCrewInfoDistance.add(crewImagePanelCrewDistance);

		JPanel panelCrewInfoTime = new JPanel();
		panelCrewInfoTime.setBackground(Color.WHITE);
		panelCrewInfoTime.setBounds(215, 5, 85, 100);
		panelShortInfo.add(panelCrewInfoTime);
		panelCrewInfoTime.setLayout(null);

		lblCrewTime = new JLabel("시간");
		lblCrewTime.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		lblCrewTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewTime.setBounds(10, 60, 65, 15);
		panelCrewInfoTime.add(lblCrewTime);
		CrewImagePanel crewImagePanelCrewTime = new CrewImagePanel("./images/crew_crew_time.png",
				panelCrewInfoTime.getSize());
		panelCrewInfoTime.add(crewImagePanelCrewTime);

		JPanel panelCrewInfoCrewNum = new JPanel();
		panelCrewInfoCrewNum.setBackground(Color.WHITE);
		panelCrewInfoCrewNum.setBounds(10, 5, 85, 100);
		panelShortInfo.add(panelCrewInfoCrewNum);
		panelCrewInfoCrewNum.setLayout(null);

		lblCrewNum = new JLabel("인원");
		lblCrewNum.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblCrewNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewNum.setBounds(10, 60, 65, 15);
		panelCrewInfoCrewNum.add(lblCrewNum);
		CrewImagePanel crewImagePanelCrewNum = new CrewImagePanel("./images/crew_crew_userCount.png",
				panelCrewInfoCrewNum.getSize());
		panelCrewInfoCrewNum.add(crewImagePanelCrewNum);

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
				if (crewManager.getMain() != null)
					crewManager.getMain().convertPanel("main");
				else {
					crewManager.updateCrewJoinState(true);
				}
			}
		});
		btnHome.setPreferredSize(new Dimension(40, 30));
		footerPanel.add(btnHome);
		footerPanel.add(new CrewImagePanel("./images/home2.png", footerPanel.getSize())); // 이미지 추가
		add(footerPanel);
		footerPanel.setLayout(null);

	}

	public void updateJoinState() {
		isJoinCrew = crewManager.getUser().getCrewName() == null ? false : true; // user의 크루네임이 null이면 미가입이라 false 아니면
																					// true

		panelJoinCrew.setVisible(!isJoinCrew); // 가입 상태에 따라 버튼 보이기 상태 바꾸기

		panelNotJoinCrewInfo.setVisible(!isJoinCrew); // 가입 상태에 따라 해당 텍스트 보일지 말지 정하기
	}
	
	public Crew getCrew() {
		return crew;
	}
}
