package model.units;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Infantry extends Unit {

	private String type = "Infantry";
	
	public Infantry(int[] xyHex, int[]xyLoc) {
		super(xyHex, xyLoc);
	}
	
	@Override
	public void move(int x, int y, int[] xYcoord) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getType() {
		return type;
	}

	@Override
	public BufferedImage getImage() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getImageDimension() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
