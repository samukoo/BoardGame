package model.units;

public enum Movement {
	stationary(95), 
	move(50),
	moveFast(15);
	
	private final int hitPer;
	
	private Movement(int hitPer){
		this.hitPer = hitPer;
	}
	
	public int getHitPer(){
		return this.hitPer;
	}
	
	
	public static Movement unitMovement(){
		return null;
	}


}

