package model.units;

public abstract class Unit implements Actions{

	int xLocation, yLocation;

	public Unit(int y, int x){
		this.xLocation = x;
		this.yLocation = y;
	}
	
	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	
	
}
