package model.units;

public enum HitSectors {

	turret(15),
	tracks(3),
	torso(10),
	engine(5);
	
	private final int hitDamage;
	
	private HitSectors(int hitDamage){
		this.hitDamage = hitDamage;
	}
	
	public int getHitDamage(){
		return this.hitDamage;
	}
}
