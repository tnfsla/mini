package com.kh.view.crew;

import java.awt.Color;
import java.awt.Dimension;
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
		this.setPreferredSize(new Dimension(360, 120));
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 5, 360, 110);
		add(panel);
		panel.setLayout(null);

		lblUserId = new JLabel("UserId");
		lblUserId.setBounds(12, 26, 57, 15);
		panel.add(lblUserId);

		lblCommentDate = new JLabel("CommentDate");
		lblCommentDate.setBounds(167, 10, 181, 23);
		panel.add(lblCommentDate);

		textAreaCommentContents = new JTextArea();
		textAreaCommentContents.setBackground(Color.LIGHT_GRAY);
		textAreaCommentContents.setBounds(12, 51, 310, 50);
		panel.add(textAreaCommentContents);
		textAreaCommentContents.setEditable(false);
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
