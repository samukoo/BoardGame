package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import model.battlefield.Field;
import model.units.Movement;
import model.units.Tank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.internal.matchers.Any;

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
	public void test_enumPercentages(){
		
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
				
//				System.out.println(att.getHitPer() + " " + tar.getHitPer() + " percentage: " + ((att.getHitPer()+tar.getHitPer())/2) + " " + SUT.calculateHit2(attacker,target,random));
				
				//Then Attacker get hit
				assertTrue(SUT.calculateHit2(attacker,target,random));
				//And when random value goes outside boundary
				when(random.nextInt(100)).thenReturn(((att.getHitPer()+tar.getHitPer())/2)+1);
				//Then attacker gets miss
				assertFalse(SUT.calculateHit2(attacker,target,random));
		}
		
		
		
	}
	
	
	
	@Test
	public void test_calculateHit(){	//testi osumissäännöille
		//jos molemmat vaunut ei liiku, osuma 90%
		//jos attacker move -30%
		//jos attacker moveFast -50%
		
		when(attacker.getSpeed()).thenReturn(Movement.stationary);
		when(target.getSpeed()).thenReturn(Movement.stationary);
		when(random.nextInt(Matchers.anyInt())).thenReturn(91); 
			assertFalse(SUT.calculateHit(attacker, target, random));
		when(random.nextInt(Matchers.anyInt())).thenReturn(90);
			assertTrue(SUT.calculateHit(attacker, target, random));

			when(target.getSpeed()).thenReturn(Movement.move);
			when(random.nextInt(Matchers.anyInt())).thenReturn(71); 
				assertFalse(SUT.calculateHit(attacker, target, random));
			when(random.nextInt(Matchers.anyInt())).thenReturn(70);
				assertTrue(SUT.calculateHit(attacker, target, random));
			
				when(target.getSpeed()).thenReturn(Movement.moveFast);
				when(random.nextInt(Matchers.anyInt())).thenReturn(51); 
					assertFalse(SUT.calculateHit(attacker, target, random));
				when(random.nextInt(Matchers.anyInt())).thenReturn(50);
					assertTrue(SUT.calculateHit(attacker, target, random));
	
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
	@Ignore
	public void testCalculateDamage() {
		fail("Not yet implemented");
	}

}
