package com.kh.model.vo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		File file = new File("C:\\Users\\reton\\Desktop\\MemberDB.txt");
		try {
			FileWriter filewriter = new FileWriter(file, true);
			if (file.isFile() && file.canWrite()) {
				System.out.println("ID를 입력하세요: ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				System.out.println("PW를 입력하세요: ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				System.out.println("이름: ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				System.out.println("나이: ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				System.out.println("키: ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				System.out.println("몸무게: ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				System.out.println("성별(M/F): ");
				filewriter.append(sc.nextLine());
				filewriter.append("\t");
				
				}

				System.out.println("회원가입이 완료되었습니다.");

			}
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}