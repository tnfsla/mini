package com.kh.view.crew;

import javax.swing.JPanel;

import com.kh.controller.crew.CrewFeedController;
import com.kh.model.vo.Crew;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;

public class CrewFeedPanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewFeedController crewFeedController;
	
	private Crew curCrew; // 현재 사용자의 크루

	public CrewFeedPanel() {
		initialize();
	}

	public CrewFeedPanel(CrewViewManager crewManager, CrewFeedController crewFeedController) {
		this();
		this.crewManager = crewManager;
		this.crewFeedController = crewFeedController;
	}

	public void setFeed(Crew crew) {
		curCrew = crew;
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.setBounds(12, 10, 90, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("피드");
		lblNewLabel.setBounds(114, 14, 57, 15);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("글쓰기");
		btnNewButton_1.setBounds(251, 10, 97, 23);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 56, 336, 534);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

	}
}
