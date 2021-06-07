package com.kh.view.admin;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.view.crew.CrewCreatePanel;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrewListP extends JPanel {
	private AdminViewManager avm;
	private JTable table;
	private String crewName;


	/**
	 * Create the panel.
	 */
	public CrewListP() {
		setBounds(0, 0, 360, 600);
		setLayout(null);
		
		JButton btnNewButton = new JButton("조회");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//
			}
		});
		btnNewButton.setBounds(168, 459, 113, 39);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("이전");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avm.convertPanel("main"); // 크루 만들기 page로
			}
		});
		btnNewButton_1.setBounds(32, 459, 113, 39);
		add(btnNewButton_1);
		
		JLabel lblEvent = new JLabel("전체 크루 명단");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(24, 42, 257, 58);
		add(lblEvent);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 134, 249, 302);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				crewName = (String) table.getModel().getValueAt(row, 1);
				System.out.println(crewName);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "\uD558\uB098", new Integer(50)},
				{new Integer(2), "\uB450\uC6B8", new Integer(30)},
			},
			new String[] {
				"No", "\uD074\uB7FD\uBA85", "\uD604\uC7AC\uD074\uB7FD\uC778\uC6D0"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
	

	}

	public CrewListP(AdminViewManager avm) {
		this();
		this.avm = avm;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewListP panel = new CrewListP();
					panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}