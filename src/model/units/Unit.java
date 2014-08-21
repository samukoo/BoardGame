package model.units;

import java.awt.image.BufferedImage;

public abstract class Unit implements Actions{

	int[] xyLocation;

	public Unit(int y, int x){
		this.xyLocation[0] = x;
		this.xyLocation[1] = y;
	}

	public int[] getXyLocation() {
		return xyLocation;
	}

	public void setXyLocation(int[] xyLocation) {
		this.xyLocation = xyLocation;
	}
	
	
	
	
}
