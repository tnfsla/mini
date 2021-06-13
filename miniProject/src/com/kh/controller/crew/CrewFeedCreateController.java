package com.kh.controller.crew;

import java.util.Calendar;
import java.util.Date;

import com.kh.model.vo.Crew;
import com.kh.model.vo.Feed;

public class CrewFeedCreateController {

	public void createFeed(Crew crew, String userId, String title, String contents) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); // 현재 시간 입력
		
		System.out.println(userId + " " + title + " " + contents);
		
		crew.getFeedList().add(new Feed(userId, cal, title, contents));
	}

}
