package model.units;

import java.awt.Image;

public interface Actions {
	
	public void move(int[] xy);
	public String getType();
	public int getCost();
	public Image getImage();
	public int[] getImageDimension();
	public String getOwner();
	public int getRange();
	public void calculateUnitSpeed();
	public void setMovePoints(int movePoints);
}
