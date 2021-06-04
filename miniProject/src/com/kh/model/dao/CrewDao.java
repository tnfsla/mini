package com.kh.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.model.vo.Crew;

// 크루리스트를 가지고 있는 CrewDao
public class CrewDao {

	private ArrayList<Crew> crewList;

	private static final String CREW_FILEPATH = "./resources/crewList.dat";

	public CrewDao() {
		crewList = new ArrayList<Crew>();
	}

	// crewList 반환
	public ArrayList<Crew> getCrewList() {
		return crewList;
	}

	// 특정 크루 선택하기
	public Crew selectCrew(String crewName) {
		for (Crew crew : crewList) {
			if (crew.getCrewName().equals(crewName)) {
				return crew;
			}
		}
		return null; // 못찾으면 null 반환
	}

	// 특정 크루 추가하기
	public void addCrew(Crew crew) {
		crewList.add(crew);
	}

	// 특정 크루 삭제하기
	public Crew removeCrew(String crewName) {
		Crew crew = selectCrew(crewName);

		if (crew != null) {
			crewList.remove(crew);
		}

		return crew; // 못찾았으면 null 반환 찾고 지웠으면 지워진 크루 반환
	}

	// 생성된 크루들 읽어오기
	public void loadCrewList() {

		crewList.clear(); // 혹시나 들어있나 싶어 다 clear

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CREW_FILEPATH))) {

			while (true) {
				crewList.add((Crew) ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("크루 리스트 읽기 완료");
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 크루 정보 저장하기
	public void saveCrewList() {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CREW_FILEPATH))) {

			for (Crew crew : crewList) {
				oos.writeObject(crew);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("크루 리스트 저장 완료");
	}

	// 크루 리스트 콘솔 출력 (테스트 용)
	public void printCrewList() {

		for (Crew crew : crewList) {
			System.out.println(crew);
		}
	}

	// 테스트용 실행 메소드
	public static void main(String[] args) {
		CrewDao dao = new CrewDao();

		dao.addCrew(new Crew("런데이1", "런데이장4", "런데이 화이팅1"));
		dao.addCrew(new Crew("런데이2", "런데이장3", "런데이 화이팅3"));
		dao.addCrew(new Crew("런데이3", "런데이장2", "런데이 화이팅2"));
		dao.addCrew(new Crew("런데이4", "런데이장1", "런데이 화이팅4"));		
		dao.printCrewList();
		System.out.println();
		
		dao.removeCrew("런데이3");
		dao.printCrewList();
		System.out.println();
		
		dao.saveCrewList();

		dao.loadCrewList();
		dao.printCrewList();
	}
}
