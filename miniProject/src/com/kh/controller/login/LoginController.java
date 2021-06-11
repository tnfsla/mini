package com.kh.controller.login;

import com.kh.model.dao.UserDao;
import com.kh.model.vo.SystemUser;
import com.kh.model.vo.User;

// Login 시 View로 부터 메소드를 호출받아 기능을 수행하게 되는 Controller
public class LoginController {
	
	private SystemUser admin;

	private UserDao userDao;

	public LoginController() {
		admin = new SystemUser("admin", "1234", true);
		
		userDao = new UserDao();

		userDao.loadUserList();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	// userDao에 있는 userList로 부터 id와 password가 같은 user를 찾아서 return
	public User selectUser(String id, String password) {
		
		if (admin.getId().equals(id) && admin.getPw().equals(password)) {
			System.out.println("관리자 로그인");
			return new User(admin);
		}
		
		for (User user : userDao.getUserList()) {
			if (user.getId().equals(id) && user.getPw().equals(password)) {
				return user;
			}
		}

		return null;
	}
	
	public SystemUser getAdmin() {
		return admin;
	}
}
