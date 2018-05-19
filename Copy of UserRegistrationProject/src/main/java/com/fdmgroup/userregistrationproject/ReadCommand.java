package com.fdmgroup.userregistrationproject;

import java.io.IOException;

public interface ReadCommand {
	User readUser(String username) throws UserRegistrationException, IOException;
}
