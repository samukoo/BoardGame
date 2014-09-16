package model.units;

import java.awt.Image;


public abstract class Unit implements Actions{

	int[]xyHex = new int[2];
	int[]xyLoc = new int[2];
	Image img;
	Movement unitSpeed = Movement.stationary;
	
	public Unit(){
	}
	
	public Unit(int[]xyHex, int[]xyLoc){
		this.xyHex[0] = xyHex[0];
		this.xyHex[1] = xyHex[1];
		this.xyLoc[0] = xyLoc[0];
		this.xyLoc[1] = xyLoc[1];
	}

	public void setSpeed(Movement speed){
		this.unitSpeed = speed;
	}
	
	public Movement getSpeed(){
		return unitSpeed;
	}
	
	public int[] getXyHex() {
		return xyHex;
	}

	public void setXyHex(int[] xyHex) {
		this.xyHex = xyHex;
	}

	public int[] getXyLoc() {
		return xyLoc;
	}

	public void setXyLoc(int[] xyLoc) {
		this.xyLoc = xyLoc;
	}

	

	
	
	
}
