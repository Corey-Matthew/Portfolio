package com.fdmgroup.userregistrationproject;

public interface WriteCommand {
		void writeUser(User user) throws UserRegistrationException;
}
