package com.fdmgroup.userregistrationproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User classUnderTest;
	private String expectedusername;
	private String expectedpassword;
	private String expectedrole;
	private String stringtowrite;
	
	
	@Before
	public void setUp(){
		classUnderTest = new User();
		expectedusername ="corey";
		expectedpassword = "******";
		expectedrole = "trainee";
		stringtowrite = "corey ****** trainee";
		
	}
	
	@After
	public void tearDown(){}
	
	@Test (expected=UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenUsernameIsNull() throws UserRegistrationException {
		
			String nullstring=null;
			classUnderTest.setUsername(nullstring);
		
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenPasswordIsNull() throws UserRegistrationException{
		
			String nullstring=null;
			classUnderTest.setPassword(nullstring);
		
	}
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenRoleIsNull() throws UserRegistrationException{
		
			String nullstring=null;
			classUnderTest.setRole(nullstring);
			
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenUsernameIsEmptyString() throws UserRegistrationException{
		String emptystring="";
		classUnderTest.setUsername(emptystring);
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenPasswordIsEmptyString() throws UserRegistrationException{
		String emptystring="";
		classUnderTest.setPassword(emptystring);
	}
	
	@Test (expected = UserRegistrationException.class)
	public void testIfExceptionIsThrownWhenRoleIsEmptyString() throws UserRegistrationException{
		String emptystring="";
		classUnderTest.setRole(emptystring);
	}
	
	
	
	@Test 
	public void testIfSetterSetUsername()throws UserRegistrationException{
		String testusername = "corey";
		classUnderTest.setUsername(testusername);
		assertEquals(expectedusername, classUnderTest.getUsername());
	}
	
	@Test 
	public void testIfSetterSetPassword()throws UserRegistrationException{
		String testpassword = "******";
		classUnderTest.setPassword(testpassword);
		assertEquals(expectedpassword, classUnderTest.getPassword());
	}
	
	@Test
	public void testIfSetterSetRole() throws UserRegistrationException{
		String testrole = "trainee";
		classUnderTest.setRole(testrole);
		assertEquals(expectedrole, classUnderTest.getRole());
	}
	
	
	@Test
	public void testIfToStringReturnsExpectedStringToWrite() throws UserRegistrationException{
		classUnderTest.setUsername(expectedusername);
		classUnderTest.setPassword(expectedpassword);
		classUnderTest.setRole(expectedrole);
		assertEquals(stringtowrite, classUnderTest.toString());
	}
	
	@Test
	public void testIfEqualsMethodReturnsTrueWhenComparingTwoUserObjects() throws UserRegistrationException{
		classUnderTest.setUsername(expectedusername);
		classUnderTest.setPassword(expectedpassword);
		classUnderTest.setRole(expectedrole);
		User otheruser = new User();
		otheruser.setUsername(expectedusername);
		otheruser.setPassword(expectedpassword);
		otheruser.setRole(expectedrole);
		assertTrue(classUnderTest.equals(otheruser));
	}
	
	@Test
	public void testIfEqualsMethodReturnsFalseWhenArgumentIsNull(){
		User userToTest = null;
		assertFalse(classUnderTest.equals(userToTest));
	}

}
