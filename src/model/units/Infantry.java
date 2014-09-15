package model.units;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Infantry extends Unit {

	private String type = "Infantry";
	private String owner;
	private static int cost = 1;
	
	public Infantry(String owner){
		
		this.owner=owner;
		
		File file = new File("src/resources/graph/infantry.png");
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void move(int[] xy) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public Image getImage() {
		return img;
	}

	@Override
	public int[] getImageDimension() {
		int imageDimension[] = new int[2];
		imageDimension[0] = img.getWidth(null);
		imageDimension[1] = img.getHeight(null);
		return imageDimension;
	}

	@Override
	public String getOwner() {
		return owner;
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}