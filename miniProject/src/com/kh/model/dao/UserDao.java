package com.kh.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.txt"))) {

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
	}

	// 유저 정보들을 객체 형태로 읽어오기
	public void loadUserList() {

		ArrayList<User> userList = new ArrayList<User>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("User.txt"))) {
			int i = 0;
			while (true) {
				userList.add((User) ois.readObject());

				System.out.println(userList.get(i));
				i++;
			}
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

	// id와 password로부터 UserList에서 User를 찾아 반환
	// 못찾으면 return null
	public  User selectUser(String id, String pwd) {
	
		
		return null;
	}
}
