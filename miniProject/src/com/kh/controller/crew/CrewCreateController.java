package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Crew;

// 크루 만들기 page controller
public class CrewCreateController {

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만

	public CrewCreateController(CrewDao crewDao) {
		this.crewDao = crewDao;
	}

	// 크루 생성
	public void createCrew(String crewName, String crewContents, String crewMasterName) {
		crewDao.addCrew(new Crew(crewName, crewContents, crewMasterName));
		
		// 확인
		crewDao.printCrewList();
		
		// 저장 (관리자가 읽어와서 승인을 해야하므로)
		crewDao.saveCrewList();
	}

}
