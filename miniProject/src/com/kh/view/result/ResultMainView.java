package com.kh.view.result;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kh.controller.result.ResultController;
import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;
import com.kh.view.main.Main;

public class ResultMainView extends JPanel implements ActionListener {

	private Main main;
	private JFrame frame;
	ResultController rc = new ResultController();

	// ------------외형구현---------------
	Calendar cal; // 캘린더
	int year, month, date;
	JPanel pane = new JPanel();

	// 위에 버튼 추가
	JButton btn1 = new JButton(); // 이전버튼
	JButton btn2 = new JButton(); // 다음버튼
	JButton btn3 = new JButton(); // 뒤로가기 버튼

	// 위에 라벨추가
	JLabel yearlb = new JLabel("년");
	JLabel monthlb = new JLabel("월");

	// 년월 추가
	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
	JComboBox<Integer> monthCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	// 패널추가
	JPanel pane2 = new JPanel(new BorderLayout());
	JPanel pane3 = new JPanel(new BorderLayout());
	JPanel pane4 = new JPanel(null);
	JPanel datePane = new JPanel(new GridLayout(0, 7));
	JPanel title = new JPanel(new GridLayout(1, 7));
	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };

	private JLabel selDate;
	private JLabel dateexercise;
	private JPanel footerPanel;
	private JLabel lblHome;
	private JLabel exercise;
	private DefaultListModel exerciseModel;

	public ResultMainView(Main main) {
		this();

		this.main = main;

		CalendarMain(); // resultView의 경우 CalendarMain 메소드를 호출해야 UI 생성 (다른 클래스의 initialize와 같음)
	}

	public void setUser(User user) {
//		System.out.println("result update user");

		rc.setExercises(user.getExercises()); // 유저의 운동기록 부분 resultController에 세팅

		rc.printExercise();

		updateExercise();
	}

	// resultContorller에 세팅된 exercise에 따라 해당 정보들 다시 수정
	private void updateExercise() {
		int totalDistance = rc.getTotalDistance();
		String totalTime = rc.getTotalTime();
		int totalKcal = rc.getTotalKcal();
		double totalPace = rc.getTotalPace();

		exercise.setText("<html>총 거리 : " + totalDistance + "km<br>총 시간 : " + totalTime + "   <br>소모한 칼로리 :  "
				+ totalKcal + "kcal<br>페이스 : " + totalPace + " </html>");

		datePane.removeAll(); // 라벨 지우기
		day((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());

		exerciseModel.clear();

		for (Exercise exercise : rc.getExercises()) {
			exerciseModel.addElement(exercise);
		}
	}

	public ResultMainView() {

		setLayout(new BorderLayout());

		ImageIcon north = new ImageIcon("images/north.PNG");
		Image northImg = north.getImage();
		Image updatenorthImg = northImg.getScaledInstance(520, 30, Image.SCALE_SMOOTH);
		ImageIcon updatenorth = new ImageIcon(updatenorthImg);
		JLabel lblNewLabel = new JLabel(updatenorth);
		lblNewLabel.setBounds(30, 0, 420, 30);

		frame = new JFrame();

		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.add(lblNewLabel);

	}

	// 화면디자인
	public void CalendarMain() {

		ImageIcon Home = new ImageIcon("images/home2.PNG");
		Image HomeImg = Home.getImage();
		Image updateHomeImg = HomeImg.getScaledInstance(360, 20, Image.SCALE_SMOOTH);
		ImageIcon updateHome = new ImageIcon(updateHomeImg);

		lblHome = new JLabel(updateHome);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);

		ImageIcon Left = new ImageIcon("images/left1.PNG");
		Image HomeLeft = Left.getImage();
		Image updateLeftImg = HomeLeft.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon updateLeft = new ImageIcon(updateLeftImg);

		btn1 = new JButton(updateLeft);
		btn1.setBorderPainted(false);
		btn1.setBounds(0, 0, 15, 15);
		btn1.setBackground(Color.white);

		ImageIcon Right = new ImageIcon("images/right1.PNG");
		Image HomeRight = Right.getImage();
		Image updateRightImg = HomeRight.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon updateRight = new ImageIcon(updateRightImg);

		btn2 = new JButton(updateRight);
		btn2.setBorderPainted(false);
		btn2.setBounds(0, 0, 15, 15);
		btn2.setBackground(Color.white);

		ImageIcon back = new ImageIcon("images/back.PNG");
		Image Homeback = back.getImage();
		Image updatebackImg = Homeback.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon updateback = new ImageIcon(updatebackImg);
		btn3 = new JButton(updateback);
		btn3.setBorderPainted(false);
		btn3.setBounds(0, 0, 30, 30);
		btn3.setBackground(Color.white);

		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메인 페이지로 이동");
				main.convertPanel("main");

			}
		});

		// 홈 버튼 추가
