package com.kh.view.admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PendingApprovalP extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PendingApprovalP() {
		setBounds(0, 0, 360, 600);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 141, 199, 177);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\uD558\uB098", "\uBB38\uB300\uD6C8"},
				{null, null, null},
			},
			new String[] {
				"\uD06C\uB8E8\uBA85", "\uC2E0\uCCAD\uC790"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblEvent = new JLabel("크루 승인 관리");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(38, 47, 257, 58);
		add(lblEvent);
		
		JButton btnNewButton = new JButton("이전");
		btnNewButton.setBounds(38, 450, 113, 39);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("승인");
		btnNewButton_1.setBounds(182, 450, 113, 39);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("대기중인 크루");
		lblNewLabel.setBounds(38, 109, 83, 31);
		add(lblNewLabel);

	}
}

