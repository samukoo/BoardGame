package model.units;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;


public class Tank extends Unit{
	
	private int hitPoint = 10;
	private int movePoints = 3;
	private String type = "Tank";
	
	public Tank(int y, int x) {
		super(y, x);
		
	}


	@Override
	public void move(int x, int y) {
		super.xyLocation[0] = x;
		super.xyLocation[1] = y;
	}


	@Override
	public String getType() {
		return type;
	}

	public BufferedImage getImage() throws IOException{
		//Ladataan ja palautetaan tank.png
		File file = new File("src/resources/graph/tank.png");
		BufferedImage img = null;
		img = ImageIO.read(file);
		return img;
	}
	
	
}
