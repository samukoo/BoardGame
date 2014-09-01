package model.units;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArmyTest {

	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAddArmyUnitsHasPoints(){
		//Given
		List<Unit>res = new ArrayList<Unit>();
		ArmyController SUT = new ArmyController();
		Tank tank = new Tank();
		//When
		res=SUT.addUnits(tank);
		//Then
		assertEquals(1, res.size());
	}
	
	@Test
	public void testAddUnitHasNoPoints(){
		//Given
		List<Unit>res = new ArrayList<Unit>();
		ArmyController SUT = new ArmyController();
		Tank tank = mock(Tank.class);
		//When
		when(tank.getCost()).thenReturn(6);
		res=SUT.addUnits(tank);
		//Then
		assertEquals(0, res.size());
	}
	
		
	@Test
	public void testAddArmyUnit() {
		//Given setup
		Army SUT = new Army();
		Tank mockTank = mock(Tank.class);
		//When
		SUT.addUnit(mockTank);
		List<Unit> res = SUT.getArmyAsList();
		//Then
		assertEquals(1, res.size());
	}
	
	@Test
	public void testArmyPointsDecrease(){
		//Given
		Army SUT = new Army();
		int cost = 4;
		int expected = SUT.getPoints()-cost;
		//When
		Tank mockUnit = mock(Tank.class);
		when(mockUnit.getCost()).thenReturn(cost);
 		SUT.setPoints(mockUnit);
		
		//Then
 		assertEquals(expected, SUT.getPoints());
	}
	
	
}
