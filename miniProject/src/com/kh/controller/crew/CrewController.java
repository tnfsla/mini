package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Crew;
import com.kh.model.vo.User;

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

	// 크루 가입
	public void joinCrew(Crew crew, User user) {
		crewDao.joinCrew(crew, user);
	}
	
}
