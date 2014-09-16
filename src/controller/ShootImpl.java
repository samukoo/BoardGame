package controller;

import java.util.Random;

import model.battlefield.Field;
import model.units.Movement;
import model.units.Unit;

public class ShootImpl implements Shoot{

	private Field field;
	
	@Override
	public boolean shootTarget(Unit attacker, Unit target, Field field) {
		/*
		 * Tarkista, voiko ampua, onko liian kaukana.
		 */
		int[][]locations = new int[2][2];
		locations[0] = attacker.getXyHex();
		locations[1] = target.getXyHex();
		
		return field.isNextHex(locations);
		
	}

	
	public boolean calculateHit(Unit attacker, Unit target, Random random) {
		/*
		 * Lasketaan osuma. Liikkuuko oma vaunu? Liikkuuko vastustajan vaunu?
		 * Jos molemmat vaunut ovat paikoillaan, osuma prosentti voisi olla jopa 95% viereiseen hexaan
		 * Ensin simppeli implementaatio: Heitetään noppaa(6). Jos yli tai yhtä kuin 3, osui 
		 * 
		 */
		Movement attackerSpeed = attacker.getSpeed();
		Movement targetSpeed = target.getSpeed();
		
		if(random.nextInt(5)>=3)
			return true;
		return false;
		
		
	}

	@Override
	public void calculateDamage(Unit attacker, Unit target) {
		/*
		 * Lasketaan vaunun damage. Osuiko teloihin, torniin, ammusvarastoon jne
		 */
	}

	
	
	
	
}
