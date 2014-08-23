package model.units;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Infantry extends Unit {

	private int hitPoint = 5;
	private int movePoints = 2;
	private String type = "Infantry";
	
	public Infantry(int[] xyHex, int[]xyLoc) {
		super(xyHex, xyLoc);
	}
	
	@Override
	public void move(int xHex, int yHex) {
		super.xyHex[0] = xHex;
		super.xyHex[1] = yHex;
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

}
