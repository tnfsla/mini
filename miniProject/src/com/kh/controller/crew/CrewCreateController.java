package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;

// 크루 만들기 page controller
public class CrewCreateController {

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만

	public CrewCreateController(CrewDao crewDao) {
		this.crewDao = crewDao;
	}

}
