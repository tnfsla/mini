package com.kh.view.crew;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewController;

public class CrewPanel extends JPanel {

	private CrewViewManager crewManager;
	
	private CrewController crewController;

	public CrewPanel() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnNewButton = new JButton("크루 랭킹");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertPanel("rank"); // rank 페이지로
			}
		});
		btnNewButton.setBounds(55, 188, 234, 147);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("홈");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertPanel("main"); // main 페이지로
			}
		});
		btnNewButton_1.setBounds(118, 528, 97, 23);
		add(btnNewButton_1);
	}

	public CrewPanel(CrewViewManager crewManager, CrewController crewController) {
		this();
		this.crewManager = crewManager;
		this.crewController = crewController;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewPanel panel = new CrewPanel();
					panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
