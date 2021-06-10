package com.kh.controller.crew;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.kh.model.vo.Comment;
import com.kh.model.vo.Crew;
import com.kh.model.vo.Feed;
import com.kh.model.vo.User;

public class CrewFeedSelectController {

	public void updateFeed(Feed curFeed, String title, String contents) {

		curFeed.setTitle(title);
		curFeed.setContents(contents);

	}

	public void removeFeed(Crew crew, Feed curFeed) {
		crew.getFeedList().remove(curFeed);
	}

	public void createComment(User user, Feed curFeed, String contents) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		curFeed.getCommentList().add(new Comment(user.getId(), cal, contents));
	}

	public void addLike(Feed curFeed, User user) {
		if (!findLikeUser(curFeed, user.getId())) {
			curFeed.getLikeUserList().add(user.getId());
		}
	}

	public boolean findLikeUser(Feed curFeed, String userId) {
		for (String id : curFeed.getLikeUserList()) {
			if (userId.equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void removeLike(Feed curFeed, User user) {
		curFeed.getLikeUserList().remove(user.getId());
	}

	public String convertCalToDate(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss");
		return sdf.format(cal.getTime());
	}

	public String stringFormatLike(ArrayList<String> likeUserList) {
		if (likeUserList.size() == 0)
			return "";
		
		return String.format("%s 외 %d명이 좋아합니다.", likeUserList.get(likeUserList.size() - 1), likeUserList.size() - 1);
	}

	public void sortCommentDateDES(ArrayList<Comment> commentList) {
		Collections.sort(commentList, new Comparator<Comment>() {

			@Override
			public int compare(Comment o1, Comment o2) {
				return (int) (o2.getDate().getTimeInMillis() / 1000) - (int) (o1.getDate().getTimeInMillis() / 1000);
			}

		});

	}
}
