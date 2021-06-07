package com.kh.controller.crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.kh.model.dao.CrewDao;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;

// Crew 랭킹 page controller (Crew 특정 page controller 안에 존재)
public class CrewRankController {

	private CrewDao crewDao; // Crew dao 생성은 CrewControllerManager에서만

	public CrewRankController(CrewDao crewDao) {
		this.crewDao = crewDao;
	}

	// 크루원 유저를 거리 내림차순으로 정렬
	public void sortRankDistanceDES(ArrayList<User> userList) {

		Collections.sort(userList, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				Double d1 = new Double(0);
				Double d2 = new Double(0);

				// 운동기록의 모든 거리
				for (Exercise ex : o1.getExercises()) {
					d1 += ex.getDistance();
				}
				for (Exercise ex : o2.getExercises()) {
					d2 += ex.getDistance();
				}

				return d2.compareTo(d1);
			}
		});

	}

	public String[][] getRank(ArrayList<User> userList) {
		String[][] rank = new String[userList.size()][3];

		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			rank[i][0] = String.valueOf(i + 1);
			rank[i][1] = user.getName();

			double totalDistance = 0;
			for (Exercise ex : user.getExercises()) {
				totalDistance += ex.getDistance();
			}

			rank[i][2] = String.format("%.1f km", totalDistance);
		}

		return rank;
	}

	public String[][] getUserRank(ArrayList<User> userList, User user) {
		String[][] result = new String[1][1];

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equals(user.getName())) {
				result[0][0] = String.valueOf(i + 1);
			}
		}

		return result;
	}
}
