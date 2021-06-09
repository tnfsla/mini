package com.kh.view.admin;

import com.kh.controller.admin.Bridge;
import com.kh.controller.admin.GetTime;
import com.kh.model.vo.User;

public class testRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User("k1","1234","김태훈", 20, 100, 100, '남', false);
		
		GetTime t1 = new GetTime();
		Bridge ts = new Bridge();
		
		t1.ts = ts;
		t1.start();
		

		AdminViewManager avm = new AdminViewManager(user);

		
		
		
//		avm.setPriority(8);
//		t1.setPriority(2);
		
		avm.ts = ts;
		
		

		avm.start();


	}

}
