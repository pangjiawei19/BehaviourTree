package com.gy.bt.test;

public class Player {
	
	/** 体力 */
	public int vitality;
	/** 饱值 */
	public int fullValue;
	
	public boolean hasVitality() {
		return vitality > 0;
	}
	
	public void decVitality() {
		this.vitality -= 10;
	}
	
	public void addVitality() {
		this.vitality = 30;
	}
	
	public boolean hasFullValue() {
		return fullValue > 0;
	}
	
	public void eat() {
		this.fullValue = 30;
	}
	
	public void decFullValue() {
		this.fullValue -= 10;
	}

}
