package com.kh.controller.admin;

import com.kh.model.dao.EventDao;
import com.kh.model.dao.UserDao;

public class AdminEventController {
	
	private EventDao eventDao;
	private UserDao userDao;
	
	public AdminEventController() {
		eventDao = new EventDao();
		eventDao.loadEvent();
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	public void loadEvent() {
		eventDao.loadEvent();
	}
	
	public void saveEvent() {
		eventDao.saveEvent();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
