package com.kh.controller.crew;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Crew;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;

// Crew 특정 page controller
public class CrewController {

	private CrewRankController crewRankController; // crew 랭킹 page controller
	private CrewFeedController crewFeedController; // crew 피드 page controller

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만

	public CrewController(CrewDao crewDao) {
		crewRankController = new CrewRankController(crewDao);
		crewFeedController = new CrewFeedController(crewDao);
		this.crewDao = crewDao;
	}

	public CrewRankController getCrewRankController() {
		return crewRankController;
	}
	
	public CrewFeedController getCrewFeedController() {
		return crewFeedController;
	}

	// 크루 가입
	public void joinCrew(Crew crew, User user) {
		crewDao.joinCrew(crew, user);
	}

	// 특정 크루 인원 반환
	public String getCrewNum(Crew crew) {
		return String.format("%d 명", crew.getCrewUserCount());
	}

	public String getCrewDistance(Crew crew) {
		double totalDistance = crew.getTotalDistance();

		return String.format("%.1f km", totalDistance);
	}

	public String getCrewTime(Crew crew) {
		long totalTime = crew.getTotalTime();

		long hour, min, sec;

		sec = totalTime % 60; // 초
		min = totalTime / 60 % 60; // 분
		hour = totalTime / 3600; // 시

		return String.format("%02d:%02d:%02d", hour, min, sec);
	}

}
