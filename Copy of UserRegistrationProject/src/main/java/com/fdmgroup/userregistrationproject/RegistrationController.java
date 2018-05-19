package com.fdmgroup.userregistrationproject;

import java.io.IOException;

import org.apache.log4j.*;
/**
 * The Registration controller is required by a client who intends
 * to register new users to their systems.
 * 
 * 
 * @author corey.davis
 *
 */
public class RegistrationController {
	private ReadCommand reader;
	private WriteCommand writer;
	private UserFactory userfactory;
	
	
	private static final Logger programmerLog = Logger.getLogger("programmerLogger");
	private static final Logger errorLog = Logger.getLogger("errorLogger");
	/**
	 * Sets the instances of the three params
	 * when invoked.
	 * 
	 * @param fileReadCommand is the readCommand to be used by controller 
	 * @param fileWriteCommand is the writeCommand to be used by controller
	 * @param userFactory is the factory to be used by controller
	 */
	public RegistrationController(ReadCommand  fileReadCommand, WriteCommand  fileWriteCommand, UserFactory  userFactory) {
		PropertyConfigurator.configure("log4j.properties");
		reader = fileReadCommand;
		writer = fileWriteCommand;
		userfactory = userFactory;

	}
	/**
	 * Creates a new user, sets its fields to params,
	 * then writes user to local file and reads the user back to the client.
	 * 
	 * 
	 * @param expectedusername is specified username 
	 * @param expectedpassword is specified password
	 * @param expectedrole is specified role
	 * @throws UserRegistrationException is thrown when params are null or empty strings
	 * @throws IOException is thrown when file passed to reader does not exists
	 */
	public void registerNewUser(String expectedusername, String expectedpassword, String expectedrole) throws UserRegistrationException, IOException {
		programmerLog.trace("Entered registerNewUser(str=" + expectedusername + ", str=" + expectedpassword + ", str=" + expectedrole + ")");
		
		if(expectedusername == null || expectedpassword == null || expectedrole == null){
			UserRegistrationException e = new UserRegistrationException("One of your fields are empty!");
			errorLog.fatal("Exception thrown..", e);
			throw e;
			
		}if (expectedusername.trim().isEmpty() || expectedpassword.trim().isEmpty() || expectedrole.trim().isEmpty()){
			UserRegistrationException e = new UserRegistrationException("One of your fields is an empty string!");
			errorLog.fatal("Exception thrown..", e);
			throw e;
		}else{
			
			User userToBeRegistered = userfactory.createUser();
			
			userToBeRegistered.setUsername(expectedusername);
			userToBeRegistered.setPassword(expectedpassword);
			userToBeRegistered.setRole(expectedrole);
			
			writer.writeUser(userToBeRegistered);
			reader.readUser(expectedusername);
		}
	}

}
