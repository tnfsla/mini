package com.kh.controller.result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.kh.model.vo.Exercise;

public class ResultController {

	public ResultController() {
		// TODO Auto-generated constructor stub
	}

	ArrayList<Exercise> exercises;

	public int getTotalDistance() {

		int sum = 0;

		for (int i = 0; i < exercises.size(); i++) {
			sum += exercises.get(i).getDistance();

		}
		return sum;

	}

	public long getTotalTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		long sum = 0;

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
