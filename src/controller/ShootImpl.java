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

	
	public boolean calculateHit2(Unit attacker, Unit target, Random random) {
		Movement a = attacker.getSpeed();
		Movement t = target.getSpeed();
		
		int i = a.getHitPer() + t.getHitPer();
		if(random.nextInt(100)<=i/2)
			return true;
		
		return false;
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
		
		
		switch (attackerSpeed) {
		case stationary:
			if(targetSpeed.equals(Movement.stationary) && random.nextInt(100)<=90){
				return true;
			}
			if(targetSpeed.equals(Movement.move) && random.nextInt(100)<=70){
				return true;
			}
			if(targetSpeed.equals(Movement.moveFast) && random.nextInt(100)<=50){
				return true;
			}
			break;

		case move:
			if(targetSpeed.equals(Movement.stationary) && random.nextInt(100)<=70){
				return true;
			}
			if(targetSpeed.equals(Movement.move) && random.nextInt(100)<=50){
				return true;
			}
			if(targetSpeed.equals(Movement.moveFast) && random.nextInt(100)<=30){
				return true;
			}
			break;
		
		case moveFast:
			if(targetSpeed.equals(Movement.stationary) && random.nextInt(100)<=25){
				return true;
			}
			if(targetSpeed.equals(Movement.move) && random.nextInt(100)<=20){
				return true;
			}
			if(targetSpeed.equals(Movement.moveFast) && random.nextInt(100)<=15){
				return true;
			}
			break;
		}
		return false;
		
	}

	@Override
	public void calculateDamage(Unit attacker, Unit target) {
		/*
		 * Lasketaan vaunun damage. Osuiko teloihin, torniin, ammusvarastoon jne
		 */
	}

	
	
	
	
}
