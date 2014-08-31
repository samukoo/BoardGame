package model.units;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
	@Test
	public void testAddThreeTanksFails(){
		//Given
		Army SUT = new Army();
		int[] foo={100,100};
		//When
		for(int i = 0; i<3; i++){
			SUT.addArmyUnit(new Tank(foo, foo));
		}
		//Then
		assertEquals("There should be only two tanks instead of 3 ",2,SUT.army.size());
	
	}
	
	
	
	@Test
	public void testHasEnoughArmyPoints(){
		//Given
		Army SUT = new Army();
		Tank mockTank = mock(Tank.class);
		//When
		when(mockTank.getCost()).thenReturn(2);
		boolean res = SUT.checkPointsLeft(mockTank);
		//Then
		assertTrue(res);
	}
	
	@Test
	public void testHasNotEnoughArmyPoints(){
		//Given
		Army SUT = new Army();
		Tank mockTank = mock(Tank.class);
		//When
		when(mockTank.getCost()).thenReturn(6);
		boolean res = SUT.checkPointsLeft(mockTank);
		//Then
		assertFalse(res);
	}
	
	
}
