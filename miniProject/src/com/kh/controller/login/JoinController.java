package com.kh.controller.login;

import com.kh.model.dao.UserDao;

// 회원가입 회원가입 View로부터 메소드를 호출받아 기능을 수행하는 Controller
public class JoinController {

	private UserDao userDao;
	
	public JoinController() {
		
	}
	
	public JoinController(UserDao userDao) {
		this.userDao = userDao;
	}
}
