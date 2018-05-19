package com.fdmgroup.userregistrationproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class RegistrationControllerTest {
	private String expectedusername;
	private String expectedpassword;
	private String expectedrole;
	private RegistrationController classUnderTest;
	private User testuser;
	private UserFactory testfactory;
	private ReadCommand reader;
	private WriteCommand writer;
	private UserFactory mockFactory;
	private User mockUser;
	private ReadCommand mockReader;
	private WriteCommand mockWriter;
	@Before
	public void setUp() throws UserRegistrationException, IOException  {
		expectedusername = "corey.davis";
		expectedpassword = "******";
		expectedrole = "trainee";
		testuser = new User();
		testfactory = new UserFactory();
		reader = new FileReadCommand();
		writer = new FileWriteCommand();
		String userdata = "Users.txt";
		mockFactory = mock(UserFactory.class);
		mockUser = mock(User.class);
		mockReader = mock(FileReadCommand.class);
		mockWriter = mock(FileWriteCommand.class);
		when(mockFactory.createUser()).thenReturn(mockUser);	
		when(mockUser.getUsername()).thenReturn(expectedusername);
		when(mockUser.getPassword()).thenReturn(expectedpassword);
		when(mockUser.getRole()).thenReturn(expectedrole);	
		when(mockReader.readUser(expectedusername)).thenReturn(mockUser);
		classUnderTest = new RegistrationController(mockReader, mockWriter, mockFactory);
	}

	@After
	public void tearDown() {
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionWasThrownWhenUsernameIsNull() throws UserRegistrationException, IOException{
		String expectedstring = null;
		classUnderTest.registerNewUser(expectedstring, expectedpassword, expectedrole);
	}

	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionWasThrownWhenPasswordIsNull() throws UserRegistrationException, IOException{
		String expectedstring = null;
		classUnderTest.registerNewUser(expectedusername, expectedstring, expectedrole);
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionWasThrownWhenRoleIsNull() throws UserRegistrationException, IOException{
		String expectedstring = null;
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedstring);
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionWasThrownWhenUsernameIsEmptyString() throws UserRegistrationException, IOException{
		String expectedstring = "";
		classUnderTest.registerNewUser(expectedstring, expectedpassword, expectedrole);
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionWasThrownWhenPasswordIsEmptyString() throws UserRegistrationException, IOException{
		String expectedstring = "";
		classUnderTest.registerNewUser(expectedusername, expectedstring, expectedrole);
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionWasThrownWhenRoleIsEmptyString() throws UserRegistrationException, IOException{
		String expectedstring = "";
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedstring);
	}
	@Test
	public void testIfParametersWereSetWhenRegisteringNewUser() throws UserRegistrationException, IOException {
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		assertEquals(expectedusername, mockUser.getUsername());
	}
	
	@Test
	public void testIfUserFactoryCreatedUserWhenControllerIsInvoked() throws UserRegistrationException, IOException{
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		verify(mockFactory,times(1)).createUser();
	}
	
	@Test
	public void testIfUsernameIsSetInUserWhenControllerIsCalled() throws UserRegistrationException, IOException{
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		verify(mockUser,times(1)).setUsername(expectedusername);
	}
	
	@Test
	public void testIfPasswordIsSetInUserWhenControllerIsCalled() throws UserRegistrationException, IOException{
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		verify(mockUser,times(1)).setPassword(expectedpassword);
	}
	
	@Test
	public void testIfRoleIsSetInUserWhenControllerIsCalled() throws UserRegistrationException, IOException{
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		verify(mockUser,times(1)).setRole(expectedrole);
	}
	
	
	
	@Test
	public void testIfMockUserWasWrittenToFileWhenControllerIsInvoked() throws UserRegistrationException, IOException{
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		verify(mockWriter,times(1)).writeUser(mockUser);
	}
	
	@Test
	public void testIfReadCommandIsInvokedWhenControllerIsCalled() throws UserRegistrationException, IOException{
		classUnderTest.registerNewUser(expectedusername, expectedpassword, expectedrole);
		verify(mockReader,times(1)).readUser(expectedusername);
		
	}

}
