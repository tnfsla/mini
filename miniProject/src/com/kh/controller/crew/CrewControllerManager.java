package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Crew;
import com.kh.model.vo.User;

// Crew part MainController
// Crew 시작 page
public class CrewControllerManager {

	private CrewDao crewDao; // Crew dao

	private CrewCreateController crewCreateController; // 크루 만들기 page controller
	private CrewController crewController; // 크루 특정 page controller

	public CrewControllerManager() {
		crewDao = new CrewDao(); // 한번만 생성 후 나머지 컨트롤러에서 같이 사용

		crewCreateController = new CrewCreateController(crewDao);
		crewController = new CrewController(crewDao);

	}

	public CrewDao getCrewDao() {
		return crewDao;
	}

	public CrewCreateController getCrewCreateController() {
		return crewCreateController;
	}

	public CrewController getCrewController() {
		return crewController;
	}

	public Crew selectCrew(String crewName) {
		return crewDao.selectCrew(crewName);
	}

	public void loadCrewList() {
		crewDao.loadCrewList();
	}

	public void removeCrew(String crewName) {
		crewDao.removeCrew(crewName);
	}
}
