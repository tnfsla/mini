package com.kh.controller.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

import com.kh.model.dao.ExerciseDao;
import com.kh.model.vo.Exercise;

public class ExerciseController {

	private RecordMainController recordMainController;
	private InputRecordController inputRecordController;
	private AutoRecordController autoRecordController;
	private StopWatchController stopWatchController;

	private ExerciseDao exerciseDao;

	public ExerciseController(ExerciseDao exerciseDao) {
		recordMainController = new RecordMainController(exerciseDao);
		inputRecordController = new InputRecordController(exerciseDao);
		autoRecordController = new AutoRecordController(exerciseDao);
		stopWatchController = new StopWatchController(exerciseDao);
		this.exerciseDao = exerciseDao;
	}

	public Calendar setCalendar(int year, int month, int date) {

		Calendar dates = Calendar.getInstance();
		dates.set(year, month - 1, date);

		return dates;

	}
	
	public void saveExercise() {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(""));
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
