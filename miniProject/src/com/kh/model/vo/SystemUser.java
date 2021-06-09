package com.kh.model.vo;//06.04(수)최용석

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemUser {

	private String id;
	private String pw;
	private boolean adminFlag; // false 일반회원 , true 관리자

	public SystemUser() {
		// TODO Auto-generated constructor stub
	}

	public SystemUser(String id, String pw, boolean adminFlag) {
		super();
		this.id = id;
		this.pw = pw;
		this.adminFlag = adminFlag;
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

}