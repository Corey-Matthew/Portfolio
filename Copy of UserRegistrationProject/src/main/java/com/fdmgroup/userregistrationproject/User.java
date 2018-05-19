package com.fdmgroup.userregistrationproject;

import org.apache.log4j.*;

/**
 * The User class contains the getters and setters for the three fields: username, password, and role, that
 * make up a user object.
 * @author corey.davis
 *
 */
public class User {
	private String username;
	private String password;
	private String role;
	
	
	private static final Logger programmerLog = Logger.getLogger("programmerLogger");
	private static final Logger errorLog = Logger.getLogger("errorLogger");
	
	
	public User(){
		PropertyConfigurator.configure("log4j.properties");
	}
	/**
	 * Sets username variable to specified string.
	 * 
	 * @param username str is the specified string to be set as username.
	 * @throws UserRegistrationException is thrown when param is null or empty string
	 */
	public void setUsername(String username) throws UserRegistrationException {
		programmerLog.trace("Entered: setUsername(str=" + username + ")");
		
		if(username == null){
			UserRegistrationException e = new UserRegistrationException("username is null.");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}if(username.trim().isEmpty()){
			UserRegistrationException e = new UserRegistrationException("username is empty string.");
			errorLog.fatal("Exception thrown..", e);
			throw e; 
		}
		else{
			
		this.username = username;
		}
	}
	/**
	 * Returns str username when invoked.
	 * @return str username.
	 */
	public String getUsername() {
		programmerLog.trace("Entered: getUsername()");
		return this.username;
	}
	/**
	 * Sets password variable to specified string.
	 * 
	 * @param password str is the specified string to be set as password.
	 * @throws UserRegistrationException is thrown when param is null or empty string
	 */
	public void setPassword(String password) throws UserRegistrationException {
		programmerLog.trace("Entered: setPassword(str=" + password + ")");
		
		if(password == null){
			UserRegistrationException e = new UserRegistrationException("password is null.");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}if(password.trim().isEmpty()){
			UserRegistrationException e = new UserRegistrationException("password is empty string.");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}
		
		else{
			
		this.password = password;
		}
	}
	/**
	 * Returns string password when invoked.
	 * @return str password.
	 */
	public String getPassword() {
		programmerLog.trace("Entered: getPassword()");
		return this.password;
		
	}
	/**
	 * Sets role variable to specified string.
	 * 
	 * @param role str is the specified string to be set as role.
	 * @throws UserRegistrationException is thrown when param is null or empty string
	 */
	public void setRole(String role) throws UserRegistrationException {
		programmerLog.trace("Entered: setRole(str=" + role + ")");
		
		if(role == null){
			UserRegistrationException e = new UserRegistrationException("role is null.");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}if(role.trim().isEmpty()){
			UserRegistrationException e = new UserRegistrationException("role is empty string.");
			errorLog.fatal("Exception thrown..", e);
			throw e; 
		}
		else{
			
			this.role = role;
		}
	}
	/**
	 * Returns string role when invoked.
	 * @return str role.
	 */
	public String getRole() {
		programmerLog.trace("Entered: getRole()");
		return this.role;
		
	}
	
	/**
	 * Returns true if and only if User equals otheruser passed thorugh.
	 * 
	 * @return true if this.User equals otheruser passed through, false otherwise.
	 */
	@Override
	public boolean equals(Object otheruser){
		programmerLog.trace("Entered: equals(obj=" + otheruser + ")");
		
		boolean result;
		if(otheruser == null){
			return false;
		}else{
			User otheruser2 = (User) otheruser;
			result = username.equals(otheruser2.getUsername()) && password.equals(otheruser2.getPassword()) && role.equals(otheruser2.getRole());
		}
			
			return result;
	}
	/**
	 * Returns a string containing username, password, and role of this User.
	 * 
	 * @return str concatenation of User fields.
	 */
	public String toString(){
		programmerLog.trace("Entered: toString()");
		return this.username + " " + this.password + " " + this.role;
	}

}
