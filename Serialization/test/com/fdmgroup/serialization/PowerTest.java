package com.fdmgroup.serialization;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PowerTest {

	private Power classUnderTest;
	private String name;
	private int addHP;
	private int loseHP;

	@Before
	public void setUp() throws Exception {
		name = "Hocus pocus";
		addHP = 0;
		loseHP = 25;
		classUnderTest = new Power(name, addHP, loseHP);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIfGetNameReturnsExpectedName() {
		String nameToTest = classUnderTest.getName();
		assertEquals(name, nameToTest);
	}
	
	@Test
	public void testIfGetAddHPReturnsExpectedAddHP() {
		int addHPToTest = classUnderTest.getAddHPs();
		assertEquals(addHP, addHPToTest);
	}
	
	@Test
	public void testIfGetLoseHPReturnsExpectedLoseHP() {
		int loseHPToTest = classUnderTest.getLoseHPs();
		assertEquals(loseHP, loseHPToTest);
	}

}
