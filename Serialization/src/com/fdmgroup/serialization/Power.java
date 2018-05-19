package com.fdmgroup.serialization;

import java.io.Serializable;

public class Power implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int addHPs;
	private int loseHPs;
	private double addHPPercent;
	private double loseHPPercent;
	
	public Power(String name, int addHPs, int loseHPs) {
		this.name = name;
		this.addHPs = addHPs;
		this.loseHPs = loseHPs;
		
	}

	
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAddHPs() {
		return addHPs;
	}
	
	public void setAddHPs(int addHPs) {
		this.addHPs = addHPs;
	}
	
	public int getLoseHPs() {
		return loseHPs;
	}
	
	public void setLoseHPs(int loseHPs) {
		this.loseHPs = loseHPs;
	}
	
	public double getAddHPPercent() {
		return addHPPercent;
	}
	
	public void setAddHPPercent(double addHPPercent) {
		this.addHPPercent = addHPPercent;
	}
	
	public double getLoseHPPercent() {
		return loseHPPercent;
	}
	
	public void setLoseHPPercent(double loseHPPercent) {
		this.loseHPPercent = loseHPPercent;
	}	
	
	
}