package com.kh.view.crew;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class CrewJoinDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public CrewJoinDialog(CrewPanel crewPanel) {

		setBounds(100, 100, 280, 130);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(215, 255, 241));
		contentPanel.setBounds(0, 0, 265, 55);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("가입 하시겠습니까?");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(215, 255, 241));
			buttonPane.setBounds(0, 55, 265, 35);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				{
					JPanel panel = new JPanel();
					panel.setBackground(new Color(190, 190, 190));
					panel.setBounds(10, 0, 115, 33);
					buttonPane.add(panel);
					panel.setLayout(null);
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setBounds(0, 0, 120, 33);
					cancelButton.setContentAreaFilled(false);
					panel.add(cancelButton);
					cancelButton.setForeground(Color.WHITE);
					cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							crewPanel.setIsJoinCrew(false); // 크루 페이지 가입 상태 false로 변경
							dispose(); // 소멸 new를 계속 하기 때문에 소멸로 dispose 안쓰고 setVisible(false)로도 가능 그러면 크루 페이지에서 new 한번만
										// 해야함
						}
					});
					cancelButton.setActionCommand("Cancel");
				}
			}
			{
				{
					JPanel panel2 = new JPanel();
					panel2.setBackground(new Color(52, 152, 219));
					panel2.setBounds(140, 0, 115, 33);
					buttonPane.add(panel2);
					panel2.setLayout(null);
					JButton okButton = new JButton("OK");
					okButton.setBounds(0, 0, 115, 33);
					okButton.setContentAreaFilled(false);
					panel2.add(okButton);
					okButton.setForeground(Color.WHITE);
					okButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							crewPanel.setIsJoinCrew(true); // 크루 페이지 가입 상태 true로 변경
							dispose(); // 소멸
						}
					});
					okButton.setActionCommand("OK");
				}
			}
		}
	}
}
