package com.fdmgroup.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.Board;
import com.fdmgroup.serialization.game.HealthPack;
import com.fdmgroup.serialization.game.Player;

public class Wizard extends Player implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private transient Backpack backpack = new Backpack();
	private List<Shield> shields = new ArrayList<>();
	private List<Power> powers = new ArrayList<Power>();

	
	
	public Backpack getBackpack() {
		return backpack;
		
		
	}

	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}

	public List<Shield> getShields() {
		return shields;
	}

	public void setShields(List<Shield> shields) {
		this.shields = shields;
	}

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	public void addPower(Power power) {
		this.getPowers().add(power);
	}

	public void addShield(Shield shield) {
		this.getShields().add(shield);
	}

	// Writes unserializable fields from superclass. Also writes serializable fields for
	// backpack object.
	private void writeObject(ObjectOutputStream os) throws IOException {
		
			os.defaultWriteObject();
			os.writeUTF(this.getName());
			os.writeInt(this.getHealthPoints());

			int numberOfPacks = backpack.getNumPacks();
			os.writeInt(numberOfPacks);

			for (int i = 0; i < numberOfPacks; i++) {
				int healthpoints = this.getBackpack().useHealthPack().getHealthPoints();
				os.writeInt(healthpoints);
				this.getBackpack().addHealthPack(new HealthPack(healthpoints));
			}

	}
		//Restores data to backpack object
	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException{
	
			is.defaultReadObject();
			setName(is.readUTF()); 
			setHealthPoints(is.readInt());

			int numberOfPacks = is.readInt();
			backpack = new Backpack();
			
			for (int i = 0; i < numberOfPacks; i++) {
				int healthpoints = is.readInt();
				getBackpack().addHealthPack(new HealthPack(healthpoints));
			}

	}

}