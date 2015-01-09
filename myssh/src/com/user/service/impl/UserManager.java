package com.user.service.impl;

import com.user.dao.UerDAOInter;
import com.user.entity.User;

public class UserManager {
	
	/**
	 * 用户管理
	 * 1.用户信息
	 * 2.用户
	 */
	
	UerDAOInter userDAO;
	
	public boolean testHH(){
		User user = new User();
		user.setUserId(345345);
		System.out.println();
		userDAO.save(user);
		System.out.println("sdfasdf");
		return true;
		
		
	}

	public UerDAOInter getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UerDAOInter userDAO) {
		this.userDAO = userDAO;
	}
	
	

}
