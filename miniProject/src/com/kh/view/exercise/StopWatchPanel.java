package com.kh.view.exercise;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.model.vo.Exercise;
import com.kh.model.vo.User;
import com.kh.view.main.Main;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class StopWatchPanel extends JPanel implements ActionListener, Runnable {

	private Main main;
	private User user;

	private JPanel panel;
	private JTextArea t;
	private JLabel hour;
	private JLabel min;
	private JLabel sec;
	private JLabel s1;
	private JLabel s2;
	private JTextField tf;

	int h = 0;
	int m = 0;
	int s = 0;
	int ms = 0;
	long start;
	long end;
	long actTime;
	private Thread thread;
	int s_hour, s_min, s_sec;
	int e_hour, e_min, e_sec;
	int f_hour, f_min, f_sec;
	int start_time, stop_time, for_time;
	String save_time;
	boolean flag;

	static int runHour;
	static int runMin;
	static String runSec;

//	public static int runHour;
//	public static int runMin;
//	public static int runSec;

	// private StopWatchController stopWatchController;

	private JButton startB;
	private JButton stopB;

	public StopWatchPanel() {

		ImageIcon ss1 = new ImageIcon("./images/star1.png");
		ImageIcon ss2 = new ImageIcon("./images/star2.png");

		setLayout(null);
		setBounds(0, 0, 360, 600);

		t = new JTextArea(
				"운동 시간 측정을 위해" + "\n" + "운동시작 버튼을 눌러주세요." + "\n" + "운동이 끝난 후에는" + "\n" + "반드시 종료버튼을 눌러 정보를 기록해 주세요.");
		t.setLocation(37, 28);
		t.setSize(286, 90);
		add(t);

		hour = new JLabel("00");
		min = new JLabel("00");
		sec = new JLabel("00");

		hour.setSize(66, 100);
		min.setSize(66, 100);
		sec.setSize(66, 100);

		hour.setLocation(40, 110);
		min.setLocation(140, 110);
		sec.setLocation(240, 110);

		hour.setFont(new Font("Agency FB", Font.BOLD, 70));
		min.setFont(new Font("Agency FB", Font.BOLD, 70));
		sec.setFont(new Font("Agency FB", Font.BOLD, 70));

		add(hour);
		add(min);
		add(sec);

		s1 = new JLabel(":");
		s2 = new JLabel(":");

		s1.setLocation(115, 135);
		s1.setSize(20, 40);
		s1.setFont(new Font("Agency FB", Font.BOLD, 50));

		s2.setLocation(220, 135);
		s2.setSize(20, 40);
		s2.setFont(new Font("Agency FB", Font.BOLD, 50));

		add(s1);
		add(s2);

		startB = new JButton("start");
		startB.setLocation(70, 200);
		startB.setSize(70, 30);
		startB.addActionListener(this);
		add(startB);

		stopB = new JButton("stop");
		stopB.setLocation(210, 200);
		stopB.setSize(70, 30);
		stopB.addActionListener(this);
		add(stopB);

		// 거리 입력

		JLabel km1 = new JLabel("거리");
		km1.setHorizontalAlignment(SwingConstants.CENTER);
		km1.setLocation(37, 250);
		km1.setSize(50, 40);
		add(km1);

		JTextField km2 = new JTextField("0.0");
		km2.setHorizontalAlignment(SwingConstants.RIGHT);
		km2.setLocation(105, 251);
		km2.setSize(150, 40);
		add(km2);

		JLabel km3 = new JLabel("km");
		km3.setHorizontalAlignment(SwingConstants.CENTER);
		km3.setLocation(273, 250);
		km3.setSize(50, 40);
		add(km3);

		km2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				km2.setText("");
			}
		});
		// 페이스 출력
		JLabel pace1 = new JLabel("달리기 페이스");
		pace1.setHorizontalAlignment(SwingConstants.CENTER);
		pace1.setLocation(50, 350);
		pace1.setSize(100, 30);
		add(pace1);

		JLabel pacef = new JLabel("00.00");
		pacef.setHorizontalAlignment(SwingConstants.CENTER);
		pacef.setLocation(50, 392);
		pacef.setSize(100, 30);
		add(pacef);

		// 칼로리
		JLabel kcal1 = new JLabel("칼로리 소모량");
		kcal1.setHorizontalAlignment(SwingConstants.CENTER);
		kcal1.setLocation(200, 350);
		kcal1.setSize(100, 30);
		add(kcal1);

		JLabel kcalf = new JLabel("0");
		kcalf.setHorizontalAlignment(SwingConstants.CENTER);
		kcalf.setLocation(200, 390);
		kcalf.setSize(100, 30);
		add(kcalf);

		// 확인
		JButton cfA = new JButton("확인");
		cfA.setLocation(145, 301);
		cfA.setSize(60, 30);
		add(cfA);

		cfA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 사용자가 입력한 값을 계산하기 위해 형변환
				int hi = Integer.parseInt(hour.getText());
				int mi = Integer.parseInt(min.getText());
				int si = Integer.parseInt(sec.getText());
				double ki = Double.valueOf(km2.getText()).doubleValue();

				double rrp = (((hi * 60) + mi + (si / 60)) / ki); // 페이스 계산
				String fp = String.format("%.2f", rrp); // 계산된 페이스값 문자열로 저장

				int kc = ((hi * 60) + mi + (si / 60)) * 6; // 칼로리계산 (분당 6kcal로리 소모)
				String kcf = Integer.toString(kc);

				pacef.setText(fp); // 페이스값을 보여주기
				kcalf.setText(kcf); // 칼로리값 보여주기

			}
		});
		JLabel star1 = new JLabel("운동 평가");
		star1.setLocation(45, 430);
		star1.setSize(80, 30);
		add(star1);

		JLabel starf = new JLabel();
		starf.setLocation(114, 450);
		starf.setSize(41, 30);
		add(starf);

		JButton s1 = new JButton();
		s1.setIcon(ss1);
		s1.setLocation(35, 460);
		s1.setSize(60, 60);
		add(s1);

		JButton s2 = new JButton(ss1);
		s2.setLocation(95, 460);
		s2.setSize(60, 60);
		add(s2);

		JButton s3 = new JButton(ss1);
		s3.setLocation(155, 460);
		s3.setSize(60, 60);
		add(s3);

		JButton s4 = new JButton(ss1);
		s4.setLocation(215, 460);
		s4.setSize(60, 60);
		add(s4);
		JButton s5 = new JButton(ss1);
		s5.setLocation(275, 460);
		s5.setSize(60, 60);
		add(s5);

		s1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss1);
				s3.setIcon(ss1);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
				starf.setText("1");
			}
		});
		s2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss1);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
				starf.setText("2");
			}
		});
		s3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss2);
				s4.setIcon(ss1);
				s5.setIcon(ss1);
				starf.setText("3");
			}
		});
		s4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss2);
				s4.setIcon(ss2);
				s5.setIcon(ss1);
				starf.setText("4");
			}
		});
		s5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				s1.setIcon(ss2);
				s2.setIcon(ss2);
				s3.setIcon(ss2);
				s4.setIcon(ss2);
				s5.setIcon(ss2);
				starf.setText("5");
			}
		});
		// 저장
		JButton save = new JButton("저장");
		save.setLocation(145, 530);
		save.setSize(70, 40);
		add(save);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar dates = Calendar.getInstance();

				int runHour = Integer.parseInt(hour.getText());
				int runMin = Integer.parseInt(min.getText());
				int runSec = Integer.parseInt(sec.getText());
				long runTime = (runHour * 3600) + (runMin * 60) + runSec;
				double distance = Double.valueOf(km2.getText()).doubleValue();
				double calorie = Double.valueOf(kcalf.getText()).doubleValue();
				double pace = Double.valueOf(pacef.getText()).doubleValue();
				int star = Integer.parseInt(starf.getText());

				user.addExercise(new Exercise(dates, runHour, runMin, runSec, runTime, distance, calorie, pace, star));

				System.out.println("운동기록이 저장되었습니다.");
				System.out.println(user.getExercises());

				main.convertPanel("main");
			}
		});

		setVisible(true);

	}

	public StopWatchPanel(Main main) {
		this();
		this.main = main;
	}

	public void setUser(User user) {
		this.user = user;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("start")) {
			if (!flag) {
				start = System.currentTimeMillis();
				if (actTime > 0) {
					start = (start - actTime);
				}
				flag = true;
				thread = new Thread(this);
				thread.start();
			}
		} else {
			flag = false;
		}
	}

	@Override
	public void run() {
		while (flag) {
			end = System.currentTimeMillis();
			ms = (int) ((end - start) / 10);
			h = (ms / (3600 * 100));
			m = ((ms - h * 3600 * 100) / (60 * 100));
			s = ((ms - h * 3600 * 100 - m * 60 * 100) / 100);
			ms = (ms - h * 3600 * 100 - m * 60 * 100 - s * 100);

			// lbl1.setText(ms < 10 ? "0" + ms : "" + ms);
			sec.setText(s < 10 ? "0" + s : "" + s);
			min.setText(m < 10 ? "0" + m : "" + m);
			hour.setText(h < 10 ? "0" + h : "" + h);

		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// actTime = end - start;

		// 운동정보 저장
		System.out.println("운동 시간 : " + h + "시간" + m + "분" + s + "초");

//		runHour = h;
//		runMin = m;
//		runSec = Integer.toString(s);
		//long runTime = (h * 3600) + (m * 60) + s;

		// System.out.println(runHour + " " + runMin + " " + runSec);

		
	}

	public int runHour() {

		return runHour;
	}

	public int runMin() {

		return runMin;
	}

	public String runSec(String runSec) {
		runSec = Integer.toString(s);
		return runSec;
	}

}
