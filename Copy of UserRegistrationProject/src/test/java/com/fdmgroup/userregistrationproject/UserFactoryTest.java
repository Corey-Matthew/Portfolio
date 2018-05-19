package com.fdmgroup.userregistrationproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserFactoryTest {
		UserFactory classUnderTest;
		
	@Before
	public void setUp()  {
		classUnderTest = new UserFactory();
		
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testIfFactoryCreatedNewUserObject() {
	 Object user = classUnderTest.createUser();
		assertNotNull(user);
	}
	
	@Test
	public void testIFactoryCreatedAnObjectOfTypeUser(){
		Object user = classUnderTest.createUser();
		assertTrue(user instanceof User);
	}

}
