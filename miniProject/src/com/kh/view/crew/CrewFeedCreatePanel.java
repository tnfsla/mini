package com.kh.view.crew;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewFeedCreateController;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewFeedCreatePanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewFeedCreateController feedCreateController;

	private JTextField textFieldFeedTitle;

	private JTextArea textAreaFeedContents;

	public CrewFeedCreatePanel() {
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

		JButton btnFeedBack = new JButton("뒤로가기");
		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("크루 피드 페이지로 이동");
				crewManager.convertPanel("crew_feed");
			}
		});
		btnFeedBack.setBounds(12, 10, 90, 23);
		add(btnFeedBack);

		JLabel lblFeedCreate = new JLabel("글쓰기");
		lblFeedCreate.setBounds(114, 14, 57, 15);
		add(lblFeedCreate);

		JButton btnCreateFeed = new JButton("게시");
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
		btnCreateFeed.setBounds(251, 10, 97, 23);
		add(btnCreateFeed);

		textFieldFeedTitle = new JTextField();
		textFieldFeedTitle.setText("제목을 입력해주세요");
		textFieldFeedTitle.setBounds(12, 50, 336, 50);
		add(textFieldFeedTitle);
		textFieldFeedTitle.setColumns(10);

		textAreaFeedContents = new JTextArea();
		textAreaFeedContents.setText("내용을 입력해주세요");
		textAreaFeedContents.setBounds(12, 110, 336, 480);
		add(textAreaFeedContents);
	}

}
