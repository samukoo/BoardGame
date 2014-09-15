package controller;

import model.battlefield.Field;
import model.units.Unit;

public interface Shoot {

	public boolean shootTarget(Unit attacker, Unit target, Field field);
//	public boolean calculateHit(Unit attacker, Unit target);
	public void calculateDamage(Unit attacker, Unit target);
	
	
}
