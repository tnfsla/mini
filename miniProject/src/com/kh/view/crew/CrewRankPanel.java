package com.kh.view.crew;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.kh.controller.crew.CrewRankController;
import javax.swing.border.EmptyBorder;

public class CrewRankPanel extends JPanel {

	private final class DefaultTableModelExtension3 extends DefaultTableModel {
		Class[] columnTypes = new Class[] { Integer.class };
		boolean[] columnEditables = new boolean[] { false };

		private DefaultTableModelExtension3(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	}

	private final class DefaultTableModelExtension2 extends DefaultTableModel {
		Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };
		boolean[] columnEditables = new boolean[] { false, false, false };

		private DefaultTableModelExtension2(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	}

	private final class DefaultTableModelExtension extends DefaultTableModel {
		Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

		private DefaultTableModelExtension(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	}

	private CrewViewManager crewManager;

	private CrewRankController rankController;
	private JTable table_2;
	private JTable table;
	private JTable table_1;

	public CrewRankPanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		initialize();
	}

	public CrewRankPanel(CrewViewManager crewManager, CrewRankController rankController) {
		this();
		this.crewManager = crewManager;
		this.rankController = rankController;
	}

	// panel 초기 설정 crewManager, crewController 설정 후에 호출해야해서 initialize 메소드로 따로 뺌
	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 특정 crew 페이지로 다시 이동
				crewManager.convertPanel("crew");
			}
		});
		btnNewButton.setBounds(12, 10, 97, 23);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("명예의 전당");
		lblNewLabel.setBounds(117, 14, 75, 15);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(22, 299, 313, 219);
		add(scrollPane);

		table_2 = new JTable();
		table_2.setShowVerticalLines(false);
		table_2.setModel(
				new DefaultTableModelExtension(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "\uC21C\uC704", "\uC774\uB984", "\uAC70\uB9AC" }));
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(107);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(112);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(108);
		scrollPane.setViewportView(table_2);

		JPanel panel = new JPanel();
		panel.setBounds(22, 55, 313, 230);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 10, 289, 103);
		panel.add(scrollPane_1);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModelExtension2(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "\uC21C\uC704", "\uC774\uB984", "\uAC70\uB9AC" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane_1.setViewportView(table);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 161, 289, 59);
		panel.add(scrollPane_2);

		table_1 = new JTable();
		table_1.setShowVerticalLines(false);
		table_1.setModel(
				new DefaultTableModelExtension3(new Object[][] { { null }, }, new String[] { "\uB0B4 \uC21C\uC704" }));
		table_1.getColumnModel().getColumn(0).setResizable(false);
		scrollPane_2.setViewportView(table_1);

		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 561, 360, 29);
		add(footerPanel);

		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				crewManager.convertPanel("main");
				crewManager.updateCrewJoinState();
			}
		});
		footerPanel.add(lblHome);
	}
}
