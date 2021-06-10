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

import com.kh.model.vo.Crew;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.Feed;
import com.kh.model.vo.User;

// 크루리스트를 가지고 있는 CrewDao
public class CrewDao {

	private ArrayList<Crew> crewList;

	private static final String CREW_FILEPATH = "./resources/crewList.dat";

	public CrewDao() {
		crewList = new ArrayList<Crew>();

	}

	public CrewDao(User user) {
		this();
//		loadCrewList(); // 저장된 크루 리스트 읽어오기 중복으로 읽어오게됨 빼버리기

		updateUser(user);
	}

	// 로그인 또는 회원가입을 하여 객체 생성된 유저를 crew의 UserList에 해당 유저가 있다면
	// 객체가 2개가 되므로 같은 객체로 유지할 수 있도록 바꿔주기
	private void updateUser(User user) {
		// 미가입 상태이면 업데이트 제외
		if (user.getCrewName() == null) {
			return;
		}

		for (Crew crew : crewList) {
			ArrayList<User> userList = crew.getUserList();
			for (int i = 0; i < userList.size(); i++) {
				// 해당 유저를 크루에서 찾으면 읽어온 객체가 아닌 생성된 객체로 변경
				if (userList.get(i).getName().equals(user.getName())) {
					userList.remove(i); // 읽어온 객체는 지워버리고
					userList.add(user); // 생성한 객체를 넣어줌
					System.out.println("update user");
					return;
				}
			}
		}
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
		System.out.println("not found crew");
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
			System.out.println("crew removed : " + crew);
			crewList.remove(crew);
		}

		return crew; // 못찾았으면 null 반환 찾고 지웠으면 지워진 크루 반환
	}

	// 크루 가입 따로 크루 리스트 확인 없이 바로 해당 크루에 user 추가
	public void joinCrew(Crew crew, User user) {
		user.setCrewName(crew.getCrewName()); // 해당 유저의 크루 가입 여부 표시
		crew.getUserList().add(user);
	}

	// 크루 만들기
	public void createCrew(String crewName, String crewContents, User crewMaster) {
		Crew crew = new Crew(crewName, crewContents, crewMaster.getName());
		addCrew(crew); // 크루 추가하기
		crewMaster.setCrewName(crewName); // 유저에 크루 가입 확인하기
		joinCrew(crew, crewMaster); // 크루장이지만 크루에 크루원으로 추가하기
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

	// 테스트 데이터 만드는 메소드
	private static void createTest(Calendar cal, Random random, ArrayList<Exercise> exercises, User user, CrewDao dao) {

		// Crew 생성
		Crew crew = new Crew("KH", "KH 정보 교육원 (강남)", "문대훈");
		crew.setAccept(true);

		// Feed 세팅
		ArrayList<Feed> feedList = new ArrayList<Feed>();
		
		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		feedList.add(new Feed("c1", cal, "test" + random.nextInt(), "test" + random.nextInt()));
		
		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		feedList.add(new Feed("m1", cal, "test" + random.nextInt(), "test" + random.nextInt()));
		
		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		feedList.add(new Feed("s1", cal, "test" + random.nextInt(), "test" + random.nextInt()));
		
		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		feedList.add(new Feed("c2", cal, "test" + random.nextInt(), "test" + random.nextInt()));
		
		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		feedList.add(new Feed("u1", cal, "test" + random.nextInt(), "test" + random.nextInt()));
		crew.setFeedList(feedList);

		// User data 세팅
		ArrayList<User> userList = new ArrayList<>();
		/////////////////////////////////////////////////////////////////////////////////
		userList.add(new User("c1", "1234", "최용석", 20, 100, 50, '남', false));
		exercises = new ArrayList<Exercise>();

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));
		userList.get(userList.size() - 1).setExercises(exercises);

		userList.get(userList.size() - 1).setExercises(exercises);
		/////////////////////////////////////////////////////////////////////////////////
		userList.add(new User("m1", "1234", "문대훈", 20, 100, 50, '남', false));
		exercises = new ArrayList<Exercise>();

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));
		userList.get(userList.size() - 1).setExercises(exercises);

		userList.get(userList.size() - 1).setExercises(exercises);
		/////////////////////////////////////////////////////////////////////////////////
		userList.add(new User("s1", "1234", "서민지", 20, 100, 50, '여', false));
		exercises = new ArrayList<Exercise>();

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));
		userList.get(userList.size() - 1).setExercises(exercises);

		userList.get(userList.size() - 1).setExercises(exercises);
		/////////////////////////////////////////////////////////////////////////////////
		userList.add(new User("c2", "1234", "최선호", 20, 100, 50, '여', false));
		exercises = new ArrayList<Exercise>();

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));
		userList.get(userList.size() - 1).setExercises(exercises);

		userList.get(userList.size() - 1).setExercises(exercises);
		/////////////////////////////////////////////////////////////////////////////////
		userList.add(new User("u1", "1234", "유기용", 20, 100, 50, '남', false));
		exercises = new ArrayList<Exercise>();

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		userList.get(userList.size() - 1).setExercises(exercises);
		/////////////////////////////////////////////////////////////////////////////////

		crew.setUserList(userList);
		dao.addCrew(crew);

		crew = new Crew("런데이", "런데이에 오신 것을 환영합니다.", "런데이");
		crew.setAccept(false);
		userList = new ArrayList<>();

		/////////////////////////////////////////////////////////////////////////////////
		userList.add(new User("runday", "1234", "런데이", 99, 999, 99, '남', false));
		exercises = new ArrayList<Exercise>();

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));

		cal = Calendar.getInstance();
		cal.set(random.nextInt(2) + 2019, random.nextInt(12) + 1, random.nextInt(27) + 1);
		exercises.add(new Exercise(cal, 0, 0, 0, random.nextInt(7200), random.nextDouble() * 20, random.nextInt(1000),
				random.nextDouble() * 10, random.nextInt(5) + 1));
		userList.get(userList.size() - 1).setExercises(exercises);
		/////////////////////////////////////////////////////////////////////////////////

		crew.setUserList(userList);
		dao.addCrew(crew);
	}

	// 테스트용 실행 메소드
	public static void main(String[] args) {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		Calendar cal = Calendar.getInstance();
		Random random = new Random();

		User user = new User("k1", "1234", "김태훈", 31, 170, 85, '남', false);

		CrewDao dao = new CrewDao(user);

		createTest(cal, random, exercises, user, dao);
		dao.saveCrewList();

//		dao.loadCrewList();

		// 확인
		dao.printCrewList();
		System.out.println();

		for (User u : dao.getCrewList().get(0).getUserList()) {
			for (Exercise exercise : u.getExercises()) {
				System.out
						.println("[" + u.getId() + "," + u.getPw() + "]" + u.getName() + " -> " + exercise.toString());
			}
			System.out.println();
		}

//		dao.removeCrew("런데이3");
//		dao.printCrewList();
//		System.out.println();
//
//		dao.saveCrewList();
//
//		dao.loadCrewList();
//		dao.printCrewList();
	}

}
