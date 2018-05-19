package com.fdmgroup.serialization;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.serialization.game.HealthPack;

public class WizardSerializerTest {

	private WizardSerializer classUnderTest;
	private String savedGame;
	private Wizard wizard;
	private HealthPack healthpack1;	
	private HealthPack healthpack2;
	private int hp;
	private String name;
	private Power power;
	private Shield shield;
	private int expectedNumberOfHealthpacks;
	private List<Power> powers;
	private List<Shield> shields;
	@Before
	public void setUp() throws Exception {
		savedGame = "savedGame.txt";
		classUnderTest = new WizardSerializer(savedGame);
		wizard = new Wizard();
		hp = 100;
		healthpack1 = new HealthPack(hp);
		healthpack2 = new HealthPack(hp);
		name = "wiz";
		wizard.setName(name);
		wizard.setHealthPoints(hp);
		wizard.addPower(power);
		wizard.addShield(shield);
		shields = wizard.getShields();
		powers = wizard.getPowers();
		wizard.getBackpack().addHealthPack(healthpack1);
		wizard.getBackpack().addHealthPack(healthpack2);
		expectedNumberOfHealthpacks = wizard.getBackpack().getNumPacks();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSerialize_SerializesWizardName() {
		classUnderTest.serialize(wizard);
		
		Wizard deserializedWizard = classUnderTest.deserialize();
		String deserializedName = deserializedWizard.getName();
		
		assertEquals(name, deserializedName);
		
	}
	
	
	@Test
	public void testSerialize_SerializesWizardHealthpoints() {
		classUnderTest.serialize(wizard);

		Wizard deserializedWizard = classUnderTest.deserialize();
		int deserializedHealthpoints = deserializedWizard.getHealthPoints();
		
		assertEquals(hp, deserializedHealthpoints);
		
	}
	

	
	@Test
	public void testSerialize_SerializesWizardNumPacksInBackpack() {
		classUnderTest.serialize(wizard);
		
		Wizard deserializedWizard = classUnderTest.deserialize();
		int deserializedHealthpacks = deserializedWizard.getBackpack().getNumPacks();
		
		assertEquals(expectedNumberOfHealthpacks, deserializedHealthpacks);
		
	}
	
	@Test
	public void testSerialize_SerializesWizardNumPacksAfterUsingHealthPack() {
		
		classUnderTest.serialize(wizard);
		
		Wizard deserializedWizard = classUnderTest.deserialize();
		int deserializedHealthpacks = deserializedWizard.getBackpack().getNumPacks();
		
		assertEquals(expectedNumberOfHealthpacks, deserializedHealthpacks);
		
	}
	
	@Test
	public void testSerialize_IfHealthpacksInBackPackHaveTheSameHealthPoints(){
		int healthpointsOfHP1 = healthpack1.getHealthPoints();
		int healthpointsOfHP2 = healthpack2.getHealthPoints();
		classUnderTest.serialize(wizard);
		
		Wizard deserializedWizard = classUnderTest.deserialize();
		int deserializedHealthpack1 = deserializedWizard.getBackpack().useHealthPack().getHealthPoints();
		int deserializedHealthpack2 = deserializedWizard.getBackpack().useHealthPack().getHealthPoints();
		
		assertEquals(healthpointsOfHP1, deserializedHealthpack1);
		assertEquals(healthpointsOfHP2, deserializedHealthpack1);
	}
	
	@Test
	public void testSerialize_SerializesWizardPowers() {
		classUnderTest.serialize(wizard);
		
		Wizard deserializedWizard = classUnderTest.deserialize();
		List<Power> deserializedPowers = deserializedWizard.getPowers();
		
		assertTrue(powers.equals(deserializedPowers));
		
	}
	
	@Test
	public void testSerialize_SerializesWizardShields() {
		classUnderTest.serialize(wizard);
		
		Wizard deserializedWizard = classUnderTest.deserialize();
		List<Shield> deserializedShields = deserializedWizard.getShields();
		
		assertTrue(shields.equals(deserializedShields));
		
	}
	
	
	@Test
	public void testNumberOfPacks_IfSavedAndCanKeepPlaying() {
		int packsInBackpackBeforeSerialization = wizard.getBackpack().getNumPacks();
		classUnderTest.serialize(wizard);
		
		int packsInBackpackAfterSerialization = wizard.getBackpack().getNumPacks();
		
		assertEquals(packsInBackpackBeforeSerialization, packsInBackpackAfterSerialization);
		
	}
	
	@Test
	public void testPackHealthPoints_IfSavedAndCanKeepPlaying() {
		int packHealthPointsBeforeSerialization = wizard.getBackpack().useHealthPack().getHealthPoints();
		classUnderTest.serialize(wizard);
		
		int packHealthPointsAfterSerialization = wizard.getBackpack().useHealthPack().getHealthPoints();
		
		assertEquals(packHealthPointsBeforeSerialization, packHealthPointsAfterSerialization);
		
	}
	
	@Test
	public void testWizardName_IfSavedAndCanKeepPlaying() {
		String nameBeforeSerialization = wizard.getName();
		classUnderTest.serialize(wizard);
		
		String nameAfterSerialization = wizard.getName();
		
		assertEquals(nameBeforeSerialization, nameAfterSerialization);
		
	}
	
	@Test
	public void testWizardHealthPoints_IfSavedAndCanKeepPlaying() {
		int healthPointsBeforeSerialization = wizard.getHealthPoints();
		classUnderTest.serialize(wizard);
		
		int healthPointsAfterSerialization = wizard.getHealthPoints();
		
		assertEquals(healthPointsBeforeSerialization, healthPointsAfterSerialization);
		
	}
}
