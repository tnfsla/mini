package com.kh.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.Crew;

public class PendingApprovalP extends JPanel {
	private JTable table;
	private AdminViewManager avm;
	private String crewName;
	private ArrayList<Crew> crew;
	private CrewListP crewp;

	/**
	 * Create the panel.
	 */
	public PendingApprovalP() {

	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 141, 199, 177);
		add(scrollPane);

		String[] colNames = new String[] { "크루 명", "신청자 명" };
		String[] rows = new String[2];
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		for (int i = 0; i < crew.size(); i++) {
			if (!crew.get(i).isAccept()) {
				for (int j = 0; j < 2; j++) {

					if (j == 0) {
						rows[j] = crew.get(i).getCrewName();
					} else if (j == 1) {
						rows[j] = crew.get(i).getCrewMasterName();
					}
				}

				model.addRow(rows);
			}

		}

		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				crewName = (String) table.getModel().getValueAt(row, 0);
				System.out.println(crewName);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"\uD558\uB098", "\uBB38\uB300\uD6C8"},
//
//
//			},
//			new String[] {
//				"크루 명", "신청자"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, Object.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		scrollPane.setViewportView(table);

		JLabel lblEvent = new JLabel("크루 승인 관리");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(38, 47, 257, 58);
		add(lblEvent);

		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avm.convertPanel("admin_main"); // 크루 만들기 page로
			}
		});
		btnNewButton.setBounds(38, 450, 113, 39);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("승인");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// crewName에 저장되어있는 것과 같은 crew의 isAccept를 true로 변환
				ArrayList<Crew> pending = new ArrayList<Crew>();
				for(int i = 0 ; i<crew.size(); i++) {
					if(!crew.get(i).isAccept()) {
						pending.add(crew.get(i));
						
					}
				}
				
				for (int i = 0; i < pending.size(); i++) {
					if (pending.get(i).getCrewName().equals(crewName)) {
						pending.get(i).setAccept(true);
						model.removeRow(i);
						crewp.reFresh();
					}
					
				}
			}
		});
		btnNewButton_1.setBounds(182, 450, 113, 39);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("대기중인 크루");
		lblNewLabel.setBounds(38, 109, 83, 31);
		add(lblNewLabel);
	}

	public PendingApprovalP(AdminViewManager avm, ArrayList<Crew> crew, CrewListP crewList) {
		this();
		this.avm = avm;
		this.crew = crew;
		this.crewp = crewList;
		initialize();
	}
}
