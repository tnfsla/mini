package com.kh.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

// Crew vo
public class Crew implements Serializable {
	private static final long serialVersionUID = -2973040292986558673L;

	private String crewName; // 크루명
	private String crewMasterName; // 크루장 일단 String으로처리 (크루장은 User이름)
	private ArrayList<User> userList; // 크루원 리스트
	private ArrayList<Feed> feedList; // 피드 리스트
	private String crewContents; // 크루 내용
	private boolean isAccept; // 크루 만들기 승인 여부 관리자가 승인 기본값 false

	public Crew() {
		userList = new ArrayList<User>();
		feedList = new ArrayList<Feed>();
	}

	public Crew(String crewName, String crewContents, String crewMasterName) {
		this();
		this.crewName = crewName;
		this.crewMasterName = crewMasterName;
		this.crewContents = crewContents;
//		this.isAccept = false; // 기본값은 승인이 안된 상태 
	}

	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public String getCrewMasterName() {
		return crewMasterName;
	}

	public void setCrewMasterName(String crewMasterName) {
		this.crewMasterName = crewMasterName;
	}

	public String getCrewContents() {
		return crewContents;
	}

	public void setCrewContents(String crewContents) {
		this.crewContents = crewContents;
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<Feed> getFeedList() {
		return feedList;
	}

	public void setFeedList(ArrayList<Feed> feedList) {
		this.feedList = feedList;
	}

	// 크루 인원 수 반환
	public int getCrewUserCount() {
		return userList.size();
	}

	// 피드 작성 수 반환
	public int getFeedCount() {
		return feedList.size();
	}

	@Override
	public String toString() {
		return "Crew [crewName=" + crewName + ", crewMasterName=" + crewMasterName + ", userNum=" + userList.size()
				+ ", feedNum=" + feedList.size() + ", isAccept=" + isAccept + "]";
	}

	public long getTotalTime() {
		long totalRunTime = 0;

		for (User user : userList) {
			for (Exercise exercise : user.getExercises()) {
				totalRunTime += exercise.getRunTime();
			}
		}

		return totalRunTime;
	}

	public double getTotalDistance() {
		double totalDistance = 0;

		for (User user : userList) {
			for (Exercise exercise : user.getExercises()) {
				totalDistance += exercise.getDistance();
			}
		}

		return totalDistance;
	}
}
