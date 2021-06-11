package com.kh.view.update;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kh.model.vo.User;
import com.kh.view.main.Main;

public class EditViewManager {
	private Main main;
	JPanel editMain;
	JPanel userChange;
	JPanel userMain;
	JPanel passwordChange;
	JPanel  userCompare;
	
	private Map<String, JPanel> panelMap;

	private User user;
	
	
	public EditViewManager() {
		// TODO Auto-generated constructor stub
		initPanel();
	}
	
	public EditViewManager(Main main , User user) {
//		user = new User("k1","1234","김태훈", 20, 100, 100, '남', false);
		this.main = main;
		this.user = user;
		initPanel();

	}
	
	public void initPanel() {
		editMain = new EditUserPanel(this);
		userChange = new UserChange(this);
		userMain = new UserMain(this);
		passwordChange = new PasswordChangeView(this);
		userCompare = new UserCompare(this);

		if(main!= null)
			panelMap = main.getPanelMap();
		else
			panelMap = new LinkedHashMap<String, JPanel>();

		panelMap.put("main", editMain);
		panelMap.put("userChange", userChange);
		panelMap.put("userMain", userMain);
		panelMap.put("passwordChange", passwordChange);
		panelMap.put("userCompare", userCompare);
	}
	
	

	
	public void addPanels(JFrame frame) {
		for (String key : panelMap.keySet()) {
			JPanel panel = panelMap.get(key);
			panel.setVisible(false);

			frame.getContentPane().add(panel);
		}
	}
	
	
	public void convertPanel(String panelName) {
		for (String key : panelMap.keySet()) {
			JPanel panel = panelMap.get(key);

			panel.setVisible(false);
			if(key == panelName) {
				panel.setVisible(true);
			}
		}

	}
	
	public void updatePanel(String panelName) {
		for (String key : panelMap.keySet()) {
			JPanel panel = panelMap.get(key);

			panel.setVisible(false);
			if(key == panelName) {
				panel.setVisible(true);
			}
		}

	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public JPanel getEditMain() {
		return editMain;
	}


	public void setEditMain(JPanel editMain) {
		this.editMain = editMain;
	}
		
	
	
}
