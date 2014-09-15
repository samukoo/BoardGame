package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import model.battlefield.Field;
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
	
	
	@Before
	public void setUp() throws Exception {

		SUT = new ShootImpl();
		attacker = mock(Tank.class);
		target = mock(Tank.class);
		field = mock(Field.class);
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
	public void testCalculateHit() {
		Random random = mock(Random.class);
		when(random.nextInt(Matchers.anyInt())).thenReturn(3);
		boolean res = SUT.calculateHit(attacker, target, random);
		assertTrue(res);
	}
	@Test
	public void testCalculateNOTHit() {
		Random random = mock(Random.class);
		when(random.nextInt(Matchers.anyInt())).thenReturn(2);
		boolean res = SUT.calculateHit(attacker, target, random);
		assertFalse(res);
	}
	
	
	@Test
	@Ignore
	public void testCalculateDamage() {
		fail("Not yet implemented");
	}

}
