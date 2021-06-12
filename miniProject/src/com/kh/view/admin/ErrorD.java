package com.kh.view.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kh.controller.admin.AdminEventController;

import javax.swing.JLabel;

public class ErrorD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private EventSettingP eventSetting;
	private AdminEventController aec;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErrorD dialog = new ErrorD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog.
	 */
	public ErrorD() {
	
	}


	public ErrorD(EventSettingP eventSetting, AdminEventController aec) {
		this.eventSetting = eventSetting;
		this.aec = aec;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("잘못된 접근입니다.");
			lblNewLabel.setBounds(32, 37, 367, 55);
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel = new JLabel("이벤트 설정을 하지 않았거나, 지정 날짜가 되지 않았습니다.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 79, 367, 55);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("설정 날짜 : " +Long.toString(aec.getEventDao().getEvent().getEventDate()));

			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(32, 127, 367, 55);
			contentPanel.add(lblNewLabel_1);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("초기화");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						aec.getEventDao().EventEnd();
						dispose();
					}
				});
				okButton.setActionCommand("초기화");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("취소");
				buttonPane.add(cancelButton);
			}
		}
	}
}
