package com.fdmgroup.userregistrationproject;

import org.apache.log4j.*;

/**
 * UserFactory utilises the factory design pattern to create 
 * a new user object.
 * 
 * @author corey.davis
 *
 */
public class UserFactory {
	private static final Logger programmerLog = Logger.getLogger("programmerLogger");
	private static final Logger errorLog = Logger.getLogger("errorLogger");
	
	
	public UserFactory(){
		PropertyConfigurator.configure("log4j.properties");
	}
	
	/**
	 * Returns a new user when invoked.
	 * @return User new user.
	 */
	public User createUser(){
		programmerLog.trace("Entered: createUser()");
		return new User();
	}
}
