package com.kh.view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JoinCheckDialog extends JDialog {
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JoinCheckDialog dialog = new JoinCheckDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JoinCheckDialog() {
		
		setBounds(100, 100, 300, 142);
		getContentPane().setLayout(null);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./images/IDPass.jpg").getImage());
		panel.setForeground(Color.WHITE);
		panel.setSize(getSize());
		getContentPane().add(panel);
		
		JButton btnConfirm = new JButton("확인");
		btnConfirm.setFont(new Font("굴림", Font.PLAIN, 16));
		btnConfirm.setBounds(86, 53, 108, 40);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
