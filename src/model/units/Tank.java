package model.units;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tank extends Unit{
	
	private String type = "Tank";
	private static int cost = 2;
	private Image img;
	
	public Tank(){
	
		File file = new File("src/resources/graph/tank.png");
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public Tank(int[] xyHex, int[]xyLoc) {
		super(xyHex, xyLoc);
	}*/

	@Override
	public void move(int xHex, int yHex, int[] xyCoord) {
		super.xyHex[0] = xHex;
		super.xyHex[1] = yHex;
		super.xyLoc[0] = xyCoord[0];
		super.xyLoc[1] = xyCoord[1];
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public Image getImage(){
		return img;
	}

	@Override
	public int[] getImageDimension(){
		int imageDimension[] = new int[2];
		imageDimension[0] = img.getWidth(null);
		imageDimension[1] = img.getHeight(null);
		
		return imageDimension;
	}

	@Override
	public int getCost() {
		return cost;
	}
}
