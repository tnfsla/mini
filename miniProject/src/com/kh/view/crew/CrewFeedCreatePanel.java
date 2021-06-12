package com.kh.view.crew;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewFeedCreateController;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class CrewFeedCreatePanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewFeedCreateController feedCreateController;

	private JTextField textFieldFeedTitle;

	private JTextArea textAreaFeedContents;

	public CrewFeedCreatePanel() {
		setBackground(Color.WHITE);
		initialize();
	}

	public CrewFeedCreatePanel(CrewViewManager crewManager, CrewFeedCreateController feedCreateController) {
		this();
		this.crewManager = crewManager;
		this.feedCreateController = feedCreateController;
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JPanel panelFeedBack = new JPanel();
		panelFeedBack.setBounds(15, 10, 30, 30);
		panelFeedBack.add(new CrewImagePanel("./images/back.png", panelFeedBack.getSize()));
		add(panelFeedBack);
		panelFeedBack.setLayout(null);

		JButton btnFeedBack = new JButton("");
		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("크루 피드 페이지로 이동");
				crewManager.convertPanel("crew_feed");
			}
		});
		btnFeedBack.setContentAreaFilled(false);
		btnFeedBack.setBorderPainted(false);
		btnFeedBack.setBounds(0, 0, 30, 30);
		panelFeedBack.add(btnFeedBack);

		JLabel lblFeedCreate = new JLabel("글쓰기");
		lblFeedCreate.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 18));
		lblFeedCreate.setBounds(65, 10, 100, 30);
		add(lblFeedCreate);

		JPanel panelCreateFeed = new JPanel();
		panelCreateFeed.setBounds(268, 10, 80, 30);
		add(panelCreateFeed);
		panelCreateFeed.setLayout(null);

		JButton btnCreateFeed = new JButton("게시");
		btnCreateFeed.setBounds(0, 0, 80, 30);
		panelCreateFeed.add(btnCreateFeed);
		btnCreateFeed.setForeground(Color.WHITE);
		btnCreateFeed.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		btnCreateFeed.setContentAreaFilled(false);
		btnCreateFeed.setBorderPainted(false);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_feed_button.png", panelCreateFeed.getSize());
		panelCreateFeed.add(crewImagePanel);

		btnCreateFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedCreateController.createFeed(crewManager.getFeedPanel().getCurCrew(), crewManager.getUser().getId(),
						textFieldFeedTitle.getText(), textAreaFeedContents.getText());
				System.out.println("피드 작성");

				// 생성 후 피드 페이지로 이동
				crewManager.getFeedPanel().updateFeed();
				crewManager.convertPanel("crew_feed");
			}
		});

		JPanel panelFeedTitle = new JPanel();
		panelFeedTitle.setBounds(12, 50, 336, 50);
		panelFeedTitle.add(new CrewImagePanel("./images/crew_create_crewname_edit.png", panelFeedTitle.getSize()));
		add(panelFeedTitle);
		panelFeedTitle.setLayout(null);

		textFieldFeedTitle = new JTextField();
		textFieldFeedTitle.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		textFieldFeedTitle.setBounds(50, 5, 274, 35);
		panelFeedTitle.add(textFieldFeedTitle);
		textFieldFeedTitle.setText("제목을 입력해주세요");
		textFieldFeedTitle.setColumns(10);

		JPanel panelFeedContents = new JPanel();
		panelFeedContents.setBackground(CrewViewManager.COLOR_MINT);
		panelFeedContents.setBounds(12, 110, 336, 480);
		add(panelFeedContents);
		panelFeedContents.setLayout(null);

		textAreaFeedContents = new JTextArea();
		textAreaFeedContents.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 13));
		textAreaFeedContents.setBounds(12, 10, 312, 460);
		panelFeedContents.add(textAreaFeedContents);
		textAreaFeedContents.setText("내용을 입력해주세요");
	}

}
