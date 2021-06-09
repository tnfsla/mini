package com.kh.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EventSettingP extends JPanel {
	private JTextField date;
	private JTextField goal;
	private AdminViewManager avm;
	private String eventDate;
	private int eventGoal;
	private String eventFlag;
	private Calendar cal;
	private int sTimeI = 0;

	/**
	 * Create the panel.
	 */
	public EventSettingP() {
		initailize();

	}
	


	private void initailize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JLabel lblEvent = new JLabel("EVENT 설정");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(52, 51, 257, 58);
		add(lblEvent);

		JLabel lblNewLabel = new JLabel("시작 날짜(yyyymmdd)");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 152, 199, 23);
		add(lblNewLabel);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(52, 185, 257, 32);
		add(date);

		JLabel lblNewLabel_1 = new JLabel("수치 입력");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 242, 199, 23);
		add(lblNewLabel_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("거리 (KM)");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(29, 271, 90, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("시간 (H)");
		rdbtnNewRadioButton_1.setBounds(119, 271, 121, 23);
		add(rdbtnNewRadioButton_1);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		this.add(rdbtnNewRadioButton);
		this.add(rdbtnNewRadioButton_1);

		goal = new JTextField();
		goal.setColumns(10);
		goal.setBounds(52, 300, 257, 32);
		add(goal);

		cal = Calendar.getInstance();

		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avm.convertPanel("main"); // 크루 만들기 page로
			}
		});
		btnNewButton.setBounds(52, 478, 113, 39);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("설정");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					eventFlag = "KM";
				} else {
					eventFlag = "H";
				}
				eventDate = date.getText();
				cal.set(Calendar.YEAR, Integer.parseInt(eventDate.substring(0, 4)));
				cal.set(Calendar.MONTH, Integer.parseInt(eventDate.substring(4, 6)) - 1);
				cal.set(Calendar.DATE, Integer.parseInt(eventDate.substring(6)));
//				long systemTime = System.currentTimeMillis();
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
//				String dTime = formatter.format(systemTime);
//				int dTimeI = Integer.parseInt(dTime);
				
//				long systemTime = System.currentTimeMillis();
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss", Locale.KOREA);
//				String dTime = formatter.format(systemTime);
//				long dTimeI = Long.parseLong(dTime);
				sTimeI = cal.get(Calendar.YEAR) * 10000 + (cal.get(Calendar.MONTH) + 1) * 100
						+ cal.get(Calendar.DATE);
				
				if (avm.ts.getSharedDataI() < sTimeI) {
					eventGoal = Integer.parseInt(goal.getText());
					System.out.println(eventGoal + eventFlag + "로 설정되었다.");

				} else {
					System.out.println("오늘 날짜인 이후만 입력하시오(" +avm.ts.getSharedDataI() + " 보다 큰 값)");
				}
				
				

				// eventGoal은 if문으로 넣어서, cal의 데이터와 현재시각을 비교해서 넘어가면 eventstart하고
				// 메인화면에 출력하는거 보여주고 goal값이 0이면 이벤트 종료상태로 보면 될듯

			}
		});
		btnNewButton_1.setBounds(196, 478, 113, 39);
		add(btnNewButton_1);
		
	}

	public int getEventGoal() {
		return eventGoal;
	}

	public void setEventGoal(int eventGoal) {
		this.eventGoal = eventGoal;
	}

	public String getEventFlag() {
		return eventFlag;
	}

	public void setEventFlag(String eventFlag) {
		this.eventFlag = eventFlag;
	}

	public EventSettingP(AdminViewManager avm) {
		this();
		this.avm = avm;

	}

	public int getsTimeI() {
		return sTimeI;
	}

	public void setsTimeI(int sTimeI) {
		this.sTimeI = sTimeI;
	}
	
	

}