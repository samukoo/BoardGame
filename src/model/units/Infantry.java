package model.units;

public class Infantry extends Unit {

	private int hitPoint = 5;
	private int movePoints = 2;
	private String type = "Infantry";
	
	public Infantry(int y, int x) {
		super(y ,x);
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
