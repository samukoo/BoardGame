package model.units;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tank extends Unit{
	
	private String type = "Tank";
	private String owner;
	private static int cost = 2;
	private int movePoints = 1;
	private static int cannonRange = 2;
	
	public Tank(String owner){
	
		this.owner = owner;
		
		File file = new File("src/resources/graph/tank.png");
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void calculateUnitSpeed(){
		
		switch (movePoints) {
		case 2:
			setSpeed(Movement.stationary);
			break;
		case 1:
			setSpeed(Movement.move);
			break;
		case 0:
			setSpeed(Movement.moveFast);
			break;
			
		default:
			break;
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

	@Override
	public String getOwner() {
		return owner;
	}

	@Override
	public int getRange() {
		return cannonRange;
	}
	
	@Override
	public void setMovePoints(int movePoints) {
		this.movePoints = movePoints;
	}
}
