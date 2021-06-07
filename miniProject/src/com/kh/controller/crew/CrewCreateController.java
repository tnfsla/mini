package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.User;

// 크루 만들기 page controller
public class CrewCreateController {

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만

	public CrewCreateController(CrewDao crewDao) {
		this.crewDao = crewDao;
	}

	// 크루 생성
	public void createCrew(String crewName, String crewContents, User crewMaster) {
		crewDao.createCrew(crewName, crewContents, crewMaster);
		
		// 확인
		crewDao.printCrewList();
		
		// 저장 (관리자가 읽어와서 승인을 해야하므로)
//		crewDao.saveCrewList(); // 테스트라서 일단 noSave 가입 여부도 다 파악해야하므로
	}

}
