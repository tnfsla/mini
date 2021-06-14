package com.kh.view.crew;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
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

	private JList<Feed> listFeed;

	private DefaultListModel feedModel;

	private FeedRenderer feedRenderer;

	public CrewFeedPanel() {
		setBackground(Color.WHITE);
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

		JPanel panelFeedBack = new JPanel();
		panelFeedBack.setBounds(15, 10, 30, 30);
		panelFeedBack.add(new CrewImagePanel("./images/back.png", panelFeedBack.getSize()));
		add(panelFeedBack);
		panelFeedBack.setLayout(null);

		JButton btnFeedBack = new JButton("");
		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("크루 페이지로 이동");
				crewManager.convertPanel("crew_crew");
			}
		});
		btnFeedBack.setContentAreaFilled(false);
		btnFeedBack.setBorderPainted(false);
		btnFeedBack.setBounds(0, 0, 30, 30);
		panelFeedBack.add(btnFeedBack);

		JLabel lblFeed = new JLabel("피드");
		lblFeed.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 18));
		lblFeed.setBounds(65, 10, 100, 30);
		add(lblFeed);

		JPanel panelCreateFeed = new JPanel();
		panelCreateFeed.setBounds(268, 10, 80, 30);
		add(panelCreateFeed);
		panelCreateFeed.setLayout(null);

		JButton btnCreateFeed = new JButton("글쓰기");
		btnCreateFeed.setBounds(0, 0, 80, 30);
		panelCreateFeed.add(btnCreateFeed);
		btnCreateFeed.setForeground(Color.WHITE);
		btnCreateFeed.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		btnCreateFeed.setContentAreaFilled(false);
		btnCreateFeed.setBorderPainted(false);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_feed_button.png", panelCreateFeed.getSize());
		panelCreateFeed.add(crewImagePanel);

		btnCreateFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 글쓰기 이동");
				crewManager.convertPanel("crew_feed_create");
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(CrewViewManager.COLOR_GREEN);
		panel.setBounds(12, 54, 336, 541);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 312, 521);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		listFeed = new JList();
		listFeed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listFeed.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JList list = (JList) e.getSource();
				if (e.getClickCount() == 2) {
					int index = list.locationToIndex(e.getPoint());
					
					Feed feed = curCrew.getFeedList().get(index);
					crewManager.getFeedSelectPanel().setFeed(feed);

					System.out.println("특정 피드 같은 위치에서 선택 (더블 클릭)");
					crewManager.convertPanel("crew_feed_select");
				}
			}
		});
		
		listFeed.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {

				if (listFeed.getSelectedIndex() != -1 && !e.getValueIsAdjusting()) {

					Feed feed = curCrew.getFeedList().get(listFeed.getSelectedIndex());
					crewManager.getFeedSelectPanel().setFeed(feed);

					System.out.println("특정 피드 선택");
					crewManager.convertPanel("crew_feed_select");
				}
			}
		});

		scrollPane.setViewportView(listFeed);

		feedModel = new DefaultListModel<Feed>();
		feedRenderer = new FeedRenderer();
		
		listFeed.setModel(feedModel);
		listFeed.setCellRenderer(feedRenderer);


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
