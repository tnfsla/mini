package com.kh.view.crew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kh.controller.CrewCreateController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewCreateFrame extends JFrame {

	private CrewViewManager crewManager;
	
	private CrewCreateController createController;

	private JPanel contentPane;

	public CrewCreateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertFrame("main"); // main page로
			}
		});
		btnNewButton.setBounds(235, 20, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("홈");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertFrame("main"); // main page로
			}
		});
		btnNewButton_1.setBounds(131, 528, 97, 23);
		contentPane.add(btnNewButton_1);
	}

	public CrewCreateFrame(CrewViewManager crewManager, CrewCreateController createController) {
		this();
		this.crewManager = crewManager;
		this.createController = createController;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewCreateFrame frame = new CrewCreateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
