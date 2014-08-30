package model.units;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddArmyUnit() {
		//Given
		int[] foo={100,100};
		Army SUT = new Army();
		//When
		SUT.addArmyUnit(new Tank(foo, foo));
		//Then
		assertEquals(1, SUT.armySize);
		assertEquals("Tank", SUT.army.get(0).getType());
		
	
	}

}
