package model.units;


public class Tank extends Unit{
	
	private int hitPoint = 10;
	private int movePoints = 3;
	private String type = "Tank";
	
	public Tank(int y, int x) {
		super(y, x);
		
	}


	@Override
	public void move(int x, int y) {
		super.xLocation = x;
		super.yLocation = y;
	}


	@Override
	public String getType() {
		return type;
	}

	
	
	
}
