package com.kh.controller.result;

import java.util.ArrayList;
import java.util.Calendar;

import com.kh.model.vo.Exercise;

public class ResultController {

	public ResultController() {
		// TODO Auto-generated constructor stub
	}

	public ResultController(ArrayList<Exercise> exericises) {
		this();
		this.exercises = exericises;
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

	public boolean getDate(int year, int month, int day) {

		for (int i = 0; i < exercises.size(); i++) {
			Calendar cal = exercises.get(i).getDates();
			int year2 = cal.get(Calendar.YEAR);
			int month2 = cal.get(Calendar.MONTH) + 1;
			int day2 = cal.get(Calendar.DATE);

			if (day2 == day && month2 == month && year2 == year) {
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

//		System.out.printf("타겟 %d %d %d\n", year, month, day);

		for (int i = 0; i < exercises.size(); i++) {
			Calendar cal = exercises.get(i).getDates();

			int year2 = cal.get(Calendar.YEAR);
			int month2 = cal.get(Calendar.MONTH) + 1;
			int day2 = cal.get(Calendar.DATE);

//			System.out.printf("비교 %d %d %d\n", year2, month2, day2);

			if (day2 == day && month2 == month && year2 == year) {
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

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public void printExercise() {
		for (Exercise exercise : exercises) {
			System.out.println(exercise);
		}
	}
}
