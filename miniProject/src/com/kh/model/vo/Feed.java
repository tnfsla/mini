package com.kh.model.vo;

import java.util.ArrayList;
import java.util.Calendar;

public class Feed extends Message {

	private String title; // 피드 제목
	private String contents; // 피드 내용
	private ArrayList<String> likeUserList; // 좋아요 한 유저 이름 리스트
	private ArrayList<Comment> commentList; // 댓글 리스트

	public Feed(String userId, Calendar date, String title, String contents) {
		super(userId, date, title);
		this.title = title;
		this.contents = contents;

		commentList = new ArrayList<Comment>();
		likeUserList = new ArrayList<String>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public ArrayList<Comment> getCommentList() {
		return commentList;
	}

	public ArrayList<String> getLikeUserList() {
		return likeUserList;
	}

	public void setLikeUserList(ArrayList<String> likeUserList) {
		this.likeUserList = likeUserList;
	}

	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}

	public void addComment(String userId, Calendar date, String comment) {
		commentList.add(new Comment(userId, date, comment));
	}

	public void addLike(String userId) {
		likeUserList.add(userId);
	}

	public int getLikeCount() {
		return likeUserList.size();
	}

	public int getCommentCount() {
		return commentList.size();
	}
}
