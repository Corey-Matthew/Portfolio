package com.fdmgroup.issuetracker.utils;

import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;

public final class Validation {

	private Validation(){}
	
	public static boolean compare(UserDAO dao, String username, String password){
		User user = dao.getUser(username);
		if(user == null)
		{
			return false;
		}
		else if(user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
}
