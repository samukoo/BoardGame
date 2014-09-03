package model.units;

import java.awt.Image;
import java.io.IOException;

public interface Actions {
	public void move(int x, int y, int[] xYcoord);
	public String getType();
	public int getCost();
	public Image getImage();
	public int[] getImageDimension();
	

}
