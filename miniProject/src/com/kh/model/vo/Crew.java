package com.kh.model.vo;

import java.util.ArrayList;

// Crew vo
public class Crew {
	private String crewName; // 크루명
	private User crewMaster; // 크루장
	private ArrayList<User> userList; // 크루원 리스트
	private boolean isAccept; // 크루 만들기 승인 여부 관리자가 승인

	public Crew() {
		userList = new ArrayList<User>();
	}

	public Crew(String crewName, User crewMaster, ArrayList<User> userList, boolean isAccept) {
		this();
		this.crewName = crewName;
		this.crewMaster = crewMaster;
		this.isAccept = isAccept;
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

}
