package com.kh.view.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.Crew;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crewListD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ArrayList<Crew> crew;
	private String crewName;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public crewListD() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the dialog.
	 */
	public crewListD(ArrayList<Crew> crew, String crewName) {
		this.crew = crew;
		this.crewName = crewName;

		setBounds(100, 100, 253, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 63, 174, 139);
		contentPanel.add(scrollPane);

		String[] colNames = new String[] { "ID", "이름" };

		model = new DefaultTableModel(colNames, 0);
		
		modelSetting();
		

		table = new JTable(model);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void modelSetting() {
		
		String[] rows = new String[2];
		for (int i = 0; i < crew.size(); i++) {
			if (crew.get(i).getCrewName().equals(crewName)) {
				for (int j = 0; j < crew.get(i).getCrewUserCount(); j++) {
					for (int k = 0; k < 2; k++) {
						if (k == 0) {
							rows[k] = crew.get(i).getUserList().get(j).getId();
						} else if (k == 1) {
							rows[k] = crew.get(i).getUserList().get(j).getName();
						}
						
					}
					model.addRow(rows);
				}
				
			}
		}
		
	}
}
