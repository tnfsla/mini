package com.kh.model.vo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
	
	
//public abstract class User  {//06.04(수)최용석
	private String name;
	private int age;
	private double height;
	private double weight;
	private char gender;
	private boolean hasBedge; // 미션 달성 여부
	private boolean hasCrew; // 크루 가입 여부

	

	public User(String name, int age, double height, double weight, char gender, boolean hasBedge, boolean hasCrew) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.hasBedge = hasBedge;
		this.hasCrew = hasCrew;
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

	public boolean isHasCrew() {
		return hasCrew;
	}

	public void setHasCrew(boolean hasCrew) {
		this.hasCrew = hasCrew;
	}
	

}

