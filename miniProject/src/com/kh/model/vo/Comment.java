package com.kh.model.vo;

import java.util.Calendar;

public class Comment extends Message {

	public Comment(String userId, Calendar date, String contents) {
		super(userId, date, contents);
	}

}
