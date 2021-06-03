package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;

// Crew 랭킹 page controller (Crew 특정 page controller 안에 존재)
public class CrewRankController {

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만
	
	public CrewRankController(CrewDao crewDao) {
		this.crewDao = crewDao;
	}
}
