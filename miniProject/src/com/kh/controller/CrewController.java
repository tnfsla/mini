package com.kh.controller;

import com.kh.model.dao.CrewDao;

// Crew 특정 page controller
public class CrewController {

	private CrewRankController crewRankController; // crew 랭킹 page controller

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만
	
	public CrewController(CrewDao crewDao) {
		crewRankController = new CrewRankController(crewDao);
		this.crewDao = crewDao;
	}

	public CrewRankController getCrewRankController() {
		return crewRankController;
	}
	
}