//		JLabel lblHome = new JLabel("Home");
//		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
//		lblHome.setBounds(150, 561, 60, 29);
//		lblHome.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("메인 페이지로 이동");
//				main.convertPanel("main");
//			}
//		});
//		add(lblHome);

		// ------년도 월 구하기------------
		cal = Calendar.getInstance(); // 현재날짜
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		date = cal.get(Calendar.DATE);

		// 년
		for (int i = year - 100; i <= year + 50; i++) {
			yearModel.addElement(i);
		}

		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(year);

		// 월
		for (int i = 1; i <= 12; i++) {
			monthModel.addElement(i);
		}
		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(month);

		// 월화수목금토일
		for (int i = 0; i < titleStr.length; i++) {
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);

			title.setBackground(Color.white);
			if (i == 0) {
				lbl.setForeground(Color.red);
			} else if (i == 6) {
				lbl.setForeground(Color.blue);
			}
			title.add(lbl);
		}

		// 날짜 출력
		day(year, month);

		// 입력받기

		int totalDistance = rc.getTotalDistance();
		String totalTime = rc.getTotalTime();
		int totalKcal = rc.getTotalKcal();
		double totalPace = rc.getTotalPace();

		exercise = new JLabel("<html>총 거리 : " + totalDistance + "km<br>총 시간 : " + totalTime + "   <br>소모한 칼로리 :  "
				+ totalKcal + "kcal<br>페이스 : " + totalPace + " </html>");

		selDate = new JLabel();

		selDate.setBounds(108, 21, 193, 60);
		add(selDate);

		// ----------------------------
		frame.setTitle("운동기록 확인"); //////

		pane.add(btn1);
		pane.add(yearCombo);
		pane.add(yearlb);
		pane.add(monthCombo);
		pane.add(monthlb);
		pane.add(btn2);

		pane2.add(title, "North");
		pane2.add(datePane);

		pane3.add(exercise); //
		add(pane3, BorderLayout.NORTH); // 사용자 운동기록 통계
		frame.getContentPane().setBackground(Color.WHITE);
		exercise.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(360, 300));
		panelBottom.setLayout(new BorderLayout());
		add(panelBottom, BorderLayout.SOUTH);

		JScrollPane scrollPaneExercises = new JScrollPane();
		scrollPaneExercises.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneExercises.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneExercises.setPreferredSize(new Dimension(360, 200));

		JList listExercise = new JList();

		listExercise.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (listExercise.getSelectedIndex() != -1) {

					Exercise ex = rc.getExercises().get(listExercise.getSelectedIndex());

					updateSelectDate(ex);
				}
			}
		});

		exerciseModel = new DefaultListModel<Exercise>();
		ExerciseRenderer exerciseRenderer = new ExerciseRenderer();

		listExercise.setModel(exerciseModel);
		listExercise.setCellRenderer(exerciseRenderer);

		scrollPaneExercises.setViewportView(listExercise);

		panelBottom.add(scrollPaneExercises, BorderLayout.CENTER);
		panelBottom.add(lblHome, BorderLayout.SOUTH);

		JPanel calendarPanel = new JPanel();
		calendarPanel.setLayout(new BorderLayout());
		calendarPanel.add(pane, BorderLayout.NORTH); // 달력 날짜 선택 콤보 박스
		calendarPanel.add(pane2, BorderLayout.CENTER); // 달력 날짜들

		add(calendarPanel, BorderLayout.CENTER);

		frame.getContentPane().add(selDate);

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.setVisible(true);
				pane2.setVisible(true);
				pane3.setVisible(true);
				pane4.setVisible(true);
				frame.setVisible(false);
			}
		});

		frame.getContentPane().add(btn3);
		frame.setVisible(false);

		dateexercise = new JLabel();
		dateexercise.setBounds(0, 82, 434, 120);
		dateexercise.setFont(new Font("맑은 고딕", Font.PLAIN, 17));

		frame.getContentPane().add(dateexercise);

		pane.setBackground(Color.white);
		pane4.setBackground(Color.white);

		pane3.setBackground(Color.white);
		yearCombo.setBackground(Color.white);
		monthCombo.setBackground(Color.white);

		// 각종 명령어

		frame.setResizable(false); ///////////
		setBounds(0, 0, 360, 600); ///////

		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ////////

		// ----------기능구현----------
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
	}

	// 기능구현
	public void actionPerformed(ActionEvent e) {

		Object eventObj = e.getSource();
		if (eventObj instanceof JComboBox) {
			datePane.setVisible(false); // 보여지는 패널을 숨킨다.
			datePane.removeAll(); // 라벨 지우기
			day((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());

			datePane.setVisible(true); // 패널 재출력

		} else if (eventObj instanceof JButton) {
			JButton eventBtn = (JButton) eventObj;
			int yy = (Integer) yearCombo.getSelectedItem();
			int mm = (Integer) monthCombo.getSelectedItem();
			if (eventBtn.equals(btn1)) { // 전달
				if (mm == 1) {
					yy--;
					mm = 12;
				} else {
					mm--;
				}
			} else if (eventBtn.equals(btn2)) { // 다음달
				if (mm == 12) {
					yy++;
					mm = 1;
				} else {
					mm++;
				}
			}
			yearCombo.setSelectedItem(yy);
			monthCombo.setSelectedItem(mm);

		}
	}

	public ResultController getRc() {
		return rc;
	}

	// 날짜출력
	public void day(int year, int month) {
		Calendar date = Calendar.getInstance();// 오늘날짜 + 시간
		date.set(year, month - 1, 1);
		int week = date.get(Calendar.DAY_OF_WEEK);

		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 공백출력

		for (int space = 1; space < week; space++) {
			datePane.add(new JLabel("\t"));

		}

		// 날짜 출력
		for (int i = 1; i <= lastDay; i++) {
			int day = i;

			JButton jbt = new JButton();
			JLabel jlb1 = new JLabel();

			if (rc.getDate(year, month, day) == true) {

				jbt = new JButton(String.valueOf(day));
				datePane.add(jbt);

			} else {
				jlb1 = new JLabel(String.valueOf(day));
				datePane.add(jlb1);
				jlb1.setHorizontalAlignment(SwingConstants.CENTER);

			}

			jbt.setFocusPainted(false);
			jbt.setContentAreaFilled(false);
			datePane.setBackground(Color.white);
			jbt.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mousePressed(e);

					Exercise ex = rc.selectExercise(year, month, day);
					updateSelectDate(ex);

				}

			});
			cal.set(year, month - 1, day);
			int Week = cal.get(Calendar.DAY_OF_WEEK);

			if (Week == 1) {
				jbt.setForeground(Color.red);
			} else if (Week == 7) {
				jbt.setForeground(Color.BLUE);
			}

		}
	}

	protected void updateSelectDate(Exercise ex) {

		Calendar cal = ex.getDates();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		
		selDate.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		selDate.setText(String.format("%02d년 %02d월 %02d일", year, month, day));
		dateexercise.setText("<html> 달린 거리 : " + ex.getDistance() + "km <br> 달린 시간 : " + rc.secToHHMMSS(ex.getRunTime())
				+ "<br> 소모한 칼로리 : " + ex.getCalorie() + "kcal<br> 평균 페이스 : " + ex.getPace() + "<br> 별점 : "
				+ ex.getStar() + "개</html>");
		frame.setForeground(Color.white);
		frame.setVisible(true);
	}

	private class ExerciseRenderer implements ListCellRenderer {

		private ResultExerciseListPanel panel;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

			panel = new ResultExerciseListPanel();
			panel.setExercise((Exercise) value);

			return panel;
		}
	}
}