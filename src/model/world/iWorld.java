package model.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

public interface iWorld {

	public ArrayList<String> loadMap(String mapFile) throws IOException;
	public ArrayList<Hex> createMap();
	public ArrayList<Hex> convertEmptyHex(ArrayList<Hex> world);
	public void drawWorld(Graphics g);
	public Color getColor(int i);
	public int[] selectHex(Point point);
	public void setHex(int[] foo);
	public int[] getHexCenterPosition(int[] hexID);
	public boolean isNextHex(int[][]locations);
	
}
