package com.kh.view.crew;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kh.controller.crew.CrewController;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class CrewPanel extends JPanel {

	private CrewViewManager crewManager;
	
	private CrewController crewController;
	private JTextField textField;

	public CrewPanel() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnNewButton_1 = new JButton("홈");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewManager.convertPanel("main"); // main 페이지로
			}
		});
		btnNewButton_1.setBounds(126, 567, 97, 23);
		add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 30, 336, 147);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 0, 336, 68);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KH 러닝 클럽");
		lblNewLabel.setBounds(41, 10, 113, 33);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(227, 15, 97, 23);
		panel_1.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(10, 78, 314, 59);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(12, 250, 336, 155);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(94, 10, 155, 135);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("크루원");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(49, 10, 57, 15);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(26, 42, 103, 72);
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("100");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 415, 310, 136);

		
		add(tabbedPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(108, 0, 96, 107);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("거리");
		lblNewLabel_5.setBounds(12, 45, 57, 15);
		panel_6.add(lblNewLabel_5);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBounds(209, 0, 96, 107);
		panel_5.add(panel_6_1);
		panel_6_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("시간");
		lblNewLabel_4.setBounds(12, 44, 57, 15);
		panel_6_1.add(lblNewLabel_4);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBounds(0, 0, 96, 107);
		panel_5.add(panel_6_2);
		panel_6_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("인원");
		lblNewLabel_3.setBounds(12, 42, 57, 15);
		panel_6_2.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setText("크루원들의 활동 정보는 크루원에게만 공개됩니다.");
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(12, 10, 281, 87);
		panel_5.add(textArea);
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
