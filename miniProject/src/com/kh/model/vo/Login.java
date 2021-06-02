package com.kh.model.vo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int pass = 0;
		System.out.println("ID: ");
		String id = sc.nextLine();
		System.out.println("PW: ");
		String pw = sc.nextLine();
		File file = new File("C:\\Users\\reton\\Desktop\\MemberDB.txt");
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			try {
				while ((line = bufReader.readLine()) != null) {
					System.out.println(line.indexOf(id) + "\t" + line.indexOf(pw));
					int passId = line.indexOf(id);
					int passPw = line.indexOf(pw);
					if (passId != -1 && passPw != -1) {
						System.out.println("로그인 성공");
						pass = 1;
					}
					
					}
				if (pass == 0) {
					System.out.println("로그인 실패");
					bufReader.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
