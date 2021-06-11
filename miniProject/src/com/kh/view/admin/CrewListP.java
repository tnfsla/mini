package com.kh.view.admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.kh.controller.crew.CrewController;
import com.kh.controller.crew.CrewControllerManager;
import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Crew;

public class CrewListP extends JPanel {
	private AdminViewManager avm;
	private JTable table;
	private String crewName;
	private CrewDao crewDao;
	private ArrayList<Crew> crew;
	private CrewController controller;
	private CrewControllerManager controllerManager;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public CrewListP(AdminViewManager avm, ArrayList<Crew> crew) {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		this.avm = avm;
		this.crew = crew;
		initialize();
	}

	public void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);
		JButton btnNewButton = new JButton("조회");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {// 정보 읽어오면 안의 사람 띄우기
				crewListD dialog1 = new crewListD(crew, crewName);
				dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog1.setVisible(true);
			}
		});
		btnNewButton.setBounds(168, 459, 113, 39);
		add(btnNewButton);
		JButton btnNewButton_1 = new JButton("이전");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avm.convertPanel("admin_main"); // 크루 만들기 page로
			}
		});
		btnNewButton_1.setBounds(32, 459, 113, 39);
		add(btnNewButton_1);
		JLabel lblEvent = new JLabel("전체 크루 명단");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(24, 42, 257, 58);
		add(lblEvent);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 134, 249, 302);
		add(scrollPane);

		reFresh();

	}

	public void reFresh() {
		String[] colNames = new String[] { "No", "크루 명", "총 크루 인원" };
		String[] rows = new String[3];
		DefaultTableModel model = new DefaultTableModel(colNames, 0);

		for (int i = 0; i < crew.size(); i++) {
			if (crew.get(i).isAccept()) {
				for (int j = 0; j < 3; j++) {
					if (j == 0) {
						rows[j] = Integer.valueOf(i + 1).toString(); // i번째
					} else if (j == 1) {
						rows[j] = crew.get(i).getCrewName(); // 크루명
					} else if (j == 2) {
						rows[j] = Integer.valueOf(crew.get(i).getCrewUserCount()).toString(); // 전 인원수
					}
				}

				model.addRow(rows);
			}
			System.out.println(rows[i]);
		}
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				crewName = (String) table.getModel().getValueAt(row, 1);
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);

		scrollPane.setViewportView(table);
	}

	public CrewListP() {
		initialize();
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

	public CrewDao getCrewDao() {
		return crewDao;
	}

	public void setCrewDao(CrewDao crewDao) {
		this.crewDao = crewDao;
	}
}