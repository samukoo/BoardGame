package model.units;

import java.awt.Image;

public interface Actions {
	
	public void move(int[] xy);
	public String getType();
	public int getCost();
	public Image getImage();
	public int[] getImageDimension();
}
