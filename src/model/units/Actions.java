package model.units;

import java.awt.Image;
import java.io.IOException;

public interface Actions {
	public void move(int x, int y);
	public String getType();
	public Image getImage()throws IOException;
	public int[] getImageDimension() throws IOException;
	

}
