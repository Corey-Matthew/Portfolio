package com.fdmgroup.serialization;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.serialization.Wizard;
import com.fdmgroup.serialization.game.HealthPack;
import com.fdmgroup.serialization.game.Player;

public class WizardTest {
		private Wizard classUnderTest;
		
		private HealthPack healthpack1;
		private HealthPack healthpack2;
		private int healthpoints;
	@Before
	public void setUp() throws Exception {
		classUnderTest = new Wizard();
		healthpack1 = new HealthPack(healthpoints);
		healthpack2 = new HealthPack(healthpoints);
		WizardSerializer wizardSerializer = new WizardSerializer("SavedGame.txt");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIfNameWasSetToString() {
		String stringToTest = "Corey";
		classUnderTest.setName(stringToTest);
		assertEquals(stringToTest, classUnderTest.getName());
	}
	
	@Test
	public void testIfHealthPointsWereSetToInt(){
		int hpToTest = 100;
		classUnderTest.setHealthPoints(hpToTest);
		assertEquals(hpToTest, classUnderTest.getHealthPoints());
	}
	
	

}
