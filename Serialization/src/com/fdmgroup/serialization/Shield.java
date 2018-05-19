package com.fdmgroup.serialization;

import java.io.Serializable;

public class Shield implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int addHPs;
	private int loseHPs;
	private double addHPPercent;
	private double loseHPPercent;
	
	public Shield(String name, int addHPs, int loseHPs) {
		this.name = name;
		this.addHPs = addHPs;
		this.loseHPs = loseHPs;
		this.loseHPPercent = loseHPPercent;
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
	
	
	
	

	
}
