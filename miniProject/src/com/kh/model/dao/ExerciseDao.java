package com.kh.model.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;

public class ExerciseDao {
	
	private ArrayList<Exercise> exercises;
	
	private static final String EXERCISE_FILEPATH = "./resources/exerciseList.dat";
	
	public ExerciseDao() {
		
		exercises = new ArrayList<Exercise>();
		
	}
	public ExerciseDao(User user) {
		this();
		
	}

	public static void addEx(Calendar dates, int runHour, int runMin, int runSec, long runTime, double distance, double calorie,
			double pace, int star) {
		Exercise exercises = new Exercise(dates, runHour, runMin, runSec, runTime, distance, calorie, pace, star);
		
	}
	
	public void saveExList() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EXERCISE_FILEPATH))) {
			
			oos.writeObject(exercises);
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("운동기록 저장 완료");
	}
	
	

}
