package model.units;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tank extends Unit{
	
	private String type = "Tank";
	private static int cost = 2;
	
	public Tank(){
	
		File file = new File("src/resources/graph/tank.png");
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void move(int[] xyCoord) {
		
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
