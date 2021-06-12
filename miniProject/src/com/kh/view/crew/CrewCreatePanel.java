package com.kh.view.crew;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kh.controller.crew.CrewCreateController;

public class CrewCreatePanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewCreateController createController;

	private JTextField textFieldCrewName; // 크루명이 입력되는 텍스트필드
	private JTextArea textAreaCrewContents; // 크루 소개가 입력되는 텍스트 에리어

	public CrewCreatePanel(CrewViewManager crewManager, CrewCreateController createController) {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		this.crewManager = crewManager;
		this.createController = createController;
		initialize();
	}

	// panel 초기 설정 crewManager, crewController 설정 후에 호출해야해서 initialize 메소드로 따로 뺌
	private void initialize() {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JPanel panelCreateCrew = new JPanel();
		panelCreateCrew.setBackground(Color.WHITE);
		panelCreateCrew.setBounds(270, 15, 75, 20);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_create_create.png", panelCreateCrew.getSize());
		panelCreateCrew.add(crewImagePanel);
		add(panelCreateCrew);
		panelCreateCrew.setLayout(null);

		JButton btnCreateCrew = new JButton("완료");
		btnCreateCrew.setContentAreaFilled(false);
		btnCreateCrew.setBounds(0, 0, 75, 20);
		panelCreateCrew.add(btnCreateCrew);
		btnCreateCrew.setForeground(Color.WHITE);
		btnCreateCrew.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		btnCreateCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createController.createCrew(textFieldCrewName.getText(), textAreaCrewContents.getText(),
						crewManager.getUser());
				crewManager.updateCrewJoinState(true); // 크루 가입 상태 업데이트
				crewManager.convertPanel("crew_main"); // main page로
				crewManager.getControllerManager().getCrewDao().saveCrewList(); // 해당 크루 정보 저장
				crewManager.getMain().getLoginView().getLoginController().getUserDao().saveUserList(); // 변경된 유저 정보 저장
			}
		});

		JPanel panelTextArea = new JPanel();
		panelTextArea.setBounds(15, 270, 330, 240);
		add(panelTextArea);
		panelTextArea.setLayout(null);

		textAreaCrewContents = new JTextArea();
		textAreaCrewContents.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 13));
		textAreaCrewContents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaCrewContents.setText("");
			}
		});
		textAreaCrewContents.setText("내용을 입력해주세요");
		textAreaCrewContents.setToolTipText("");
		textAreaCrewContents.setBounds(5, 5, 320, 230);
		panelTextArea.add(textAreaCrewContents);
		textAreaCrewContents.setBackground(Color.WHITE);
		textAreaCrewContents.setToolTipText("");

		JPanel panelCrewContents = new JPanel();
		panelCrewContents.setBackground(Color.WHITE);
		panelCrewContents.setBounds(25, 220, 100, 40);
		panelCrewContents.add(new CrewImagePanel("./images/crew_create_crewContents.png", panelCrewContents.getSize()));
		add(panelCrewContents);
		panelCrewContents.setLayout(null);

		JLabel lblCrewContents = new JLabel("소 개");
		lblCrewContents.setBounds(0, 0, 100, 40);
		panelCrewContents.add(lblCrewContents);
		lblCrewContents.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewContents.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 16));

		JPanel panelCrewName = new JPanel();
		panelCrewName.setBackground(Color.WHITE);
		panelCrewName.setBounds(25, 70, 100, 40);
		panelCrewName.add(new CrewImagePanel("./images/crew_create_crewName.png", panelCrewName.getSize()));
		add(panelCrewName);
		panelCrewName.setLayout(null);

		JLabel lblCrewName = new JLabel("크루 명");
		lblCrewName.setBounds(0, 0, 100, 40);
		panelCrewName.add(lblCrewName);
		lblCrewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewName.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 16));

		JPanel panelTextField = new JPanel();
		panelTextField.setBackground(Color.WHITE);
		panelTextField.setBounds(20, 120, 310, 50);
		panelTextField.add(new CrewImagePanel("./images/crew_create_crewname_edit.png", panelTextField.getSize()));
		add(panelTextField);
		panelTextField.setLayout(null);

		textFieldCrewName = new JTextField();
		textFieldCrewName.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		textFieldCrewName.setBounds(50, 10, 260, 30);
		panelTextField.add(textFieldCrewName);
		textFieldCrewName.setColumns(10);

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
				else
					crewManager.convertPanel("crew_main");
				crewManager.updateCrewJoinState(true);
			}
		});
		btnHome.setPreferredSize(new Dimension(40, 30));
		footerPanel.add(btnHome);
		footerPanel.add(new CrewImagePanel("./images/home2.png", footerPanel.getSize())); // 이미지 추가
		add(footerPanel);
		footerPanel.setLayout(null);
	}

	// 패널 상태 초기화
	public void initPanel() {
		textFieldCrewName.setText("");
		textAreaCrewContents.setText("내용을 입력해주세요");
	}
}
