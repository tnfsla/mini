package com.kh.controller.result;

import java.util.ArrayList;

import com.kh.model.vo.Excercise;

public class ResultController {

	public ResultController() {
		// TODO Auto-generated constructor stub
	}

	ArrayList<Excercise> exercises;

	public int getTotalDistance() {

		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getDistance();

		}
		return sum;

	}

	public int getTotalTime() {
		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getRunTime();

		}
		return sum;
	}

	public int getTotalKcal() {
		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getCalorie();

		}
		return sum;
	}

}
