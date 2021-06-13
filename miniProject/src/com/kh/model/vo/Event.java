package com.kh.model.vo;

import java.io.Serializable;

public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7854138967310674038L;
	private String eventFlag;
	private long eventDate;
	private int eventGoal;
	private boolean eventStart;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eventFlag, long eventDate, int eventGoal) {
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

	public long getEventDate() {
		return eventDate;
	}

	public void setEventDate(long eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventGoal() {
		return eventGoal;
	}

	public void setEventGoal(int eventGoal) {
		this.eventGoal = eventGoal;
	}
	
	public boolean isEventStart() {
		return eventStart;
	}

	public void setEventStart(boolean eventStart) {
		this.eventStart = eventStart;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "진행중 이벤트  : "+eventDate+"부터 시작한"+eventGoal+eventFlag+"달리기";
	}
	
	
	
	
}
