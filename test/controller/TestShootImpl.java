package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.battlefield.Field;
import model.units.Movement;
import model.units.Tank;
import model.units.HitSectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

public class TestShootImpl {

	private Field field;
	private Tank attacker;
	private Tank target;
	private ShootImpl SUT;
	private Random random;
	
	@Before
	public void setUp() throws Exception {

		SUT = new ShootImpl();
		attacker = mock(Tank.class);
		target = mock(Tank.class);
		field = mock(Field.class);
		random = mock(Random.class);
	}

	
	@Test
	public void test_calculateHit(){
		
		//Given testData
		Movement[] aData = {Movement.stationary,Movement.move,Movement.moveFast};
		Movement[] tData = {Movement.stationary,Movement.move,Movement.moveFast};
		
		for(Movement att : aData)
			for(Movement tar : tData){
				//When unit gets speed
				when(attacker.getSpeed()).thenReturn(att);
				when(target.getSpeed()).thenReturn(tar);
				//And random generator returns positive boundary values
				when(random.nextInt(100)).thenReturn(((att.getHitPer()+tar.getHitPer())/2)+0);
				
				//Then Attacker get hit
				assertTrue(SUT.calculateHit(attacker,target,random));
				//And when random value goes outside boundary
				when(random.nextInt(100)).thenReturn(((att.getHitPer()+tar.getHitPer())/2)+1);
				//Then attacker gets miss
				assertFalse(SUT.calculateHit(attacker,target,random));
		}
	}
		
	@Test
	public void testShootTarget() {
		int[][]locations={{3,3},{3,4}};
		when(attacker.getXyHex()).thenReturn(locations[0]);
		when(attacker.getRange()).thenReturn(1);
		when(target.getXyHex()).thenReturn(locations[1]);
		when(field.isNextHex(locations)).thenReturn(true);
		
		//tarkistetaan, onko target viereisessä hexassa
		boolean res = SUT.shootTarget(attacker, target, field);
		assertTrue( res);
	
	}
	
	@Test
	public void testCalculateDamage() {
		List<HitSectors>list=new ArrayList<HitSectors>();
		for(HitSectors h: HitSectors.values()){
			list.add(h);
		}
		
		for(int i=0;i<list.size();i++ ){
			when(random.nextInt(list.size())).thenReturn(i);
			int res = SUT.calculateDamage(random);
			System.out.println(res);
		
		}
			
			
			
			
		
		
		
		
		}
		
}
