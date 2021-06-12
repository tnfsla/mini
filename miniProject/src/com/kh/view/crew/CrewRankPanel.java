package com.kh.view.crew;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kh.controller.crew.CrewRankController;
import com.kh.model.vo.Crew;
import com.kh.model.vo.User;

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
	}

	// panel 초기 설정 crewManager, crewController 설정 후에 호출해야해서 initialize 메소드로 따로 뺌
	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnCrewPageBack = new JButton("뒤로가기");
		btnCrewPageBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 특정 crew 페이지로 다시 이동
				crewManager.convertPanel("crew_crew");
			}
		});
		btnCrewPageBack.setBounds(12, 10, 97, 23);
		add(btnCrewPageBack);

		JLabel lblHallOfFame = new JLabel("명예의 전당");
		lblHallOfFame.setBounds(117, 14, 75, 15);
		add(lblHallOfFame);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(22, 299, 313, 219);
		add(scrollPane);

		tableTotalCrewUser = new JTable();
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
		scrollPane.setViewportView(tableTotalCrewUser);

		JPanel panel = new JPanel();
		panel.setBounds(22, 55, 313, 230);

		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPaneTopCrewUser = new JScrollPane();
		scrollPaneTopCrewUser.setBounds(12, 10, 289, 103);
		panel.add(scrollPaneTopCrewUser);

		tableTopCrewUser = new JTable();
		tableTopCrewUser.setFont(new Font("굴림", Font.PLAIN, 12));
		tableTopCrewUser.setShowVerticalLines(false);
		tableTopCrewUser.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "\uC21C\uC704", "\uC774\uB984", "\uAC70\uB9AC" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		scrollPaneTopCrewUser.setViewportView(tableTopCrewUser);

		JScrollPane scrollPaneCurCrewUser = new JScrollPane();
		scrollPaneCurCrewUser.setBounds(12, 161, 289, 59);
		panel.add(scrollPaneCurCrewUser);

		tableCurCrewUser = new JTable();
		tableCurCrewUser.setShowVerticalLines(false);
		tableCurCrewUser
				.setModel(new DefaultTableModel(new Object[][] { { null }, }, new String[] { "\uB0B4 \uC21C\uC704" }) {
					Class[] columnTypes = new Class[] { Integer.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		scrollPaneCurCrewUser.setViewportView(tableCurCrewUser);

		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.LIGHT_GRAY);
		footerPanel.setBounds(0, 561, 360, 29);

		add(footerPanel);

		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				crewManager.convertPanel("crew_main");
				crewManager.updateCrewJoinState(true);
			}
		});
		footerPanel.add(lblHome);
	}
}
