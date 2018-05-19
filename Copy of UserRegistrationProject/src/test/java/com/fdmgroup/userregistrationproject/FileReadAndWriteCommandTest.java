package com.fdmgroup.userregistrationproject;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class FileReadAndWriteCommandTest {
	private User testuser;
	private File file;
	private String expectedusername;
	private String expectedpassword;
	private String expectedrole;
	private FileReadCommand reader;
	private FileWriteCommand writer;
	private User mockUser;

	@Before
	public void setUp() {
		testuser = new User();
		file = new File("Users.txt");
		expectedusername = "corey";
		expectedpassword = "******";
		expectedrole = "trainee";
		reader = new FileReadCommand();
		writer = new FileWriteCommand();
		mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn(expectedusername);
		when(mockUser.getPassword()).thenReturn(expectedpassword);
		when(mockUser.getRole()).thenReturn(expectedrole);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testIfFileBeingWrittenExists() {
		assertTrue(file.exists());
	}

	@Test (expected= UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenUsernamePassedThroughReadUserIsNull() throws UserRegistrationException, IOException{
		String nullUsername = null;
		reader.readUser(nullUsername);
	}
	
	
	@Test (expected= UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenUsernamePassedThroughReadUserIsEmptyString() throws UserRegistrationException, IOException{
		String nullUsername = "";
		reader.readUser(nullUsername);
	}
	
	@Test (expected= UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenUserPassedThroughWriteUserIsNull() throws UserRegistrationException, IOException{
		User nullUser = null;
		writer.writeUser(nullUser);
	}
	
	@Test
	public void testIfFileReadCommandReturnsTheSameUserThatWasWrittenToFile() throws UserRegistrationException, IOException {
		testuser.setUsername(expectedusername);
		testuser.setPassword(expectedpassword);
		testuser.setRole(expectedrole);
		writer.writeUser(testuser);
		User newuser = reader.readUser(expectedusername);
		assertEquals(testuser.getUsername(), newuser.getUsername());

	}

	@Test
	public void testIfgetUsernameMethodWasCalledOnMockUserWhenWriteUserInvoked() throws UserRegistrationException {
		writer.writeUser(mockUser);
		verify(mockUser, times(1)).getUsername();
	}

	@Test
	public void testIfgetPasswordMethodWasCalledOnMockUserWhenWriteUserInvoked() throws UserRegistrationException {
		writer.writeUser(mockUser);
		verify(mockUser, times(1)).getPassword();
	}

	@Test
	public void testIfgetRoleMethodWasCalledOnMockUserWhenWriteUserInvoked() throws UserRegistrationException {
		writer.writeUser(mockUser);
		verify(mockUser, times(1)).getRole();
	}

	
}
