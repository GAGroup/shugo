package com.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.user.dao.impl.UserDAO;
import com.user.entity.User;
import com.user.service.impl.UserManager;

public class UserAction extends ActionSupport {

	UserManager userManager;
	
	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setUserId(3);
		userManager.testHH();
		System.out.println("sdfasdf");
		
		return SUCCESS;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	

	
	
	
	
	
	
	
	

}
