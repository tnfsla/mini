package com.kh.controller.crew;

import java.util.ArrayList;
import java.util.Calendar;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Feed;

public class CrewFeedController {

	private CrewDao crewDao;

	private CrewFeedCreateController crewFeedCreateController;
	private CrewFeedSelectController crewFeedSelectController;
	
	public CrewFeedController(CrewDao crewDao) {
		this.crewDao = crewDao;
		
		crewFeedCreateController = new CrewFeedCreateController();
		crewFeedSelectController = new CrewFeedSelectController();
	}

	// 피드 생성
	public void createFeed(ArrayList<Feed> feedList, String userId, Calendar date, String title, String contents) {
		System.out.println("피드 생성");
		feedList.add(new Feed(userId, date, title, contents));
	}

	// 피드 선택
	public Feed selectFeed(ArrayList<Feed> feedList, String userId, Calendar date, String title) {

		for (Feed feed : feedList) {
			if (feed.getUserId().equals(userId) && feed.getDate().getTimeInMillis() == date.getTimeInMillis()
					&& feed.getTitle().equals(title)) {
				return feed;
			}
		}

		return null;
	}

	// 피드 수정
	public void updateFeed(ArrayList<Feed> feedList, String userId, Calendar date, String title, String contents) {
		Feed feed = selectFeed(feedList, userId, date, title);

		if (feed == null) {
			System.out.println("수정할 피드를 못찾음");
			return;
		}

		feed.setContents(contents);
	}

	// 피드 삭제
	public void removeFeed(ArrayList<Feed> feedList, String userId, Calendar date, String title, String contents) {
		Feed feed = selectFeed(feedList, userId, date, title);

		if (feed == null) {
			System.out.println("삭제할 피드를 못찾음");
			return;
		}

		feedList.remove(feed);
	}
	
	// 해당 피드에 좋아요 추가
	public void addLike(Feed feed, String userId) {
		feed.addLike(userId);
	}
	
	// 해당 피드에 댓글 추가
	public void createComment(Feed feed, String userId, Calendar date, String comment) {
		feed.addComment(userId, date, comment);
	}
	
	public CrewFeedCreateController getCrewFeedCreateController() {
		return crewFeedCreateController;
	}
	
	public CrewFeedSelectController getCrewFeedSelectController() {
		return crewFeedSelectController;
	}
}
