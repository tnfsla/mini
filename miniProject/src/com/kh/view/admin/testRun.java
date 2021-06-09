//package com.kh.view.admin;
//
//import com.kh.controller.admin.Bridge;
//import com.kh.controller.admin.EventStart;
//import com.kh.controller.admin.GetTime;
//import com.kh.model.vo.User;
//
//public class testRun {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		User user = new User("k1","1234","김태훈", 20, 100, 100, '남', false);
//		
//		GetTime t1 = new GetTime();
//		Bridge ts = new Bridge();
//		AdminViewManager avm = new AdminViewManager(user);
////		EventStart es = new EventStart(); 
//
//		
//		t1.ts = ts;		
//		avm.ts = ts;
//		t1.avm = avm;
//		t1.start();
//		avm.start();
//
//	}
//
//}
//

package com.kh.view.admin;

import com.kh.controller.admin.GetTime;
import com.kh.model.vo.User;

public class testRun {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      User user = new User("k1","1234","김태훈", 20, 100, 100, '남', false);
      
      GetTime t1 = new GetTime();

      
      AdminViewManager avm = new AdminViewManager(user);
      t1.ts = avm.ts;
      
      t1.start();
      
      
   }

}