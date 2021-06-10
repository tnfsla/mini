package com.kh.view.crew;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kh.controller.crew.CrewFeedController;
import com.kh.model.vo.Crew;
import com.kh.model.vo.Feed;

public class CrewFeedPanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewFeedController crewFeedController;

	private Crew curCrew; // 현재 사용자의 크루

	private JList listFeed;

	private DefaultListModel feedModel;

	public CrewFeedPanel() {
		initialize();
	}

	public CrewFeedPanel(CrewViewManager crewManager, CrewFeedController crewFeedController) {
		this();
		this.crewManager = crewManager;
		this.crewFeedController = crewFeedController;
	}

	public void setFeed(Crew crew) {
		curCrew = crew;
		updateFeed();
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnCrewBack = new JButton("뒤로가기");
		btnCrewBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("크루 페이지로 이동");
				crewManager.convertPanel("crew_crew");
			}
		});
		btnCrewBack.setBounds(12, 10, 90, 23);
		add(btnCrewBack);

		JLabel lblFeed = new JLabel("피드");
		lblFeed.setBounds(114, 14, 57, 15);
		add(lblFeed);

		JButton btnCreateFeed = new JButton("글쓰기");
		btnCreateFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 글쓰기 이동");
				crewManager.convertPanel("crew_feed_create");
			}
		});
		btnCreateFeed.setBounds(251, 10, 97, 23);
		add(btnCreateFeed);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 59, 336, 541);
		add(scrollPane);

		feedModel = new DefaultListModel<Feed>();
		FeedRenderer feedRenderer = new FeedRenderer();

		listFeed = new JList();
		listFeed.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (listFeed.getSelectedIndex() != -1) {

					Feed feed = curCrew.getFeedList().get(listFeed.getSelectedIndex());
					crewManager.getFeedSelectPanel().setFeed(feed);

					System.out.println("특정 피드 선택");
					crewManager.convertPanel("crew_feed_select");
				}
			}
		});
		listFeed.setModel(feedModel);
		listFeed.setCellRenderer(feedRenderer);

		scrollPane.setViewportView(listFeed);

	}

	public Crew getCurCrew() {
		return curCrew;
	}

	// Feed 상태 변경
	public void updateFeed() {
		feedModel.clear();

		crewFeedController.sortFeedDateDES(curCrew.getFeedList());

		for (Feed feed : curCrew.getFeedList()) {
			feedModel.addElement(feed);

		}
	}

	private class FeedRenderer implements ListCellRenderer {

		private CrewFeedListPanel panel;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

			panel = new CrewFeedListPanel();
			panel.setFeed((Feed) value);

			return panel;
		}

	}
}
