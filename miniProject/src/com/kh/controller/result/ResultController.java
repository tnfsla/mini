package com.kh.controller.result;

import java.util.ArrayList;


public class ResultController {

	 public ResultController() {
		// TODO Auto-generated constructor stub
	}
	 
	 ArrayList<Exercise> exercises;

	public int getTotalDistance() {
		
			int sum = 0;
			
			for(int i = 0 ; i < exercises.size(); i++) {
				sum += exercises.get(i).getDistance();
				
			}
			return sum;
			
		}
	
	public int getTotalTime() {
		int sum =  0;
		
		for(int i = 0 ; i < exercises.size(); i++) {
			sum += exercises.get(i).getTime();
			
		}
		return sum;
	}
	
	public int getTotalKcal() {
		int sum =  0;
		
		for(int i = 0 ; i < exercises.size(); i++) {
			sum += exercises.get(i).getKcal();
			
			}
		return sum;
		}
	
	}

