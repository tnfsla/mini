package com.kh.controller.login;

import com.kh.model.dao.UserDao;

// Login 시 View로 부터 메소드를 호출받아 기능을 수행하게 되는 Controller
public class LoginController {

	private UserDao userDao;
	
	public LoginController() {
		userDao = new UserDao();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
}
