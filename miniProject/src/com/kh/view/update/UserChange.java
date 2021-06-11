package com.kh.view.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserChange extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private EditViewManager viewManager;

	/**
	 * Create the panel.
	 */
	public UserChange(EditViewManager viewManager) {
		this.viewManager = viewManager;
		setLayout(null);
		setBounds(0, 0, 360, 600);
		
		
		textField = new JTextField();
		textField.setBounds(42, 300, 228, 33);
		add(textField);
		textField.setColumns(10);
		Double userHeight = this.viewManager.getUser().getHeight();
		textField.setText(userHeight.toString());


		
		
		textField_1 = new JTextField();
		textField_1.setBounds(42, 413, 228, 33);
		add(textField_1);
		textField_1.setColumns(10);
		Double userWeight = this.viewManager.getUser().getWeight();
		textField_1.setText(userWeight.toString());

		
		JLabel lblNewLabel = new JLabel("Height");
		lblNewLabel.setBounds(42, 270, 62, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Weight");
		lblNewLabel_1.setBounds(42, 383, 62, 18);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cm");
		lblNewLabel_2.setBounds(284, 302, 62, 18);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setBounds(284, 415, 62, 18);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(119, 477, 105, 27);
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewManager.getUser().setPrevHeight(viewManager.getUser().getHeight());
				viewManager.getUser().setHeight(Double.parseDouble(textField.getText()));
		System.out.println(" getHeight() = " +  viewManager.getUser().getHeight());
	    System.out.println("getPrevHeight() = " + viewManager.getUser().getPrevHeight());
	    System.out.println("textField() = " + textField.getText());
			
				viewManager.getUser().setPrevWeight(viewManager.getUser().getWeight());
				viewManager.getUser().setWeight(Double.parseDouble(textField_1.getText()));
				viewManager.convertPanel("userCompare");
			}
		});

	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//
//		frame.setBounds(100, 100, 360, 600);
//
//		frame.setVisible(true);
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		UserChange uc = new UserChange();
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(uc);
//		frame.setResizable(false);
//		
//		
//	}
}
