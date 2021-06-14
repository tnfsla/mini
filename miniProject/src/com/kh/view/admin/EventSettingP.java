package com.kh.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kh.controller.admin.AdminEventController;
import com.kh.model.vo.Event;
import java.awt.Color;

public class EventSettingP extends JPanel {
	private JTextField date;
	private JTextField goal;
	private AdminViewManager avm;
	private String eventDate;
	private int eventGoal;
	private String eventFlag;
	private long sTimeI = 0;
	private long dTimeI = 0;
	private AdminEventController aec;

	/**
	 * Create the panel.
	 */
	public EventSettingP() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		initailize();

	}

	public EventSettingP(AdminViewManager avm, AdminEventController aec) {
		this();
		this.avm = avm;
		this.aec = aec;

	}

	private void initailize() {
		setBounds(0, 0, 360, 600);
		setLayout(null);

		JLabel lblEvent = new JLabel("EVENT 설정");
		lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvent.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblEvent.setBounds(52, 51, 257, 58);
		add(lblEvent);

		JLabel lblNewLabel = new JLabel("시작 날짜(yyyyMMddHHmmss)");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 152, 230, 23);
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
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(29, 271, 90, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("시간 (H)");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
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

		JButton btnNewButton = new JButton("이전");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avm.convertPanel("admin_main"); // 크루 만들기 page로
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
				sTimeI = Long.parseLong(eventDate);

				long systemTime = System.currentTimeMillis();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
				String dTime = formatter.format(systemTime);
				dTimeI = Long.parseLong(dTime); // 현재시각 받아와서 정해진 format의 long형으로 바꿔줌

				if (dTimeI < sTimeI) {
					eventGoal = Integer.parseInt(goal.getText());
					System.out.println(eventGoal + eventFlag + "로 설정되었다.");

					for (int i = 0; i < aec.getUserDao().getUserList().size(); i++) {
						aec.getUserDao().getUserList().get(i).setHasBedge(false);
					} // 설정을 누르면 모든 user들 새로운 이벤트를 시작하므로 모든 bedge false

					aec.getEventDao().setEvent(new Event(eventFlag, sTimeI, eventGoal));
					aec.getEventDao().saveEvent();
					aec.getUserDao().saveUserList();

				} else {
					System.out.println("오늘 날짜인 이후만 입력하시오(" + dTimeI + " 보다 큰 값)");
				}

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

	public long getsTimeI() {
		return sTimeI;
	}

	public void setsTimeI(long sTimeI) {
		this.sTimeI = sTimeI;
	}

	public long getdTimeI() {
		return dTimeI;
	}

	public void setdTimeI(long dTimeI) {
		this.dTimeI = dTimeI;
	}

}
