package com.kh.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JDialog;

import com.kh.model.dao.EventDao;
import com.kh.model.dao.UserDao;
import com.kh.view.admin.ErrorD;
import com.kh.view.admin.EventEndAlertD;

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

	public void eventDeadline() {
		// TODO Auto-generated method stub
		long sTime1 = getEventDao().getEvent().getEventDate();
		long sTime2 = sTime1 / 1000000;
		long sTime3 = sTime1 - (sTime2) * 1000000;

		long dTimeI = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
		String dTime = formatter.format(dTimeI);
		long dTime1 = Long.parseLong(dTime);
		long dTime2 = dTime1 / 1000000;
		long dTime3 = dTime1 - (dTime1 / 1000000) * 1000000;

		if (sTime2 != 0 && sTime2 <= dTime2) {
			if (sTime3 <= dTime3) {
				eventEndAlert();

			} else {
				if (getEventDao().getEvent().isEventStart()) {
					eventEndAlert();
				} else {
					errorAlert();
				}
			}

		} else {
			if (getEventDao().getEvent().isEventStart()) {
				eventEndAlert();
			} else {
				errorAlert();
				// 해당 조건문을 넣은 이유는 프로그램을 종료하였다가 다시 켰을때,
				// 이벤트 마감버튼을 누르면 마치 이전 날짜를 입력한것 처럼 표시 되어서
				// eventStart를 flag로서 작동하게 하여, settingDate가 현재 날짜보다 적더라도,
				// flag가 true면 마감 alert으로 갈 수 있게함
			}
		}
	}

	private void eventEndAlert() {
		EventEndAlertD dialog = new EventEndAlertD(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	private void errorAlert() {
		ErrorD dialog1 = new ErrorD(this);
		dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog1.setVisible(true);
	}

	public int hasBedgeCount() {
		int sum = getUserDao().userCount();
		int cnt = 0;
		for (int i = 0; i < sum; i++) {
			if (getUserDao().getUserList().get(i).isHasBedge())
				cnt++;
		}

		return cnt;

	}

}
