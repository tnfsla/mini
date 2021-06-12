package com.kh.controller.admin;

import com.kh.model.dao.EventDao;

public class AdminEventController {
	
	private EventDao eventDao;
	
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
	
	

}
