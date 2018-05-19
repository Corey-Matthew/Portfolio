package com.fdmgroup.userregistrationproject;

import java.io.IOException;

public class Client {

	public static void main(String[] args) throws UserRegistrationException, IOException {
		String clientusername = "Username";
		String clientpassword = "Password";
		String clientrole = "Role";
		
		RegistrationController rc = new RegistrationController(new FileReadCommand(), new FileWriteCommand(), new UserFactory());
				
				rc.registerNewUser(clientusername, clientpassword, clientrole);
	}

}
