package com.kh.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class User extends SystemUser implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID =-4624560970749904817L;
	//public abstract class User  {//06.04(수)최용석
	private String name;
	private int age;
	private double height;
	private double weight;
	private char gender;
	private boolean hasBedge; // 미션 달성 여부
	private String crewName; // 크루 가입 여부 가입시 가입한 크루이름, 미가입시 null

	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	public User(String id, String pw, boolean adminFlag, String name, int age, double height, double weight,
			char gender, boolean hasBedge) {
		super(id, pw, adminFlag);
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.hasBedge = hasBedge;
		this.crewName = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isHasBedge() {
		return hasBedge;
	}

	public void setHasBedge(boolean hasBedge) {
		this.hasBedge = hasBedge;
	}

	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	// 운동 기록 추가 메소드
	public void addExercise(Exercise exercise) {
		exercises.add(exercise);
	}
}
