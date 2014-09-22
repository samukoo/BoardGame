package controller;

import java.util.Random;

import model.battlefield.Field;
import model.units.HitSectors;
import model.units.Unit;

public interface Shoot {

	public boolean shootTarget(Unit attacker, Unit target, Field field);
	public boolean calculateHit(Unit attacker, Unit target, Random random);
	public int calculateDamage(Random random);
	
	
	
	
}
