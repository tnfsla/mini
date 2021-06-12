package com.kh.model.vo;

import java.io.Serializable;

public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7854138967310674038L;
	private String eventFlag;
	private String eventDate;
	private int eventGoal;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eventFlag, String eventDate, int eventGoal) {
		super();
		this.eventFlag = eventFlag;
		this.eventDate = eventDate;
		this.eventGoal = eventGoal;
	}

	public String getEventFlag() {
		return eventFlag;
	}

	public void setEventFlag(String eventFlag) {
		this.eventFlag = eventFlag;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventGoal() {
		return eventGoal;
	}

	public void setEventGoal(int eventGoal) {
		this.eventGoal = eventGoal;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "진행중 이벤트  : "+eventDate+"부터 시작한"+eventGoal+eventFlag+"달리기";
	}
	
	
	
	
}
