package com.fdmgroup.userregistrationproject;

import java.io.BufferedWriter;
import org.apache.log4j.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
/**
 * FileWriteCommand writes the fields of a User to the specified local file.
 * 
 * 
 * @author corey.davis
 *
 */
public class FileWriteCommand implements WriteCommand {
	private String userfile = "Users.txt";
	private String userdata;
	
	private static final Logger programmerLog = Logger.getLogger("programmerLogger");
	private static final Logger errorLog = Logger.getLogger("errorLogger");

	public FileWriteCommand(){
		PropertyConfigurator.configure("log4j.properties");
	}
	/**
	 * Writes fields of user to file if and only if user is not null.
	 * 
	 * @param user is the specified user to be written to file.
	 */
	public void writeUser(User user) throws UserRegistrationException {
		programmerLog.trace("Entered: writeUser(User=" + user + ")");	
		
		if(user == null){
				UserRegistrationException e = new UserRegistrationException("user is null.");
				errorLog.fatal("Exception thrown..", e);
				throw e;
			}
			
			
		File file = new File(userfile);
		userdata = user.getUsername() + "," + user.getPassword() + "," + user.getRole();
		Writer writer = null;
		BufferedWriter bufferedwriter = null;

		try {
			writer = new FileWriter(file);
			bufferedwriter = new BufferedWriter(writer);

			bufferedwriter.write(userdata);

			bufferedwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
