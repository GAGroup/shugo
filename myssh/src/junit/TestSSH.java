package junit;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.user.action.UserAction;
import com.user.dao.UerDAOInter;
import com.user.entity.User;
import com.user.service.impl.UserManager;

public class TestSSH {
	ApplicationContext cxt;
	
	UerDAOInter userDAO ;
	
	@Before
	public void saa(){
		cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testLoad(){
		
		UerDAOInter ud = (UerDAOInter) cxt.getBean("userDAO");
		ud.findAll();
	}
	
	@Test
	public void testsave(){
		UerDAOInter ud = (UerDAOInter) cxt.getBean("userDAO");
		User user = new User();
		user.setUserId(33);
		ud.save(user);
		//ud.delete(user);
	}
	
	@Test 
	public void tstAction(){
		UserAction us = new UserAction();
		try {
			UserAction usb = (UserAction) cxt.getBean("userAction");
			System.out.println(usb==null);
			us.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void testService(){
		UserManager u = (UserManager) cxt.getBean("userManager");
		u.testHH();
		
	}
}
