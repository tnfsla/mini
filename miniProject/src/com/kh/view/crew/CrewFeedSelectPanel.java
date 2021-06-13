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
import java.awt.Color;
import java.awt.Font;

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
		setBackground(Color.WHITE);
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

		JPanel panelFeedBack = new JPanel();
		panelFeedBack.setBounds(15, 10, 30, 30);
		add(panelFeedBack);
		panelFeedBack.setLayout(null);

		JButton btnFeedBack = new JButton("");
		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 페이지로 이동");
				crewManager.convertPanel("crew_feed");
			}
		});
		btnFeedBack.setContentAreaFilled(false);
		btnFeedBack.setBorderPainted(false);
		btnFeedBack.setBounds(0, 0, 30, 30);
		panelFeedBack.add(btnFeedBack);
		CrewImagePanel crewImagePanelFeedBack = new CrewImagePanel("./images/back.png", panelFeedBack.getSize());
		panelFeedBack.add(crewImagePanelFeedBack);

		JLabel lblFeedCreate = new JLabel("게시글");
		lblFeedCreate.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 18));
		lblFeedCreate.setBounds(65, 10, 100, 30);
		add(lblFeedCreate);

		JPanel panelEditFeed = new JPanel();
		panelEditFeed.setBackground(Color.WHITE);
		panelEditFeed.setBounds(224, 13, 60, 25);
		add(panelEditFeed);
		panelEditFeed.setLayout(null);

		JButton btnEditFeed = new JButton("수정");
		btnEditFeed.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		btnEditFeed.setBounds(0, 0, 60, 25);
		btnEditFeed.setForeground(Color.WHITE);

		btnEditFeed.setContentAreaFilled(false);
		btnEditFeed.setBorderPainted(false);

		panelEditFeed.add(btnEditFeed);
		CrewImagePanel crewImagePanelEditFeed = new CrewImagePanel("./images/crew_feed_button.png",
				panelEditFeed.getSize());
		panelEditFeed.add(crewImagePanelEditFeed);
		btnEditFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("피드 수정");
				feedSelectController.updateFeed(curFeed, textFieldTitle.getText(), textAreaContents.getText());
			}
		});

		JPanel panelRemoveFeed = new JPanel();
		panelRemoveFeed.setBackground(Color.WHITE);
		panelRemoveFeed.setBounds(288, 13, 60, 25);
		add(panelRemoveFeed);
		panelRemoveFeed.setLayout(null);

		JButton btnRemoveFeed = new JButton("삭제");
		btnRemoveFeed.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		btnRemoveFeed.setBounds(0, 0, 60, 25);
		btnRemoveFeed.setForeground(Color.WHITE);

		btnRemoveFeed.setContentAreaFilled(false);
		btnRemoveFeed.setBorderPainted(false);

		panelRemoveFeed.add(btnRemoveFeed);
		CrewImagePanel crewImagePanelRemoveFeed = new CrewImagePanel("./images/crew_feed_button2.png",
				btnRemoveFeed.getSize());
		panelRemoveFeed.add(crewImagePanelRemoveFeed);
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

		JPanel panelSelectFeedWrap = new JPanel();
		panelSelectFeedWrap.setBackground(CrewViewManager.COLOR_GREEN);
		panelSelectFeedWrap.setBounds(12, 55, 336, 175);
		add(panelSelectFeedWrap);
		panelSelectFeedWrap.setLayout(null);

		JPanel panelSelectFeed = new JPanel();
		panelSelectFeed.setBackground(Color.WHITE);
		panelSelectFeed.setBounds(10, 10, 316, 155);
		panelSelectFeedWrap.add(panelSelectFeed);
		panelSelectFeed.setLayout(null);

		lblUserId = new JLabel("유저 아이디");
		lblUserId.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		lblUserId.setBounds(90, 10, 80, 15);
		panelSelectFeed.add(lblUserId);

		lblDate = new JLabel("2021.06.10 오후 17:25");
		lblDate.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblDate.setBounds(90, 30, 130, 15);
		panelSelectFeed.add(lblDate);

		JPanel panelContents = new JPanel();
		panelContents.setBounds(30, 90, 255, 55);
		panelSelectFeed.add(panelContents);
		panelContents.setLayout(null);

		textAreaContents = new JTextArea();
		textAreaContents.setBounds(5, 5, 245, 45);
		panelContents.add(textAreaContents);

		JPanel panelTitle = new JPanel();
		panelTitle.setBounds(90, 50, 195, 30);
		panelSelectFeed.add(panelTitle);
		panelTitle.setLayout(null);

		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(10, 0, 175, 20);
		panelTitle.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		CrewImagePanel crewImagePanelTitle = new CrewImagePanel("./images/crew_feed_feedname_edit.png",
				panelTitle.getSize());
		panelTitle.add(crewImagePanelTitle);

		JPanel panelUserIcon = new JPanel();
		panelUserIcon.setBounds(12, 10, 65, 65);
		panelSelectFeed.add(panelUserIcon);
		panelUserIcon.setLayout(null);
		CrewImagePanel crewImagePanel = new CrewImagePanel("./images/crew_feed_userIcon.png", panelUserIcon.getSize());
		panelUserIcon.add(crewImagePanel);
		
		JPanel panelLikeWrap = new JPanel();
		panelLikeWrap.setBounds(12, 245, 336, 50);
		add(panelLikeWrap);
		panelLikeWrap.setLayout(null);

		JPanel panelLike = new JPanel();
		panelLike.setBounds(10, 10, 316, 30);
		panelLikeWrap.add(panelLike);
		panelLike.setBackground(Color.WHITE);
		panelLike.setLayout(null);

		lblLike = new JLabel("파도아가라님 외 6명이 좋아합니다.");
		lblLike.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		lblLike.setBounds(55, 8, 237, 15);
		panelLike.add(lblLike);

		JPanel paneltoggleLike = new JPanel();
		paneltoggleLike.setBounds(10, 5, 30, 20);
		panelLike.add(paneltoggleLike);
		paneltoggleLike.setLayout(null);
		
		CrewImagePanel crewImagePanelToggleLike = new CrewImagePanel("./images/crew_feed_like.png", paneltoggleLike.getSize());
		paneltoggleLike.add(crewImagePanelToggleLike);
		
		CrewImagePanel crewImagePanelToggleLikeClicked = new CrewImagePanel("./images/crew_feed_like_clicked.png", paneltoggleLike.getSize());
		paneltoggleLike.add(crewImagePanelToggleLikeClicked);
		crewImagePanelToggleLikeClicked.setVisible(false);

		JToggleButton tglbtnLike = new JToggleButton("");
		tglbtnLike.setFont(new Font(CrewViewManager.MAIN_FONT, Font.BOLD, 12));
		tglbtnLike.setBounds(0, 0, 30, 20);
		tglbtnLike.setContentAreaFilled(false);
		tglbtnLike.setBorderPainted(false);
		paneltoggleLike.add(tglbtnLike);
		tglbtnLike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((JToggleButton) e.getSource()).isSelected() == true) {
					feedSelectController.addLike(curFeed, crewManager.getUser());
					crewImagePanelToggleLike.setVisible(false);
					crewImagePanelToggleLikeClicked.setVisible(true);
				} else {
					feedSelectController.removeLike(curFeed, crewManager.getUser());
					crewImagePanelToggleLike.setVisible(true);
					crewImagePanelToggleLikeClicked.setVisible(false);
				}
				updateLike();
			}
		});

		JPanel panelList = new JPanel();
		panelList.setBackground(CrewViewManager.COLOR_GREEN);
		panelList.setBounds(12, 305, 336, 235);
		add(panelList);
		panelList.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 316, 215);
		panelList.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JList listComment = new JList();

		commentModel = new DefaultListModel<Comment>();
		commentRenderer = new CommentRenderer();

		listComment.setModel(commentModel);
		listComment.setCellRenderer(commentRenderer);

		scrollPane.setViewportView(listComment);

		JPanel panelComment = new JPanel();
		panelComment.setBackground(Color.LIGHT_GRAY);
		panelComment.setBounds(12, 550, 336, 40);

		add(panelComment);
		panelComment.setLayout(null);

		textFieldComment = new JTextField();
		textFieldComment.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		textFieldComment.setText("댓글을 남겨주세요");
		textFieldComment.setBounds(50, 0, 212, 30);
		panelComment.add(textFieldComment);
		textFieldComment.setColumns(10);

		JPanel panelCreateComment = new JPanel();
		panelCreateComment.setBounds(261, 0, 75, 40);
		panelComment.add(panelCreateComment);
		panelCreateComment.setLayout(null);

		JButton btnCreateComment = new JButton("보내기");
		btnCreateComment.setBounds(0, 0, 75, 40);
		panelCreateComment.add(btnCreateComment);
		btnCreateComment.setForeground(Color.WHITE);
		btnCreateComment.setFont(new Font(CrewViewManager.MAIN_FONT, Font.PLAIN, 12));
		btnCreateComment.setContentAreaFilled(false);
		btnCreateComment.setBorderPainted(false);
		CrewImagePanel crewImagePanelCreateComment = new CrewImagePanel("./images/crew_feed_button.png",
				panelCreateComment.getSize());
		panelCreateComment.add(crewImagePanelCreateComment);

		CrewImagePanel crewImagePanelComment = new CrewImagePanel("./images/crew_create_crewname_edit.png",
				panelComment.getSize());
		panelComment.add(crewImagePanelComment);

		btnCreateComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("댓글 작성");
				feedSelectController.createComment(crewManager.getUser(), curFeed, textFieldComment.getText());
				updateComment();
			}
		});

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
