package com.kh.model.dao;

import java.util.ArrayList;

import com.kh.model.vo.Crew;

// 크루리스트를 가지고 있는 CrewDao
public class CrewDao {
	
	private ArrayList<Crew> crewList;
	
	public CrewDao() {
		crewList = new ArrayList<Crew>();
	}
}
