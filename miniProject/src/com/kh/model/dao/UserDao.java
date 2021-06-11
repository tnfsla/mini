package com.kh.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;

// User 정보들을 다루게 되는 DAO
public class UserDao {

	// User 정보들을 저장하는 ArrayList 회원가입시 User 객체를 생성하여 여기다 넣어주고
	// 프로그램 시작 및 회원가입 등의 경우 User 정보들을 저장하고 읽어오기도 하여야함
	private ArrayList<User> userList;

	public UserDao() {
		userList = new ArrayList<User>();
	}

	// 유저 정보들을 객체 형태로 저장
	public void saveUserList() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./resources/userList.dat"))) {

			for (int i = 0; i < userList.size(); i++) {
				oos.writeObject(userList.get(i));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("유저 리스트 저장 완료");
	}

	// 유저 정보들을 객체 형태로 읽어오기
	public void loadUserList() {

		userList.clear();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./resources/userList.dat"))) {

			while (true) {
				userList.add((User) ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("유저 리스트 읽기 완료");
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

	// id와 password로부터 UserList에서 User를 찾아 반환
	// 못찾으면 return null
	public User selectUser(String id, String pwd) {

		for (User user : userList) {
			if (user.getId().equals(id) && user.getPw().equals(pwd)) {
				return user;
			}
		}

		System.out.println("유저 검색 불가");
		return null;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public static void main(String[] args) {
		// UserDao 만들어 저장

		UserDao userDao = new UserDao();
		userDao.getUserList().add(new User("c1", "1234", "최용석", 20, 100, 50, '남', false));
		userDao.getUserList().add(new User("m1", "1234", "문대훈", 20, 100, 50, '남', false));
		userDao.getUserList().add(new User("s1", "1234", "서민지", 20, 100, 50, '여', false));
		userDao.getUserList().add(new User("c2", "1234", "최선호", 20, 100, 50, '여', false));
		userDao.getUserList().add(new User("u1", "1234", "유기용", 20, 100, 50, '남', false));
		userDao.getUserList().add(new User("runday", "1234", "런데이", 99, 999, 99, '남', false));

		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		Calendar cal = Calendar.getInstance();
		Random random = new Random();

		for (User user : userDao.getUserList()) {
			user.setCrewName("KH");

			if (user.getName().equals("런데이"))
				user.setCrewName("런데이");

			exercises = new ArrayList<Exercise>();

			cal = Calendar.getInstance();
			cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
			exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20,
					random.nextInt(1000), random.nextDouble() * 10, random.nextInt(5) + 1));

			cal = Calendar.getInstance();
			cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
			exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20,
					random.nextInt(1000), random.nextDouble() * 10, random.nextInt(5) + 1));

			cal = Calendar.getInstance();
			cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
			exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20,
					random.nextInt(1000), random.nextDouble() * 10, random.nextInt(5) + 1));

			user.setExercises(exercises);
		}

		userDao.saveUserList();

//		userDao.loadUserList();

		for (User user : userDao.getUserList()) {
			System.out.println(user);
		}

	}
}
