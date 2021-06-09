package com.kh.controller.result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.kh.model.vo.Exercise;

public class ResultController {

	public ResultController() {
		// TODO Auto-generated constructor stub
	}

	ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	public void addExercise(Exercise ex) {
		exercises.add(ex);
	}
	
	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	public int getTotalDistance() {

		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getDistance();

		}
		return sum;

	}

	public String getTotalTime() {

		long sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getRunTime();

		}

		return secToHHMMSS(sum);
	}

	public int getTotalKcal() {
		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getCalorie();

		}
		return sum;
	}

	public boolean getDay(int day) {

		for (int i = 0; i < exercises.size(); i++) {
			if (day == exercises.get(i).getDates().get(Calendar.DATE)) {
				return true;
			}

		}

		return false;
	}

	public String secToHHMMSS(long secs) {
		long hour, min, sec;
		sec = secs % 60;
		min = secs / 60 % 60;
		hour = secs / 3600;

		return String.format("%02d:%02d:%02d", hour, min, sec);
	}

	public Exercise selectExercise(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);

		for (int i = 0; i < exercises.size(); i++) {
			if (exercises.get(i).getDates().get(Calendar.DATE) == day
					&& exercises.get(i).getDates().get(Calendar.MONTH) == month
					&& exercises.get(i).getDates().get(Calendar.YEAR) == year) {
				return exercises.get(i);
			}
		}
		System.out.println("찾을수 없습니다.");
		return null;
	}

	public double getTotalPace() {
		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getPace();

		}
		return sum;
	}

}
