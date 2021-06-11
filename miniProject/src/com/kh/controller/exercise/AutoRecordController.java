package com.kh.controller.exercise;

import com.kh.model.dao.ExerciseDao;

public class AutoRecordController {

	private ExerciseDao exerciseDao;

	public AutoRecordController(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

}
