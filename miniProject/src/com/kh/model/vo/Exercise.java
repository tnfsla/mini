package com.kh.model.vo;

import java.util.Calendar;

public class Exercise {

	private Calendar dates; // 기록했던 날짜
	private int runHour; // GUI 작업을 위한 시 변수
	private int runMin; // GUI 작업을 위한 분 변수
	private int runSec; // GUI 작업을 위한 초 변수
	private long runTime; // 달린 시간 초 단위로 저장 해당 시간으로 전체 시간 등을 계산
	private double distance; // 이동거리
	private double calorie; // 칼로리
	private double pace; // 페이스
	private int star; // 별점 (1 ~ 5)

	public Exercise() {
	}

	public Exercise(Calendar dates, int runHour, int runMin, int runSec, long runTime, double distance, double calorie,
			double pace, int star) {
		super();
		this.dates = dates;
		this.runHour = runHour;
		this.runMin = runMin;
		this.runSec = runSec;
		this.runTime = runTime;
		this.distance = distance;
		this.calorie = calorie;
		this.pace = pace;
		this.star = star;
	}

	public Calendar getDates() {
		return dates;
	}

	public void setDates(Calendar dates) {
		this.dates = dates;
	}

	public int getRunHour() {
		return runHour;
	}

	public void setRunHour(int runHour) {
		this.runHour = runHour;
	}

	public int getRunMin() {
		return runMin;
	}

	public void setRunMin(int runMin) {
		this.runMin = runMin;
	}

	public int getRunSec() {
		return runSec;
	}

	public void setRunSec(int runSec) {
		this.runSec = runSec;
	}

	public long getRunTime() {
		return runTime;
	}

	public void setRunTime(long runTime) {
		this.runTime = runTime;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getCalorie() {
		return calorie;
	}

	public void setCalory(double calorie) {
		this.calorie = calorie;
	}

	public double getPace() {
		return pace;
	}

	public void setPace(double pace) {
		this.pace = pace;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

}
