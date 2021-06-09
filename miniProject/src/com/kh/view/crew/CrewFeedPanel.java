package com.kh.view.crew;

import javax.swing.JPanel;

import com.kh.controller.crew.CrewFeedController;
import com.kh.model.vo.Crew;

import java.awt.Color;

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 336, 259);
		add(panel);

	}

}
