package com.kh.controller.exercise;

import java.util.ArrayList;

import com.kh.model.dao.ExerciseDao;
import com.kh.model.vo.Exercise;

public class InputRecordController {
	
	private ExerciseDao exerciseDao;
	ArrayList<Exercise> exercies = new ArrayList<Exercise>();
	
	public InputRecordController() {
		
	}
	
	
	
	public InputRecordController(ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}



	public void saveEx() {
		exerciseDao.saveExList();
	}

}
