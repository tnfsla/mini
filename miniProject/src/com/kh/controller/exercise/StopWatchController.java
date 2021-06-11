package com.kh.controller.exercise;

import com.kh.model.dao.ExerciseDao;

public class StopWatchController {

	private ExerciseDao exerciseDao;

	public StopWatchController(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

}
