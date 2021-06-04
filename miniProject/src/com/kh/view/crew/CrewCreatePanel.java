package com.kh.view.crew;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewCreateController;

public class CrewCreatePanel extends JPanel {

	private CrewViewManager crewManager;
	
	private CrewCreateController createController;

	public CrewCreatePanel() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnNewButton = new JButton("완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertPanel("main"); // main page로
			}
		});
		btnNewButton.setBounds(235, 20, 97, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("홈");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertPanel("main"); // main page로
			}
		});
		btnNewButton_1.setBounds(131, 528, 97, 23);
		add(btnNewButton_1);
	}

	public CrewCreatePanel(CrewViewManager crewManager, CrewCreateController createController) {
		this();
		this.crewManager = crewManager;
		this.createController = createController;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewCreatePanel panel = new CrewCreatePanel();
					panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
