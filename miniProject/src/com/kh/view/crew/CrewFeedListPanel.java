package com.kh.view.crew;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.model.vo.Feed;
import java.awt.Color;

public class CrewFeedListPanel extends JPanel {

	private JLabel lblUserId;
	private JLabel lblFeedDate;
	private JLabel lblFeedTitle;
	private JTextArea textAreaFeedContents;
	private JLabel lblLikeCount;
	private JLabel lblCommentCount;
	private JPanel panel;

	public CrewFeedListPanel() {
		this.setPreferredSize(new Dimension(360, 240));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 360, 230);
		add(panel);
		panel.setLayout(null);

		lblUserId = new JLabel("UserId");
		lblUserId.setBounds(12, 10, 57, 15);
		panel.add(lblUserId);

		lblFeedDate = new JLabel("FeedDate");
		lblFeedDate.setBounds(12, 35, 181, 23);
		panel.add(lblFeedDate);

		lblFeedTitle = new JLabel("FeedTitle");
		lblFeedTitle.setBounds(12, 68, 163, 15);
		panel.add(lblFeedTitle);

		textAreaFeedContents = new JTextArea();
		textAreaFeedContents.setBackground(Color.LIGHT_GRAY);
		textAreaFeedContents.setBounds(12, 93, 310, 85);
		panel.add(textAreaFeedContents);
		textAreaFeedContents.setEditable(false);

		JLabel lblLikeImg = new JLabel("LikeImg");
		lblLikeImg.setBounds(12, 193, 44, 23);
		panel.add(lblLikeImg);

		lblLikeCount = new JLabel("LikeCount");
		lblLikeCount.setBounds(59, 197, 57, 15);
		panel.add(lblLikeCount);

		JLabel lblCommentImg = new JLabel("ComImg");
		lblCommentImg.setBounds(159, 197, 57, 15);
		panel.add(lblCommentImg);

		lblCommentCount = new JLabel("CommentCount");
		lblCommentCount.setBounds(217, 197, 119, 15);
		panel.add(lblCommentCount);
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
