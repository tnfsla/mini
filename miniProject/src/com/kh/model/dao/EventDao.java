package com.kh.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.model.vo.Event;

public class EventDao {
	
	private Event event;
	
	public EventDao() {
		// TODO Auto-generated constructor stub
		event = new Event();
	}
	
	public void saveEvent() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./resources/event.dat"))) {

			oos.writeObject(event);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("이벤트 저장 완료");
	}
	
	public void loadEvent() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./resources/event.dat"))) {

			event = (Event)ois.readObject();
			System.out.println("이벤트 리스트 읽기 완료");
		} catch (EOFException e) {
			
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void EventEnd() {
		event.setEventDate(0);
		event.setEventFlag("");
		event.setEventGoal(0);
		saveEvent();
	}
	

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public static void main(String[] args) {
		// event파일 초기화

		EventDao eventDao = new EventDao();
		eventDao.getEvent().setEventDate(0);
		eventDao.getEvent().setEventFlag("KM");
		eventDao.getEvent().setEventGoal(5);
	
//		eventDao.saveEvent();

		eventDao.loadEvent();

		System.out.println(eventDao.getEvent().toString());

	}
	

}
