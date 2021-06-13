package com.kh.view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinCompleteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinCompleteDialog dialog = new JoinCompleteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoinCompleteDialog() {
		setBounds(100, 100, 300, 142);
		getContentPane().setLayout(null);
		
		JButton btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ImagePanel panel = new ImagePanel(new ImageIcon("./images/JCDialogImage.jpg").getImage());
		panel.setLocation(0, 0);
		panel.setForeground(Color.WHITE);
		panel.setSize(new Dimension(283, 95));
		getContentPane().add(panel);
		panel.setLayout(null); 
		
		btnConfirm.setFont(new Font("굴림", Font.PLAIN, 16));
		btnConfirm.setBounds(89, 50, 100, 40);
		getContentPane().add(btnConfirm);
	}

}

