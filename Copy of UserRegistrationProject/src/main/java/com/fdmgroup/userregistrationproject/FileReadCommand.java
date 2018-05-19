package com.fdmgroup.userregistrationproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.*;
/**
 * 
 * FileReadCommand reads the user data from the local file Users.txt and
 * returns the User whos username equals the specified username passed through the readUser method.
 * 
 * @author corey.davis
 *
 */
public class FileReadCommand implements ReadCommand {
	private String userfile = "Users.txt";
	private String[] userdata;
	private User requesteduser;

	
	private static final Logger programmerLog = Logger.getLogger("programmerLogger");
	private static final Logger errorLog = Logger.getLogger("errorLogger");
	public FileReadCommand() {
		
		PropertyConfigurator.configure("log4j.properties");
	}
		/**
		 * Returns a User if and only if the param username matches a username
		 * within the Users.txt file.
		 * 
		 * @param username is the username of the desired User to be returned.
		 * @return User if username matches a username within the specified file.
		 */
	public User readUser(String username) throws UserRegistrationException, IOException {
		programmerLog.trace("Entered readUser(str=" + username + ")");
		
		if (username == null){
			UserRegistrationException e = new UserRegistrationException("username is null.");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}if (username.trim().isEmpty()){
			UserRegistrationException e = new UserRegistrationException("username is empty string.");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}
		
		
		
		File file = new File(userfile);

		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null) {
			userdata = line.split(",");
			User user = new User();
			user.setUsername(userdata[0]);
			user.setPassword(userdata[1]);
			user.setRole(userdata[2]);

			if (username.equals(user.getUsername())) {
				requesteduser = user;
			}
		}
		br.close();
		return requesteduser;
	}

}
