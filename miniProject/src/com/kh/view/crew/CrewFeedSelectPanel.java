package com.kh.view.crew;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;

import com.kh.controller.crew.CrewFeedSelectController;
import com.kh.model.vo.Comment;
import com.kh.model.vo.Feed;

public class CrewFeedSelectPanel extends JPanel {

	private CrewViewManager crewManager;

	private CrewFeedSelectController feedSelectController;

	private JTextField textFieldComment;

	private JLabel lblUserId;

	private JLabel lblDate;

	private JTextArea textAreaContents;

	private JLabel lblLike;

	private Feed curFeed;

	private DefaultListModel<Comment> commentModel;

	private CommentRenderer commentRenderer;
	private JTextField textFieldTitle;

	public CrewFeedSelectPanel() {
		initialize();
	}

	public CrewFeedSelectPanel(CrewViewManager crewManager, CrewFeedSelectController feedSelectController) {
		this();
		this.crewManager = crewManager;
		this.feedSelectController = feedSelectController;
	}

	public void setFeed(Feed feed) {
		curFeed = feed;
		updateSelectFeed();
	}

	public void updateSelectFeed() {
		lblUserId.setText(curFeed.getUserId());

		Calendar cal = curFeed.getDate();
		String date = feedSelectController.convertCalToDate(cal);
		lblDate.setText(date);

		textFieldTitle.setText(curFeed.getTitle());

		textAreaContents.setText(curFeed.getContents());

		updateLike();

		updateComment();
	}

	private void updateLike() {
		lblLike.setText(feedSelectController.stringFormatLike(curFeed.getLikeUserList()));
	}
	
	private void updateComment() {
		commentModel.clear();
		
		feedSelectController.sortCommentDateDES(curFeed.getCommentList());
		
		for (Comment comment : curFeed.getCommentList()) {
			commentModel.addElement(comment);
		}
	}

	private void initialize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JButton btnFeedBack = new JButton("뒤로가기");
		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 페이지로 이동");
				crewManager.convertPanel("crew_feed");
			}
		});
		btnFeedBack.setBounds(12, 10, 90, 23);
		add(btnFeedBack);

		JLabel lblSelectFeed = new JLabel("게시글");
		lblSelectFeed.setBounds(114, 14, 57, 15);
		add(lblSelectFeed);

		JButton btnEditFeed = new JButton("수정");
		btnEditFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 수정");
				feedSelectController.updateFeed(curFeed, textFieldTitle.getText(), textAreaContents.getText());
			}
		});
		btnEditFeed.setBounds(224, 10, 60, 23);
		add(btnEditFeed);

		JButton btnRemoveFeed = new JButton("삭제");
		btnRemoveFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 삭제");
				feedSelectController.removeFeed(
						crewManager.getControllerManager().selectCrew(crewManager.getUser().getCrewName()), curFeed);

				// 삭제 후 피드 페이지로 이동
				crewManager.getFeedPanel().updateFeed();
				crewManager.convertPanel("crew_feed");
			}
		});
		btnRemoveFeed.setBounds(288, 10, 60, 23);
		add(btnRemoveFeed);

		JPanel panelSelectFeed = new JPanel();
		panelSelectFeed.setBounds(12, 55, 336, 150);
		add(panelSelectFeed);
		panelSelectFeed.setLayout(null);

		lblUserId = new JLabel("유저 아이디");
		lblUserId.setBounds(12, 10, 72, 15);
		panelSelectFeed.add(lblUserId);

		lblDate = new JLabel("2021.06.10 오후 17:25");
		lblDate.setBounds(12, 35, 130, 15);
		panelSelectFeed.add(lblDate);

		textAreaContents = new JTextArea();
		textAreaContents.setBounds(12, 88, 312, 52);
		panelSelectFeed.add(textAreaContents);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(12, 60, 116, 21);
		panelSelectFeed.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		JPanel panelLike = new JPanel();
		panelLike.setBounds(12, 215, 336, 50);
		add(panelLike);
		panelLike.setLayout(null);

		lblLike = new JLabel("파도아가라님 외 6명이 좋아합니다.");
		lblLike.setBounds(87, 18, 237, 15);
		panelLike.add(lblLike);

		JToggleButton tglbtnLike = new JToggleButton("좋아요");
		tglbtnLike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((JToggleButton) e.getSource()).isSelected() == true) {
					feedSelectController.addLike(curFeed, crewManager.getUser());
				} else {
					feedSelectController.removeLike(curFeed, crewManager.getUser());
				}
				updateLike();
			}
		});
		tglbtnLike.setBounds(0, 14, 75, 23);
		panelLike.add(tglbtnLike);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 275, 336, 265);
		add(scrollPane);

		commentModel = new DefaultListModel<Comment>();
		commentRenderer = new CommentRenderer();
		
		JList listComment = new JList();
		
		listComment.setModel(commentModel);
		listComment.setCellRenderer(commentRenderer);
		
		scrollPane.setViewportView(listComment);

		JPanel panelComment = new JPanel();
		panelComment.setBounds(12, 550, 336, 40);
		add(panelComment);
		panelComment.setLayout(null);

		textFieldComment = new JTextField();
		textFieldComment.setText("댓글을 남겨주세요");
		textFieldComment.setBounds(12, 0, 250, 40);
		panelComment.add(textFieldComment);
		textFieldComment.setColumns(10);

		JButton btnCreateComment = new JButton("보내기");
		btnCreateComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("댓글 작성");
				feedSelectController.createComment(crewManager.getUser(), curFeed, textFieldComment.getText());
				updateComment();
			}
		});
		btnCreateComment.setBounds(261, 0, 75, 40);
		panelComment.add(btnCreateComment);

	}

	private class CommentRenderer implements ListCellRenderer {

		private CrewFeedCommentListPanel panel;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

			panel = new CrewFeedCommentListPanel();
			panel.setComment((Comment) value);

			return panel;
		}

	}
}
