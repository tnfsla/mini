package com.kh.view.exercise;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.kh.controller.exercise.RecordMainController;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RecordMainPanel extends JPanel {
	
	private InputRecordPanel inputRecordPanel;
	private StopWatchPanel stopWatchPanel;
	
	private Map<String, JPanel> panelMap; // 프레임 전환을 위하여 map 사용
	
	private RecordMainController recordMainController;

	private Main main;
	
	private User user;
	
	public RecordMainPanel() {
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JLabel title = new JLabel(new ImageIcon("./Images/recordmaintitle.png"));
		title.setBounds(50, 40, 200, 50);
		add(title);
		
		JLabel explain = new JLabel(new ImageIcon("./Images/recordmain.png"));
		explain.setBackground(Color.WHITE);
		explain.setLocation(50, 90);
		explain.setSize(260, 130);
		add(explain);

		JButton stopwatch = new JButton();
		stopwatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("record_stopWatch");
			}
		});
		stopwatch.setLocation(55, 250);
		stopwatch.setSize(250, 80);
		stopwatch.setIcon(new ImageIcon("./Images/stopwatchrecord.png"));
		stopwatch.setBorderPainted(false);
		stopwatch.setContentAreaFilled(false);
		stopwatch.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		add(stopwatch);

		JButton input = new JButton();
		input.setIcon(new ImageIcon("./Images/inputrecord.png"));
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("record_input");
			}
		});
		input.setLocation(55, 350);
		input.setSize(250, 80);
		input.setBorderPainted(false);
		input.setContentAreaFilled(false);
		input.setFocusPainted(false);
		input.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		add(input);

		JLabel lblHome = new JLabel();
		lblHome.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon("./Images/home2.png"));
		lblHome.setBounds(0, 570, 360, 30);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				main.convertPanel("main");
			}
		});
		add(lblHome);
	}

	public RecordMainPanel(Main main) {
		this();
		this.main = main;
		
		initPanel();
	}
	
	public void initPanel() {
		
		inputRecordPanel = new InputRecordPanel(main);
		stopWatchPanel = new StopWatchPanel(main);
		
		panelMap = main.getPanelMap();
		
		
		panelMap.put("record_input", inputRecordPanel);
		panelMap.put("record_stopWatch", stopWatchPanel);
	}

	public void setUser(User user) {
		 this.user = user;
	      
	      updateUser();
	}
	
	   public void updateUser() {
		      
		      inputRecordPanel.setUser(user);
		      stopWatchPanel.setUser(user);
		   }

}
