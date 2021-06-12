package com.kh.controller.login;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.User;

// 회원가입 회원가입 View로부터 메소드를 호출받아 기능을 수행하는 Controller
public class JoinController {

	private UserDao userDao;

	public JoinController() {

	}

	public JoinController(UserDao userDao) {
		this.userDao = userDao;
	}

	// 해당 아이디가 userDao에 있는지 확인하여 true false 반환
	public boolean hasUserId(String id) {

		for (User user : userDao.getUserList()) {
			if (user.getId().equals(id))
				return true;
		}

		return false;
	}

	// 해당 정보들로 User 객체를 생성하여 userList에 넣기
	public void createUser(String name, String id, String pw, int age, char gender, double height,
			double weight) {

		userDao.getUserList().add(new User(id, pw, name, age, height, weight, gender, false));
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void printUser() {
		System.out.println("User 정보 일람");
		
		for (User user : userDao.getUserList()) {
			System.out.println(user);
		}
	}

	public void saveUserList() {
		userDao.saveUserList();
	}
	

}
