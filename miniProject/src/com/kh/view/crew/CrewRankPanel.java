package com.kh.view.crew;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.kh.controller.crew.CrewRankController;
import com.kh.model.vo.Crew;

public class CrewRankPanel extends JPanel {

	private class CrewRankTableModel extends DefaultTableModel {
		Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

		private CrewRankTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		public Class GetColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	}

	private CrewViewManager crewManager;

	private CrewRankController rankController;
	private JTable tableTotalCrewUser;
	private JTable tableTopCrewUser;
	private JTable tableCurCrewUser;

	public CrewRankPanel() {
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		initialize();
	}

	public CrewRankPanel(CrewViewManager crewManager, CrewRankController rankController) {
		this();
		this.crewManager = crewManager;
		this.rankController = rankController;
	}

	public void setRank(Crew crew) {
		// 오름차순 asc, 내림차순 des
		rankController.sortRankDistanceDES(crew.getUserList());
		String[][] ranks = rankController.getRank(crew.getUserList());
		String[][] myRank = rankController.getUserRank(crew.getUserList(), crewManager.getUser());

		String[] columnNames = { "순위", "이름", "거리" };

		String[][] topRanks = new String[3][3];

		for (int i = 0; i < topRanks.length; i++) {
//			System.arraycopy(ranks[i], 0, topRanks[i], 0, topRanks[i].length); // 깊은 복사
			topRanks[i] = ranks[i]; // 얕은 복사 둘다 바뀌면 같이 바뀌게 별차이는 없긴함
		}

		tableTopCrewUser.setModel(new CrewRankTableModel(topRanks, columnNames));
		tableTotalCrewUser.setModel(new CrewRankTableModel(ranks, columnNames));
		tableCurCrewUser.setModel(new DefaultTableModel(myRank, new String[] { "내 순위" }));
		
		setTableColumnAlignCenter(tableTopCrewUser);
		setTableColumnAlignCenter(tableTotalCrewUser);
		setTableColumnAlignCenter(tableCurCrewUser);
	}

	// panel 초기 설정 crewManager, crewController 설정 후에 호출해야해서 initialize 메소드로 따로 뺌
	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JPanel panelCrewPageBack = new JPanel();
		panelCrewPageBack.setBounds(15, 10, 30, 30);
		panelCrewPageBack.add(new CrewImagePanel("./images/back.png", panelCrewPageBack.getSize()));
		add(panelCrewPageBack);
		panelCrewPageBack.setLayout(null);

		JButton btnCrewPageBack = new JButton("");
		btnCrewPageBack.setContentAreaFilled(false);
		btnCrewPageBack.setBorderPainted(false);
		btnCrewPageBack.setBounds(0, 0, 30, 30);
		panelCrewPageBack.add(btnCrewPageBack);
		btnCrewPageBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 특정 crew 페이지로 다시 이동
				crewManager.convertPanel("crew_crew");
			}
		});

		JLabel lblHallOfFame = new JLabel("명예의 전당");
		lblHallOfFame.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 18));
		lblHallOfFame.setBounds(65, 10, 100, 30);
		add(lblHallOfFame);

		JPanel panelScrollPane2 = new JPanel();
		panelScrollPane2.setBackground(CrewViewManager.COLOR_GREEN);
		panelScrollPane2.setBounds(20, 290, 320, 250);
		add(panelScrollPane2);
		panelScrollPane2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 300, 230);
		panelScrollPane2.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tableTotalCrewUser = new JTable();
		tableTotalCrewUser.setEnabled(false);
		tableTotalCrewUser.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		tableTotalCrewUser.setShowVerticalLines(false);
		tableTotalCrewUser
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "\uC21C\uC704", "\uC774\uB984", "\uAC70\uB9AC" }) {
					Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

		tableTotalCrewUser.getTableHeader().setPreferredSize(new Dimension(100, 32));
		tableTotalCrewUser.getTableHeader().setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		tableTotalCrewUser.setRowHeight(40);

		scrollPane.setViewportView(tableTotalCrewUser);

		JPanel panelScrollPane = new JPanel();
		panelScrollPane.setBackground(CrewViewManager.COLOR_GREEN);
		panelScrollPane.setBounds(20, 50, 320, 230);

		add(panelScrollPane);
		panelScrollPane.setLayout(null);

		JScrollPane scrollPaneTopCrewUser = new JScrollPane();
		scrollPaneTopCrewUser.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneTopCrewUser.setBounds(10, 10, 300, 122);
		panelScrollPane.add(scrollPaneTopCrewUser);

		tableTopCrewUser = new JTable();
		tableTopCrewUser.setEnabled(false);
		tableTopCrewUser.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 14));
		tableTopCrewUser.setShowVerticalLines(false);
		tableTopCrewUser.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "\uC21C\uC704", "\uC774\uB984", "\uAC70\uB9AC" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		tableTopCrewUser.getTableHeader().setPreferredSize(new Dimension(100, 30));
		tableTopCrewUser.getTableHeader().setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		tableTopCrewUser.setRowHeight(30);

		scrollPaneTopCrewUser.setViewportView(tableTopCrewUser);

		JScrollPane scrollPaneCurCrewUser = new JScrollPane();
		scrollPaneCurCrewUser.setBounds(10, 155, 300, 65);
		panelScrollPane.add(scrollPaneCurCrewUser);

		tableCurCrewUser = new JTable();
		tableCurCrewUser.setEnabled(false);
		tableCurCrewUser.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 14));
		tableCurCrewUser.setShowVerticalLines(false);
		tableCurCrewUser
				.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "\uB0B4 \uC21C\uC704" }) {
					Class[] columnTypes = new Class[] { Integer.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});

		tableCurCrewUser.getTableHeader().setPreferredSize(new Dimension(100, 30));
		tableCurCrewUser.getTableHeader().setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 14));
		tableCurCrewUser.setRowHeight(32);

		scrollPaneCurCrewUser.setViewportView(tableCurCrewUser);
	}
	
	// table column 가운데 정렬 시켜주는 메소드
	private void setTableColumnAlignCenter(JTable table) {
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
	}
}
