package com.kh.view.crew;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.model.vo.Feed;

public class CrewFeedListPanel extends JPanel {

	private JLabel lblUserId;
	private JLabel lblFeedDate;
	private JLabel lblFeedTitle;
	private JTextArea textAreaFeedContents;
	private JLabel lblLikeCount;
	private JLabel lblCommentCount;
	private JPanel panel;
	private JPanel panel_1;

	public CrewFeedListPanel() {
		this.setPreferredSize(new Dimension(312, 240));
		setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 312, 240);
		panel_1.setBackground(CrewViewManager.COLOR_MINT);
		add(panel_1);
		panel_1.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 312, 230);
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		lblUserId = new JLabel("UserId");
		lblUserId.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		lblUserId.setBounds(95, 20, 100, 20);
		panel.add(lblUserId);

		lblFeedDate = new JLabel("FeedDate");
		lblFeedDate.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblFeedDate.setBounds(95, 45, 188, 20);
		panel.add(lblFeedDate);

		lblFeedTitle = new JLabel("FeedTitle");
		lblFeedTitle.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblFeedTitle.setBounds(95, 70, 150, 20);
		panel.add(lblFeedTitle);
		
		JPanel panelFeedContents = new JPanel();
		panelFeedContents.setBounds(95, 100, 192, 85);
		panel.add(panelFeedContents);
		panelFeedContents.setLayout(null);

		textAreaFeedContents = new JTextArea();
		textAreaFeedContents.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 13));
		textAreaFeedContents.setBounds(5, 5, 182, 75);
		panelFeedContents.add(textAreaFeedContents);
		textAreaFeedContents.setBackground(Color.WHITE);
		textAreaFeedContents.setEditable(false);

		JLabel lblLikeImg = new JLabel("");
		lblLikeImg.setBounds(95, 195, 30, 25);
		lblLikeImg.setIcon(new ImageIcon("./images/feed_like.png"));
		panel.add(lblLikeImg);

		lblLikeCount = new JLabel("LikeCnt");
		lblLikeCount.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblLikeCount.setBounds(135, 195, 50, 25);
		panel.add(lblLikeCount);

		JLabel lblCommentImg = new JLabel("");
		lblCommentImg.setBounds(195, 195, 30, 25);
		lblCommentImg.setIcon(new ImageIcon("./images/feed_comment.png"));
		panel.add(lblCommentImg);

		lblCommentCount = new JLabel("ComCnt");
		lblCommentCount.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblCommentCount.setBounds(235, 195, 50, 25);
		panel.add(lblCommentCount);
		
		JPanel panelUserIcon = new JPanel();
		panelUserIcon.setBounds(7, 20, 76, 70);
		panelUserIcon.setLayout(null);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_feed_userIcon.png", panelUserIcon.getSize());
		panelUserIcon.add(crewImagePanel);
		panel.add(panelUserIcon);
	}

	public void setFeed(Feed feed) {
		lblUserId.setText(feed.getUserId());

		Calendar cal = feed.getDate();

		String date = convertCalToDate(cal);
		lblFeedDate.setText(date);

		lblFeedTitle.setText(feed.getTitle());
		textAreaFeedContents.setText(feed.getContents());
		lblLikeCount.setText(String.valueOf(feed.getLikeCount()));
		lblCommentCount.setText(String.valueOf(feed.getCommentCount()));

	}

	private String convertCalToDate(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss");
		return sdf.format(cal.getTime());
	}
}
