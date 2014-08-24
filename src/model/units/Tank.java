package model.units;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tank extends Unit{
	
	private String type = "Tank";
	
	public Tank(int[] xyHex, int[]xyLoc) {
		super(xyHex, xyLoc);
		
	}


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
	public Image getImage() throws IOException{
		//Ladataan ja palautetaan tank.png
		File file = new File("src/resources/graph/tank.png");
		Image img = ImageIO.read(file);
		return img;
	}


	@Override
	public int[] getImageDimension() throws IOException {
		int imageDimension[] = new int[2];
		Image img = getImage();
		imageDimension[0] = img.getWidth(null);
		imageDimension[1] = img.getHeight(null);
		return imageDimension;
	}
	
	
}
