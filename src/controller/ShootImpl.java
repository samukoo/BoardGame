package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.battlefield.Field;
import model.units.HitSectors;
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
		Movement a = attacker.getSpeed();
		Movement t = target.getSpeed();
		
		int i = a.getHitPer() + t.getHitPer();
		if(random.nextInt(100)<=i/2)
			return true;
		
		return false;
	}
	
	@Override
	public int calculateDamage(Random random) {
		/*
		 * Lasketaan vaunun damage. Osuiko teloihin, torniin, ammusvarastoon jne
		 * Hitsector enum maarittelee kulloisen osumapisteen maksimidamagen, joka arvotaan. palauttaa Intin, joka vahennetaan vaunun osumapisteita
		 */
		List<HitSectors>hitList = new ArrayList<HitSectors>();
		for(HitSectors h: HitSectors.values())
			hitList.add(h);
		HitSectors impact = hitList.get(random.nextInt(hitList.size()));
		return random.nextInt(impact.getHitDamage());
	}
}
