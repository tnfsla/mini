package com.kh.view.crew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kh.controller.crew.CrewController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewFrame extends JFrame {

	private CrewViewManager crewManager;
	
	private CrewController crewController;

	private JPanel contentPane;

	public CrewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("크루 랭킹");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertFrame("rank"); // rank 페이지로
			}
		});
		btnNewButton.setBounds(55, 188, 234, 147);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("홈");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertFrame("main"); // main 페이지로
			}
		});
		btnNewButton_1.setBounds(118, 528, 97, 23);
		contentPane.add(btnNewButton_1);
	}

	public CrewFrame(CrewViewManager crewManager, CrewController crewController) {
		this();
		this.crewManager = crewManager;
		this.crewController = crewController;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewFrame frame = new CrewFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
