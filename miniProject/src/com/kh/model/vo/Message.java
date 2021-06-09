package com.kh.model.vo;

import java.util.Calendar;

public abstract class Message {
	private String userId; // 작성한 유저 아이디
	private Calendar date; // 작성 날짜
	private String contents; // 피드 내용

	public Message(String userId, Calendar date, String contents) {
		super();
		this.userId = userId;
		this.date = date;
		this.contents = contents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
