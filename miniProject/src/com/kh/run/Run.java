package com.kh.run;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;
import com.kh.view.result.ResultMainView;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultMainView rm = new ResultMainView();
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();

		
		cal.set(2021, 6, 9);	
		rm.getRc().addExercise(new Exercise(cal, 0, 0, 0, 7300, 10, 700, 10, 3  ));
		cal1.set(2021, 6, 10);
		rm.getRc().addExercise(new Exercise(cal1, 0, 0, 0, 6800, 35, 652, 10, 4));

		rm.CalendarMain();
	}
	//private static void createTest(Calendar cal, Random random, ArrayList<Exercise> exercises, User user, CrewDao dao) {
		//cal = Calendar.getInstance();
		//cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		//exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000), random.nextDouble() * 10, random.nextInt(5) + 1));
		//}
}

