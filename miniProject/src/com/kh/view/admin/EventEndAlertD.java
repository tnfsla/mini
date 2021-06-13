package com.kh.view.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kh.controller.admin.AdminEventController;
import com.kh.controller.login.JoinController;

public class EventEndAlertD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AdminEventController aec;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EventEndAlertD dialog = new EventEndAlertD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EventEndAlertD() {
		
	}

	public EventEndAlertD(AdminEventController aec) {
		this.aec = aec;
		
		setBounds(100, 100, 452, 188);
		contentPanel.setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			JLabel eventAlertL = new JLabel("진행중인 "+aec.getEventDao().getEvent().getEventGoal()+aec.getEventDao().getEvent().getEventFlag()+" 달리기를 마감 하시겠습니까?");
			eventAlertL.setBounds(26, 26, 375, 29);
			eventAlertL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			contentPanel.add(eventAlertL);
		}
		{
			JLabel eventFinishL = new JLabel("총 "+aec.getUserDao().userCount()+"명 중 "+aec.hasBedgeCount()+"명이 목표를 달성하였습니다."); //총인원과 목표달성 인원 받아오기
			eventFinishL.setBounds(26, 65, 236, 23);
			contentPanel.add(eventFinishL);
		}
		{
			JPanel buttonPane = new JPanel();//
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						aec.getEventDao().EventEnd();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
