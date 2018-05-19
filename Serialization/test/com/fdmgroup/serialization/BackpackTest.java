package com.fdmgroup.serialization;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.HealthPack;

public class BackpackTest implements Serializable{
		private Backpack classUnderTest;
		private HealthPack healthpack1;	
		private HealthPack healthpack2;
		private int hp;
		private int numPacks;
	@Before
	public void setUp()  {
		classUnderTest = new Backpack();
		hp = 100;
		healthpack1 = new HealthPack(hp);
		healthpack2 = new HealthPack(hp);
		classUnderTest.addHealthPack(healthpack1);
		classUnderTest.addHealthPack(healthpack2);
		
		
	}

	@After
	public void tearDown()  {
	}
	
	
	@Test
	public void testIfUsedHealthpackIsHealthpack1(){
		HealthPack usedHealthpack = classUnderTest.useHealthPack();
		assertEquals(healthpack1, usedHealthpack);
		
	}
	
	@Test
	public void testNumberOfHealthpacks_IsOne(){
		int expectedNumPacks = 1;
		classUnderTest.useHealthPack();
		numPacks = classUnderTest.getNumPacks();
		assertEquals(numPacks, expectedNumPacks);
		
	}

}
