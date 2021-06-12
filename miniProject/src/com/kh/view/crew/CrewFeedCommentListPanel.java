package com.kh.view.crew;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.model.vo.Comment;

public class CrewFeedCommentListPanel extends JPanel {

	private JLabel lblUserId;
	private JLabel lblCommentDate;
	private JTextArea textAreaCommentContents;
	private JPanel panel;

	public CrewFeedCommentListPanel() {
		this.setPreferredSize(new Dimension(312, 120));
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 5, 312, 110);
		add(panel);
		panel.setLayout(null);

		lblUserId = new JLabel("UserId");
		lblUserId.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		lblUserId.setBounds(95, 5, 100, 20);
		panel.add(lblUserId);

		lblCommentDate = new JLabel("CommentDate");
		lblCommentDate.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblCommentDate.setBounds(95, 25, 188, 20);
		panel.add(lblCommentDate);

		JPanel panelFeedContents = new JPanel();
		panelFeedContents.setBounds(95, 50, 200, 50);
		panel.add(panelFeedContents);
		panelFeedContents.setLayout(null);

		textAreaCommentContents = new JTextArea();
		textAreaCommentContents.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 13));
		textAreaCommentContents.setBounds(5, 5, 190, 40);
		panelFeedContents.add(textAreaCommentContents);
		textAreaCommentContents.setBackground(Color.WHITE);
		textAreaCommentContents.setEditable(false);
		
		JPanel panelUserIcon = new JPanel();
		panelUserIcon.setBounds(15, 10, 65, 65);
		panelUserIcon.setLayout(null);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_feed_userIcon.png", panelUserIcon.getSize());
		crewImagePanel.setLocation(0, 0);
		crewImagePanel.setSize(65, 65);
		panelUserIcon.add(crewImagePanel);
		panel.add(panelUserIcon);
	}

	public void setComment(Comment comment) {
		lblUserId.setText(comment.getUserId());

		Calendar cal = comment.getDate();

		String date = convertCalToDate(cal);
		lblCommentDate.setText(date);

		textAreaCommentContents.setText(comment.getContents());

	}

	private String convertCalToDate(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss");
		return sdf.format(cal.getTime());
	}

}
